package main.problems.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nr851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // Build graph
        HashMap<Integer, RicherNode> richGraph = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            richGraph.put(i, new RicherNode(quiet[i], i));
        }
        for (int i = 0; i < richer.length; i++) {
            richGraph.get(richer[i][1]).richer.add(richGraph.get(richer[i][0]));
        }

        // Find answers for every node
        Queue<RicherNode> toVisit = new LinkedList<>(richGraph.values());
        int[] ans = new int[quiet.length];
        while (!toVisit.isEmpty()) {
            RicherNode current = toVisit.poll();
            setRichAndQuiet(current);
            ans[current.id] = current.richerAndMostQuiet.id;
        }
        return ans;
    }

    public RicherNode setRichAndQuiet(RicherNode root) {
        if (root == null) {
            return null;
        }
        // If this is not null we have already visited this node
        if (root.richerAndMostQuiet != null) {
            return root.richerAndMostQuiet;
        }
        RicherNode min = root;
        for (int i = 0; i < root.richer.size(); i++) {
            RicherNode newMin = setRichAndQuiet(root.richer.get(i));
            min = newMin.quietness < min.quietness ? newMin : min;
        }
        // Save answer so we don't have to compute it again
        root.richerAndMostQuiet = min;
        return min;
    }

    private class RicherNode {
        final int quietness;
        final List<RicherNode> richer;
        final int id;

        RicherNode richerAndMostQuiet;

        public RicherNode(int quietness, int id) {
            this.quietness = quietness;
            this.richer = new ArrayList<>();
            this.id = id;
        }
    }
}
