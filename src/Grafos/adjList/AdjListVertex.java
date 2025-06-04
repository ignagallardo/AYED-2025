package Grafos.adjList;

import Grafos.Edge;
import Grafos.Vertex;
import java.util.ArrayList;
import java.util.List;

public class AdjListVertex<T> implements Vertex<T> {
    private T data;
    private int position;
    private List<Edge<T>> edges;

    public AdjListVertex(T data, int position) {
        this.data = data;
        this.position = position;
        this.edges = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void decrementPosition() {
        this.position--;
    }

    public Edge<T> getEdge(Vertex<T> destination) {
        for (Edge<T> edge : edges) {
            if (edge.getTarget().equals(destination)) {
                return edge;
            }
        }
        return null;
    }

    public void connect(Vertex<T> destination, int weight) {
        if (getEdge(destination) == null) {
            edges.add(new AdjListEdge<>(destination, weight));
        }
    }

    public void disconnect(Vertex<T> destination) {
        edges.removeIf(edge -> edge.getTarget().equals(destination));
    }
}
