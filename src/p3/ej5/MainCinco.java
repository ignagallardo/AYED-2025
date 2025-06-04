/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej5;

import p3.ej1.GeneralTree;
/**
 *
 * @author UsuarioW10
 */
public class MainCinco {
    
    public static void main(String[]args){
        
        GeneralTree<Integer> a = new GeneralTree<Integer>(4);
        GeneralTree<Integer> n1 = new GeneralTree<Integer>(7);
        GeneralTree<Integer> n2= new GeneralTree<Integer>(4);
        GeneralTree<Integer> n4 = new GeneralTree<Integer>(77);
        GeneralTree<Integer> n5 = new GeneralTree<Integer>(9);
	GeneralTree<Integer> n6 = new GeneralTree<Integer>(44);
	GeneralTree<Integer> n7 = new GeneralTree<Integer>(2);
	GeneralTree<Integer> n8 = new GeneralTree<Integer>(3);
	GeneralTree<Integer> n9 = new GeneralTree<Integer>(5);
        a.addChild(n1); a.addChild(n2); 
        n1.addChild(n4); n1.addChild(n5); n2.addChild(n6);
        n2.addChild(n7);;n1.addChild(n8);
        n5.addChild(n9);        
        if(a.esAncestro(7, 5)){
            System.out.println("Es ancestro");
        }
        else System.out.println("No es ancestro");
        
        
        
    }
    
}
