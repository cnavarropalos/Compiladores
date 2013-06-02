package Nodos;

import Expresiones.Expresion;
import TiposDeDato.TipoDato;

public class Imprime extends Nodo
{

    private Expresion expresion;

    public Imprime(Expresion expresion, Nodo siguiente)
    {
        this.expresion = expresion;
        this.siguiente = siguiente;
    }

    public Imprime(Expresion expresion)
    {
        this.expresion = expresion;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.expresion.validaTipos();
        
        if(this.expresion.tipoDato != TipoDato.VACIO){
            this.tipoDato = tipoDato.ERROR;
            this.setError("Error en la expresion de "+this.simbolo);
        }
        else{
            this.tipoDato = this.expresion.tipoDato;
        }
        
        if(this.siguiente != null){
            this.siguiente.validaTipos();
        }
    }

    @Override
    public String generaCodigo()
    {
        String codigo = "";
        codigo += expresion.generaCodigo();
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "print str$(eax)" + "\n";
        codigo += "\t" + "print chr$('', 13)" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
