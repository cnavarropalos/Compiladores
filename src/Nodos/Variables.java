package Nodos;

import Ejemplos.ArbolSintactico;
import Expresiones.ID;

public class Variables extends Nodo
{

    private Tipo tipo;
    private ID identificador;

    public Variables(Tipo tipo, ID identificador, Nodo siguiente)
    {
        this.tipo = tipo;
        this.identificador = identificador;
        this.siguiente = siguiente;
    }

    public Variables(Tipo tipo, ID identificador)
    {
        this.tipo = tipo;
        this.identificador = identificador;
        this.siguiente = null;
    }

    @Override
    public void validaTipos()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generaCodigo()
    {
        String codigoTipo = tipo.generaCodigo();
        String codigo = "";
        Nodo nodoAuxiliar = identificador;
        while (nodoAuxiliar != null)
        {
            ArbolSintactico.codigoObjetoVariables += "\t" + simbolo + " " + codigoTipo.replaceAll("\n", "") + "?" + "\n";
            nodoAuxiliar = nodoAuxiliar.siguiente;
        }

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
