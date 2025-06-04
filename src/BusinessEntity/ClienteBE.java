/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class ClienteBE extends PersonaAbs  {

    private UUID id;
    private String telefono;
    private String email;
    
    public ClienteBE() {
        super();
    }
    
    public ClienteBE(String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
    }
    
    public ClienteBE(String nombre, String apellidos, String dni, String telefono, String email) {
        super(nombre, apellidos, dni);
        this.telefono = telefono;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
//    public List<VehiculoBE> getVehiculos() {
//        return vehiculos;
//    }
//    
//    public void setVehiculos(List<VehiculoBE> vehiculos) {
//        this.vehiculos = vehiculos;
//    }
//    
//    public void addVehiculo(VehiculoBE vehiculo) {
//        if (vehiculos == null) {
//            vehiculos = new ArrayList<>();
//        }
//        vehiculos.add(vehiculo);
//    }
//    
//    public void removeVehiculo(VehiculoBE vehiculo) {
//        if (vehiculos != null) {
//            vehiculos.remove(vehiculo);
//        }
//    }
}
