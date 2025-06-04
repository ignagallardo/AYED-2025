package Grafos.adjList;

import Grafos.Edge;
import Grafos.Vertex;

public class AdjListEdge<T> implements Edge<T> {
    private Vertex<T> target;
    private int weight;

    public AdjListEdge(Vertex<T> target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex<T> getTarget() {
        return this.target;
    }

    public int getWeight() {
        return this.weight;
    }
}
