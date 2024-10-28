/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

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
    private final Connection conexion;

    public ControladorLogin(ControladorConectar controladorConectar) {
        this.conexion = controladorConectar.getConexion();
    }
    
    // Método para validar usuario y rol
    public LoginUsuario validarCredenciales(String ID_USUARIO, String contrasenaIngresada) {
        String sql = "SELECT * FROM Usuario WHERE ID_USUARIO = ?";
        LoginUsuario login = null;
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, ID_USUARIO);
            ResultSet resultSet = statement.executeQuery();

            // Verificar si el usuario existe
            if (resultSet.next()) {
                String contrasenaBD = resultSet.getString("contrasena");
                String tipoRol = resultSet.getString("tipo_Rol");

                // Verificar si la contraseña coincide
                if (contrasenaBD.equals(contrasenaIngresada)) {
                    // Crear el objeto LoginUsuario si las credenciales son válidas
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
    
    // Método para obtener el ID del tipo de rol por cédula
    public Integer obtenerTipoRol(String ID_USUARIO) {
        String sql = "SELECT TIPO_ROL FROM Usuario WHERE ID_USUARIO = ?";
        Integer idTipoRol = null;

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, ID_USUARIO);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idTipoRol = resultSet.getInt("TIPO_ROL");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el tipo de rol: " + e.getMessage());
        }
        return idTipoRol;
    }
}
