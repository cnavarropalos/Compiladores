package Expresiones;

import TiposDeDato.TipoDato;

public class Signo extends Expresion
{

    public Signo(Expresion izquierdo)
    {
        super(izquierdo, null);
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.izquierdo.validaTipos();
        
        this.tipoDato = izquierdo.tipoDato;
        if(this.tipoDato  == TipoDato.ERROR){
            this.setError("Signo invalido "+this.simbolo);
        }
    }

    @Override
    public String generaCodigo()
    {
        String codigo = "";
        codigo += izquierdo.generaCodigo();
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "mov ebx, -1" + "\n";
        codigo += "\t" + "imul ebx" + "\n";
        codigo += "\t" + "push eax" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
