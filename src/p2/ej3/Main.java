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
public class Main {
    
    public static void main(String[] args){
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(3);
        BinaryTree<Integer> hd = new BinaryTree<Integer>(4);
        BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(7);
        hi.addLeftChild(nodo1);
        hi.addRightChild(nodo2);
        ab.addLeftChild(hi);
        ab.addRightChild(hd);
        
        ContadorArbol contador = new ContadorArbol(ab);
        
        LinkedList<Integer> lista = new LinkedList<Integer>();
        
        lista = contador.numerosPares_inOrden();
        for(Integer i: lista)
            System.out.println(i);
        
        lista = contador.numerosPares_postOrden();
        for(Integer i:lista)
            System.out.println(i);
    }
    
}
