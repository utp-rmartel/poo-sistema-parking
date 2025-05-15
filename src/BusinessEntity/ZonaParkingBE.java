/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author Royss
 */
public class ZonaParkingBE extends AuditoriaAbs{
    private int id;
    private String nombre;
    private String descripcion;
    private int idEstado;
    private int idTipoZona;

    public ZonaParkingBE() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdTipoZona() {
        return idTipoZona;
    }

    public void setIdTipoZona(int idTipoZona) {
        this.idTipoZona = idTipoZona;
    }
    
    
}
