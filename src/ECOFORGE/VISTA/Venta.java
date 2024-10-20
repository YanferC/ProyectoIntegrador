/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

import ECOFORGE.CONTROLADOR.ControladorVentas;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author YANFER
 */
public class Venta extends javax.swing.JFrame {

    /**
     * Creates new form Venta
     */
    PanelCliente agregarCliente = new PanelCliente();
    CardLayout vistaAgregarCliente;
    PanelVenta agregarVenta = new PanelVenta();
    CardLayout vistaAgregarVenta;

    private Asesor formularioVentas;

    public Venta(Asesor formularioVentas) {
        initComponents();
        this.formularioVentas = formularioVentas;
        vistaAgregarCliente = (CardLayout) agregarCliente.getLayout();
        vistaAgregarVenta = (CardLayout) agregarVenta.getLayout();

        // Inicializar el controlador de ventas
        ControladorVentas controladorVentas = new ControladorVentas(this);

        // Establecer el listener en el panel de clientes
        agregarCliente.setClienteAddedListener(controladorVentas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        jpEncabezado = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpPanelBotones = new javax.swing.JPanel();
        jbtAgregarCliente = new javax.swing.JButton();
        jbtRegistrarVenta = new javax.swing.JButton();
        jbtRegistrarCuota = new javax.swing.JButton();
        jpPaneles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpFondo.setBackground(new java.awt.Color(175, 229, 239));
        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpEncabezado.setBackground(new java.awt.Color(108, 93, 71));
        jpEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 188, 71));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpEncabezado.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¡EcoForge - Forjando un Futuro Ecológico!");
        jpEncabezado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jpFondo.add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jpPanelBotones.setBackground(new java.awt.Color(255, 255, 255));
        jpPanelBotones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 99, 94), 3, true));
        jpPanelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtAgregarCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jbtAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar Cliente.png"))); // NOI18N
        jbtAgregarCliente.setText("Agregar Cliente");
        jbtAgregarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAgregarCliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAgregarClienteActionPerformed(evt);
            }
        });
        jpPanelBotones.add(jbtAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 100));

        jbtRegistrarVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jbtRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_Venta.png"))); // NOI18N
        jbtRegistrarVenta.setText("Agregar Venta");
        jbtRegistrarVenta.setEnabled(false);
        jbtRegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegistrarVentaActionPerformed(evt);
            }
        });
        jpPanelBotones.add(jbtRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 100));

        jbtRegistrarCuota.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jbtRegistrarCuota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_Cuota.png"))); // NOI18N
        jbtRegistrarCuota.setText("Agregar Cuotas");
        jbtRegistrarCuota.setEnabled(false);
        jbtRegistrarCuota.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRegistrarCuota.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpPanelBotones.add(jbtRegistrarCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 140, 100));

        jpFondo.add(jpPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 450));

        jpPaneles.setBackground(new java.awt.Color(175, 229, 239));
        jpPaneles.setLayout(new java.awt.CardLayout());
        jpFondo.add(jpPaneles, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 590, 450));

        getContentPane().add(jpFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarClienteActionPerformed
        jpPaneles.add(agregarCliente, "Agregar Cliente");
        vistaAgregarCliente.show(agregarCliente, "Agregar Cliente");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_jbtAgregarClienteActionPerformed

    public void clienteAgregado() {
        jbtAgregarCliente.setEnabled(false); // Deshabilitar Agregar Cliente
        jbtRegistrarVenta.setEnabled(true);   // Habilitar Registrar Venta
        jbtRegistrarVentaActionPerformed(null);
    }

    private void jbtRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegistrarVentaActionPerformed
        // Limpiar el panel de ventas antes de agregarlo
        jpPaneles.removeAll(); // Elimina todos los componentes existentes
        
        jpPaneles.add(agregarVenta, "Agregar Venta");
        vistaAgregarVenta.show(agregarVenta, "Agregar Venta");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_jbtRegistrarVentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta(new Asesor()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtAgregarCliente;
    private javax.swing.JButton jbtRegistrarCuota;
    private javax.swing.JButton jbtRegistrarVenta;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JPanel jpPanelBotones;
    private javax.swing.JPanel jpPaneles;
    // End of variables declaration//GEN-END:variables
}
