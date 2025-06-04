package Grafos.adjMatrix;

import Grafos.Edge;
import Grafos.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {
    private Vertex<T> target;
    private int weight;

    public AdjMatrixEdge(Vertex<T> target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex<T> getTarget() { return target; }
    public int getWeight() { return weight; }
}
