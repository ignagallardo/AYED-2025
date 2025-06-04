/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.ej4;
import p2.ej2.BinaryTree;
/**
 *
 * @author UsuarioW10
 */
public class MainCuatro {
    
    public static void main(String[] args){
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(3);
        BinaryTree<Integer> hd = new BinaryTree<Integer>(8);
        BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(10);
        BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(5);
        hi.addLeftChild(nodo1);
        hi.addRightChild(nodo2);
        hd.addLeftChild(nodo3);
        hd.addRightChild(nodo4);
        ab.addLeftChild(hi);
        ab.addRightChild(hd);
        
        RedBinariaLlena r = new RedBinariaLlena();
        r.setArbol(ab);
        System.out.println(r.retardoReenvio(ab));
    }
    
}
