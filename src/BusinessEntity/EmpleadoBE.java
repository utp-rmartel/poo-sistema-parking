/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.util.UUID;

/**
 *
 * @author Royss
 */
public class EmpleadoBE extends PersonaAbs {
    
    private UUID id;
    private String telefono;
    
    public EmpleadoBE() {
        super();
    }
    
    public EmpleadoBE(String nombre, String apellidos, String dni, String telefono) {
        super(nombre, apellidos, dni);
        this.telefono = telefono;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
