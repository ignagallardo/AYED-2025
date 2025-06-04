/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej2;

/**
 *
 * @author UsuarioW10
 */
public class Contador {
    
    public static int[] generar(int n){
            
        int[] vector = new int[n];
        for(int i = 0; i < n; i++){
            vector[i] = n * (i + 1);
        }
        
        return vector;
        
    }
    
    public static void imprimir(int n){
        int[] vec;
        vec = generar(n);
        
        for(int i = 0; i < n; i++)
            System.out.println(vec[i]);
    }
    
}
