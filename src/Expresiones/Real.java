package Expresiones;

import TiposDeDato.TipoDato;

public class Real extends Expresion
{

    public Real(String simbolo)
    {
        this.simbolo = simbolo;
        siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.tipoDato = TipoDato.REAL;
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
