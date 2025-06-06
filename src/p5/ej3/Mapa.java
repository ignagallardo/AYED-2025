/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5.ej3;
import Grafos.*;
import java.util.*;
import Grafos.adjList.*;
/**
 *
 * @author UsuarioW10
 */
public class Mapa {
    
    private Graph<String> map;

    public Mapa(Graph<String> mapaCiudades) {
        this.map = mapaCiudades;
    }
    
    public List <String> devolverCamino(String c1, String c2){
        Vertex<String> origen = map.search(c1);
        Vertex<String> destino = map.search(c2);
        
        if(origen == null || destino == null)
            return new ArrayList<>();
        
        boolean[] marca = new boolean[map.getSize()];
        List<String> camino = new ArrayList<>();
        
        boolean encontro;
        encontro = devolverCamino(origen, destino, camino, marca);
        
        return encontro ? camino: new ArrayList<>(); //if encontro es true devuelve camino, sino lista vacia
    }
    
    private boolean devolverCamino(Vertex<String> actual, Vertex<String> destino, List<String> camino, boolean[]marca){
        marca[actual.getPosition()] = true;
        camino.add(actual.getData());
        System.out.println("Visitando: " + actual.getData());
        
        if(actual.equals(destino)){
            System.out.println("Camino encontrado: " + actual.getData());
            return true;        //encontro camino
        }
            
        for(Edge<String> e: map.getEdges(actual)){ //recorro adyacencias
            Vertex<String> sig = e.getTarget();
            if(!marca[sig.getPosition()]){  //si no fueron visitadas las llamo para seguir buscando el camino
                System.out.println("→ Explorando camino hacia: " + sig.getData());
                if(devolverCamino(sig, destino, camino, marca)){ //si encuentra un camino valido sigue
                    return true;    //camino para seguir
                }
            } else{
                System.out.println("↺ Ya visitado: " + sig.getData());
            }
        }
        
        //bacltracking
        System.out.println("Retrocediendo desde: " + actual.getData());
        camino.remove(camino.size() - 1);
        return false;
    }
    
    public List <String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades){
        Vertex<String> origen = map.search(c1);
        Vertex<String> destino = map.search(c2);
        
        if(origen == null || destino == null)
            return new ArrayList<>();
        
        boolean[] marca = new boolean[map.getSize()];
        marcarExcluidos(ciudades, marca);
        
        List<String> camino = new ArrayList<>();
        
        boolean encontro;
        encontro = devolverCamino(origen, destino, camino, marca);
        
        return encontro ? camino: new ArrayList<>(); //if encontro es true devuelve camino, sino lista vacia
    }
    
    public void marcarExcluidos(List<String> excluidas, boolean[] marca){
        for(String ciudad: excluidas){
            Vertex<String> v = this.map.search(ciudad);
            if(v != null)
                marca[v.getPosition()] = true;
        }
    }
    
    public List<String> caminoMasCorto(String c1, String c2){
        List<String> camino = new ArrayList<>();
        if(!this.map.isEmpty()){
            Vertex<String> origen = map.search(c1);
            Vertex<String> destino = map.search(c2);
            if(origen == null || destino == null){
                return new ArrayList<>();
            }
            boolean[] marcas = new boolean[map.getSize()];
            caminoMasCorto(origen, destino, camino, marcas, new ArrayList<>(), 0, 9999);
        }
        return camino;
    }
    
    private int caminoMasCorto(Vertex<String> actual, Vertex<String> destino, List<String> caminoMin, boolean[] marcas,
                                    List<String> camino, int total, int min){
        marcas[actual.getPosition()] = true;
        camino.add(actual.getData());
        
        if(actual == destino && total < min){
            caminoMin.removeAll(caminoMin);
            caminoMin.addAll(camino);
            min = total;
        } else {
            List<Edge<String>> ady = this.map.getEdges(actual);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && total < min){
                Edge<String> ver = it.next();
                int visitado = ver.getTarget().getPosition();
                int costo = total + ver.getWeight();
                if(!marcas[visitado] && costo < min){
                    min = caminoMasCorto(ver.getTarget(), destino, caminoMin, marcas, camino, costo, min);
                }
            }
        }
        
        marcas[actual.getPosition()] = false;
        camino.remove(camino.size() - 1);
        return min;
    }
    
    public List<String> caminoSinCargarCombustible(String c1, String c2, int tanque){
        List<String> camino = new ArrayList<>();
        if(!this.map.isEmpty()){
            Vertex<String> origen = map.search(c1);
            Vertex<String> destino = map.search(c2);
            if(origen == null && destino == null)
                return camino;
            
            boolean[] marcas = new boolean[map.getSize()];
            sinCargar(origen, destino, tanque, camino, marcas);
        }
        System.out.println("Nafta total:" + tanque);
        return camino;
    }
    
    private boolean sinCargar(Vertex<String> actual, Vertex<String> destino, int tanque, List<String> camino, boolean[] marcas){
        boolean ok = false;
        marcas[actual.getPosition()] = true;
        camino.add(actual.getData());
        
        if(actual == destino && tanque > 0){
            return true;
        } else {
            List<Edge<String>> ady = map.getEdges(actual);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !ok){
                Edge<String> e = it.next();
                Vertex<String> v = e.getTarget();
                int costo = tanque-e.getWeight();
                if(!marcas[v.getPosition()] && costo > 0){
                    ok = sinCargar(v, destino, costo, camino, marcas);
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
        // 1. Crear grafo
        Graph<String> grafo = new AdjListGraph<>();

        // 2. Crear vértices
        Vertex<String> v1 = grafo.createVertex("Buenos Aires");
        Vertex<String> v2 = grafo.createVertex("Santiago");
        Vertex<String> v3 = grafo.createVertex("Asunción");
        Vertex<String> v4 = grafo.createVertex("Caracas");
        Vertex<String> v5 = grafo.createVertex("Madrid");
        Vertex<String> v6 = grafo.createVertex("Londres");

        // 3. Conectar ciudades (aristas dirigidas)
        grafo.connect(v1, v2, 5); // Buenos Aires → Santiago
        grafo.connect(v1, v3, 20); // Buenos Aires → Asunción
        grafo.connect(v3, v5, 40); // Asuncion → Madrid
        grafo.connect(v2, v4, 10); // Santiago → Caracas
        grafo.connect(v4, v5, 10); // Caracas → Madrid
        grafo.connect(v5, v6, 15); // Madrid → Londres

        // 4. Crear instancia de Mapa
        Mapa mapa = new Mapa(grafo);
        /*List<String> excluidas = new ArrayList<>();
        excluidas.add("Madrid");
        // 5. Probar devolverCamino con trazas
        System.out.println("\nBuscando camino de Buenos Aires a Londres, sin pasar por Madrid:");
        List<String> camino = mapa.devolverCaminoExceptuando("Buenos Aires", "Londres", excluidas);

        System.out.println("\nResultado:");
        if (!camino.isEmpty()) {
            System.out.println("Camino encontrado: " + camino);
        } else {
            System.out.println("No existe camino.");
        }*/
        
        List<String> camino = mapa.caminoSinCargarCombustible("Buenos Aires", "Madrid", 10);
        System.out.println("Camino sin cargar combustible: " + camino);
    }
    
    
}
