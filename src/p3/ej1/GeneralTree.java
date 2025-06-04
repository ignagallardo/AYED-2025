/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej1;

import java.util.LinkedList;
import java.util.List;
import p2.ej2.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
            int alt = 0;
            if(!this.isEmpty()){
                alt = altura(0, this);
            }
            return alt;
        }
        
        private int altura(int nivel, GeneralTree<T> ag){
            int max = 0;
            if(ag.hasChildren()){
                List<GeneralTree<T>> children = ag.getChildren();
                for(GeneralTree<T> child: children){
                    max = Math.max(altura(nivel+1, ag), max);
                }
            }
            if(ag.isLeaf()){
                return nivel;
            }
            return Math.max(nivel, max);
        }
        
	public int nivel(T dato){
            Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
            cola.enqueue(this);
            cola.enqueue(null);
            int niv = 0;
            boolean ok = false;
            GeneralTree<T> aux;
            while(!cola.isEmpty() && !ok){
                aux = cola.dequeue();
                if(aux != null){
                    if(aux.getData().equals(dato)){
                        ok = true;
                    }
                    else{
                        List<GeneralTree<T>> children = aux.getChildren();
                        for(GeneralTree<T> child: children){
                            cola.enqueue(child);
                        }
                    }
                }
                else{
                    if(!cola.isEmpty()){
                        niv++;
                        cola.enqueue(null);
                    }
                }
            }
            
            return niv;
	}

	public int ancho(){
            int max = 0;
            Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
            cola.enqueue(this);
            cola.enqueue(null);
            int cant = 0;
            
            while(!cola.isEmpty()){
                GeneralTree<T> aux = cola.dequeue();
                if(aux != null){
                    List<GeneralTree<T>> children = aux.getChildren();
                    for(GeneralTree<T> child: children){
                        cola.enqueue(child);
                        cant++;
                    }
                }
                else{
                    max = Math.max(max, cant);
                    cant = 0;
                    cola.enqueue(null);
                }
            }
            
            return max;
	}
        
        public boolean esAncestro(T a, T b){
            boolean ok=false;
            GeneralTree<T> tree=buscarA(a, b);
            if(tree!=null){
                return buscarB(tree, b);
            }
            else{
                return false;
            }
        }    
        
        //recorrido por profundidad, hay que buscar el subArbol A  y devolverlo verificando que ANTES no hayamos encontrado B
        public GeneralTree<T> buscarA(T a, T b){
            GeneralTree<T> tree = this;
            if(tree.getData() == a){
                return tree;
            }
            else if(tree.getData() == b){
                    return null;
                }
            if(tree.hasChildren()){
                List<GeneralTree<T>> lista = tree.getChildren();
                for(GeneralTree<T> child: lista){
                    tree = child.buscarA(a, b);
                }
            }
            return null;
        }
        
        public boolean buscarB(GeneralTree<T> tree, T b){
            if(tree.getData() == b){
                return true;
            }
            else if(tree.hasChildren()){
                List<GeneralTree<T>> lista = tree.getChildren();
                for(GeneralTree<T> child: lista){
                    child.buscarB(child, b);
                }
            }
            return false;
        }
}