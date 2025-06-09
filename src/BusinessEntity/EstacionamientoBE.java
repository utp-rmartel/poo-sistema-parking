/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class EstacionamientoBE extends AuditoriaAbs {

    private UUID id;
    private UUID idVehiculo;
    private int idZonaParking;
    private UUID idTarifa;
    private int idEstado;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
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

    public UUID getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(UUID idTarifa) {
        this.idTarifa = idTarifa;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
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
