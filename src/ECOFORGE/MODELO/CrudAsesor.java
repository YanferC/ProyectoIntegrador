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


public class CrudAsesor implements Crud<Asesor> {

    @Override
    public boolean Crear(Asesor asesor) {
        String sql = "{ call inc_Asesor(?, ?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setString(1, asesor.getNumero_Identificacion());
            statement.setString(2, asesor.getNombre_Completo());
            statement.setString(3, asesor.getDireccion());
            statement.setString(4, asesor.getTelefono());
            statement.setString(5, asesor.getCorreo_Electronico());

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear el Asesor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Actualizar(Asesor asesor) {
        String sql = "{ call mod_datos_Asesor(?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setString(1, asesor.getNumero_Identificacion());
            statement.setString(2, asesor.getDireccion());
            statement.setString(3, asesor.getTelefono());
            statement.setString(4, asesor.getCorreo_Electronico());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Asesor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(String Codigo1, String Codigo2) {
        String sql = "{ call eliminar_Asesor(?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo1);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar el Asesor: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar el Asesor: " + e.getMessage());
            }
            return false;
        }
    }

    @Override
    public List<Asesor> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todos_Asesor}";
        List<Asesor> listaAsesor = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                     Asesor asesor = new Asesor(
                        resultSet.getString("numero_Identificacion"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_electronico")
                    );
                    listaAsesor.add(asesor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }

        return listaAsesor;
    }

    @Override
    public Asesor ObtenerPorCodigo(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
