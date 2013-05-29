package GUI.Paneles;

import Ejemplos.*;
import GUI.VentanasEmergentes.*;
import Nodos.Nodo;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class PanelCodigoObjeto extends javax.swing.JPanel implements ActionListener
{

    private Nodo arbolSintactico;

    public PanelCodigoObjeto(Nodo arbolSintactico)
    {
        this.arbolSintactico = arbolSintactico;
        initComponents();

        construyeCodigoObjeto();
    }

    private void construyeCodigoObjeto()
    {
        String codigoObjeto = arbolSintactico.generaCodigo();
        areaCodigoObjeto.append(ArbolSintactico.cabeceraCodigoObjeto);
        areaCodigoObjeto.append(ArbolSintactico.apartadosData);
        areaCodigoObjeto.append(ArbolSintactico.codigoObjetoVariables);
        areaCodigoObjeto.append(ArbolSintactico.aparatadoCode);
        areaCodigoObjeto.append(codigoObjeto);
        areaCodigoObjeto.append(ArbolSintactico.finalizacionCodigoObjeto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        scrollCodigoObjeto = new javax.swing.JScrollPane();
        areaCodigoObjeto = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollCodigoObjeto.setName("scrollCodigoObjeto"); // NOI18N

        areaCodigoObjeto.setEditable(false);
        areaCodigoObjeto.setBackground(new java.awt.Color(0, 0, 0));
        areaCodigoObjeto.setColumns(20);
        areaCodigoObjeto.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        areaCodigoObjeto.setForeground(new java.awt.Color(255, 255, 255));
        areaCodigoObjeto.setRows(5);
        areaCodigoObjeto.setName("areaCodigoObjeto"); // NOI18N
        scrollCodigoObjeto.setViewportView(areaCodigoObjeto);

        add(scrollCodigoObjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 780, 560));

        botonGuardar.setText("Guardar");
        botonGuardar.setName("botonGuardar"); // NOI18N
        botonGuardar.addActionListener(this);
        add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, -1, -1));
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == botonGuardar)
        {
            PanelCodigoObjeto.this.botonGuardarActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botonGuardarActionPerformed
    {//GEN-HEADEREND:event_botonGuardarActionPerformed
        File archivoTemporal = new File("codigo_fuente.txt");
        JFileChooser selectorArchivo = new JFileChooser("");
        selectorArchivo.setSelectedFile(archivoTemporal);
        if (selectorArchivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                String codigo = areaCodigoObjeto.getText();
                try (BufferedWriter archivoGuardar = new BufferedWriter(new FileWriter(selectorArchivo.getSelectedFile(), true)))
                {
                    archivoGuardar.write(codigo);
                }

                VentanaEmergente ventanaEmergente = new VentanaEmergente();
                ventanaEmergente.muestraVentanaEmergente(2, VentanaEmergente.ACEPTAR);

            }
            catch (FileNotFoundException ex)
            {
                VentanaEmergente ventanaEmergente = new VentanaEmergente();
                ventanaEmergente.muestraVentanaEmergente(0, VentanaEmergente.DENEGAR);
            }
            catch (IOException ex)
            {
                VentanaEmergente ventanaEmergente = new VentanaEmergente();
                ventanaEmergente.muestraVentanaEmergente(1, VentanaEmergente.DENEGAR);
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCodigoObjeto;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JScrollPane scrollCodigoObjeto;
    // End of variables declaration//GEN-END:variables
}
