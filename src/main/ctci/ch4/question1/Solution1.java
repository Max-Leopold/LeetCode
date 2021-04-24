package main.ctci.ch4.question1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import main.util.java.GraphNode;

public class Solution1 {

    static boolean isPath(GraphNode<Integer> firstNode, GraphNode<Integer> secondNode) {
        Queue<GraphNode<Integer>> queue = new LinkedList<>();
        HashSet<GraphNode<Integer>> visited = new HashSet<>();

        queue.add(firstNode);

        while (!queue.isEmpty()) {
            GraphNode<Integer> currentNode = queue.poll();
            visited.add(currentNode);
            if (currentNode == secondNode) {
                return true;
            }

            for (GraphNode<Integer> nextNode : currentNode.getEdges()) {
                if (!visited.contains(nextNode)) {
                    queue.add(nextNode);
                }
            }
        }

        return false;
    }
}
