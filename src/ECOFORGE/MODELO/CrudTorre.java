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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudTorre implements Crud<Torre> {

    /// Torres
    /**
     * Método para crear una Torre
     *
     * @param torre
     * @return
     */
    @Override
    public boolean Crear(Torre torre) {
        String sql = "{ call inc_Torre(?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setInt(1, torre.getNumero_torre());
            statement.setInt(2, torre.getNumero_pisos());
            statement.setString(3, torre.getCodigo_proyecto());

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear la torre: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para actualizar una torre
     *
     * @param torre
     * @return
     */
    @Override
    public boolean Actualizar(Torre torre) {
        String sql = "{ call mod_num_pisos_Torre(?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setInt(1, torre.getNumero_torre());
            statement.setInt(2, torre.getNumero_pisos());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la torre: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para eliminar una torre
     *
     * @param Codigo1
     * @param Codigo2
     * @return
     */
    @Override
    public boolean Eliminar(String Codigo1, String Codigo2) {
        String sql = "{ call eliminar_torre(?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo1);
            statement.setString(2, Codigo2);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar la torre: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar la torre: " + e.getMessage());
            }
            return false;
        }
    }

    /**
     * Método para obtener todas las torres
     *
     * @return
     */
    @Override
    public List<Torre> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todas_Torres }";
        List<Torre> listaTorre = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Torre torre;
                    torre = new Torre(
                            resultSet.getInt("numero_Torre"),
                            resultSet.getInt("numero_Pisos"),
                            resultSet.getString("codigo_Proyecto"));
                    listaTorre.add(torre);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las torres: " + e.getMessage());
        }

        return listaTorre;
    }

    @Override
    public Torre ObtenerPorCodigo(String Codigo) {
        String sql = "{ ? = call obtener_torres_por_proyecto(?) }";
        Torre resultado = new Torre(0, 0, Codigo); // Torre principal como contenedor

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Registrar el segundo parámetro como el código del proyecto
            statement.setString(2, Codigo);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Torre torre = new Torre(
                            resultSet.getInt("numero_Torre"),
                            0, // Si hay más datos, puedes agregarlos aquí
                            Codigo
                    );
                    resultado.getTorresRelacionadas().add(torre); // Añadir a la lista
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las torres para el proyecto: " + e.getMessage());
        }

        return resultado;
    }

    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
