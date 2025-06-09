/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Royss
 */
public enum TipoDocumentoEnum {
    DNI(1),
    PASS(2),
    CEX(3);
    
    private final int valor;

    TipoDocumentoEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
