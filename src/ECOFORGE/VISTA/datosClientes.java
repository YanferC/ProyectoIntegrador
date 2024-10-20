/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author YANFER
 */
import ECOFORGE.CONTROLADOR.ControladorCrud;
import ECOFORGE.MODELO.Cliente;
import javax.swing.JOptionPane;

public class datosClientes extends javax.swing.JFrame {

    private ControladorCrud controlador;
    private boolean isModoActualizar = false;
    private Clientes formularioClientes;

    /**
     * Creates new form datosClientes
     */
    public datosClientes(Clientes formularioClientes) {
        initComponents();
        this.formularioClientes = formularioClientes;
        controlador = new ControladorCrud();
        configurarFormulario();
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
        jTextFieldCedula = new javax.swing.JTextField();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jTextFieldSisben = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextSubsidio_Ministerio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datos del Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 92, -1, -1));
        getContentPane().add(jTextFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 171, -1));
        getContentPane().add(jTextFieldNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 192, -1));
        getContentPane().add(jTextFieldSisben, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 71, -1));
        getContentPane().add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 196, -1));
        getContentPane().add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 195, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, -1));

        jLabel1.setText("Cédula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 46, -1));

        jLabel2.setText("Nombre Completo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 102, -1));

        jLabel3.setText("SISBEN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 71, -1));

        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 67, -1));

        jLabel6.setText("Correo ELectronico");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 112, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 75, -1));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 99, -1));
        getContentPane().add(jTextSubsidio_Ministerio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 180, -1));

        jLabel7.setText("Subsidio Ministerio");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Obtener datos de los campos de texto
        Integer numero_Identificacion = Integer.parseInt(jTextFieldCedula.getText());
        String nombreCompleto = jTextFieldNombreCompleto.getText();
        String sisben = jTextFieldSisben.getText();
        Integer subsidio_Ministerio = Integer.parseInt(jTextSubsidio_Ministerio.getText());
        String direccion = jTextFieldDireccion.getText();
        String telefono = jTextFieldTelefono.getText();
        String correo = jTextFieldCorreo.getText();

        // Crear un objeto Cliente
        Cliente nuevoCliente = new Cliente(numero_Identificacion, nombreCompleto, sisben, subsidio_Ministerio,direccion, telefono, correo);

        // Agregar cliente utilizando el controlador
        if (controlador.crearCliente(nuevoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");

            // Actualizar la tabla en el formulario Clientes
            formularioClientes.actualizarTabla();

            this.dispose(); // Cerrar el formulario
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (isModoActualizar) {
            // Código para actualizar el cliente
            Integer numero_Identificacion = Integer.parseInt(jTextFieldCedula.getText());
            String nombreCompleto = jTextFieldNombreCompleto.getText();
            String sisben = jTextFieldSisben.getText();
            Integer subsidio_Ministerio = Integer.parseInt(jTextSubsidio_Ministerio.getText());
            String direccion = jTextFieldDireccion.getText();
            String telefono = jTextFieldTelefono.getText();
            String correo = jTextFieldCorreo.getText();
            Cliente actualizarCliente = new Cliente(numero_Identificacion, nombreCompleto, sisben, subsidio_Ministerio,direccion, telefono, correo);
            // Llamar al controlador para actualizar
            if (controlador.actualizarCliente(actualizarCliente)) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
                // Cerrar el formulario después de actualizar
                formularioClientes.actualizarTabla();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el cliente.");
            }
        } else {
            // Código para agregar un nuevo cliente
            // (Ya lo tienes implementado)
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void cargarDatos(Integer numero_Identificacion, String nombre, String sisben, Integer subsidio_Ministerio,
            String direccion, String telefono, String correo) {
        jTextFieldCedula.setText(String.valueOf(numero_Identificacion));
        jTextFieldNombreCompleto.setText(nombre);
        jTextFieldSisben.setText(sisben);
        jTextSubsidio_Ministerio.setText(String.valueOf(subsidio_Ministerio));
        jTextFieldDireccion.setText(direccion);
        jTextFieldTelefono.setText(telefono);
        jTextFieldCorreo.setText(correo);

        // Deshabilitar la caja de texto de cédula para que no sea modificable
        jTextFieldCedula.setEnabled(false);
    }

    public void setModoActualizar(boolean modoActualizar) {
        this.isModoActualizar = modoActualizar;
    }
    
    private void configurarFormulario() {
        if (isModoActualizar) {
            jButton2.setEnabled(true);  // Activar el botón de Actualizar
            jButton1.setEnabled(false);    // Desactivar el botón de Agregar
        } else {
            jButton2.setEnabled(false); // Desactivar el botón de Actualizar
            jButton1.setEnabled(true);     // Activar el botón de Agregar
        }
    }
    
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
            java.util.logging.Logger.getLogger(datosClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datosClientes(new Clientes()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldSisben;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextSubsidio_Ministerio;
    // End of variables declaration//GEN-END:variables
}
