/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5.ej4;
import Grafos.*;
import Grafos.adjList.*;
import java.util.*;
/**
 *
 * @author UsuarioW10
 */
public class VisitaOslo {
    
    public List<String> paseoEnBici(Graph<String> lugares, String objetivo, int tiempoMax, List<String> lugaresRestringidos){
        List<String> camino = new ArrayList<>();
        if(!lugares.isEmpty()){
            Vertex<String> origen = lugares.search("Ayuntamiento");
            Vertex<String> destino = lugares.search(objetivo);
            boolean[] marcas = new boolean[lugares.getSize()];
            marcarRestringidos(lugares, marcas, lugaresRestringidos);
            if(origen != null || destino != null){
                boolean ok = paseoAux(lugares, origen, destino, tiempoMax, marcas, camino);
            }
        }
        return camino;
    }
    
    private void marcarRestringidos(Graph<String> lugares, boolean[] marcas, List<String> lugaresRestringidos){
        for(String ciudad: lugaresRestringidos){
            Vertex<String> v = lugares.search(ciudad);
            if(v != null){
                marcas[v.getPosition()] = true;
            }
        }
    }
    
    private boolean paseoAux(Graph<String> lugares, Vertex<String> actual, Vertex<String> destino, int tiempoMax, boolean[] marcas, List<String> camino){
        boolean ok = false;
        marcas[actual.getPosition()] = true;
        camino.add(actual.getData());
        
        if(actual.equals(destino) && tiempoMax > 0){
            return true;
        } else {
            List<Edge<String>> ady = lugares.getEdges(actual);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && tiempoMax > 0){
                Edge<String> arista = it.next();
                Vertex<String> sig = arista.getTarget();
                int aux = tiempoMax - arista.getWeight();
                if(!marcas[sig.getPosition()] && aux > 0){
                    ok = paseoAux(lugares, sig, destino, aux, marcas, camino);
                }
            }
        }
        if(!ok){
            camino.remove(camino.size() - 1);
        }
        marcas[actual.getPosition()] = false;
        return ok;
    }
    
    
    public static void main(String[] args){
       
        Graph<String> lugares = new AdjListGraph<>();
        Vertex<String> v1 = lugares.createVertex("Holmenkollen");
        Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
        Vertex<String> v3 = lugares.createVertex("Galería Nacional");
        Vertex<String> v4 = lugares.createVertex("Parque Botánico");
        Vertex<String> v5 = lugares.createVertex("Museo Munch");
        Vertex<String> v6 = lugares.createVertex("FolkMuseum");
        Vertex<String> v7 = lugares.createVertex("Palacio Real");
        Vertex<String> v8 = lugares.createVertex("Ayuntamiento");
        Vertex<String> v9 = lugares.createVertex("El Tigre");
        Vertex<String> v10 = lugares.createVertex("Akker Brigge");
        Vertex<String> v11 = lugares.createVertex("Museo Fram");
        Vertex<String> v12 = lugares.createVertex("Museo Vikingo");
        Vertex<String> v13 = lugares.createVertex("La Opera");
        Vertex<String> v14 = lugares.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");   
        
        lugares.connect(v1, v2, 30);
        lugares.connect(v2, v1, 30);
        lugares.connect(v2, v3, 10);
        lugares.connect(v3, v2, 10);
        lugares.connect(v3, v4, 15);
        lugares.connect(v4, v3, 15);
        lugares.connect(v4, v5, 1);
        lugares.connect(v5, v4, 1);
        
        lugares.connect(v5, v9, 15);
        lugares.connect(v9, v5, 15);
        lugares.connect(v9, v13, 5);
        lugares.connect(v13, v9, 5);
        lugares.connect(v13, v15, 10);
        lugares.connect(v15, v13, 10);
        
        lugares.connect(v2, v6, 20);
        lugares.connect(v6, v2, 20);
        lugares.connect(v6, v7, 5);
        lugares.connect(v7, v6, 5);
        lugares.connect(v7, v8, 5);
        lugares.connect(v8, v7, 5);
        lugares.connect(v6, v10, 30);
        lugares.connect(v10, v6, 30);
        lugares.connect(v10, v8, 20);
        lugares.connect(v8, v10, 20);
        lugares.connect(v8, v4, 10);
        lugares.connect(v4, v8, 10);
        lugares.connect(v8, v9, 15);
        lugares.connect(v9, v8, 15);
        
        lugares.connect(v6, v11, 5);
        lugares.connect(v11, v6, 5);
        lugares.connect(v10, v12, 30);
        lugares.connect(v12, v10, 30);
        lugares.connect(v11, v14, 5);
        lugares.connect(v14, v11, 5);
        lugares.connect(v12, v14, 5);
        lugares.connect(v14, v12, 5);
        
        List<String> lugaresRestringidos = new LinkedList<>();
        lugaresRestringidos.add("Akker Brigge");
        lugaresRestringidos.add("Palacio Real");
        VisitaOslo vis = new VisitaOslo();
        List<String> camino = vis.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos);
        
        System.out.println(camino);
	

    }
    
}
