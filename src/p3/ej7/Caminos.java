/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej7;
import p3.ej1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author UsuarioW10
 */
public class Caminos {
    
    GeneralTree<Integer> tree;

    public GeneralTree<Integer> getTree() {
        return tree;
    }

    public void setTree(GeneralTree<Integer> tree) {
        this.tree = tree;
    }
    
    public List<Integer> caminoAHojaMasLejana (){
        List<Integer> lista = new LinkedList<Integer>();
        if(!tree.isEmpty()){
            lista = caminoHelper(tree);
        }
        return lista;
    }
    
    //consultar por explicacion practica
    public List<Integer> caminoHelper(GeneralTree<Integer> tree){
        List<Integer> aux = new LinkedList<Integer>();
        List<Integer> lista = new LinkedList<Integer>();
        if(tree.isLeaf()){
            aux.add(tree.getData());
            return aux;
        }
        else{
            List<GeneralTree<Integer>> children = tree.getChildren();
            for(GeneralTree<Integer>child: children){
                aux = new LinkedList();
                aux.addAll(caminoHelper(child));
                if(lista.size() < aux.size()){
                    lista = aux;
                }
            }
            lista.add(tree.getData());
            return lista;
        }
    }
    
}
