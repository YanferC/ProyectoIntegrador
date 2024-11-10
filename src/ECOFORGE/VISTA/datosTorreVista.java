/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

import ECOFORGE.MODELO.Conectar;
import ECOFORGE.MODELO.CrudTorre;
import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import ECOFORGE.MODELO.DatabaseConnection;
import ECOFORGE.MODELO.Torre;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class datosTorreVista extends javax.swing.JFrame {

    private Conectar controladorConectar;
    private CrudTorre controlador;

    /**
     * Creates new form datosTorreVista
     */
    public datosTorreVista() {
        initComponents();
        // Inicializar el controlador de conexión y lo conectamos conectarlo
        controladorConectar = new Conectar(new DatabaseConnection());
        controladorConectar.conectar();

        controlador = new CrudTorre(controladorConectar);
        ControladorUtilidades.centrarVentana(this);

        // Llenamos la tabla
        List<Torre> listaTorres = controlador.obtenerTodasLasTorres();
        llenarTablaTorres(listaTorres);
    }

    public void llenarTablaTorres(List<Torre> listaTorres) {
        //DefaultTableModel modelo = (DefaultTableModel) tProyecto.getModel();

        // Crear el modelo de la tabla con las columnas definidas
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{
                    "Número Torre", "Numero Pisos", "Código Proyecto"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Bloquear edición de las celdas
            }
        };

        for (Torre torre : listaTorres) {
            Object[] fila = {
                torre.getNumero_torre(),
                torre.getNumero_pisos(),
                torre.getCodigo_proyecto(),};
            modelo.addRow(fila);
        }

        tTorre.setModel(modelo);
        tTorre.setBackground(Color.decode("#AFE5EF"));
        tTorre.setForeground(Color.BLACK);             // Texto en negro
        tTorre.setSelectionBackground(new Color(100, 150, 255)); // Fondo al seleccionar
        tTorre.setSelectionForeground(Color.WHITE);    // Texto al seleccionar
    }
    
    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tTorre.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Obtener todos las Torre y agregarlos a la tabla
        CrudTorre controlador = new CrudTorre(controladorConectar);
        List<Torre> listaTorres = controlador.obtenerTodasLasTorres();

        for (Torre torre : listaTorres) {
            Object[] fila = {
                torre.getNumero_torre(),
                torre.getNumero_pisos(),
                torre.getCodigo_proyecto(),};
            modelo.addRow(fila);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtbCerrarSesion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTorre = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoForge");

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(108, 93, 71));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Torre");

        jtbCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        jtbCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtbCerrarSesion.setText("Cerrar Sesión");

        jButton2.setBackground(new java.awt.Color(255, 188, 72));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Regresar_30.png"))); // NOI18N
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jtbCerrarSesion)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_30.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Actualizar_30.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Eliminar_30.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnAgregar)
                .addGap(71, 71, 71)
                .addComponent(btnActualizar)
                .addGap(66, 66, 66)
                .addComponent(btnEliminar)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 377, -1, -1));

        tTorre.setModel(new javax.swing.table.DefaultTableModel(
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
        tTorre.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tTorre);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 610, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        CreandoTorreVista agregarTorre = new CreandoTorreVista(this);
        agregarTorre.setVisible(true);
        agregarTorre.btnActualizar.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DashBoardPrincipal newframe = new DashBoardPrincipal();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Verificar que se ha seleccionado un registro en la tabla
        int filaSeleccionada = tTorre.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una torre para actualizar.");
            return;
        }

        // Obtener los datos del Proyecto seleccionado
        Integer numero_Torre = Integer.parseInt(tTorre.getValueAt(filaSeleccionada, 0).toString());
        Integer numero_Pisos = Integer.parseInt(tTorre.getValueAt(filaSeleccionada, 1).toString());
        String codigo_proyecto = tTorre.getValueAt(filaSeleccionada, 2).toString();

        // Abrir el formulario CreandoTorreVista y pasar los datos
        CreandoTorreVista actualizarTorre = new CreandoTorreVista(this);
        actualizarTorre.setVisible(true);
        actualizarTorre.btnAgregar.setEnabled(false);
        // Pasar los datos al formulario
        actualizarTorre.cargarDatos(numero_Torre, numero_Pisos, codigo_proyecto);

             // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       // Verificar que se ha seleccionado un registro en la tabla
        int filaSeleccionada = tTorre.getSelectedRow();

        if (filaSeleccionada == -1) {
            // Si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una torre para eliminar.");
            return;
        }

        // Obtener el numero de la torre seleccionado (asumiendo que está en la primera columna)
        Integer numero_Torre = Integer.parseInt(tTorre.getValueAt(filaSeleccionada, 0).toString());
        String codigo_Proyecto = tTorre.getValueAt(filaSeleccionada, 2).toString();
        // Confirmar la eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta Torre?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Crear una instancia del controlador
            CrudTorre torre = new CrudTorre(controladorConectar);

            // Intentar eliminar la torre
            if (controlador.eliminarTorre(numero_Torre, codigo_Proyecto)) {
                JOptionPane.showMessageDialog(this, "Torre eliminada correctamente.");

                // Actualizar la tabla después de eliminar la torre
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la torre.");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(datosTorreVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosTorreVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosTorreVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosTorreVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datosTorreVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jtbCerrarSesion;
    private javax.swing.JTable tTorre;
    // End of variables declaration//GEN-END:variables
}
