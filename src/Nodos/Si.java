package Nodos;

import Expresiones.Expresion;
import TiposDeDato.TipoDato;

public class Si extends Nodo
{

    private Expresion expresion;
    private Nodo bloque;
    private Nodo otro;

    public Si(Expresion expresion, Nodo bloque, Nodo otro, Nodo siguiente)
    {
        this.expresion = expresion;
        this.bloque = bloque;
        this.otro = otro;
        this.siguiente = siguiente;
    }

    public Si(Expresion expresion, Nodo bloque, Nodo otro)
    {
        this.expresion = expresion;
        this.bloque = bloque;
        this.otro = otro;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.expresion.validaTipos();
        this.bloque.validaTipos();
        if(otro != null){
            this.otro.validaTipos();
        }
        
        if(expresion.tipoDato == TipoDato.ENTERO && bloque.tipoDato == TipoDato.VACIO){
            if(otro != null){
                if(otro.tipoDato == TipoDato.VACIO){
                    tipoDato = TipoDato.VACIO;
                }
            }
            else{
                tipoDato = TipoDato.VACIO;
            }
            
        }
        else{
            this.tipoDato = TipoDato.ERROR;
            
            if (expresion.tipoDato == TipoDato.ENTERO)
            {
                this.setError("Error en la expresion logica "+expresion.simbolo);
            }
            if(bloque.tipoDato == TipoDato.VACIO)
            {
                this.setError("Error de bloque if "+bloque.simbolo);
            }
            if(otro != null){
                if(otro.tipoDato == TipoDato.VACIO)
                {
                    this.setError("Error en el else "+otro.simbolo);
                }
            }
        }
        
        if(siguiente != null)
        {
            this.siguiente.validaTipos();
        }
    }

    @Override
    public String generaCodigo()
    {
        String etiquetaOtro = siguienteEtiqueta("IF_OTRO");
        String etiquetaFin = siguienteEtiqueta("FIN_IF");
        String codigo = "";
        codigo += expresion.generaCodigo();
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "cmp eax, 0" + "\n";
        codigo += "\t" + "je " + etiquetaOtro + "\n";
        codigo += bloque.generaCodigo();
        codigo += "\t" + "jmp " + etiquetaFin + "\n";
        codigo += "\t" + etiquetaOtro + ":" + "\n";
        if (otro != null)
        {
            codigo += otro.generaCodigo();
        }
        codigo += "\t" + etiquetaFin + ":" + "\n";
        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
