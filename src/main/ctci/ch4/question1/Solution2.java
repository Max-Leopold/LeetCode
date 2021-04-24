package main.ctci.ch4.question1;

import java.util.HashSet;

import main.util.java.GraphNode;

public class Solution2 {

    static boolean isPath(
            GraphNode<Integer> firstNode,
            GraphNode<Integer> secondNode
    ) {
        return dfs(firstNode, secondNode, new HashSet<>());
    }

    private static boolean dfs(
            GraphNode<Integer> firstNode,
            GraphNode<Integer> secondNode,
            HashSet<GraphNode<Integer>> visited
    ) {
        if (firstNode == secondNode) {
            return true;
        }

        visited.add(firstNode);
        for (GraphNode<Integer> neighbour : firstNode.getEdges()) {
            if (!visited.contains(neighbour)) {
                if (dfs(neighbour, secondNode, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
