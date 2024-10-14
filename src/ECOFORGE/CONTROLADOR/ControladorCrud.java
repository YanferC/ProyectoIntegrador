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


public class ControladorCrud {

    private DatabaseConnection dbConnection;
    private Connection connection;

    public ControladorCrud() {
        dbConnection = new DatabaseConnection();
    }

    public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un cliente
    public boolean crearCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (numero_Identificacion, nombre_completo, sisben, subsidio_Ministerio, direccion, telefono, correo_electronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cliente.getNumero_Identificacion());
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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, numero_Identificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
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
            System.out.println("Error al obtener cliente: " + e.getMessage());
        }
        return cliente;
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre_completo = ?, sisben = ?, subsidio_Ministerio = ?, "
                + " direccion = ?, telefono = ?, correo_electronico = ? WHERE numero_Identificacion = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombreCompleto());
            statement.setString(2, cliente.getSisben());
            statement.setInt(3, cliente.getSubsidio_Ministerio());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getCorreoElectronico());
            statement.setInt(7, cliente.getNumero_Identificacion());

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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("numero_Identificacion"),
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

    public void llenarTablaClientes(JTable tablaClientes) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("Sisben");
        modelo.addColumn("Subsidio Ministerio");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo Electrónico");

        // Obtener todos los clientes
        List<Cliente> listaClientes = obtenerTodosLosClientes();

        // Agregar los datos al modelo
        for (Cliente cliente : listaClientes) {
            Object[] fila = {
                cliente.getNumero_Identificacion(),
                cliente.getNombreCompleto(),
                cliente.getSisben(),
                cliente.getSubsidio_Ministerio(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCorreoElectronico()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaClientes.setModel(modelo);
    }

    // PROYECTOS

    // Método para crear un proyecto
    public boolean crearProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (codigo_proyecto, nombre_proyecto) VALUES (?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, proyecto.getCodigo_proyecto());
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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, codigo_proyecto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Proyecto = new Proyecto(
                    resultSet.getInt("codigo_proyecto"),
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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, Proyecto.getNombre_proyecto());
            statement.setInt(2, Proyecto.getCodigo_proyecto());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Proyecto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Proyecto
    public boolean eliminarProyecto(Integer codigo_proyecto) {
        String sql = "DELETE FROM Proyecto WHERE codigo_proyecto = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, codigo_proyecto);

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
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Proyecto proyecto = new Proyecto(
                        resultSet.getInt("codigo_proyecto"),
                        resultSet.getString("nombre_proyecto")
                );
                listaProyecto.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener proyectos: " + e.getMessage());
        }
        return listaProyecto;
    }

    public void llenarTablaProyectos(JTable tablaProyectos) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Proyecto");

        // Obtener todos los Proyectos
        List<Proyecto> listaProyectos = obtenerTodosLosProyectos();

        // Agregar los datos al modelo
        for (Proyecto proyecto : listaProyectos) {
            Object[] fila = {
                proyecto.getCodigo_proyecto(),
                proyecto.getNombre_proyecto(),
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaProyectos.setModel(modelo);
    }
}
