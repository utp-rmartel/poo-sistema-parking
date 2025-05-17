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
    private String tipo;
    private String marca;
    private String modelo;
    private String color;
    private UUID idCliente;
    
    public VehiculoBE() {
    }
    
    public VehiculoBE(String placa, String tipo, String marca, String modelo, String color, UUID idCliente) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.idCliente = idCliente;
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
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
