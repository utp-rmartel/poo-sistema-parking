/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Royss
 */
public enum EstadoZonaParkingEnum {
    LIBRE(8),
    OCUPADO(9),
    EN_MANTENIMIENTO(10),
    FUERA_SERVICIO(11);
    
    private final int valor;

    EstadoZonaParkingEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
