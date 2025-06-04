/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.ej3;
import java.util.LinkedList;
import p2.ej2.BinaryTree;
/**
 *
 * @author UsuarioW10
 */
public class ContadorArbol {
    
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public LinkedList<Integer> numerosPares_inOrden(){
        if(this.arbol != null){
            LinkedList<Integer> lista = new LinkedList<Integer>();
            numerosPares_inOrden(this.arbol, lista);
            return lista;
        }
        else return null;
    }
    
    public void numerosPares_inOrden(BinaryTree<Integer> arbol, LinkedList<Integer> l){
        if(arbol.hasLeftChild())
            numerosPares_inOrden(arbol.getLeftChild(), l);
        if(arbol.getData() % 2 == 0)
            l.add(arbol.getData());
        if(arbol.hasRightChild())
            numerosPares_inOrden(arbol.getRightChild(), l);
    }
    
    public LinkedList<Integer> numerosPares_postOrden(){
        if(this.arbol != null){
            LinkedList<Integer> lista = new LinkedList<Integer>();
            numerosPares_postOrden(this.arbol, lista);
            return lista;
        }
        else return null;
    }
    
    public void numerosPares_postOrden(BinaryTree<Integer> arbol, LinkedList<Integer> l){
        if(arbol.hasLeftChild())
            numerosPares_postOrden(arbol.getLeftChild(), l);
        if(arbol.hasRightChild())
            numerosPares_postOrden(arbol.getRightChild(), l);
        if(arbol.getData() % 2 == 0)
            l.add(arbol.getData());
    }
    
}

