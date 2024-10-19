/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package ECOFORGE.CONTROLADOR;


 *
 * @author YANFER

import ECOFORGE.MODELO.Apartamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorApartamento {

    private DatabaseConnection dbConnection;
    private Connection connection;

    public ControladorApartamento() {
        dbConnection = new DatabaseConnection();
    }

    public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un Apartamento
    public boolean crearApartamento(Apartamento Apartamento) {
        String sql = "INSERT INTO Apartamento (numero_Identificacion, nombre_completo, sisben, subsidio_Ministerio, direccion, telefono, correo_electronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Apartamento.getNumero_Identificacion());
            statement.setString(2, Apartamento.getNombreCompleto());
            statement.setString(3, Apartamento.getSisben());
            statement.setInt(4, Apartamento.getSubsidio_Ministerio());
            statement.setString(5, Apartamento.getDireccion());
            statement.setString(6, Apartamento.getTelefono());
            statement.setString(7, Apartamento.getCorreoElectronico());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un Apartamento por cédula
    public Apartamento obtenerApartamento(String numero_Identificacion) {
        String sql = "SELECT * FROM Apartamento WHERE numero_Identificacion = ?";
        Apartamento Apartamento = null;
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, numero_Identificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Apartamento = new Apartamento(
                        resultSet.getInt("numero_Identificacion"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("sisben"),
                        resultSet.getInt("subsidio_Ministerio"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_electronico")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Apartamento: " + e.getMessage());
        }
        return Apartamento;
    }

    // Método para actualizar un Apartamento
    public boolean actualizarApartamento(Apartamento Apartamento) {
        String sql = "UPDATE Apartamento SET nombre_completo = ?, sisben = ?, subsidio_Ministerio = ?, "
                + " direccion = ?, telefono = ?, correo_electronico = ? WHERE numero_Identificacion = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, Apartamento.getNombreCompleto());
            statement.setString(2, Apartamento.getSisben());
            statement.setInt(3, Apartamento.getSubsidio_Ministerio());
            statement.setString(4, Apartamento.getDireccion());
            statement.setString(5, Apartamento.getTelefono());
            statement.setString(6, Apartamento.getCorreoElectronico());
            statement.setInt(7, Apartamento.getNumero_Identificacion());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Apartamento
    public boolean eliminarApartamento(Integer Numero_Identificacion) {
        String sql = "DELETE FROM Apartamento WHERE numero_Identificacion = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Numero_Identificacion);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los Apartamentos
    public List<Apartamento> obtenerTodosLosApartamentos() {
        String sql = "SELECT * FROM Apartamento";
        List<Apartamento> listaApartamentos = new ArrayList<>();
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Apartamento Apartamento = new Apartamento(
                        resultSet.getInt("numero_Identificacion"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("sisben"),
                        resultSet.getInt("subsidio_Ministerio"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_electronico")
                );
                listaApartamentos.add(Apartamento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Apartamentos: " + e.getMessage());
        }
        return listaApartamentos;
    }

    public void llenarTablaApartamentos(JTable tablaApartamentos) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("Sisben");
        modelo.addColumn("Subsidio Ministerio");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo Electrónico");

        // Obtener todos los Apartamentos
        List<Apartamento> listaApartamentos = obtenerTodosLosApartamentos();

        // Agregar los datos al modelo
        for (Apartamento Apartamento : listaApartamentos) {
            Object[] fila = {
                Apartamento.getNumero_Identificacion(),
                Apartamento.getNombreCompleto(),
                Apartamento.getSisben(),
                Apartamento.getSubsidio_Ministerio(),
                Apartamento.getDireccion(),
                Apartamento.getTelefono(),
                Apartamento.getCorreoElectronico()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaApartamentos.setModel(modelo);
    }
}
*/