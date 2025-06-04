/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5.ej2;
import Grafos.*;
import Grafos.adjList.*;
import java.util.*;

/**
 *
 * @author UsuarioW10
 */
public class Main {
    
    public static void main(String[] args){
        Graph<String> ciudades = new AdjListGraph<>();

        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Caracas");
        Vertex<String> v5 = ciudades.createVertex("Madrid");
        Vertex<String> v6 = ciudades.createVertex("Londres");
        Vertex<String> v7 = ciudades.createVertex("Roma");

        ciudades.connect(v1, v2, 3); // Buenos Aires → Santiago
        ciudades.connect(v1, v3, 6); // Buenos Aires → Asunción
        ciudades.connect(v2, v7, 4); // Santiago → Roma
        ciudades.connect(v2, v4, 2); // Santiago → Caracas
        ciudades.connect(v4, v5, 1); // Caracas → Madrid
        ciudades.connect(v5, v6, 2); // Madrid → Londres
        
        Recorridos reco = new Recorridos();
        List<String> listaDfs = reco.dfs(ciudades);

        System.out.println("Recorrido DFS:" + listaDfs);
        
        List<String> listaBfs = reco.bfs(ciudades);
        System.out.println("Recorrido BFS:" + listaBfs);
    }
}
