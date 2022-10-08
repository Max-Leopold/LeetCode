package main.problems.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Nr1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(i);
        }

        for (List<Integer> edge : edges) {
            res.remove(edge.get(1));
        }

        return new ArrayList<>(res);
    }
}
