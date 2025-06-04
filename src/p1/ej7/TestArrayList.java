/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author UsuarioW10
 */
public class TestArrayList {
    
    public static void imprimirLista(){
    
        ArrayList<Estudiante> lista = new ArrayList();
        Estudiante est = new Estudiante("Ignacio", "Gallardo", 3, "153 e 46 y 47", "gallardo123");
        Estudiante est2 = new Estudiante("Santiago", "Swanston", 3, "143 e 46 y 47", "santiago123");
        Estudiante est3 = new Estudiante("Melina", "Figueroa", 3, "153 e 46 y 47", "melina123");
        lista.add(est);
        lista.add(est2);
        lista.add(est3);
        
        ArrayList<Estudiante> lista_copiada = new ArrayList<Estudiante>(lista);
        
        for (Estudiante e: lista){
            System.out.println(e.tusDatos());
        }
        
        for (Estudiante e: lista_copiada){
            System.out.println(e.tusDatos());
        }
        
        for (Estudiante e: lista){
            e.setComision(10);
            System.out.println(e.tusDatos());
        }
        
        for (Estudiante e: lista_copiada){
            e.setEmail("vacio");
            System.out.println(e.tusDatos());
        }
        
        boolean ok = false;
        Estudiante est4 = new Estudiante("Juan", "Perez", 3, "153 e 46 y 47", "juan123");
        for (Estudiante e: lista){
            if(!e.getApe().equals(est4.getApe()))
                ok = true;
        }
        if(ok = false)
            lista.add(est4);
    }
    
    public static boolean esCapicua(ArrayList<Integer> lista_num){
        String num = "";
        for (Integer i: lista_num){
            num = num + Integer.toString(i); 
        }
        System.out.println(num);
        String numeroReverso = new StringBuilder(num).reverse().toString();
        
        if(num.equals(numeroReverso))
            return true;
        else
            return false;
    }
      
    public static void main(String[] args){
        
        ArrayList<Integer> lista = new ArrayList();
        
        lista.add(2);
        lista.add(5);
        lista.add(2);
        
        Iterator<Integer> it1 = lista.iterator();
        while(it1.hasNext())
            System.out.println(it1.next().intValue());
    
        imprimirLista();
        
        if(esCapicua(lista))
            System.out.println("Es capicua");
        else
            System.out.println("No es capicua");
        
        
    }
    
}
