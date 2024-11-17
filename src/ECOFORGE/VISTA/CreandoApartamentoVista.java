/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

import javax.swing.JOptionPane;

import ECOFORGE.CONTROLADOR.ControladorCajaTexto;
import java.util.List;
import ECOFORGE.MODELO.Torre;
import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import ECOFORGE.CONTROLADOR.CrearApartamentoEntidad;
import ECOFORGE.CONTROLADOR.CrearProyectoEntidad;
import ECOFORGE.CONTROLADOR.CrearTorreEntidad;
import ECOFORGE.MODELO.Apartamento;
import ECOFORGE.MODELO.Proyecto;

/**
 *
 * @author juans
 */
public class CreandoApartamentoVista extends javax.swing.JFrame {

    // contiene controladores para manejar la lógica de la interfaz y la conexión a la base de datos.

    private final datosApartamentoVista formularioApartamento;
    private Integer torreSeleccionada; 
    
    ControladorCajaTexto controladorCT = new ControladorCajaTexto();
    CrearApartamentoEntidad crearApartamento = null;
    CrearTorreEntidad crearTorre = null;
    CrearProyectoEntidad crearProyecto = null;
    /**
     * Creates new form CreandoApartamento
     *
     * @param formularioApartamento
     */
    public CreandoApartamentoVista(datosApartamentoVista formularioApartamento) {
        initComponents();
        this.formularioApartamento = formularioApartamento;

        crearApartamento = new CrearApartamentoEntidad();
        crearTorre = new CrearTorreEntidad();
        crearProyecto = new CrearProyectoEntidad();
        ControladorUtilidades.centrarVentana(this);

        btnAgregar.addActionListener(e -> guardarApartamento());

        cargarTorres();
        cargarProyectos();
    }

    public void guardarApartamento() {
        try {

            int numeroApartamento = Integer.parseInt(jtfNumeroApartamento.getText());
            int valorApartamento = Integer.parseInt(jtfValorApartamento.getText());
            String tipoInmueble = (String) cbTipoInmueble.getSelectedItem();
            int area = Integer.parseInt(jtfArea.getText());
            //Obtener el numero de la torre como String y convertirlo a integer
            String numeroTorreString = (String) jcbNumeroTorre.getSelectedItem();
            Integer numeroTorre = Integer.valueOf(numeroTorreString);

            //Creamos un objeto apartamento
            Apartamento apartamento = new Apartamento(numeroApartamento, valorApartamento, tipoInmueble, area, numeroTorre);

            //Llamamos al metodo para guardar el apartamento
            boolean guardado = crearApartamento.armarCrud().Crear(apartamento);

            //Verificar si si se guardo correctamente
            if (guardado) {
                JOptionPane.showMessageDialog(this, "Apartamento guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                datosApartamentoVista apartamentoVista = new datosApartamentoVista();
                apartamentoVista.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el apartamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores validos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTorres() {
        jcbNumeroTorre.removeAllItems();
        // Método que carga las torres disponibles en un JComboBox según el proyecto seleccionado
        String codigo_proyecto = (String) jcbCodigoProyecto.getSelectedItem();
        // Verifica si se ha seleccionado un proyecto
        if (codigo_proyecto != null) {
            Torre torreContenedora = (Torre) crearTorre.armarCrud().ObtenerPorCodigo(codigo_proyecto);
            if (torreContenedora != null && torreContenedora.getTorresRelacionadas() != null) {
                // Agrega cada torre al JComboBox
                for (Torre torre : torreContenedora.getTorresRelacionadas()) {
                    jcbNumeroTorre.addItem(String.valueOf(torre.getNumero_torre()));
                }
            }
        }
    }

    private void cargarProyectos() {
        jcbCodigoProyecto.removeAllItems();

        List<Proyecto> proyectos = crearProyecto.armarCrud().ObtenerTodo();

        for (Proyecto proyecto : proyectos) {
            jcbCodigoProyecto.addItem(proyecto.getCodigo_proyecto());
        }

        // Agregamos un ActionListener para cargar torres cuando se seleccione un proyecto
        jcbCodigoProyecto.addActionListener(e -> cargarTorres());
    }

    public void cargarDatos(Integer numero_Apartamento, Integer valor_Apartamento, String tipo_Inmueble,
            Integer area, Integer numero_Torre) {

        jtfNumeroApartamento.setText(String.valueOf(numero_Apartamento));
        jtfValorApartamento.setText(String.valueOf(valor_Apartamento));
        cbTipoInmueble.setSelectedItem(tipo_Inmueble);
        jtfArea.setText(String.valueOf(area));
        
        jcbNumeroTorre1.removeAllItems();
        jcbNumeroTorre1.addItem(String.valueOf(numero_Torre));  
        
        // Deshabilitar las cajas de texto que no serán modificable
        jtfNumeroApartamento.setEnabled(false);
        jcbNumeroTorre1.setEnabled(false);
        jcbNumeroTorre.setVisible(false);
        jcbCodigoProyecto.setVisible(false);
        jLabel8.setVisible(false);
    }

    public void actualizarApartamento() {
        try {

            int numeroApartamento = Integer.parseInt(jtfNumeroApartamento.getText());
            int valorApartamento = Integer.parseInt(jtfValorApartamento.getText());
            String tipoInmueble = (String) cbTipoInmueble.getSelectedItem();
            int area = Integer.parseInt(jtfArea.getText());
            //Obtener el numero de la torre0
            String numeroTorreString = (String) jcbNumeroTorre1.getSelectedItem();
            Integer numeroTorre = Integer.valueOf(numeroTorreString);

            //Creamos un objeto apartamento
            Apartamento apartamento = new Apartamento(numeroApartamento, valorApartamento, tipoInmueble, area, numeroTorre);

            //Llamamos al metodo para guardar el apartamento
            boolean actualizado = crearApartamento.armarCrud().Actualizar(apartamento);

            //Verificar si si se guardo correctamente
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Apartamento actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Cerrar el formulario después de actualizar
                formularioApartamento.actualizarTabla();
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el apartamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores validos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
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
        btnActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtfArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroTorre = new javax.swing.JLabel();
        jtfValorApartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNumeroApartamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbNumeroTorre = new javax.swing.JComboBox<>();
        jcbCodigoProyecto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbTipoInmueble = new javax.swing.JComboBox<>();
        jcbNumeroTorre1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoForge");
        setBackground(new java.awt.Color(175, 229, 239));
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_30.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Actualizar_30.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnAgregar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 436, 430, 80));

        jPanel4.setBackground(new java.awt.Color(175, 229, 239));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Apartamento"));
        jPanel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAreaKeyTyped(evt);
            }
        });
        jPanel4.add(jtfArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 210, 150, 31));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Area m²");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 54, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Tipo Inmueble");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 93, -1));

        txtNumeroTorre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNumeroTorre.setText("Numero Torre");
        jPanel4.add(txtNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 97, -1));

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

        jcbNumeroTorre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jcbNumeroTorre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbNumeroTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNumeroTorreActionPerformed(evt);
            }
        });
        jPanel4.add(jcbNumeroTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 90, 30));

        jcbCodigoProyecto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jcbCodigoProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jcbCodigoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 120, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Numero Proyecto");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        cbTipoInmueble.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbTipoInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apartamento", "Local", "Bodega" }));
        jPanel4.add(cbTipoInmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 30));

        jcbNumeroTorre1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jcbNumeroTorre1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbNumeroTorre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNumeroTorre1ActionPerformed(evt);
            }
        });
        jPanel4.add(jcbNumeroTorre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 90, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 434, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 510));

        jPanel2.setBackground(new java.awt.Color(108, 93, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creando apartamento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 300, 40));

        jButton1.setBackground(new java.awt.Color(255, 188, 72));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Regresar_30.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Vis_CreandoApartamento.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 310, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNumeroApartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroApartamentoKeyTyped
        // Permite solo números y limita la longitud del texto a 3 caracteres
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfNumeroApartamento, 3, evt);
    }//GEN-LAST:event_jtfNumeroApartamentoKeyTyped

    private void jtfValorApartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorApartamentoKeyTyped
        // Limita la longitud del texto a 10 caracteres
        controladorCT.longitudCaracter(jtfValorApartamento, 10, evt);
    }//GEN-LAST:event_jtfValorApartamentoKeyTyped

    private void jtfAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAreaKeyTyped
        // Permite solo números y limita la longitud del texto a 3 caracteres
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfArea, 3, evt);
    }//GEN-LAST:event_jtfAreaKeyTyped

    private void jcbNumeroTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNumeroTorreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNumeroTorreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarApartamento();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jcbNumeroTorre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNumeroTorre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNumeroTorre1ActionPerformed

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
            java.util.logging.Logger.getLogger(CreandoApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreandoApartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreandoApartamentoVista(new datosApartamentoVista()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbTipoInmueble;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> jcbCodigoProyecto;
    private javax.swing.JComboBox<String> jcbNumeroTorre;
    private javax.swing.JComboBox<String> jcbNumeroTorre1;
    private javax.swing.JTextField jtfArea;
    private javax.swing.JTextField jtfNumeroApartamento;
    private javax.swing.JTextField jtfValorApartamento;
    private javax.swing.JLabel txtNumeroTorre;
    // End of variables declaration//GEN-END:variables
}
