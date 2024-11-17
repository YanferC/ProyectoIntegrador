/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.Conectar;
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

    public LoginUsuario validarCredenciales(String ID_USUARIO, String contrasenaIngresada) {
        String sql = "SELECT * FROM Usuario WHERE ID_USUARIO = ?";
        LoginUsuario login = null;
        DatabaseConnection.configurarConexion("");
        try (PreparedStatement statement = DatabaseConnection.getConexion().prepareStatement(sql)) {
            statement.setString(1, ID_USUARIO);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String contrasenaBD = resultSet.getString("contrasena");
                String tipoRol = resultSet.getString("tipo_Rol");

                if (contrasenaBD.equals(contrasenaIngresada)) {
                    // Configurar la conexión de la base de datos según el rol del usuario
                    DatabaseConnection.configurarConexion(tipoRol);

                    login = new LoginUsuario(
                            resultSet.getString("id_Usuario"),
                            tipoRol,
                            resultSet.getString("Descripcion_Rol"),
                            contrasenaBD
                    );
                    System.out.println("Usuario válido con rol: " + tipoRol);
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                System.out.println("Usuario no existe.");
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }
        return login;
    }

}
