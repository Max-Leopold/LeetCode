package main.util.java;

public class GraphBuilder {

    public static <T> Graph<T> buildGraph(T[] nodes, T[][] edges, boolean directed) {
        Graph<T> graph = new Graph<>();

        for (int i = 0; i < nodes.length; i++) {
            graph.addNode(new GraphNode<>(nodes[i]));
        }

        for (int i = 0; i < edges.length; i++) {
            graph.getNode(edges[i][0]).addEdge(graph.getNode(edges[i][1]));
            if (!directed) {
                graph.getNode(edges[i][1]).addEdge(graph.getNode(edges[i][0]));
            }
        }

        return graph;
    }
}
