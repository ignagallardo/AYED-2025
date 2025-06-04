package p5.ej2;
import Grafos.*;
import java.util.*;
import p2.ej2.Queue;

public class Recorridos<T> {
    
    public List<T> dfs(Graph<T> grafo) {
        List<T> resultado = new ArrayList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                dfs(i, grafo, marca, resultado);
            }
        }
        
        return resultado;
    }
    
    private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> resultado) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        resultado.add(v.getData());
        
        List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca, resultado);
            }
        }
    }

    
    public List<T> bfs(Graph<T> grafo) {
        List<T> resultado = new ArrayList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca, resultado);
            }
        }
        
        return resultado;
    }
    
    private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> resultado) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> v = q.dequeue();
            resultado.add(v.getData());
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(v);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
    
}
