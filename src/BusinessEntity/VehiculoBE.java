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
public class VehiculoBE extends AuditoriaAbs {
    private UUID id;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private UUID idCliente;
    private int idTipoVehiculo;
    
    public VehiculoBE() {
    }
    
    public VehiculoBE(String placa, String marca, String modelo, String color, UUID idCliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.idCliente = idCliente;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }
    
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public UUID getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
}
