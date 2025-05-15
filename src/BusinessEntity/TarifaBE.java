/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;


/**
 *
 * @author Royss
 */
public class TarifaBE extends AuditoriaAbs{
   private int id;
   private int idTipoZona;
   private int idTipoVehiculo;

    public TarifaBE() {
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoZona() {
        return idTipoZona;
    }

    public void setIdTipoZona(int idTipoZona) {
        this.idTipoZona = idTipoZona;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }
   
   
}
