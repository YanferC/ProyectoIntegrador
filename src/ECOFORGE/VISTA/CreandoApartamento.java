/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;
import javax.swing.JOptionPane;

import ECOFORGE.CONTROLADOR.ControladorCajaTexto;
import java.util.List;
import ECOFORGE.CONTROLADOR.ControladorTorre;
import ECOFORGE.MODELO.Torre;
import ECOFORGE.CONTROLADOR.ControladorApartamento;
import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import javax.swing.*;
import java.awt.event.ActionListener;
import ECOFORGE.MODELO.Apartamento;

/**
 *
 * @author juans
 */
public class CreandoApartamento extends javax.swing.JFrame {

    ControladorCajaTexto controladorCT = new ControladorCajaTexto();
    ControladorTorre controladorTorre = new ControladorTorre();
    ControladorApartamento controladorApartamento = new ControladorApartamento();
    
    
    /** 
     * Creates new form CreandoApartamento
     */
    public CreandoApartamento() {
        initComponents();
        cargarTorres();
        ControladorUtilidades.centrarVentana(this);

        btnAgregar.addActionListener(e -> guardarApartamento());
        
        
        
        

    }

    public void guardarApartamento() {
        try {

            int numeroApartamento = Integer.parseInt(jtfNumeroApartamento.getText());
            int valorApartamento = Integer.parseInt(jtfValorApartamento.getText());
            String tipoInmueble = jtfTipoInmueble.getText();
            int area = Integer.parseInt(jtfArea.getText());
            //Obtener el numero de la torre como String y convertirlo a integer
            String numeroTorreString = (String) jcbNumeroTorre.getSelectedItem();
            Integer numeroTorre = Integer.parseInt(numeroTorreString);

            //Creamos un objeto apartamento
            Apartamento apartamento = new Apartamento(numeroApartamento, valorApartamento, tipoInmueble, area, numeroTorre);
            controladorApartamento.conectar(); //conectamos a la base de datos

            //Llamamos al metodo para guardar el apartamento
            boolean guardado = controladorApartamento.crearApartamento(apartamento);

            //Verificar si si se guardo correctamente
            if (guardado) {
                JOptionPane.showMessageDialog(this, "Apartamento guardado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                ApartamentoVista apartamentoVista = new ApartamentoVista(); 
                apartamentoVista.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el apartamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores validos.", "Error de formto", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTorres() {
        jcbNumeroTorre.removeAllItems();
        List<Torre> torres = controladorTorre.obtenerTodosLosTorres();

        for (Torre torre : torres) {
            jcbNumeroTorre.addItem(String.valueOf(torre.getNumero_torre()));
        }
    }

    
    public void actualizarApartamento() {
        try {

            int numeroApartamento = Integer.parseInt(jtfNumeroApartamento.getText());
            int valorApartamento = Integer.parseInt(jtfValorApartamento.getText());
            String tipoInmueble = jtfTipoInmueble.getText();
            int area = Integer.parseInt(jtfArea.getText());
            //Obtener el numero de la torre como String y convertirlo a integer
            String numeroTorreString = (String) jcbNumeroTorre.getSelectedItem();
            Integer numeroTorre = Integer.parseInt(numeroTorreString);

            //Creamos un objeto apartamento
            Apartamento apartamento = new Apartamento(numeroApartamento, valorApartamento, tipoInmueble, area, numeroTorre);
            controladorApartamento.conectar(); //conectamos a la base de datos

            //Llamamos al metodo para guardar el apartamento
            boolean actualizado = controladorApartamento.actualizarApartamento(apartamento);

            //Verificar si si se guardo correctamente
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Apartamento actualizado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el apartamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores validos.", "Error de formto", JOptionPane.ERROR_MESSAGE);
        }
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
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtfArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfTipoInmueble = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroTorre = new javax.swing.JLabel();
        jtfValorApartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNumeroApartamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbNumeroTorre = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEcharAtras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(175, 229, 239));
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 430, -1));

        jPanel4.setBackground(new java.awt.Color(175, 229, 239));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Apartamento"));
        jPanel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAreaKeyTyped(evt);
            }
        });
        jPanel4.add(jtfArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 144, 31));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Area m²");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 54, -1));

        jtfTipoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTipoInmuebleActionPerformed(evt);
            }
        });
        jtfTipoInmueble.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTipoInmuebleKeyTyped(evt);
            }
        });
        jPanel4.add(jtfTipoInmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 207, 145, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Tipo Inmueble");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 93, -1));

        txtNumeroTorre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNumeroTorre.setText("Numero Torre");
        jPanel4.add(txtNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 97, -1));

        jtfValorApartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorApartamentoKeyTyped(evt);
            }
        });
        jPanel4.add(jtfValorApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 154, 32));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Valor Apartamento");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 127, -1));

        jtfNumeroApartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNumeroApartamentoKeyTyped(evt);
            }
        });
        jPanel4.add(jtfNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 153, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Numero Apartamento");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jcbNumeroTorre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbNumeroTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNumeroTorreActionPerformed(evt);
            }
        });
        jPanel4.add(jcbNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 90, 30));

        jLabel6.setText("*");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 120, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Numero Proyecto");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 434, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 520));

        jPanel2.setBackground(new java.awt.Color(108, 93, 71));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación de apartamento");

        btnCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnEcharAtras.setBackground(new java.awt.Color(255, 188, 71));
        btnEcharAtras.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnEcharAtras.setText("Atrás");
        btnEcharAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEcharAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEcharAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEcharAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Vis_CreandoApartamento.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 310, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTipoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTipoInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTipoInmuebleActionPerformed

    private void btnEcharAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEcharAtrasActionPerformed
        ApartamentoVista newframe = new ApartamentoVista();
        newframe.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnEcharAtrasActionPerformed

    private void jtfNumeroApartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroApartamentoKeyTyped
        controladorCT.soloNumeros(evt);
    }//GEN-LAST:event_jtfNumeroApartamentoKeyTyped

    private void jtfValorApartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorApartamentoKeyTyped
        controladorCT.soloNumeros(evt);
    }//GEN-LAST:event_jtfValorApartamentoKeyTyped

    private void jtfTipoInmuebleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTipoInmuebleKeyTyped
        controladorCT.soloLetras(evt);
    }//GEN-LAST:event_jtfTipoInmuebleKeyTyped

    private void jtfAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAreaKeyTyped
        controladorCT.soloNumeros(evt);
    }//GEN-LAST:event_jtfAreaKeyTyped

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login newframe = new Login();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jcbNumeroTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNumeroTorreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNumeroTorreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(CreandoApartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreandoApartamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEcharAtras;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> jcbNumeroTorre;
    private javax.swing.JTextField jtfArea;
    private javax.swing.JTextField jtfNumeroApartamento;
    private javax.swing.JTextField jtfTipoInmueble;
    private javax.swing.JTextField jtfValorApartamento;
    private javax.swing.JLabel txtNumeroTorre;
    // End of variables declaration//GEN-END:variables
}
