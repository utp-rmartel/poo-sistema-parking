/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author Royss
 */
public abstract class PersonaAbs extends AuditoriaAbs{
    
    private String nombre;
    private String apellidos;
    private String documento;
    private int tipoDocumento;
    
    public PersonaAbs() {
    }
    
    public PersonaAbs(String nombre, String apellidos, String documento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
   
}
