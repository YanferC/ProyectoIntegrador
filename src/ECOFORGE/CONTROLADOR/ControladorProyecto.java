/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControladorProyecto {

    private final Connection conexion;

    public ControladorProyecto(ControladorConectar controladorConectar) {
        this.conexion = controladorConectar.getConexion();
    }

    // PROYECTOS

    // Método para crear un proyecto
    public boolean crearProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (codigo_proyecto, nombre_proyecto) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, proyecto.getCodigo_proyecto());
            statement.setString(2, proyecto.getNombre_proyecto());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear proyecto: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un Proyecto por cédula
    public Proyecto obtenerProyecto(String codigo_proyecto) {
        String sql = "SELECT * FROM proyecto WHERE codigo_proyecto = ?";
        Proyecto Proyecto = null;
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, codigo_proyecto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Proyecto = new Proyecto(
                    resultSet.getString("codigo_proyecto"),
                    resultSet.getString("nombre_proyecto")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Proyecto: " + e.getMessage());
        }
        return Proyecto;
    }

    // Método para actualizar un Proyecto
    public boolean actualizarProyecto(Proyecto Proyecto) {
        String sql = "UPDATE proyecto SET nombre_proyecto = ? WHERE codigo_proyecto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, Proyecto.getNombre_proyecto());
            statement.setString(2, Proyecto.getCodigo_proyecto());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Proyecto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Proyecto
        public boolean eliminarProyecto(String codigo_proyecto) {
        String sql = "DELETE FROM Proyecto WHERE codigo_proyecto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, codigo_proyecto);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Proyecto: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los proyectos
    public List<Proyecto> obtenerTodosLosProyectos() {
        String sql = "SELECT * FROM proyecto";
        List<Proyecto> listaProyecto = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Proyecto proyecto = new Proyecto(
                        resultSet.getString("codigo_proyecto"),
                        resultSet.getString("nombre_proyecto")
                );
                listaProyecto.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener proyectos: " + e.getMessage());
        }
        return listaProyecto;
    }
}
