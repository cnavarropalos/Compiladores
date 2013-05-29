package Nodos;

public class Tipo extends Nodo
{

    public Tipo(String simbolo)
    {
        this.simbolo = simbolo;
    }

    @Override
    public void validaTipos()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generaCodigo()
    {
        String codigo = "";
        if (simbolo.equalsIgnoreCase("int"))
        {
            codigo = "\t" + "DWORD" + "\n";
        }
        else if (simbolo.equalsIgnoreCase("float"))
        {
            codigo = "\t" + "REAL4" + "\n";
        }

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
