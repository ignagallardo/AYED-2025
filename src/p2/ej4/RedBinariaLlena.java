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
public class RedBinariaLlena {
    
    BinaryTree<Integer> arbol;
    
    public void setArbol(BinaryTree<Integer> ar){
        this.arbol = ar;
    }
    
    public int retardoReenvio(){
        if(!arbol.isEmpty())
            return retardoReenvio(arbol);
        else
            return 0;
    }
    
    public int retardoReenvio(BinaryTree<Integer> ab){
        if(ab.isLeaf()){
            return ab.getData();
        }
        else {
            int i = 0;
            int j = 0;
            if(ab.hasLeftChild())
                i = retardoReenvio(ab.getLeftChild());
            if(ab.hasRightChild())
                j = retardoReenvio(ab.getRightChild());
        
        return ab.getData() + Math.max(i, j);
        }
    }
    
}
