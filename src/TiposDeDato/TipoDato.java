package TiposDeDato;

public enum TipoDato
{

    REAL('f'),
    ENTERO('i'),
    VACIO('v'),
    ERROR('e');
    private char identificador;

    private TipoDato(char identificador)
    {
        this.identificador = identificador;
    }
}
