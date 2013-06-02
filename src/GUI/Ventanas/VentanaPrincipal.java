package GUI.Ventanas;

import GUI.Paneles.*;

public class VentanaPrincipal extends javax.swing.JFrame
{

    public VentanaPrincipal()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        panelTabs.addTab("Inicio", new PanelPresentacion());
        panelTabs.addTab("Codigo Fuente", new PanelCodigoFuente(panelTabs));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPrincipal = new javax.swing.JScrollPane();
        panelTabs = new javax.swing.JTabbedPane();
        menuPrincipal = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        submenuAbrir = new javax.swing.JMenuItem();
        submenuNuevo = new javax.swing.JMenuItem();
        submenuGuardar = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MCNP Compiler");
        setMaximumSize(null);
        setName("framePrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1015, 800));
        setResizable(false);

        scrollPrincipal.setName("scrollPrincipal"); // NOI18N

        panelTabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        panelTabs.setName("panelTabs"); // NOI18N
        scrollPrincipal.setViewportView(panelTabs);

        getContentPane().add(scrollPrincipal, java.awt.BorderLayout.CENTER);

        menuPrincipal.setName("menuPrincipal"); // NOI18N

        menuArchivo.setText("Archivo");
        menuArchivo.setName("menuArchivo"); // NOI18N

        submenuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        submenuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/abrir.png"))); // NOI18N
        submenuAbrir.setText("Abrir");
        submenuAbrir.setName("submenuAbrir"); // NOI18N
        menuArchivo.add(submenuAbrir);

        submenuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        submenuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/nuevo.png"))); // NOI18N
        submenuNuevo.setText("Nuevo");
        submenuNuevo.setName("submenuNuevo"); // NOI18N
        menuArchivo.add(submenuNuevo);

        submenuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        submenuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/guardar.png"))); // NOI18N
        submenuGuardar.setText("Guardar");
        submenuGuardar.setName("submenuGuardar"); // NOI18N
        menuArchivo.add(submenuGuardar);

        menuPrincipal.add(menuArchivo);

        menuVer.setText("Ver");
        menuVer.setName("menuVer"); // NOI18N
        menuPrincipal.add(menuVer);

        menuAyuda.setText("Ayuda");
        menuAyuda.setName("menuAyuda"); // NOI18N
        menuPrincipal.add(menuAyuda);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuVer;
    private javax.swing.JTabbedPane panelTabs;
    private javax.swing.JScrollPane scrollPrincipal;
    private javax.swing.JMenuItem submenuAbrir;
    private javax.swing.JMenuItem submenuGuardar;
    private javax.swing.JMenuItem submenuNuevo;
    // End of variables declaration//GEN-END:variables
}
