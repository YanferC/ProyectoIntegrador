/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;
import ECOFORGE.CONTROLADOR.ControladorApartamento;
/**
 *
 * @author SEBASTIAN
 */
public class ApartamentoVista extends javax.swing.JFrame {
    
    private ControladorApartamento apartamento;
    /**
     * Creates new form ApartamentoVista
     */
    public ApartamentoVista() {
        initComponents();
        apartamento = new ControladorApartamento();
        apartamento.conectar();
        apartamento.llenarTablaApartamentos(jtbTablaApartamento);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTablaApartamento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtnAgregar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbTablaApartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero Apartamento", "Valor Apartamento", "Tipo Inmueble", "Area", "Numero torre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbTablaApartamento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 820, 300));

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        jbtnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jbtnActualizar)
                .addGap(64, 64, 64)
                .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 824, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 820, 420));

        jPanel2.setBackground(new java.awt.Color(108, 93, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¡Bienvenido a EcoForge Administrador!");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 430, 43));

        jbtnCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        jbtnCerrarSesion.setText("Cerrar Sesión");
        jPanel2.add(jbtnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 6, -1, 31));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        CreandoApartamento newframe = new CreandoApartamento();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(ApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApartamentoVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCerrarSesion;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JTable jtbTablaApartamento;
    // End of variables declaration//GEN-END:variables
}
