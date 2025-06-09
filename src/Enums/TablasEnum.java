/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Royss
 */
public enum TablasEnum {
    TIPO_DOCUMENTO(1),
    ROL(2),
    TIPO_VEHICULO(3),
    ESTADO_ZONA(4),
    ESTADO_ESTACIONAMIENTO(5),
    METODO_PAGO(6),
    ESTADO_COMPROBANTE(7);  
    
    private final int valor;

    TablasEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
