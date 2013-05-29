package GUI.VentanasEmergentes;

import javax.swing.JOptionPane;

public class VentanaEmergente
{
    ////////////////////////////////////////////////////////////////////////////
    //////////////////// A T R I B U T O S /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public static final String ERROR = "error.png";
    public static final String ACEPTAR = "aceptar.png";
    public static final String DENEGAR = "denegar.png";
    public static final String INFORMACION = "informacion.png";
    private static String[] listaMensajes =
    {
        //00
        "No se puede abrir el archivo destino.",
        //01
        "Imposible guardar el archivo.",
        //02
        "Archivo guardado con exito.",
    };

    ////////////////////////////////////////////////////////////////////////////
    //////////////////// M E T O D O S /// /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void muestraVentanaEmergente(int indiceMensaje, String icono)
    {
        JOptionPane.showMessageDialog(
                null,
                listaMensajes[indiceMensaje],
                "CTA Helpdesk",
                JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource(
                "/GUI/Imagenes/Iconos/" + icono)));
    }

    public void muestraVentanaEmergente(String mensaje, String icono)
    {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "CTA Helpdesk",
                JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource(
                "/GUI/Imagenes/Iconos/" + icono)));
    }

    public int muestraVentanaEmergenteOpciones(int indiceMensaje)
    {
        return JOptionPane.showConfirmDialog(null,
                listaMensajes[indiceMensaje]);
    }

    public int muestraVentanaEmergenteOpciones(String mensaje)
    {
        return JOptionPane.showConfirmDialog(null,
                mensaje);
    }
}
