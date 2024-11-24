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


public class CrudCliente implements Crud<Cliente> {
    
    //// Clientes
    /**
     * Método para crear un Cliente
     *
     * @param cliente
     * @return
     */
    @Override
    public boolean Crear(Cliente cliente) {
        String sql = "{ call inc_Cliente(?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setString(1, cliente.getNumero_Identificacion());
            statement.setString(2, cliente.getNombreCompleto());
            statement.setString(3, cliente.getSisben());
            statement.setInt(4, cliente.getSubsidio_Ministerio());
            statement.setString(5, cliente.getDireccion());
            statement.setString(6, cliente.getTelefono());
            statement.setString(7, cliente.getCorreoElectronico());

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
            return false;
        }
    }
    
     /**
     * Método para actualizar un Cliente
     *
     * @param cliente
     * @return
     */
    @Override
    public boolean Actualizar(Cliente cliente) {
        String sql = "{ call mod_datos_Cliente(?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setString(1, cliente.getNumero_Identificacion());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getCorreoElectronico());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Método para eliminar un Cliente
     *
     * @param Codigo1
     * @param Codigo2
     * @return
     */
    @Override
    public boolean Eliminar(String Codigo1, String Codigo2) {
        String sql = "{ call eliminar_cliente(?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo1);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar el cliente: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar el cliente: " + e.getMessage());
            }
            return false;
        }
    }
    
    /**
     * Método para obtener todos los clientes
     *
     * @return
     */
    @Override
    public List<Cliente> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todos_Clientes}";
        List<Cliente> listaClientes = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                     Cliente cliente = new Cliente(
                        resultSet.getString("numero_Identificacion"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("sisben"),
                        resultSet.getInt("subsidio_Ministerio"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_electronico")
                    );
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }

        return listaClientes;
    }

    @Override
    public Cliente ObtenerPorCodigo(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
