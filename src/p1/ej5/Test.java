/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej5;

/**
 *
 * @author UsuarioW10
 */
public class Test {
    
    public static void main(String[] args){
        
        int[] vec = {0, 2, 4, 6, 8, 10};
        
        Datos dat = Calculo.resultado(vec);
        
        System.out.println("El maximo es: " + dat.getMax());
        System.out.println("El minimo es: " + dat.getMin());
        System.out.println("El promedio es: " + dat.getProm());
    }
    
}
