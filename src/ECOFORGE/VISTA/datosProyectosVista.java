/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author SEBASTIAN
 */
import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import ECOFORGE.CONTROLADOR.CrearProyectoEntidad;
import ECOFORGE.MODELO.Proyecto;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class datosProyectosVista extends javax.swing.JFrame {

    //Crear instancia de la clase CrearProyectoEntidad
    CrearProyectoEntidad crearProyecto = null;

    public datosProyectosVista() {
        initComponents();

        ControladorUtilidades.centrarVentana(this);

        crearProyecto = new CrearProyectoEntidad();
        // Llenamos la tabla
        List<Proyecto> listaProyectos = crearProyecto.armarCrud().ObtenerTodo();
        llenarTablaProyectos(listaProyectos);
    }

    public void llenarTablaProyectos(List<Proyecto> listaProyectos) {
        //DefaultTableModel modelo = (DefaultTableModel) tProyecto.getModel();

        // Crear el modelo de la tabla con las columnas definidas
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{
                    "Código Proyecto", "Nombre Proyecto"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Bloquear edición de las celdas
            }
        };

        // Agregar los datos al modelo
        for (Proyecto proyecto : listaProyectos) {
            Object[] fila = {
                proyecto.getCodigo_proyecto(),
                proyecto.getNombre_proyecto(),};
            modelo.addRow(fila);
        }

        tProyecto.setModel(modelo);
        tProyecto.setBackground(Color.decode("#AFE5EF"));
        tProyecto.setForeground(Color.BLACK);             // Texto en negro
        tProyecto.setSelectionBackground(new Color(100, 150, 255)); // Fondo al seleccionar
        tProyecto.setSelectionForeground(Color.WHITE);    // Texto al seleccionar
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbtCerrarSesion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProyecto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoForge");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(175, 229, 239));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(108, 93, 71));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Proyecto");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 60));

        jbtCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        jbtCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbtCerrarSesion.setText("Cerrar Sesión");
        jbtCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCerrarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(jbtCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, 38));

        jButton1.setBackground(new java.awt.Color(255, 188, 72));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Regresar_30.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        tProyecto.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Código Proyecto", "Nombre Proyecto"}));
        tProyecto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tProyecto);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 770, 380));

        jPanel2.setBackground(new java.awt.Color(193, 65, 62));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_30.png"))); // NOI18N
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setLabel("AGREGAR");
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 50));

        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Actualizar_30.png"))); // NOI18N
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setLabel("ACTUALIZAR");
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 50));

        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Eliminar_30.png"))); // NOI18N
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setLabel("ELIMINAR");
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 102, 50));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 770, 70));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 774, 507));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        /**
         * // Verificar que se ha seleccionado un registro en la tabla
         */
        int filaSeleccionada = tProyecto.getSelectedRow();

        if (filaSeleccionada == -1) { // Si no se ha seleccionado ninguna fila 
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un proyecto para eliminar.");
            return;
        }

        // Obtener el código del Proyecto seleccionado (asumiendo que el código está en la primera columna) 
        String codigo_proyecto = tProyecto.getValueAt(filaSeleccionada, 0).toString();

        // Confirmar la eliminación 
        int confirmacion
                = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este proyecto?", "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) { // Crear una instancia del controlador //
            // Intentar eliminar el Proyecto 
            if (crearProyecto.armarCrud().Eliminar(codigo_proyecto, null)) {
                JOptionPane.showMessageDialog(this, "Proyecto eliminado correctamente.");

                // Actualizar la tabla después de eliminar el Proyecto
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al eliminar el Proyecto.");
            }
        } // TODO add your handling code here:

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Verificar que se ha seleccionado un registro en la tabla
        int filaSeleccionada = tProyecto.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un proyecto para actualizar.");
            return;
        }

        // Obtener los datos del Proyecto seleccionado
        String codigo_proyecto = tProyecto.getValueAt(filaSeleccionada, 0).toString();
        String nombre_proyecto = tProyecto.getValueAt(filaSeleccionada, 1).toString();

        // Abrir el formulario CreandoProyectoVista y pasar los datos
        CreandoProyectoVista actualizarProyecto = new CreandoProyectoVista(this);
        actualizarProyecto.setVisible(true);
        actualizarProyecto.btnGuardar.setEnabled(false);
        // Pasar los datos al formulario
        actualizarProyecto.cargarDatos(codigo_proyecto, nombre_proyecto);

        // TODO add your handling code here:

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        CreandoProyectoVista agregarProyecto = new CreandoProyectoVista(this);
        agregarProyecto.setVisible(true);
        agregarProyecto.btnActualizar.setEnabled(false);
        agregarProyecto.setCodigoProyecto(crearProyecto.armarCrud().ObtenerID());
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jbtCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCerrarSesionActionPerformed
        Login inicioSesion = new Login();
        inicioSesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtCerrarSesionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DashBoardPrincipal vistaPrincipal = new DashBoardPrincipal();
    
    
    vistaPrincipal.setVisible(true);
    
    
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tProyecto.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Obtener todos los Proyectos y agregarlos a la tabla
        List<Proyecto> listaProyectos = crearProyecto.armarCrud().ObtenerTodo();

        for (Proyecto proyecto : listaProyectos) {
            Object[] fila = {
                proyecto.getCodigo_proyecto(),
                proyecto.getNombre_proyecto(),};
            modelo.addRow(fila);
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
            java.util.logging.Logger.getLogger(datosProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new datosProyectosVista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCerrarSesion;
    private javax.swing.JTable tProyecto;
    // End of variables declaration//GEN-END:variables
}
