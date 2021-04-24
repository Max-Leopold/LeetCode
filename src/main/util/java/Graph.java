package main.util.java;

import java.util.HashMap;

public class Graph<T> {

    private final HashMap<T, GraphNode<T>> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public HashMap<T, GraphNode<T>> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode<T> node) {
        nodes.put(node.getId(), node);
    }

    public GraphNode<T> getNode(T id) {
        return nodes.get(id);
    }
}
