/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej4;

/**
 *
 * @author UsuarioW10
 */
public class AreaEmpresa {
    
    String id;
    int tardanza;
    
    public AreaEmpresa(){
        
    }

    public AreaEmpresa(String id, int tardanza) {
        this.id = id;
        this.tardanza = tardanza;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
    
    
    
}
