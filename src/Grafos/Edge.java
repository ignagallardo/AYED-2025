package Grafos;

public interface Edge<T> {
    Vertex<T> getTarget();
    int getWeight();
}
