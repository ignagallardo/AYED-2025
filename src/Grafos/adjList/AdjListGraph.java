package Grafos.adjList;

import Grafos.*;
import java.util.*;

public class AdjListGraph<T> implements Graph<T> {
    private List<AdjListVertex<T>> vertices;

    public AdjListGraph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex<T> createVertex(T data) {
        AdjListVertex<T> vertex = new AdjListVertex<>(data, vertices.size());
        vertices.add(vertex);
        return vertex;
    }

    public void removeVertex(Vertex<T> vertex) {
        int pos = vertex.getPosition();
        if (vertices.get(pos) != vertex) return;

        vertices.remove(pos);
        for (int i = pos; i < vertices.size(); i++) {
            vertices.get(i).decrementPosition();
        }

        for (AdjListVertex<T> v : vertices) {
            v.disconnect(vertex);
        }
    }

    public void connect(Vertex<T> origin, Vertex<T> destination) {
        connect(origin, destination, 1);
    }

    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        AdjListVertex<T> o = vertices.get(origin.getPosition());
        o.connect(destination, weight);
    }

    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        AdjListVertex<T> o = vertices.get(origin.getPosition());
        o.disconnect(destination);
    }

    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        return vertices.get(origin.getPosition()).getEdge(destination) != null;
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(vertices);
    }

    public int weight(Vertex<T> origin, Vertex<T> destination) {
        Edge<T> edge = vertices.get(origin.getPosition()).getEdge(destination);
        return edge != null ? edge.getWeight() : 0;
    }

    public List<Edge<T>> getEdges(Vertex<T> v) {
        return new ArrayList<>(vertices.get(v.getPosition()).getEdges());
    }

    public Vertex<T> getVertex(int position) {
        return vertices.get(position);
    }

    public int getSize() {
        return vertices.size();
    }

    public Vertex<T> search(T data) {
        for (Vertex<T> v : vertices) {
            if (v.getData().equals(data)) return v;
        }
        return null;
    }
}
