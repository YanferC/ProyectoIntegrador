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


public class ControladorTorre {

    private final Connection conexion;

    public ControladorTorre(ControladorConectar controladorConectar) {
        this.conexion = controladorConectar.getConexion();
    }

    // Método para crear un Torre
    public boolean crearTorre(Torre torre) {
        String sql = "INSERT INTO torre (numero_torre, numero_pisos, codigo_proyecto) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

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
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

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
        String sql = "UPDATE Torre SET numero_pisos = ? WHERE numero_torre = ? and codigo_proyecto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(2, Torre.getNumero_torre());
            statement.setInt(1, Torre.getNumero_pisos());
            statement.setString(3, Torre.getCodigo_proyecto());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Torre: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Torre
    public boolean eliminarTorre(Integer numero_torre, String codigo_proyecto) {
        String sql = "DELETE FROM Torre WHERE numero_torre = ? and codigo_proyecto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, numero_torre);
            statement.setString(2, codigo_proyecto);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Torre: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los Torres
    public List<Torre> obtenerTodasLasTorres() {
        String sql = "SELECT * FROM torre";
        List<Torre> listaTorres = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

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

   
    // Método para obtener todos las Torres
    
    public List<Torre> obtenerTorresPorProyecto(String codigo_proyecto) {
        String sql = "SELECT * FROM torre where codigo_proyecto = ?";
        List<Torre> listaTorres = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql);) {
            
            statement.setString(1, codigo_proyecto);
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

}
