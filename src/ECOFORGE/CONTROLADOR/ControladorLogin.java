/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.DatabaseConnection;
import ECOFORGE.MODELO.LoginUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author YANFER
 */
public class ControladorLogin {

    private static ControladorLogin instancia;
    private LoginUsuario usuarioActivo; // Usuario autenticado actualmente

    // Constructor privado para evitar instanciaciones externas
    private ControladorLogin() { }

    // Método para obtener la única instancia de ControladorLogin
    public static ControladorLogin obtenerInstancia() {
        if (instancia == null) {
            instancia = new ControladorLogin();
        }
        return instancia;
    }

    /**
     * Método para validar credenciales del usuario.
     *
     * @param idUsuario ID del usuario
     * @param contrasena Contraseña ingresada por el usuario
     * @return Objeto LoginUsuario si las credenciales son válidas, null si no lo son.
     */
    public LoginUsuario validarCredenciales(String idUsuario, String contrasena) {
        String sql = "SELECT * FROM Usuario WHERE ID_USUARIO = ?";
        try (Connection conexion = DatabaseConnection.getConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, idUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return procesarValidacion(resultSet, contrasena);
                } else {
                    System.out.println("Usuario no existe.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }
        return null;
    }

    /**
     * Procesa la validación de las credenciales.
     *
     * @param resultSet Resultado de la consulta SQL
     * @param contrasenaIngresada Contraseña ingresada por el usuario
     * @return Objeto LoginUsuario si la validación es exitosa, null si no.
     * @throws SQLException
     */
    private LoginUsuario procesarValidacion(ResultSet resultSet, String contrasenaIngresada) throws SQLException {
        String contrasenaBD = resultSet.getString("contrasena");
        String tipoRol = resultSet.getString("tipo_Rol");

        if (contrasenaBD.equals(contrasenaIngresada)) {
            usuarioActivo = new LoginUsuario(
                    resultSet.getString("id_Usuario"),
                    tipoRol,
                    resultSet.getString("Descripcion_Rol"),
                    contrasenaBD
            );
            System.out.println("Inicio de sesión exitoso para el rol: " + tipoRol + " y Asesor: "+ resultSet.getString("id_Usuario"));
            return usuarioActivo;
        } else {
            System.out.println("Contraseña incorrecta.");
        }
        return usuarioActivo;
    }

    /**
     * Obtiene el usuario actualmente autenticado.
     *
     * @return Usuario activo (LoginUsuario) o null si no hay sesión activa.
     */
    public LoginUsuario getUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * Cierra la sesión del usuario actual.
     */
    public void cerrarSesion() {
        usuarioActivo = null;
        System.out.println("Sesión cerrada.");
    }

}
