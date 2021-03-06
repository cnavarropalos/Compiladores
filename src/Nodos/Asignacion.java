package Nodos;

import Expresiones.ID;
import Expresiones.Expresion;
import TiposDeDato.TipoDato;

public class Asignacion extends Nodo
{

    private ID identificador;
    private Expresion expresion;

    public Asignacion(ID identificador, Expresion expresion, Nodo siguiente)
    {
        this.identificador = identificador;
        this.expresion = expresion;
        this.siguiente = siguiente;
    }

    public Asignacion(ID identificador, Expresion expresion)
    {
        this.identificador = identificador;
        this.expresion = expresion;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.identificador.validaTipos();
        this.expresion.validaTipos();
        
        if(this.identificador.tipoDato == this.expresion.tipoDato){
            this.tipoDato = this.identificador.tipoDato;
        }
        else{
            this.tipoDato = TipoDato.ERROR;
            this.setError("Tipos incompatibles "+this.identificador.simbolo+" "+this.expresion.simbolo);
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
        codigo += "\t" + "mov " + simbolo + ", eax" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
