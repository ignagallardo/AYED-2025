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
public class Calculo {
    
    public static Datos resultado(int[] vec){
        
        int max = 0; int min = 100;
        int total = 0; int cant = 0;
        for(int i=0; i<vec.length; i++){
            if(vec[i] > max) max = vec[i];
            if(vec[i] < min) min = vec[i];
            total+= vec[i];
            cant++;
        }
        
        double promedio = total/cant;
        Datos obj = new Datos();
        obj.setMax(max);
        obj.setMin(min);
        obj.setProm(promedio);
        return obj;
    }
    
}
