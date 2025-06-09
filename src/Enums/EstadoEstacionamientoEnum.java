/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Royss
 */
public enum EstadoEstacionamientoEnum {
    EN_CURSO(12),
    FINALIZADO(13);
    
    private final int valor;

    EstadoEstacionamientoEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
