/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CrudCliente {

    private final Connection conexion;

    public CrudCliente(Conectar controladorConectar) {
        this.conexion = controladorConectar.getConexion();
    }

    // Método para crear un cliente
    public boolean crearCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (numero_Identificacion, nombre_completo, sisben, subsidio_Ministerio, direccion, telefono, correo_electronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, cliente.getNumero_Identificacion());
            statement.setString(2, cliente.getNombreCompleto());
            statement.setString(3, cliente.getSisben());
            statement.setInt(4, cliente.getSubsidio_Ministerio());
            statement.setString(5, cliente.getDireccion());
            statement.setString(6, cliente.getTelefono());
            statement.setString(7, cliente.getCorreoElectronico());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un cliente por cédula
    public Cliente obtenerCliente(String numero_Identificacion) {
        String sql = "SELECT * FROM cliente WHERE numero_Identificacion = ?";
        Cliente cliente = null;
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, numero_Identificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
                        resultSet.getString("numero_Identificacion"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("sisben"),
                        resultSet.getInt("subsidio_Ministerio"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo_electronico")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cliente: " + e.getMessage());
        }
        return cliente;
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre_completo = ?, sisben = ?, subsidio_Ministerio = ?, "
                + " direccion = ?, telefono = ?, correo_electronico = ? WHERE numero_Identificacion = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombreCompleto());
            statement.setString(2, cliente.getSisben());
            statement.setInt(3, cliente.getSubsidio_Ministerio());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getCorreoElectronico());
            statement.setString(7, cliente.getNumero_Identificacion());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(Integer Numero_Identificacion) {
        String sql = "DELETE FROM cliente WHERE numero_Identificacion = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, Numero_Identificacion);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

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
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }
        return listaClientes;
    }
}
