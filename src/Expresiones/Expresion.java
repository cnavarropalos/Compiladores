package Expresiones;

import Nodos.Nodo;

public abstract class Expresion extends Nodo
{

    protected Expresion izquierdo;
    protected Expresion derecho;

    public Expresion()
    {
        izquierdo = null;
        derecho = null;
    }

    public Expresion(Expresion izquierdo, Expresion derecho)
    {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        if (izquierdo != null)
        {
            izquierdo.validaTipos();
        }
        if (derecho != null)
        {
            derecho.validaTipos();
        }
    }
}
