/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej3;

import p1.ej3.Estudiante;

/**
 *
 * @author UsuarioW10
 */
public class Test {
    
    public static void main (String[] args){
        
        Estudiante[] est = new Estudiante[2];
        
        Profesor[] pro = new Profesor[3];
        
        Estudiante e1 = new Estudiante();
        e1.setNom("Ignacio");
        e1.setApe("Gallardo");
        e1.setComision(3);
        e1.setDireccion("153 n°718");
        e1.setEmail("gallardoignacio634");
        
        Estudiante e2 = new Estudiante();
        e2.setNom("Santiago");
        e2.setApe("Swanston");
        e2.setComision(3);
        e2.setDireccion("143 n°120");
        e2.setEmail("santiago123");
        
        est[0] = e1;
        est[1] = e2;
        
        Profesor p1 = new Profesor();
        
        p1.setNom("Juan");
        p1.setApe("Perez");
        p1.setCatedra("cadp");
        p1.setEmail("juan123");
        p1.setFacultad("Informatica");
        
        Profesor p2 = new Profesor();
        
        p2.setNom("Gonzalo");
        p2.setApe("Villarreal");
        p2.setCatedra("cadp");
        p2.setEmail("gonza123");
        p2.setFacultad("Informatica");
        
        Profesor p3 = new Profesor();
        
        p3.setNom("Camila");
        p3.setApe("Gonzalez");
        p3.setCatedra("linti");
        p3.setEmail("camila123");
        p3.setFacultad("Derecho");
                
        pro[0] = p1;
        pro[1] = p2;
        pro[2] = p3;
        
        for(int i = 0; i < 2; i++)
            System.out.println(est[i].tusDatos());
        
        for(int j = 0; j < 3; j++)
            System.out.println(pro[j].tusDatos());
    }
    
}
