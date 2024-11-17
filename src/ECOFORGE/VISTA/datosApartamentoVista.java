/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import ECOFORGE.CONTROLADOR.CrearApartamentoEntidad;
import javax.swing.JOptionPane;
import ECOFORGE.MODELO.Apartamento;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author SEBASTIAN
 */
public class datosApartamentoVista extends javax.swing.JFrame {
    //Crear instancia de la clase CrearApartamentoEntidad
    CrearApartamentoEntidad crearApartamento = null;

    /**
     * Constructor que inicializa la vista de Apartamento.
     */
    public datosApartamentoVista() {

        initComponents(); //Inicializa los componentes gráficos del JFrame
        ControladorUtilidades.centrarVentana(this); // Centra la ventana en la pantalla
        
        crearApartamento = new CrearApartamentoEntidad();
        // Llenamos la tabla
        List<Apartamento> listaApartamentos = crearApartamento.armarCrud().ObtenerTodo();
        llenarTablaApartamento(listaApartamentos);
    }

    public void llenarTablaApartamento(List<Apartamento> listaApartamentos) {
        //DefaultTableModel modelo = (DefaultTableModel) tProyecto.getModel();
        
        // Crear el modelo de la tabla con las columnas definidas
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{
                    "Número Apartamento", "Valor Apartamento", "Tipo Inmueble",
                    "Área m²", "Número Torre"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Bloquear edición de las celdas
            }
        };

        // Agregar los datos al modelo
        for (Apartamento apartamento : listaApartamentos) {
            Object[] fila = {
                apartamento.getNumero_Apartamento(),
                apartamento.getValor_Apartamento(),
                apartamento.getTipo_Inmueble(),
                apartamento.getArea(),
                apartamento.getNumero_Torre(),};
            modelo.addRow(fila);
        }
        
        tApartamento.setModel(modelo);
        tApartamento.setBackground(Color.decode("#AFE5EF"));
        tApartamento.setForeground(Color.BLACK);             // Texto en negro
        tApartamento.setSelectionBackground(new Color(100, 150, 255)); // Fondo al seleccionar
        tApartamento.setSelectionForeground(Color.WHITE);    // Texto al seleccionar
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
        tApartamento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoForge");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tApartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero Apartamento", "Valor Apartamento", "Tipo Inmueble", "Area m²", "Numero torre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tApartamento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 820, 310));

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_30.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Actualizar_30.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setName(""); // NOI18N
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Eliminar_30.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
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
                .addGap(145, 145, 145)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnActualizar)
                .addGap(91, 91, 91)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 820, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 820, 410));

        jPanel2.setBackground(new java.awt.Color(108, 93, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apartamento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 3, 200, 40));

        btnCerrarSesion.setBackground(new java.awt.Color(255, 188, 71));
        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 31));

        jButton1.setBackground(new java.awt.Color(255, 188, 71));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Regresar_30.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         // Verificar que se ha seleccionado un registro en la tabla
        int filaSeleccionada = tApartamento.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Apartamento para actualizar.");
            return;
        }

        // Obtener los datos del apartamento seleccionado
        Integer numero_Apartamento = Integer.valueOf(tApartamento.getValueAt(filaSeleccionada, 0).toString());
        Integer valor_Apartamento = Integer.valueOf(tApartamento.getValueAt(filaSeleccionada, 1).toString());
        String tipo_Inmueble  = tApartamento.getValueAt(filaSeleccionada, 2).toString();
        Integer area = Integer.valueOf(tApartamento.getValueAt(filaSeleccionada, 3).toString());
        Integer numero_Torre = Integer.valueOf(tApartamento.getValueAt(filaSeleccionada, 4).toString());

        // Abrir el formulario CreandoApartamentoVista y pasar los datos
        CreandoApartamentoVista actualizarApartamento = new CreandoApartamentoVista(this);
        actualizarApartamento.setVisible(true);
        actualizarApartamento.btnAgregar.setEnabled(false);
        // Pasar los datos al formulario
        actualizarApartamento.cargarDatos(numero_Apartamento, valor_Apartamento, tipo_Inmueble, area, numero_Torre);

    }//GEN-LAST:event_btnActualizarActionPerformed
    // Este método se ejecuta cuando se hace clic en el botón de agregar
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        CreandoApartamentoVista apartamentoVistaC = new CreandoApartamentoVista(this); // Crea una nueva ventana para agregar un apartamento
        apartamentoVistaC.setVisible(true); // Muestra la nueva ventana
        apartamentoVistaC.btnActualizar.setEnabled(false);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_btnAgregarActionPerformed
    // Este método se ejecuta cuando se hace clic en el botón de cerrar sesión
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Verificar que se ha seleccionado un registro en la tabla
        int filaSeleccionada = tApartamento.getSelectedRow();

        if (filaSeleccionada == -1) {
            // Si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Apartamento para eliminar.");
            return;
        }

        // Obtener el número del apartamento seleccionado (asumiendo que el número está en la primera columna)
        String numero_Apartamento = tApartamento.getValueAt(filaSeleccionada, 0).toString();
        String numero_Torre = tApartamento.getValueAt(filaSeleccionada, 4).toString();
        // Confirmar la eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este Apartamento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Intentar eliminar el Apartamento
            if (crearApartamento.armarCrud().Eliminar(numero_Apartamento, numero_Torre)) {
                JOptionPane.showMessageDialog(this, "Apartamento eliminado correctamente.");

                // Actualizar la tabla después de eliminar el Apartamento
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el Apartamento.");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DashBoardPrincipal newframe = new DashBoardPrincipal();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tApartamento.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Obtener todos los Apartamentos y agregarlos a la tabla
        List<Apartamento> listaApartamentos = crearApartamento.armarCrud().ObtenerTodo();

        for (Apartamento apartamento : listaApartamentos) {
            Object[] fila = {
                apartamento.getNumero_Apartamento(),
                apartamento.getValor_Apartamento(),
                apartamento.getTipo_Inmueble(),
                apartamento.getArea(),
                apartamento.getNumero_Torre(),};
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
            java.util.logging.Logger.getLogger(datosApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new datosApartamentoVista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tApartamento;
    // End of variables declaration//GEN-END:variables
}
