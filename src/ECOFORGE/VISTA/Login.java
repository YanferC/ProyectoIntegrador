/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author YANFER
 */
import ECOFORGE.CONTROLADOR.ControladorCajaTexto;
import ECOFORGE.CONTROLADOR.ControladorLogin;
import ECOFORGE.CONTROLADOR.ControladorUtilidades;
import ECOFORGE.MODELO.LoginUsuario;

public class Login extends javax.swing.JFrame {

    private ControladorLogin login;// Controlador de login
    private boolean primeraVezUsuario = true, primeraVezContra = true; // Controlar si es la primera vez que se hace clic
    private final ControladorCajaTexto controladorCT = new ControladorCajaTexto();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //login = new ControladorLogin();
        login = ControladorLogin.obtenerInstancia(); 
        ControladorUtilidades.centrarVentana(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLLogoEcoForge = new javax.swing.JLabel();
        jLIcono = new javax.swing.JLabel();
        jLInicioSesion = new javax.swing.JLabel();
        jLusuario = new javax.swing.JLabel();
        jLSeparador = new javax.swing.JSeparator();
        jTFNombreUsuario = new javax.swing.JTextField();
        jLContraseña = new javax.swing.JLabel();
        jLSeparador2 = new javax.swing.JSeparator();
        jPFContraseña = new javax.swing.JPasswordField();
        btnInicioSesion = new javax.swing.JButton();
        btnCrearAsesor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoForge");
        setLocationByPlatform(true);
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLLogoEcoForge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/ECOFORGE.jpg"))); // NOI18N
        Fondo.add(jLLogoEcoForge, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 500));

        jLIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ECOFORGE/IMAGENES/icono.png"))); // NOI18N
        Fondo.add(jLIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 50, 60));

        jLInicioSesion.setFont(new java.awt.Font("Roboto Bk", 0, 36)); // NOI18N
        jLInicioSesion.setText("INICIAR SESIÓN");
        Fondo.add(jLInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 280, 60));

        jLusuario.setFont(new java.awt.Font("Roboto Lt", 1, 14)); // NOI18N
        jLusuario.setText("USUARIO");
        Fondo.add(jLusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 30));
        Fondo.add(jLSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 270, 10));

        jTFNombreUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTFNombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jTFNombreUsuario.setText("Ingrese su usuario");
        jTFNombreUsuario.setBorder(null);
        jTFNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFNombreUsuarioMouseClicked(evt);
            }
        });
        jTFNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreUsuarioActionPerformed(evt);
            }
        });
        jTFNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreUsuarioKeyTyped(evt);
            }
        });
        Fondo.add(jTFNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 280, 30));

        jLContraseña.setFont(new java.awt.Font("Roboto Lt", 1, 14)); // NOI18N
        jLContraseña.setText("CONTRASEÑA");
        Fondo.add(jLContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 30));
        Fondo.add(jLSeparador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 270, 10));

        jPFContraseña.setForeground(new java.awt.Color(204, 204, 204));
        jPFContraseña.setText("jPasswordField1");
        jPFContraseña.setBorder(null);
        jPFContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPFContraseñaMouseClicked(evt);
            }
        });
        Fondo.add(jPFContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 280, 30));

        btnInicioSesion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnInicioSesion.setText("Iniciar Sesión");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });
        Fondo.add(btnInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, 40));

        btnCrearAsesor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCrearAsesor.setText("Crear Asesor");
        btnCrearAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAsesorActionPerformed(evt);
            }
        });
        Fondo.add(btnCrearAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed

        String Passwoard = jPFContraseña.getText();
        String ID_USUARIO = jTFNombreUsuario.getText();

        if (ID_USUARIO.trim().isEmpty() || Passwoard.trim().isEmpty()) {
            // Puedes mostrar un mensaje de alerta si alguno de los campos está vacío
            System.out.println("Por favor, ingrese su usuario y contraseña.");
        } else {
            LoginUsuario usuario = login.validarCredenciales(ID_USUARIO, Passwoard);
            
            /// 1 = Asesor
            if (usuario != null) {
                if ("1".equals(usuario.getTIPO_ROL())) {
                    DashBoardPrincipal ventanaprincipal = new DashBoardPrincipal();
                    ventanaprincipal.setVisible(true);
                    ventanaprincipal.btnProyecto.setEnabled(false); // Desactivar botones de administrador en el DashBoard
                    ventanaprincipal.btnTorre.setEnabled(false);
                    ventanaprincipal.btnApartamento.setEnabled(false);
                } else { /// 2 = Administrador
                    DashBoardPrincipal ventanaprincipal = new DashBoardPrincipal();
                    ventanaprincipal.setVisible(true); // Mostrar dashboard
                    ventanaprincipal.btnVentas.setEnabled(false); // Desactivar botones de Asesor en el DashBoard
                    ventanaprincipal.btnCuota.setEnabled(false);
                    ventanaprincipal.btnCliente.setEnabled(false);
                }
                this.setVisible(false);
            } else {
                // Si el usuario no existe o las credenciales no son válidas
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void jTFNombreUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreUsuarioMouseClicked
        if (primeraVezUsuario) {
            jTFNombreUsuario.setText(""); // Limpia el contenido
            primeraVezUsuario = false; // Marca que ya fue limpiado una vez
        }
    }//GEN-LAST:event_jTFNombreUsuarioMouseClicked

    private void jPFContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPFContraseñaMouseClicked
        if (primeraVezContra) {
            jPFContraseña.setText(""); // Limpia el contenido
            primeraVezContra = false; // Marca que ya fue limpiado una vez
        }
    }//GEN-LAST:event_jPFContraseñaMouseClicked

    private void jTFNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreUsuarioKeyTyped
        controladorCT.soloNumeros(evt);
    }//GEN-LAST:event_jTFNombreUsuarioKeyTyped

    private void btnCrearAsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAsesorActionPerformed
        // TODO add your handling code here:
        datosAsesorVista asesorVista = new datosAsesorVista();
        asesorVista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearAsesorActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btnCrearAsesor;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JLabel jLContraseña;
    private javax.swing.JLabel jLIcono;
    private javax.swing.JLabel jLInicioSesion;
    private javax.swing.JLabel jLLogoEcoForge;
    private javax.swing.JSeparator jLSeparador;
    private javax.swing.JSeparator jLSeparador2;
    private javax.swing.JLabel jLusuario;
    private javax.swing.JPasswordField jPFContraseña;
    private javax.swing.JTextField jTFNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
