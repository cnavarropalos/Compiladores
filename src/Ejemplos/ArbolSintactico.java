package Ejemplos;

import Expresiones.*;
import Nodos.*;

public enum ArbolSintactico
{

    EJEMPLO1(
    new Variables(new Tipo("int"), new ID("a")),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a;" + "\n"
    + "}" + "\n"),
    
    EJEMPLO2(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c")))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a;" + "\n"
    + "\tint b;" + "\n"
    + "\tint c;" + "\n"
    + "}" + "\n"),
    
    EJEMPLO3(
    new Variables(new Tipo("int"), new ID("a", new ID("b")), new Variables(new Tipo("int"),
    new ID("c", new ID("d")), new Asignacion(new ID("a"), new Entero("3"),
    new Imprime(new ID("a"))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO4(
    new Variables(new Tipo("int"), new ID("a", new ID("b")), new Variables(new Tipo("int"),
    new ID("c", new ID("d")), new Asignacion(new ID("c"), new Entero("5"),
    new Asignacion(new ID("a"), new Suma(new Entero("3"), new ID("c")), new Imprime(new ID("a"),
    new Imprime(new Suma(new Entero("2"), new Multiplicacion(new Entero("3"), new Signo(new Entero("4")))))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO5(
    new Variables(new Tipo("int"), new ID("a", new ID("b")), new Variables(new Tipo("int"),
    new ID("c", new ID("d")), new Asignacion(new ID("b"), new Entero("2"),
    new Asignacion(new ID("c"), new Entero("4"), new Asignacion(new ID("d"),
    new Entero("1"), new Asignacion(new ID("a"), new Suma(new ID("b"),
    new Multiplicacion(new ID("c"), new ID("d"))), new Imprime(new ID("a")))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO6(
    new Variables(new Tipo("int"), new ID("a", new ID("z")), new Asignacion(new ID("z"),
    new Entero("0"), new Asignacion(new ID("a"), new Entero("5"),
    new Si(new Relacional(">", new ID("a"), new Entero("2")),
    new Asignacion(new ID("z"), new Entero("1")), null, new Imprime(new ID("z")))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO7(
    new Variables(new Tipo("int"), new ID("a", new ID("z")), new Asignacion(new ID("a"),
    new Entero("5"), new Si(new Relacional(">", new ID("a"), new Entero("2")),
    new Asignacion(new ID("z"), new Entero("1")), new Asignacion(new ID("z"),
    new Entero("0")), new Imprime(new ID("z"))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO8(
    new Variables(new Tipo("int"), new ID("a", new ID("b")), new Asignacion(new ID("a"),
    new Entero("5"), new Asignacion(new ID("b"), new Entero("10"),
    new Si(new Conjuncion(new Relacional("<=", new ID("a"), new Entero("10")),
    new Relacional(">=", new ID("b"), new Entero("20"))), new Asignacion(new ID("z"),
    new Entero("1")), new Asignacion(new ID("z"), new Entero("0")),
    new Imprime(new ID("z")))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO9(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("z"))),
    new Asignacion(new ID("a"), new Entero("5"), new Asignacion(new ID("b"),
    new Entero("10"), new Si(new Conjuncion(new Relacional("<=",
    new ID("a"), new Entero("10")), new Relacional(">=", new ID("b"),
    new Entero("20"))), new Asignacion(new ID("z"), new Entero("1")),
    new Asignacion(new ID("z"), new Entero("0")), new Imprime(new ID("z")))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO10(
    new Variables(new Tipo("int"), new ID("a", null), null),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO11(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c"))),
    new Asignacion(new ID("a"), new Entero("5"), new Asignacion(new ID("b"),
    new Entero("21"), new Asignacion(new ID("c"), new Entero("2"),
    new Si(new Conjuncion(new Relacional("<=", new ID("a"), new Entero("10")),
    new Disyuncion(new Relacional(">=", new ID("b"), new Entero("20")),
    new Relacional("<", new ID("c"), new Entero("10")))), new Asignacion(new ID("z"),
    new Entero("1")), new Asignacion(new ID("z"), new Entero("0")),
    new Imprime(new ID("z"))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO12(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c",
    new ID("z")))), new Asignacion(new ID("a"), new Entero("5"),
    new Asignacion(new ID("b"), new Entero("21"),
    new Asignacion(new ID("c"), new Entero("2"), new Si(new Conjuncion(
    new Relacional("<=", new ID("a"), new Entero("10")),
    new Disyuncion(new Relacional(">=", new ID("b"), new Entero("20")),
    new Relacional("<", new ID("c"), new Entero("10")))),
    new Asignacion(new ID("z"), new Entero("1")), new Asignacion(new ID("z"),
    new Entero("0")), new Imprime(new ID("z"))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO13(
    new Variables(new Tipo("int"), new ID("i"), new Para(new Asignacion(
    new ID("i"), new Entero("0")), new Relacional("<", new ID("i"),
    new Entero("100")), new Asignacion(new ID("i"), new Suma(new ID("i"),
    new Entero("1"))), new Imprime(new ID("i")))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO14(
    new Variables(new Tipo("int"), new ID("a", new ID("c", new ID("i", new ID("j")))),
    new Asignacion(new ID("a"), new Entero("5"), new Asignacion(new ID("b"),
    new Entero("23"), new Asignacion(new ID("c"), new Entero("6"),
    new Asignacion(new ID("j"), new Entero("7"), new Si(new Conjuncion(new Relacional("<=",
    new ID("a"), new Entero("10")), new Disyuncion(new Relacional(">=", new ID("b"),
    new Entero("20")), new Relacional("!=", new ID("c"), new Entero("30")))),
    new Asignacion(new ID("j"), new Suma(new ID("j"), new Entero("2"))),
    new Asignacion(new ID("j"), new Entero("0")), new Para(new Asignacion(
    new ID("i"), new ID("j")), new Relacional("<", new ID("i"), new Entero("10")),
    new Asignacion(new ID("i"), new Suma(new ID("i"), new Entero("1"))),
    new Imprime(new ID("i"))))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO15(
    new Variables(new Tipo("int"), new ID("a", new ID("c", new ID("i",
    new ID("j", new ID("b"))))), new Asignacion(new ID("a"), new Entero("5"),
    new Asignacion(new ID("b"), new Entero("23"), new Asignacion(
    new ID("c"), new Entero("6"), new Asignacion(new ID("j"),
    new Entero("7"), new Si(new Conjuncion(new Relacional("<=",
    new ID("a"), new Entero("10")), new Disyuncion(new Relacional(">=",
    new ID("b"), new Entero("20")), new Relacional("!=", new ID("c"),
    new Entero("30")))), new Asignacion(new ID("j"), new Suma(new ID("j"),
    new Entero("2"))), new Asignacion(new ID("j"), new Entero("0")),
    new Para(new Asignacion(new ID("i"), new ID("j")), new Relacional("<", new ID("i"),
    new Entero("10")), new Asignacion(new ID("i"), new Suma(new ID("i"),
    new Entero("1"))), new Imprime(new ID("i"))))))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO16(
    new Variables(new Tipo("int"), new ID("a"), new Variables(new Tipo("float"),
    new ID("x"), new Asignacion(new ID("a"), new ID("x")))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO17(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c"))),
    new Asignacion(new ID("a"), new Entero("2"), new Asignacion(new ID("b"),
    new Multiplicacion(new Entero("3"), new ID("a")), new Asignacion(new ID("c"),
    new Suma(new ID("a"), new Multiplicacion(new ID("b"), new ID("d"))),
    new Imprime(new ID("c")))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO18(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c"))),
    new Variables(new Tipo("float"), new ID("d"),
    new Asignacion(new ID("a"), new Suma(new Entero("2"),
    new Multiplicacion(new Entero("3"), new ID("d"))), new Imprime(new ID("a"))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n"),
    
    EJEMPLO19(
    new Variables(new Tipo("int"), new ID("a", new ID("b", new ID("c"))),
    new Asignacion(new ID("b"), new Entero("2"), new Asignacion(new ID("c"),
    new Entero("3"), new Asignacion(new ID("a"), new Suma(new ID("b"),
    new Multiplicacion(new ID("c"), new Real("2.5"))), new Imprime(new ID("a")))))),
    "public static void main(String[] args)" + "\n"
    + "{" + "\n"
    + "\tint a" + "\n"
    + "}" + "\n");
    
    private Nodo arbolSintactico;
    private String codigoFuente;
    public static String codigoObjetoVariables;
    public static String cabeceraCodigoObjeto =
            ".386" + "\n"
            + ".model flat, stdcall" + "\n"
            + "option casemap:none" + "\n" + "\n"
            + "include \\masm32\\macros\\macros.asm" + "\n"
            + "include \\masm32\\include\\masm32.inc" + "\n"
            + "include \\masm32\\include\\kernel32.inc" + "\n" + "\n"
            + "includelib \\masm32\\lib\\masm32.lib" + "\n"
            + "includelib \\masm32\\lib\\kernel32.lib" + "\n" + "\n";
    public static String apartadosData =
            "data" + "\n" + "\n"
            + ".data?" + "\n" + "\n";
    public static String aparatadoCode =
            "\n" + ".code" + "\n" + "\n"
            + "inicio:" + "\n" + "\n";
    public static String finalizacionCodigoObjeto =
            "\n" + "\t" + "exit" + "\n" + "\n"
            + "end inicio" + "\n";

    private ArbolSintactico(Nodo arbolSintactico, String codigoFuente)
    {
        this.arbolSintactico = arbolSintactico;
        this.codigoFuente = codigoFuente;
    }

    public Nodo getArbolSintactico()
    {
        return arbolSintactico;
    }

    public void setArbolSintactico(Nodo arbolSintactico)
    {
        this.arbolSintactico = arbolSintactico;
    }

    public String getCodigoFuente()
    {
        return codigoFuente;
    }

    public void setCodigoFuente(String codigoFuente)
    {
        this.codigoFuente = codigoFuente;
    }
}
