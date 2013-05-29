package Nodos;

import TiposDeDato.TipoDato;

public abstract class Nodo
{

    public static int contadorEtiquetas = 0;
    protected String simbolo;
    protected Nodo siguiente;
    protected TipoDato tipoDato;

    public Nodo()
    {
    }

    public String siguienteEtiqueta(String contexto)
    {
        String nuevaEtiqueta = contexto + "_" + contadorEtiquetas;
        contadorEtiquetas++;
        return nuevaEtiqueta;
    }

    public void validaTipos()
    {
        if (siguiente != null)
        {
            siguiente.validaTipos();
        }

    }

    public String generaCodigo()
    {
        if (siguiente != null)
        {
            siguiente.generaCodigo();
        }

        return "";
    }
}
