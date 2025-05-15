/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class UsuarioBE {
    
    private UUID id;
    private String nombreUsuario;
    private String contrasenia;
    private int idRol;
    private UUID idEmpleado;
    
    public UsuarioBE() {
    }
    
    public UsuarioBE(String nombreUsuario, String contrasenia, UUID idEmpleado) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idEmpleado = idEmpleado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public UUID getIdEmpleado() {
        return idEmpleado;
    }
    
    public void setIdEmpleado(UUID idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
