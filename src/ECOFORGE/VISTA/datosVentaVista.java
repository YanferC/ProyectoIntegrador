/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.CrudCuota;

import ECOFORGE.MODELO.Cuota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ECOFORGE.CONTROLADOR.ControladorUtilidades;

public class datosVentaVista extends javax.swing.JFrame {

    private CrudCuota cuota;

    /**
     * Creates new form Asesor
     */
    public datosVentaVista() {

        initComponents();
        cuota = new CrudCuota();
        //cuota.conectar();
        //cuota.llenarTablaCuotas(jTable1);

        ControladorUtilidades.centrarVentana(this);// Centra la ventana en la pantalla

        
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
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jpInferior = new javax.swing.JPanel();
        btnVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpEncabezado.setBackground(new java.awt.Color(108, 93, 71));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¡Bienvenido a EcoForge Asesor!");

        btnCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEncabezadoLayout = new javax.swing.GroupLayout(jpEncabezado);
        jpEncabezado.setLayout(jpEncabezadoLayout);
        jpEncabezadoLayout.setHorizontalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEncabezadoLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(btnCerrarSesion)
                .addContainerGap())
        );
        jpEncabezadoLayout.setVerticalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpEncabezadoLayout.createSequentialGroup()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpFondo.add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 40));

        jpInferior.setBackground(new java.awt.Color(193, 65, 62));

        btnVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Venta_30.png"))); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInferiorLayout = new javax.swing.GroupLayout(jpInferior);
        jpInferior.setLayout(jpInferiorLayout);
        jpInferiorLayout.setHorizontalGroup(
            jpInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInferiorLayout.createSequentialGroup()
                .addContainerGap(690, Short.MAX_VALUE)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpInferiorLayout.setVerticalGroup(
            jpInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpFondo.add(jpInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 790, 70));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jpFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 380));

        getContentPane().add(jpFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
      /**  VentaVista venta = new VentaVista(this);
        venta.setVisible(true); */
    }//GEN-LAST:event_btnVentaActionPerformed

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
            java.util.logging.Logger.getLogger(datosVentaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosVentaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosVentaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosVentaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datosVentaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JPanel jpInferior;
    // End of variables declaration//GEN-END:variables
}
