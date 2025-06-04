/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej2;

import java.util.Iterator;
import p3.ej1.GeneralTree;
import java.util.LinkedList;
import java.util.List;
import p2.ej2.Queue;

/**
 *
 * @author UsuarioW10
 */
public class RecorridosAG {
        
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> ag, Integer n){
        List<Integer> lis = new LinkedList<Integer>();
        if(!ag.isEmpty())
            this.numerosImparesMayoresQuePreOrden(ag, n, lis);
        return lis;
    }
    
    private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> ag, Integer n, List<Integer> lis){
        if(((ag.getData() % 2) != 0) && (ag.getData() > n)){
                lis.add(ag.getData());
        }
        List <GeneralTree<Integer>> children = ag.getChildren();
        Iterator<GeneralTree<Integer>> it = children.iterator();
        while(it.hasNext()){
            GeneralTree<Integer> child = it.next();
            this.numerosImparesMayoresQuePreOrden(child, n, lis);
        }
    }
    
    
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> ag, Integer n){
        List<Integer> lis = new LinkedList<Integer>();
        if(!ag.isEmpty())
            this.numerosImparesMayoresQueInOrden(ag, n, lis);
        return lis;
    }
    
    private void numerosImparesMayoresQueInOrden (GeneralTree <Integer> ag, Integer n, List<Integer> lis){
        List<GeneralTree<Integer>> children = ag.getChildren();
        if(ag.hasChildren()){
            numerosImparesMayoresQueInOrden(children.get(0), n, lis);
        }
        int dato = ag.getData();
        if(dato > n && dato % 2 != 0){
            lis.add(dato);
        }
        for(int i=1; i < children.size(); i++){
            numerosImparesMayoresQueInOrden(children.get(i), n, lis);
        }
    }
    
    
    
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> ag, Integer n){
        List<Integer> lis = new LinkedList<Integer>();
        if(!ag.isEmpty())
            numerosImparesMayoresQuePostOrden(ag, n, lis);
        return lis;
    }    
    
    private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> ag, Integer n, List lis){
        if(!ag.isLeaf()){
            List<GeneralTree<Integer>> children = ag.getChildren();
            numerosImparesMayoresQuePostOrden(children.get(0), n, lis);
            for(int i=1; i < children.size(); i++){
                numerosImparesMayoresQuePostOrden(children.get(i), n, lis);
            }
            if(ag.getData() % 2 != 0 && ag.getData() > n){
                lis.add(ag.getData());
            }
        }
        else{
            if(ag.getData() % 2 != 0 && ag.getData() > n){
                lis.add(ag.getData());
            }
        }
    }
    
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> ag, Integer n){
        List<Integer> lis = new LinkedList<Integer>();
        if(!ag.isEmpty()){
            numerosImparesMayoresQuePorNiveles(ag, n, lis);
        }
        return lis;
    }
    
    private void numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> ag, Integer n, List lis){
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(ag);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux.getData() % 2 != 0 && aux.getData() > n){
                lis.add(aux.getData());
            }        
            List <GeneralTree<Integer>> children = aux.getChildren();
            for(GeneralTree<Integer> child: children){
                cola.enqueue(child);
            }
        }
    }
    
}
