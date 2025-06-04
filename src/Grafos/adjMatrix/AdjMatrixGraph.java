package Grafos.adjMatrix;

import Grafos.*;
import java.util.*;

public class AdjMatrixGraph<T> implements Graph<T> {
    private static final int EMPTY = 0;
    private int maxVertices;
    private List<AdjMatrixVertex<T>> vertices;
    private int[][] matrix;

    public AdjMatrixGraph(int maxVertices) {
        this.maxVertices = maxVertices;
        this.vertices = new ArrayList<>();
        this.matrix = new int[maxVertices][maxVertices];
    }

    public Vertex<T> createVertex(T data) {
        if (vertices.size() >= maxVertices) return null;
        AdjMatrixVertex<T> v = new AdjMatrixVertex<>(data, vertices.size());
        vertices.add(v);
        return v;
    }

    public void removeVertex(Vertex<T> vertex) {
        int pos = vertex.getPosition();
        if (vertices.get(pos) != vertex) return;

        // Remove from list
        vertices.remove(pos);
        for (int i = pos; i < vertices.size(); i++)
            vertices.get(i).decrementPosition();

        // Clear row and column
        for (int i = 0; i < maxVertices; i++) {
            matrix[pos][i] = EMPTY;
            matrix[i][pos] = EMPTY;
        }
    }

    public void connect(Vertex<T> origin, Vertex<T> destination) {
        connect(origin, destination, 1);
    }

    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        matrix[origin.getPosition()][destination.getPosition()] = weight;
    }

    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        matrix[origin.getPosition()][destination.getPosition()] = EMPTY;
    }

    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        return matrix[origin.getPosition()][destination.getPosition()] != EMPTY;
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(vertices);
    }

    public int weight(Vertex<T> origin, Vertex<T> destination) {
        return matrix[origin.getPosition()][destination.getPosition()];
    }

    public List<Edge<T>> getEdges(Vertex<T> v) {
        List<Edge<T>> edges = new ArrayList<>();
        int pos = v.getPosition();
        for (int i = 0; i < vertices.size(); i++) {
            int w = matrix[pos][i];
            if (w != EMPTY) {
                edges.add(new AdjMatrixEdge<>(vertices.get(i), w));
            }
        }
        return edges;
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
