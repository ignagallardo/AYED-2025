/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.ej6;
import p2.ej2.*;

/**
 *
 * @author UsuarioW10
 */
public class Transformacion {
    
    BinaryTree<Integer> ab;
    
    public Transformacion(BinaryTree<Integer> arbol){
        ab = arbol;
    }
    
    public BinaryTree<Integer> getArbol(){
        return ab;
    }
    
    public BinaryTree<Integer> suma(){
        suma(ab);
        return ab;
    }
    
    public int suma(BinaryTree<Integer>ab){
        int suma = 0;
        if(ab.isLeaf()){
            suma = ab.getData();
            ab.setData(0);
            return suma;
        }
        if(ab.hasLeftChild()){
            suma += suma(ab.getLeftChild());
        }
        if(ab.hasRightChild()){
            suma += suma(ab.getRightChild());
        }
        int aux = ab.getData();
        ab.setData(suma);
        return aux + suma;
    }
    
    public String toString() {
		String aux = "";
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(ab);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			BinaryTree<Integer> aux1 = cola.dequeue();
			if(aux1 != null) {
			  aux += " | "+ aux1 + " | ";
			if(aux1.hasLeftChild()) {
				cola.enqueue(aux1.getLeftChild());
				}
			if(aux1.hasRightChild()) {
				cola.enqueue(aux1.getRightChild());
			}
			}
			else if(!cola.isEmpty()) {
				    aux+= "\n";
				    
				    cola.enqueue(null);
				}
	}
		return aux;
    }
    
    public static void main(String[] args){
        
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
        BinaryTree<Integer> leftChild = new BinaryTree<Integer>(4);
        BinaryTree<Integer> lf1 = new BinaryTree<Integer>(20);
        BinaryTree<Integer> lf2 = new BinaryTree<Integer>(30);
        lf1.addRightChild(lf2);
        leftChild.addRightChild(lf1);
        arbol.addLeftChild(leftChild);
        BinaryTree<Integer> rightChild = new BinaryTree<Integer>(10);
        BinaryTree<Integer> rc1 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> rc2 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> rc3 = new BinaryTree<Integer>(8);
        rc2.addRightChild(rc3);
        rightChild.addLeftChild(rc1);
        rightChild.addRightChild(rc2);
        arbol.addRightChild(rightChild);
        
        Transformacion tr = new Transformacion(arbol);
        
        System.out.println(tr.toString());
        
        tr.suma();
        
        System.out.println(tr.toString());
    }
}
