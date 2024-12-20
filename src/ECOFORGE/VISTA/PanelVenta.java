/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author YANFER
 */
import ECOFORGE.CONTROLADOR.ControladorCajaTexto;
import ECOFORGE.CONTROLADOR.ControladorLogin;
import ECOFORGE.CONTROLADOR.ControladorVenta;
import ECOFORGE.CONTROLADOR.CrearVentaEntidad;
import ECOFORGE.MODELO.CalculosDatos;
import ECOFORGE.MODELO.LoginUsuario;
import javax.swing.JOptionPane;
import ECOFORGE.MODELO.Venta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelVenta extends javax.swing.JPanel {

    ControladorCajaTexto controladorCT = new ControladorCajaTexto();
    CrearVentaEntidad crearVenta = null;
    CalculosDatos calculo = null;
    private VentaAddedListener ventaAddedListener;
    private final ControladorVenta controladorVenta;
    private final ControladorLogin controladorLogin;

    /**
     * Creates new form PanelVenta
     */
    public PanelVenta() {
        initComponents();

        crearVenta = new CrearVentaEntidad();

        // Crear instancia del controlador pasando los comboboxes del formulario
        controladorVenta = new ControladorVenta(jcbProyecto, jcbTorre, jcbApartamento);
        calculo = new CalculosDatos();
        controladorLogin = ControladorLogin.obtenerInstancia();

        jcbApartamento.addItemListener(evt -> {
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                Object selectedItem = jcbApartamento.getSelectedItem();
                if (selectedItem != null && !selectedItem.toString().equals("Seleccione...")) {
                    cargarValorTotal();
                } else {
                    jtfPrecioTotalVenta.setText(""); // Limpia el campo si no hay selección válida
                }
            }
        });

        Date fechaActual = new Date();
        jftfFechaVenta.setValue(fechaActual);
        jftfFechaEscritura.setValue(fechaActual);
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
        jtfPrecioTotalVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfIdCliente = new javax.swing.JTextField();
        jtfMatricula = new javax.swing.JTextField();
        jtfIdVenta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtAgregar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfIdAsesor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbProyecto = new javax.swing.JComboBox<>();
        jcbTorre = new javax.swing.JComboBox<>();
        jcbApartamento = new javax.swing.JComboBox<>();
        jtfNumeroApartamento = new javax.swing.JTextField();
        jcbTipoPago = new javax.swing.JComboBox<>();
        jftfFechaEscritura = new javax.swing.JFormattedTextField();
        jftfFechaVenta = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(676, 480));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(175, 229, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(175, 229, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserte datos de la venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 24))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Precio Total Venta:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, -1));

        jtfPrecioTotalVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfPrecioTotalVenta.setEnabled(false);
        jtfPrecioTotalVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPrecioTotalVentaKeyTyped(evt);
            }
        });
        jPanel2.add(jtfPrecioTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 192, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("ID Venta:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Tipo de Pago:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setText("Fecha de Venta:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setText("Matricula:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 100, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setText("Fecha Escritura:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        jtfIdCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfIdCliente.setEnabled(false);
        jPanel2.add(jtfIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 192, -1));

        jtfMatricula.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMatriculaKeyTyped(evt);
            }
        });
        jPanel2.add(jtfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 192, -1));

        jtfIdVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfIdVenta.setEnabled(false);
        jtfIdVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdVentaKeyTyped(evt);
            }
        });
        jPanel2.add(jtfIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 192, -1));

        jPanel3.setBackground(new java.awt.Color(193, 65, 62));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jbtAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/Agregar_30.png"))); // NOI18N
        jbtAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAgregar.setLabel("AGREGAR");
        jbtAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 390, 60));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setText("Asesor:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 180, -1));

        jtfIdAsesor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfIdAsesor.setEnabled(false);
        jtfIdAsesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdAsesorKeyTyped(evt);
            }
        });
        jPanel2.add(jtfIdAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 192, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setText("Apartamento:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 180, -1));

        jcbProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jcbProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 190, -1));

        jcbTorre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jcbTorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 190, -1));

        jcbApartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jcbApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 190, -1));

        jtfNumeroApartamento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtfNumeroApartamento.setEnabled(false);
        jPanel2.add(jtfNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 192, -1));

        jcbTipoPago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jcbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "De Contado", "A Cuotas" }));
        jcbTipoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoPagoItemStateChanged(evt);
            }
        });
        jPanel2.add(jcbTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 190, -1));

        jftfFechaEscritura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jftfFechaEscritura.setEnabled(false);
        jftfFechaEscritura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(jftfFechaEscritura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 190, -1));

        jftfFechaVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jftfFechaVenta.setEnabled(false);
        jftfFechaVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jftfFechaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftfFechaVentaKeyTyped(evt);
            }
        });
        jPanel2.add(jftfFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 190, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 410, 460));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPrecioTotalVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioTotalVentaKeyTyped
        controladorCT.soloLetras(evt);
        controladorCT.longitudCaracter(jtfPrecioTotalVenta, 10, evt);
    }//GEN-LAST:event_jtfPrecioTotalVentaKeyTyped

    private void jtfMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatriculaKeyTyped
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfMatricula, 5, evt);
    }//GEN-LAST:event_jtfMatriculaKeyTyped

    private void jtfIdVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdVentaKeyTyped
        controladorCT.soloNumeros(evt);
        controladorCT.longitudCaracter(jtfIdVenta, 10, evt);
    }//GEN-LAST:event_jtfIdVentaKeyTyped

    private void jbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarActionPerformed
        try {
            // Obtener datos de los campos de texto
            Integer id_Venta = Integer.valueOf(jtfIdVenta.getText());
            Integer precio_Total_Venta = Integer.valueOf(jtfPrecioTotalVenta.getText());
            String tipo_Pago = (String) jcbTipoPago.getSelectedItem();

            String textoFechaVenta = jftfFechaVenta.getText();
            String textoFechaEscritura = jftfFechaEscritura.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date fecha_Venta = formato.parse(textoFechaVenta);
            Date fecha_Escritura = formato.parse(textoFechaEscritura);

            String matricula = jtfMatricula.getText();
            String numero_idcliente = jtfIdCliente.getText();
            String numero_idAsesor = jtfIdAsesor.getText();
            Integer numero_Apartamento = Integer.valueOf((String) jcbApartamento.getSelectedItem());
            // Crear un objeto Cliente
            Venta nuevaVenta = new Venta(id_Venta, precio_Total_Venta, tipo_Pago, fecha_Venta, fecha_Escritura, matricula, numero_idcliente, numero_idAsesor, numero_Apartamento);

            // Agregar cliente utilizando el controlador
            if (crearVenta.armarCrud().Crear(nuevaVenta)) {
                JOptionPane.showMessageDialog(this, "Venta agregada exitosamente.");
                if (ventaAddedListener != null) {
                    ventaAddedListener.onVentaAdded();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar la venta.");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error al convertir las fechas. Por favor, verifica el formato (dd/MM/yyyy).");
        }
    }//GEN-LAST:event_jbtAgregarActionPerformed

    public interface VentaAddedListener {

        void onVentaAdded();
    }

    public void setVentaAddedListener(VentaAddedListener listener) {
        this.ventaAddedListener = listener;
    }

    private void jftfFechaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftfFechaVentaKeyTyped

    }//GEN-LAST:event_jftfFechaVentaKeyTyped

    private void jtfIdAsesorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdAsesorKeyTyped
        controladorCT.longitudCaracter(jtfIdAsesor, 3, evt);
    }//GEN-LAST:event_jtfIdAsesorKeyTyped

    private void jcbTipoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoPagoItemStateChanged

    }//GEN-LAST:event_jcbTipoPagoItemStateChanged

    void cargarIdVenta() {
        String Id = crearVenta.armarCrud().ObtenerID();
        jtfIdVenta.setText(Id);
    }

    void cargarIdCliente(String numero_Cliente) {
        jtfIdCliente.setText(numero_Cliente);
    }

    void cargarIdAsesor() {
        LoginUsuario usuarioActivo = controladorLogin.getUsuarioActivo();
        if (usuarioActivo != null) {
            jtfIdAsesor.setText(usuarioActivo.getID_USUARIO()); // Suponiendo que LoginUsuario tiene el método getIdUsuario
        } else {
            jtfIdAsesor.setText("No hay usuario activo.");
        }
    }

    public void cargarValorTotal() {
        Integer num_Torre = Integer.valueOf((String) jcbTorre.getSelectedItem());
        Integer apt = Integer.valueOf((String) jcbApartamento.getSelectedItem());
        if (apt != null && num_Torre != null) {
            Integer valor_apt = calculo.ObtenerValorApartamento(apt, num_Torre);
            Integer valor_subM = calculo.ObtenerSubsidioMinisterio(Integer.valueOf(jtfIdCliente.getText()));

            Integer valor_Total = calculo.Calcular_Valor_Total(valor_apt, valor_subM);
            jtfPrecioTotalVenta.setText(String.valueOf(valor_Total));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JComboBox<String> jcbApartamento;
    private javax.swing.JComboBox<String> jcbProyecto;
    protected javax.swing.JComboBox<String> jcbTipoPago;
    private javax.swing.JComboBox<String> jcbTorre;
    private javax.swing.JFormattedTextField jftfFechaEscritura;
    private javax.swing.JFormattedTextField jftfFechaVenta;
    private javax.swing.JTextField jtfIdAsesor;
    private javax.swing.JTextField jtfIdCliente;
    protected javax.swing.JTextField jtfIdVenta;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JTextField jtfNumeroApartamento;
    private javax.swing.JTextField jtfPrecioTotalVenta;
    // End of variables declaration//GEN-END:variables
}
