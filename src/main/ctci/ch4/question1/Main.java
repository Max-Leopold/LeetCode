package main.ctci.ch4.question1;

import main.util.java.Graph;
import main.util.java.GraphBuilder;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = GraphBuilder.<Integer>buildGraph(
                new Integer[]{1, 2, 3, 4, 5},
                new Integer[][]{
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {4, 5},
                        {3, 1}
                },
                true
        );

        System.out.println(Solution1.isPath(graph.getNode(1), graph.getNode(5)));

        System.out.println(Solution1.isPath(graph.getNode(2), graph.getNode(1)));

        System.out.println(Solution1.isPath(graph.getNode(4), graph.getNode(1)));

        System.out.println(Solution2.isPath(graph.getNode(1), graph.getNode(5)));

        System.out.println(Solution2.isPath(graph.getNode(2), graph.getNode(1)));

        System.out.println(Solution2.isPath(graph.getNode(4), graph.getNode(1)));
    }
}
