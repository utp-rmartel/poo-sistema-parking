/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.util.Date;
import java.sql.Time;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class ComprobanteBE extends AuditoriaAbs{
    private UUID id;
    private UUID idEstacionamiento;
    private String numeroComprobante;
    private String tipoTarifa;
    private String zonaParking;
    private Double precioBase;
    private Integer cantidad;
    private Double montoTotal;
    private int idMetodoPago;
    private int idEstado;
    private Date fechaPago;

    public ComprobanteBE() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(UUID idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public String getZonaParking() {
        return zonaParking;
    }

    public void setZonaParking(String zonaParking) {
        this.zonaParking = zonaParking;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
    
}
