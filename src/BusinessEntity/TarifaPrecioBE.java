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
public class TarifaPrecioBE extends AuditoriaAbs {
    private UUID id;
    private int idTarifa;
    private int idTipoTarifa;
    private double precioBase;
    private double precioAdicional;

    public TarifaPrecioBE() {
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getIdTipoTarifa() {
        return idTipoTarifa;
    }

    public void setIdTipoTarifa(int idTipoTarifa) {
        this.idTipoTarifa = idTipoTarifa;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
    
    
}
