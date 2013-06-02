package Expresiones;

import TiposDeDato.TipoDato;

public class Multiplicacion extends Expresion
{

    public Multiplicacion(Expresion izquierdo, Expresion derecho)
    {
        super(izquierdo, derecho);
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        izquierdo.validaTipos();
        derecho.validaTipos();
        
        if(izquierdo.tipoDato == derecho.tipoDato && 
           izquierdo.tipoDato != tipoDato.VACIO){
            this.tipoDato = this.izquierdo.tipoDato;
        }
        else{
            this.tipoDato = TipoDato.ERROR;
            this.setError("la expresion "+this.simbolo+" es incompatible");
        }
    }

    @Override
    public String generaCodigo()
    {
        String codigo = "";
        codigo = izquierdo.generaCodigo();
        codigo += derecho.generaCodigo();
        codigo += "\t" + "pop ebx" + "\n";
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "mul ebx" + "\n";
        codigo += "\t" + "push eax" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
