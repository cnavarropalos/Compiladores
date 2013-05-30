package Nodos;

import Expresiones.Expresion;
import TiposDeDato.TipoDato;

public class Para extends Nodo
{

    private Asignacion asignacion;
    private Expresion expresionLogica;
    private Asignacion incremento;
    private Nodo bloque;

    public Para(Asignacion asignacion, Expresion expresionLogica, Asignacion incremento,
                Nodo bloque, Nodo siguiente)
    {
        this.asignacion = asignacion;
        this.expresionLogica = expresionLogica;
        this.incremento = incremento;
        this.bloque = bloque;
        this.siguiente = siguiente;
    }

    public Para(Asignacion asignacion, Expresion expresionLogica, Asignacion incremento,
                Nodo bloque)
    {
        this.asignacion = asignacion;
        this.expresionLogica = expresionLogica;
        this.incremento = incremento;
        this.bloque = bloque;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.asignacion.validaTipos();
        this.expresionLogica.validaTipos();
        this.incremento.validaTipos();
        this.bloque.validaTipos();
        
        tipoDato = TipoDato.ERROR;
        
        if(asignacion.tipoDato != tipoDato)
        {
            if (expresionLogica.tipoDato == TipoDato.ENTERO)
            {
                if(incremento.tipoDato != tipoDato)
                {
                    if(bloque.tipoDato == TipoDato.VACIO)
                    {
                        tipoDato = TipoDato.VACIO;
                    }
                    else
                    {
                       this.setError("Error de bloque for "+bloque.simbolo); 
                    }
                }
                else
                {
                    this.setError("Error en el incremento "+incremento.simbolo);
                }
            }
            else
            {
                this.setError("Error en la expresion logica "+expresionLogica.simbolo);
            }
        }
        else
        {
            this.setError("Error de tipo en la asignacion "+asignacion.simbolo);
        }
        
        if(siguiente != null)
        {
            this.siguiente.validaTipos();
        }
    }

    @Override
    public String generaCodigo()
    {
        String etiquetaInicio = siguienteEtiqueta("INICIO_FOR");
        String etiquetaFin = siguienteEtiqueta("FIN_FOR");
        String codigo = "";
        codigo += asignacion.generaCodigo();
        codigo += "\t" + etiquetaInicio + ":" + "\n";
        codigo += expresionLogica.generaCodigo();
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "cmp eax, 0" + "\n";
        codigo += "\t" + "je " + etiquetaFin + "\n";
        codigo += bloque.generaCodigo();
        codigo += incremento.generaCodigo();
        codigo += "\t" + "jmp " + etiquetaInicio + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
