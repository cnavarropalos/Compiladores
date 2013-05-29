package Expresiones;

public class Conjuncion extends Expresion
{

    public Conjuncion(Expresion izquierdo, Expresion derecho)
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
        String etiquetaFalso = siguienteEtiqueta("AND_FALSO");
        String etiquetaFin = siguienteEtiqueta("FIN_AND");
        codigo = izquierdo.generaCodigo();
        codigo += derecho.generaCodigo();
        codigo += "\t" + "pop ebx" + "\n";
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "cmp eax, 0" + "\n";
        codigo += "\t" + "je " + etiquetaFalso + "\n";
        codigo += "\t" + "push 1" + "\n";
        codigo += "\t" + "jmp " + etiquetaFin + "\n";
        codigo += "\t" + etiquetaFalso + ":" + "\n";
        codigo += "\t" + "push 0" + "\n";
        codigo += etiquetaFin + ":" + "\n";

        if (siguiente != null)
        {
            codigo += siguiente.generaCodigo();
        }

        return codigo;
    }
}
