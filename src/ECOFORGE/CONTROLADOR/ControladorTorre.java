/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorTorre {

    private DatabaseConnection dbConnection;
    private Connection connection;

    public ControladorTorre() {
        dbConnection = new DatabaseConnection();
    }

    public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un Torre
    public boolean crearTorre(Torre torre) {
        String sql = "INSERT INTO torre (numero_torre, numero_pisos, codigo_proyecto) VALUES (?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, torre.getNumero_torre());
            statement.setInt(2, torre.getNumero_pisos());
            statement.setString(3, torre.getCodigo_proyecto());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear Torre: " + e.getMessage());
            return false;
        }
    }

    // Método para leer Torres por proyecto
    public Torre obtenerTorre(Integer codigo_proyecto) {
        String sql = "SELECT * FROM torre WHERE codigo_proyecto = ?";
        Torre torre = null;
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, codigo_proyecto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                torre = new Torre(
                        resultSet.getInt("numero_torre"),
                        resultSet.getInt("numero_pisos"),
                        resultSet.getString("codigo_proyecto")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Torre: " + e.getMessage());
        }
        return torre;
    }

    // Método para actualizar un Torre
    public boolean actualizarTorre(Torre Torre) {
        String sql = "UPDATE Torre SET numero_torre = ? numero_pisos = ?, codigo_proyecto = ? WHERE numero_torre = ? and codigo_proyecto = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Torre.getNumero_torre());
            statement.setInt(2, Torre.getNumero_pisos());
            statement.setString(3, Torre.getCodigo_proyecto());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Torre: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Torre
    public boolean eliminarTorre(Integer numero_torre, Integer codigo_proyecto) {
        String sql = "DELETE FROM Torre WHERE numero_torre = ? and codigo_proyecto = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, numero_torre);
            statement.setInt(1, codigo_proyecto);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Torre: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los Torres
    public List<Torre> obtenerTodosLosTorres() {
        String sql = "SELECT * FROM torre";
        List<Torre> listaTorres = new ArrayList<>();
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Torre Torre = new Torre(
                        resultSet.getInt("numero_torre"),
                        resultSet.getInt("numero_pisos"),
                        resultSet.getString("codigo_proyecto")
                );
                listaTorres.add(Torre);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Torres: " + e.getMessage());
        }
        return listaTorres;
    }

    public void llenarTablaTorres(JTable tablaTorres) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        modelo.addColumn("Numero torre");
        modelo.addColumn("Numero pisos");
        modelo.addColumn("Codigo proyecto");

        // Obtener todos los Torres
        List<Torre> listaTorres = obtenerTodosLosTorres();

        // Agregar los datos al modelo
        for (Torre Torre : listaTorres) {
            Object[] fila = {
                Torre.getNumero_torre(),
                Torre.getNumero_pisos(),
                Torre.getCodigo_proyecto(),
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaTorres.setModel(modelo);
    }
    // Método para obtener todos los Torres
    public List<Torre> obtenerTorresPorProyecto(Integer codigo_proyecto) {
        String sql = "SELECT * FROM torre where codigo_proyecto = ?";
        List<Torre> listaTorres = new ArrayList<>();
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, codigo_proyecto);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Torre Torre = new Torre(
                        resultSet.getInt("numero_torre"),
                        resultSet.getInt("numero_pisos"),
                        resultSet.getString("codigo_proyecto")
                );
                listaTorres.add(Torre);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Torres: " + e.getMessage());
        }
        return listaTorres;
    }

    public void llenarTablaTorresPorProyecto(JTable tablaTorres,Integer codigo_proyecto) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        modelo.addColumn("Numero torre");
        modelo.addColumn("Numero pisos");
        modelo.addColumn("Codigo proyecto");

        // Obtener todos los Torres
        List<Torre> listaTorres = obtenerTorresPorProyecto(codigo_proyecto);

        // Agregar los datos al modelo
        for (Torre Torre : listaTorres) {
            Object[] fila = {
                Torre.getNumero_torre(),
                Torre.getNumero_pisos(),
                Torre.getCodigo_proyecto(),
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaTorres.setModel(modelo);
    }
}
