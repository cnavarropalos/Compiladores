/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla_simbolos;

import TiposDeDato.TipoDato;

/**
 *
 * @author Naye Wonka
 */
public class Elemento {
    private String simbolo;
    private TipoDato tipo;
    
    public Elemento(String simbolo, TipoDato tipo)
    {
        this.simbolo = simbolo;
        this.tipo = tipo;
    }
    public String getSimbolo()
    {
        return simbolo;
    }

    public TipoDato getTipo()
    {
        return tipo;
    }
}
