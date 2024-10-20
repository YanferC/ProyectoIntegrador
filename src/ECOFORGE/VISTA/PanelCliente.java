/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ECOFORGE.VISTA;

import ECOFORGE.MODELO.Cliente;
import javax.swing.JOptionPane;
import ECOFORGE.CONTROLADOR.ControladorCliente;
import ECOFORGE.CONTROLADOR.ControladorCajaTexto;

/**
 *
 * @author YANFER
 */
public class PanelCliente extends javax.swing.JPanel {

    private ControladorCliente controlador;
    ControladorCajaTexto controladorCT = new ControladorCajaTexto();
    private ClienteAddedListener clienteAddedListener;

    /**
     * Creates new form PanelCliente
     */
    public PanelCliente() {
        initComponents();
        controlador = new ControladorCliente();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNombreCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jtfCorreoElectronico = new javax.swing.JTextField();
        jtfSisben = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jtfSubsidio_Ministerio = new javax.swing.JTextField();
        jtfNumeroIdentificacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtAgregar = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(175, 229, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserte datos del cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 24))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Nombre Completo:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, -1));

        jtfNombreCompleto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreCompletoKeyTyped(evt);
            }
        });
        jPanel2.add(jtfNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 192, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Numero Identificación:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("SISBEN:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setText("Subsidio Ministerio:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("Dirección:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 110, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setText("Telefono:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setText("Correo Electrónico:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 170, -1));

        jtfDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jtfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 192, -1));

        jtfCorreoElectronico.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jtfCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 192, -1));

        jtfSisben.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfSisben.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSisbenKeyTyped(evt);
            }
        });
        jPanel2.add(jtfSisben, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 192, -1));

        jtfTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(jtfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 192, -1));

        jtfSubsidio_Ministerio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfSubsidio_Ministerio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSubsidio_MinisterioKeyTyped(evt);
            }
        });
        jPanel2.add(jtfSubsidio_Ministerio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 192, -1));

        jtfNumeroIdentificacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNumeroIdentificacionKeyTyped(evt);
            }
        });
        jPanel2.add(jtfNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 192, -1));

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        jbtAgregar.setLabel("AGREGAR");
        jbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jbtAgregar)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtAgregar)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 390, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 410, 450));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarActionPerformed
        // Obtener datos de los campos de texto
        Integer numero_Identificacion = Integer.parseInt(jtfNumeroIdentificacion.getText());
        String nombreCompleto = jtfNombreCompleto.getText();
        String sisben = jtfSisben.getText();
        Integer subsidio_Ministerio = Integer.parseInt(jtfSubsidio_Ministerio.getText());
        String direccion = jtfDireccion.getText();
        String telefono = jtfTelefono.getText();
        String correo = jtfCorreoElectronico.getText();

        // Crear un objeto Cliente
        Cliente nuevoCliente = new Cliente(numero_Identificacion, nombreCompleto, sisben, subsidio_Ministerio, direccion, telefono, correo);

        // Agregar cliente utilizando el controlador
        if (controlador.crearCliente(nuevoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");
            // Notificar al listener que se ha agregado un cliente
            if (clienteAddedListener != null) {
                clienteAddedListener.onClienteAdded();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente.");
        }
    }//GEN-LAST:event_jbtAgregarActionPerformed

    public interface ClienteAddedListener {

        void onClienteAdded();
    }

    public void setClienteAddedListener(ClienteAddedListener listener) {
        this.clienteAddedListener = listener;
    }

    private void jtfNumeroIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroIdentificacionKeyTyped
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfNumeroIdentificacion, 10, evt);
    }//GEN-LAST:event_jtfNumeroIdentificacionKeyTyped

    private void jtfSubsidio_MinisterioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSubsidio_MinisterioKeyTyped
        controladorCT.soloNumeros(evt);
    }//GEN-LAST:event_jtfSubsidio_MinisterioKeyTyped

    private void jtfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoKeyTyped
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfTelefono, 10, evt);
    }//GEN-LAST:event_jtfTelefonoKeyTyped

    private void jtfNombreCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreCompletoKeyTyped
        controladorCT.soloLetras(evt);
    }//GEN-LAST:event_jtfNombreCompletoKeyTyped

    private void jtfSisbenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSisbenKeyTyped
        controladorCT.longitudCaracter(jtfSisben, 2, evt);
    }//GEN-LAST:event_jtfSisbenKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JTextField jtfCorreoElectronico;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfNombreCompleto;
    private javax.swing.JTextField jtfNumeroIdentificacion;
    private javax.swing.JTextField jtfSisben;
    private javax.swing.JTextField jtfSubsidio_Ministerio;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables
}