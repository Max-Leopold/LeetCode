package main.problems.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Nr1514 {

    public static void main(String[] args) {
        Nr1514 nr1514 = new Nr1514();
        System.out.println(
                nr1514.maxProbability(
                        3,
                        new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
                        new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04},
                        3,
                        4)
        );
    }

    public double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int start,
            int end
    ) {
        Graph graph = new Graph();
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], succProb[i]);
        }

        Queue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Node startingNode = graph.getNode(start);
        if (startingNode == null) {
            return 0;
        }
        startingNode.probToGetHere = 1;
        maxHeap.add(graph.getNode(start));
        Set<Node> unvisited = new HashSet<>(graph.getAllNodes());

        while (!unvisited.isEmpty() && !maxHeap.isEmpty()) {
            Node currentNode = maxHeap.poll();
            if (currentNode == graph.getNode(end)) {
                return currentNode.probToGetHere;
            }
            for (Edge neighbour : currentNode.connectedNodes) {
                if (neighbour.to.visited) {
                    continue;
                }
                neighbour.to.probToGetHere = Math.max(currentNode.probToGetHere * neighbour.prob, neighbour.to.probToGetHere);
                maxHeap.add(neighbour.to);
            }
            currentNode.visited = true;
            unvisited.remove(currentNode);
        }

        return 0;
    }

    class Node implements Comparable<Node> {
        final List<Edge> connectedNodes = new ArrayList<>();
        double probToGetHere;
        int val;
        boolean visited;

        public Node(int val) {
            this.val = val;
        }

        public void addEdge(Node to, double prob) {
            connectedNodes.add(new Edge(to, prob));
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.probToGetHere, o.probToGetHere);
        }
    }

    class Edge {
        final Node to;
        final double prob;

        public Edge(Node to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    class Graph {

        private final HashMap<Integer, Node> nodesInGraph = new HashMap<>();

        public void addEdge(int from, int to, double prob) {
            Node fromNode = nodesInGraph.getOrDefault(from, new Node(from));
            Node toNode = nodesInGraph.getOrDefault(to, new Node(to));
            fromNode.addEdge(toNode, prob);
            toNode.addEdge(fromNode, prob);
            nodesInGraph.put(from, fromNode);
            nodesInGraph.put(to, toNode);
        }

        public Node getNode(int key) {
            return nodesInGraph.get(key);
        }

        public Collection<Node> getAllNodes() {
            return nodesInGraph.values();
        }
    }
}
