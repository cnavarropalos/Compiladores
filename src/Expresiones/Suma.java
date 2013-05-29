package Expresiones;

public class Suma extends Expresion
{

    public Suma(Expresion izquierdo, Expresion derecho)
    {
        super(izquierdo, derecho);
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
        codigo = izquierdo.generaCodigo();
        codigo += derecho.generaCodigo();
        codigo += "\t" + "pop ebx" + "\n";
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "add eax, ebx" + "\n";
        codigo += "\t" + "push eax" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
