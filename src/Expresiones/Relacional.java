package Expresiones;

import TiposDeDato.TipoDato;

public class Relacional extends Expresion
{

    public Relacional(String simbolo, Expresion izquierdo, Expresion derecho)
    {
        super(izquierdo, derecho);
        this.simbolo = simbolo;
    }

    private String getCodigoOperador()
    {
        String codigoOperador;
        switch (simbolo)
        {
            case "<":
                codigoOperador = " jl ";
                break;
            case "<=":
                codigoOperador = " jle ";
                break;
            case ">":
                codigoOperador = " jg ";
                break;
            case ">=":
                codigoOperador = " jge ";
                break;
            case "==":
                codigoOperador = " je ";
                break;
            case "!=":
                codigoOperador = " jne ";
                break;
            default:
                codigoOperador = " jmp ";
        }
        return codigoOperador;
    }

    @Override
    public void validaTipos()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.izquierdo.validaTipos();
        this.derecho.validaTipos();
        
        if((izquierdo.tipoDato == derecho.tipoDato) && (izquierdo.tipoDato == tipoDato.ENTERO))
        {
            this.tipoDato = izquierdo.tipoDato;
        }
        else
        {
            this.tipoDato = tipoDato.ERROR;
            this.setError("Error en la expresion "+this.simbolo);
        }
    }

    @Override
    public String generaCodigo()
    {
        String etiquetaVerdadero = siguienteEtiqueta("RELACIONAL_VERDADERO");
        String etiquetaFin = siguienteEtiqueta("FIN_RELACIONAL");
        String codigo = "";
        codigo += izquierdo.generaCodigo();
        codigo += derecho.generaCodigo();
        codigo += "\t" + "pop ebx" + "\n";
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "cmp eax, ebx" + "\n";
        codigo += "\t" + getCodigoOperador() + " " + etiquetaVerdadero + "\n";
        codigo += "\t" + "push 0" + "\n";
        codigo += "\t" + "jmp " + etiquetaFin + "\n";
        codigo += "\t" + etiquetaVerdadero + ":" + "\n";
        codigo += "\t" + "push 1" + "\n";
        codigo += "\t" + etiquetaFin + ":" + "\n";
        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
