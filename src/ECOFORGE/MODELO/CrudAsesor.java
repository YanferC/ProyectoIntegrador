/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.Asesor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CrudAsesor {

    private DatabaseConnection dbConnection;
    private Connection connection;

    public CrudAsesor() {
        dbConnection = new DatabaseConnection();
    }

    public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un asesor
    public boolean crearAsesor(Asesor asesor) {
        String sql = "INSERT INTO Asesor (NUMERO_IDENTIFICACION, NOMBRE_COMPLETO, DIRECCION, TELEFONO, CORREO_ELECTRONICO, ID_TIPO_ROL) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, asesor.getNumero_Identificacion());
            statement.setString(2, asesor.getNombre_Completo());
            statement.setString(3, asesor.getDireccion());
            statement.setString(4, asesor.getTelefono());
            statement.setString(5, asesor.getCorreo_Electronico());
            statement.setInt(6, asesor.getId_Tipo_Rol());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear Asesor: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un asesor por cédula
    public Asesor obtenerAsesor(String numero_Identificacion) {
        String sql = "SELECT * FROM Asesor WHERE numero_Identificacion = ?";
        Asesor asesor = null;
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, numero_Identificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                asesor = new Asesor(
                        resultSet.getInt("numero_Identificacion"),
                        resultSet.getString("nombre_Completo"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_Electronico"),
                        resultSet.getInt("id_Tipo_Rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Asesor: " + e.getMessage());
        }
        return asesor;
    }

    // Método para eliminar un asesor
    public boolean eliminarAsesor(Integer Numero_Identificacion) {
        String sql = "DELETE FROM Asesor WHERE numero_Identificacion = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Numero_Identificacion);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar asesor: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener el ID del tipo de rol por cédula
    public Integer obtenerTipoRol(String numero_Identificacion) {
        String sql = "SELECT id_Tipo_Rol FROM Asesor WHERE numero_Identificacion = ?";
        Integer idTipoRol = null;

        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, numero_Identificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idTipoRol = resultSet.getInt("id_Tipo_Rol");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el tipo de rol: " + e.getMessage());
        }
        return idTipoRol;
    }
}
