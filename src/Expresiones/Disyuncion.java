package Expresiones;

public class Disyuncion extends Expresion
{

    public Disyuncion(Expresion izquierdo, Expresion derecho)
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
        String etiquetaVerdadero = siguienteEtiqueta("OR_VERDADERO");
        String etiquetaFin = siguienteEtiqueta("FIN_OR");
        codigo = izquierdo.generaCodigo();
        codigo += derecho.generaCodigo();
        codigo += "\t" + "pop ebx" + "\n";
        codigo += "\t" + "pop eax" + "\n";
        codigo += "\t" + "cmp eax, 0" + "\n";
        codigo += "\t" + "jne " + etiquetaVerdadero + "\n";
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
