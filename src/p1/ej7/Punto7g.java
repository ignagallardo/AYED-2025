/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej7;
import java.util.*;
/**
 *
 * @author UsuarioW10
 */
public class Punto7g {
    
    public static void main(String[] args){
        ArrayList<Integer> l = calcularSucesion(6);
        for (Integer i: l){
            System.out.println(i);
        }
    }
    
    public static ArrayList<Integer> calcularSucesion(int n){
        ArrayList<Integer> lis = new ArrayList();
        return calcularSucesionAux(n, lis);
    }
    
    public static ArrayList<Integer> calcularSucesionAux(int n, ArrayList<Integer> lis){
        lis.add(n);
        if(n != 1){
            if((n % 2) == 0)
                calcularSucesionAux(n/2, lis);
            else
                calcularSucesionAux(3*n + 1, lis);
        }
        
        return lis;
    }
    
}
