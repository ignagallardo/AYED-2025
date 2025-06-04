package Grafos;

import java.util.List;

public interface Graph<T> {
    Vertex<T> createVertex(T data);
    void removeVertex(Vertex<T> vertex);
    Vertex<T> search(T data);
    void connect(Vertex<T> origin, Vertex<T> destination);
    void connect(Vertex<T> origin, Vertex<T> destination, int weight);
    void disconnect(Vertex<T> origin, Vertex<T> destination);
    boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
    boolean isEmpty();
    List<Vertex<T>> getVertices();
    int weight(Vertex<T> origin, Vertex<T> destination);
    List<Edge<T>> getEdges(Vertex<T> v);
    Vertex<T> getVertex(int position);
    int getSize();
}
    