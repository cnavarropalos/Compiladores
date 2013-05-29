package Expresiones;

public class Signo extends Expresion
{

    public Signo(Expresion izquierdo)
    {
        super(izquierdo, null);
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
        codigo += izquierdo.generaCodigo();
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "mov ebx, -1" + "\n";
        codigo += "\t" + "imul ebx" + "\n";
        codigo += "\t" + "push eax" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
