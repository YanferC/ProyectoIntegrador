/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import ECOFORGE.CONTROLADOR.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudProyecto implements Crud<Proyecto> {

    // PROYECTOS
    /**
     * Método para crear un proyecto
     *
     * @param proyecto
     * @return
     */
    @Override
    public boolean Crear(Proyecto proyecto) {
        String sql = "{ call inc_Proyecto(?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setString(1, proyecto.getCodigo_proyecto());
            statement.setString(2, proyecto.getNombre_proyecto());

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear proyecto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para actualizar un Proyecto
     *
     * @param proyecto
     * @return
     */
    @Override
    public boolean Actualizar(Proyecto proyecto) {
        String sql = "{ call mod_nom_Proyecto(?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, proyecto.getCodigo_proyecto());
            statement.setString(2, proyecto.getNombre_proyecto());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Proyecto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para eliminar un Proyecto
     *
     * @param Codigo
     * @return
     */
    @Override
    public boolean Eliminar(String Codigo) {
        String sql = "{ call eliminar_proyecto(?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar Proyecto: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar Proyecto: " + e.getMessage());
            }
            return false;
        }
    }

    /**
     * Método para obtener todos los proyectos
     *
     * @return
     */
    @Override
    public List<Proyecto> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todos_Proyectos }";
        List<Proyecto> listaProyecto = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Proyecto proyecto = new Proyecto(
                            resultSet.getString("codigo_proyecto"),
                            resultSet.getString("nombre_proyecto"));
                    listaProyecto.add(proyecto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener proyectos: " + e.getMessage());
        }

        return listaProyecto;
    }

    /**
     * Método para leer un Proyecto por codigo proyecto
     *
     * @param Codigo
     * @return
     */
    @Override
    public Proyecto ObtenerPorCodigo(String Codigo) {
        String sql = "SELECT * FROM proyecto WHERE codigo_proyecto = ?";
        Proyecto proyecto = null;
        try (Connection conexion = DatabaseConnection.getConexion(); PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, Codigo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    proyecto = new Proyecto(
                            resultSet.getString("codigo_proyecto"),
                            resultSet.getString("nombre_proyecto"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Proyecto: " + e.getMessage());
        }
        return proyecto;
    }

    /**
     * Método para generar un nuevo código de proyecto utilizando la función
     * generar_codigo_proyecto en la base de datos.
     *
     * @return String con el nuevo código de proyecto
     */
    @Override
    public String ObtenerID() {
        String nuevoCodigoProyecto = "";
        String sql = "SELECT generar_codigo_proyecto FROM dual";

        try (Connection conexion = DatabaseConnection.getConexion(); PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                nuevoCodigoProyecto = resultSet.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener nuevo código de proyecto: " + e.getMessage());
        }
        return nuevoCodigoProyecto;
    }

}
