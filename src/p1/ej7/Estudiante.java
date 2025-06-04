/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej7;

/**
 *
 * @author UsuarioW10
 */
public class Estudiante {
    
    private String nom;
    private String ape;
    private int comision;
    private String direccion;
    private String email;

    public Estudiante(String nom, String ape, int comision, String direccion, String email) {
        this.nom = nom;
        this.ape = ape;
        this.comision = comision;
        this.direccion = direccion;
        this.email = email;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String tusDatos(){
        
        return getNom() + ", " + getApe() + ", " + getComision() + ", " + getEmail() + ", " + getDireccion();
        
    }
    
}
