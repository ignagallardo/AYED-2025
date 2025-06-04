/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Grafos.*;
import Grafos.adjMatrix.*;

public class PruebaGrafos {
    public static void main(String[] args) {
        Graph<String> g = new AdjMatrixGraph<>(10);

        Vertex<String> a = g.createVertex("A");
        Vertex<String> b = g.createVertex("B");
        g.connect(a, b, 5);

        System.out.println("¿Existe conexión A→B? " + g.existsEdge(a, b));
        System.out.println("Peso A→B: " + g.weight(a, b));
    }

}
