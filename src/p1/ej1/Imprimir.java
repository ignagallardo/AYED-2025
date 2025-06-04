/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej1;

/**
 *
 * @author UsuarioW10
 */
public class Imprimir {
    
    public static void devolver(int a, int b){
     
        int inicio = a;
        int fin = b;
        for(int i=inicio; i <= fin; i++){
            System.out.println("El numero es " + i);
        }
    }

    public static void devolver2(int a, int b){
        int i = a;
        while(i <= b){
            System.out.println("El numero es " + i);
            i++;
        }
    }
    
    public static void devolver3(int a, int b){
        System.out.println("El numero es " + a);
        if(a < b)
            devolver3(a+1, b);
    }
    
    
}

