package Expresiones;

import Tabla_simbolos.Elemento;
import TiposDeDato.TipoDato;

public class ID extends Expresion
{

    public ID(String simbolo, ID identificador)
    {
        this.simbolo = simbolo;
        this.siguiente = identificador;
    }

    public ID(String simbolo)
    {
        this.simbolo = simbolo;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Elemento identificador = this.tabla_simbolos.getElement(simbolo);
        if(identificador != null){
            tipoDato = identificador.getTipo();
        }
        else{
            this.setError("Variable no definida "+this.simbolo);
            tipoDato = TipoDato.ERROR;
        }
    }

    @Override
    public String generaCodigo()
    {
        String codigo = "";
        codigo += "\t" + "push " + simbolo + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
