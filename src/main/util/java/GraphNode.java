package main.util.java;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode<T> {

    private final Set<GraphNode<T>> edges;
    private T id;

    public GraphNode(T id) {
        this.edges = new HashSet<>();
        this.id = id;
    }

    public void addEdge(GraphNode<T> edge) {
        edges.add(edge);
    }

    public Set<GraphNode<T>> getEdges() {
        return edges;
    }

    public T getId() {
        return id;
    }

    public void setValue(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return getId().equals(graphNode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
