/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.ej3;

/**
 *
 * @author UsuarioW10
 */
public class Profesor {
 
    private String nom;
    private String ape;
    private String email;
    private String catedra;
    private String facultad;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public String tusDatos(){
        
        return getNom() + ", " + getApe() + ", " + getCatedra() + ", " + getEmail() + ", " + getFacultad();
        
    }
    
}
