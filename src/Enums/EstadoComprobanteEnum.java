/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Royss
 */
public enum EstadoComprobanteEnum {
    PENDIENTE(17),
    PAGADO(18);
    
    private final int valor;

    EstadoComprobanteEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
