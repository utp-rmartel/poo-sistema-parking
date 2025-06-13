/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import BusinessEntity.ClienteBE;
import BusinessEntity.MaestroDetalleBE;
import BusinessEntity.TarifaBE;
import BusinessEntity.VehiculoBE;
import BusinessEntity.ZonaParkingBE;

/**
 *
 * @author Royss
 */
public class EstacionamientoCrearDTO {
    private ClienteBE cliente;
    private VehiculoBE vehiculo;
    private TarifaBE tarifa;
    private ZonaParkingBE zonaParking;
    private int cantidad;

    public EstacionamientoCrearDTO(ClienteBE cliente, VehiculoBE vehiculo, TarifaBE tarifa, ZonaParkingBE zonaParking, int cantidad) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.tarifa = tarifa;
        this.zonaParking = zonaParking;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public ClienteBE getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBE cliente) {
        this.cliente = cliente;
    }

    public VehiculoBE getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoBE vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TarifaBE getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifaBE tarifa) {
        this.tarifa = tarifa;
    }

    public ZonaParkingBE getZonaParking() {
        return zonaParking;
    }

    public void setZonaParking(ZonaParkingBE zonaParking) {
        this.zonaParking = zonaParking;
    }
    
    
    
}
