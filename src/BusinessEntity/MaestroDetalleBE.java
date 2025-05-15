/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author Royss
 */
public class MaestroDetalleBE extends AuditoriaAbs {
    private int id;
    private int idMaestro;
    private String valor;
    
    public MaestroDetalleBE() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
  
}
