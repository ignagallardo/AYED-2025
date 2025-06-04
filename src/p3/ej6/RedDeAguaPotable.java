/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej6;
import p3.ej1.GeneralTree;
import java.util.List;

/**
 *
 * @author UsuarioW10
 */
public class RedDeAguaPotable {
    
    private GeneralTree<Character> red;

    public RedDeAguaPotable(GeneralTree<Character> red) {
        this.red = red;
    }
    
    public double minimoCaudal(double caudal){
        if(this.red != null){
            return minimoCaudalHelper(this.red, caudal);
        }
        else
            return 0.0;
    }

    public double minimoCaudalHelper(GeneralTree<Character> tree, double caudal){
        //si es hoja, devuelve el caudal actual
        if(tree.isLeaf()){
            return caudal;
        }
        //calculo el caudal divido entre los hijos
        double newCaudal = caudal/tree.getChildren().size();
        double min = Double.MAX_VALUE;
        List<GeneralTree<Character>> children = tree.getChildren();
        //por cada hijo pregunto si tiene menos caudal al actual
        for(GeneralTree<Character>child : children){
            double caudalHijo = minimoCaudalHelper(child, newCaudal);
            if(caudalHijo < min){
                min = caudalHijo;
            }
        }
        
        return min;
    }
    
}
