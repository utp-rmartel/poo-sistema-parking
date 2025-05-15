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
public class EstacionamientoBE extends AuditoriaAbs{
    private UUID id;
    private UUID idVehiculo;
    private int idZonaParking;
    private UUID idTarifaPrecio;
    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;
    private int idEstado;
    private int cantidad;

    public EstacionamientoBE() {
    }
    
    public EstacionamientoBE(UUID id) {
        this.id = id;
    }
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(UUID idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdZonaParking() {
        return idZonaParking;
    }

    public void setIdZonaParking(int idZonaParking) {
        this.idZonaParking = idZonaParking;
    }

    public UUID getIdTarifaPrecio() {
        return idTarifaPrecio;
    }

    public void setIdTarifaPrecio(UUID idTarifaPrecio) {
        this.idTarifaPrecio = idTarifaPrecio;
    }

    public Date getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Date fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
    

}
