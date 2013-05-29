package GUI.Paneles;

import Ejemplos.*;
import Nodos.Nodo;
import java.awt.event.*;
import javax.swing.*;

public class PanelCodigoFuente extends javax.swing.JPanel implements ItemListener, ActionListener
{

    private JTabbedPane panelTabs;
    private String codigoFuente;
    private Nodo arbolSintactico;

    public PanelCodigoFuente(JTabbedPane panelTabs)
    {
        this.panelTabs = panelTabs;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        seleccionadoCodigoFuente = new javax.swing.JComboBox();
        etiquetaCodigoFuente = new javax.swing.JLabel();
        scrollCodigoFuente = new javax.swing.JScrollPane();
        areaCodigoFuente = new javax.swing.JTextArea();
        botonCompilar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seleccionadoCodigoFuente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seleccionadoCodigoFuente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecciona el Codigo -", "Ejemplo 01", "Ejemplo 02", "Ejemplo 03", "Ejemplo 04", "Ejemplo 05", "Ejemplo 06", "Ejemplo 07", "Ejemplo 08", "Ejemplo 09", "Ejemplo 10", "Ejemplo 11", "Ejemplo 12", "Ejemplo 13", "Ejemplo 14", "Ejemplo 15", "Ejemplo 16", "Ejemplo 17", "Ejemplo 18", "Ejemplo 19" }));
        seleccionadoCodigoFuente.setName("seleccionadoCodigoFuente"); // NOI18N
        seleccionadoCodigoFuente.addItemListener(this);
        add(seleccionadoCodigoFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 180, -1));

        etiquetaCodigoFuente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etiquetaCodigoFuente.setText("Codigo Fuente");
        etiquetaCodigoFuente.setName("etiquetaCodigoFuente"); // NOI18N
        add(etiquetaCodigoFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        scrollCodigoFuente.setName("scrollCodigoFuente"); // NOI18N

        areaCodigoFuente.setEditable(false);
        areaCodigoFuente.setColumns(20);
        areaCodigoFuente.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        areaCodigoFuente.setRows(5);
        areaCodigoFuente.setName("areaCodigoFuente"); // NOI18N
        scrollCodigoFuente.setViewportView(areaCodigoFuente);

        add(scrollCodigoFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 610, 350));

        botonCompilar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonCompilar.setText("Compilar");
        botonCompilar.setName("botonCompilar"); // NOI18N
        botonCompilar.addActionListener(this);
        add(botonCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, 90, -1));
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == botonCompilar)
        {
            PanelCodigoFuente.this.botonCompilarActionPerformed(evt);
        }
    }

    public void itemStateChanged(java.awt.event.ItemEvent evt)
    {
        if (evt.getSource() == seleccionadoCodigoFuente)
        {
            PanelCodigoFuente.this.seleccionadoCodigoFuenteItemStateChanged(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionadoCodigoFuenteItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_seleccionadoCodigoFuenteItemStateChanged
    {//GEN-HEADEREND:event_seleccionadoCodigoFuenteItemStateChanged
        if (seleccionadoCodigoFuente.getSelectedIndex() != 0)
        {
            switch (seleccionadoCodigoFuente.getSelectedIndex())
            {
                case 1:
                    codigoFuente = ArbolSintactico.EJEMPLO1.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO1.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 2:
                    codigoFuente = ArbolSintactico.EJEMPLO2.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO2.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 3:
                    codigoFuente = ArbolSintactico.EJEMPLO3.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO3.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 4:
                    codigoFuente = ArbolSintactico.EJEMPLO4.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO4.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 5:
                    codigoFuente = ArbolSintactico.EJEMPLO5.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO5.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 6:
                    codigoFuente = ArbolSintactico.EJEMPLO6.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO6.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 7:
                    codigoFuente = ArbolSintactico.EJEMPLO7.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO7.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 8:
                    codigoFuente = ArbolSintactico.EJEMPLO8.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO8.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 9:
                    codigoFuente = ArbolSintactico.EJEMPLO9.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO9.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 10:
                    codigoFuente = ArbolSintactico.EJEMPLO10.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO10.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 11:
                    codigoFuente = ArbolSintactico.EJEMPLO11.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO11.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 12:
                    codigoFuente = ArbolSintactico.EJEMPLO12.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO12.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 13:
                    codigoFuente = ArbolSintactico.EJEMPLO13.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO13.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 14:
                    codigoFuente = ArbolSintactico.EJEMPLO14.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO14.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 15:
                    codigoFuente = ArbolSintactico.EJEMPLO15.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO15.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 16:
                    codigoFuente = ArbolSintactico.EJEMPLO16.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO16.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 17:
                    codigoFuente = ArbolSintactico.EJEMPLO17.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO17.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 18:
                    codigoFuente = ArbolSintactico.EJEMPLO18.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO18.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
                case 19:
                    codigoFuente = ArbolSintactico.EJEMPLO19.getCodigoFuente();
                    arbolSintactico = ArbolSintactico.EJEMPLO19.getArbolSintactico();
                    areaCodigoFuente.setText(codigoFuente);
                    break;
            }
        }
        else
        {
            codigoFuente = null;
            arbolSintactico = null;
            areaCodigoFuente.setText("");
        }
    }//GEN-LAST:event_seleccionadoCodigoFuenteItemStateChanged

    private void botonCompilarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botonCompilarActionPerformed
    {//GEN-HEADEREND:event_botonCompilarActionPerformed
        if (arbolSintactico != null)
        {
            PanelCodigoObjeto panelCodigoObjeto = new PanelCodigoObjeto(arbolSintactico);
            int indiceTab = panelTabs.indexOfTab("Codigo Objeto");
            if (indiceTab != -1)
            {
                panelTabs.removeTabAt(indiceTab);
            }
            panelTabs.addTab("Codigo Objeto", panelCodigoObjeto);

            int indiceNuevaTab = panelTabs.indexOfTab("Codigo Objeto");
            panelTabs.setSelectedIndex(indiceNuevaTab);
        }
    }//GEN-LAST:event_botonCompilarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCodigoFuente;
    private javax.swing.JButton botonCompilar;
    private javax.swing.JLabel etiquetaCodigoFuente;
    private javax.swing.JScrollPane scrollCodigoFuente;
    private javax.swing.JComboBox seleccionadoCodigoFuente;
    // End of variables declaration//GEN-END:variables
}
