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
import ECOFORGE.VISTA.PanelCliente.ClienteAddedListener;
import ECOFORGE.VISTA.CreandoVentaVista;
import ECOFORGE.MODELO.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import javax.swing.*;
import java.awt.*;

public class CrudVentas implements ClienteAddedListener, Crud<Venta> {

    private CreandoVentaVista vista;
    private DatabaseConnection dbConnection;
    private Connection connection;

   
/**
    public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un venta
    public boolean crearVenta(Venta venta) {
        String sql = "INSERT INTO venta (ID, PRECIO_TOTAL_VENTA, TIPO_PAGO, FECHA_VENTA, NUMERO_CUOTAS, MATRICULA, FECHA_ESCRITURA, NUMERO_APARTAMENTO, NUMERO_IDENT_CLI) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            Date sqlDate = new Date(venta.getFecha_Venta().getTime());
            Date sqlDate2 = new Date(venta.getFecha_Escritura().getTime());

            statement.setInt(1, venta.getId());
            statement.setInt(2, venta.getPrecio_Total_Venta());
            statement.setInt(3, venta.getTipo_Pago());
            statement.setDate(4, sqlDate);
            statement.setInt(5, venta.getNumero_Cuotas());
            statement.setString(6, venta.getMatricula());
            statement.setDate(7, sqlDate2);
            statement.setInt(8, venta.getNumero_Apartamento());
            statement.setInt(9, venta.getNumero_Ident_Cli());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear venta: " + e.getMessage());
            return false;
        }
    }
    
    
    //se crea el siguiente método para consultar la secuencia del id para la venta
    public int consultarIdVenta() {
        String sql = "SELECT seq_Venta.NEXTVAL AS ID FROM dual";
        int idVenta = -1;  // Inicializamos con un valor por defecto.

        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                idVenta = resultSet.getInt("ID");  // Tomamos el valor de la secuencia.
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID de Venta: " + e.getMessage());
        }

        return idVenta;
    }
*/
    
    @Override
    public void onClienteAdded() {
        vista.clienteAgregado(); // Llamar al método que habilita el botón
    }
    
    /**
     * Método para crear una Venta
     *
     * @param venta
     * @return
     */
    @Override
    public boolean Crear(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método para actualizar una venta
     *
     * @param venta
     * @return
     */
    @Override
    public boolean Actualizar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     /**
     * Método para eliminar una venta
     *
     * @param Codigo1
     * @param Codigo2
     * @return
     */
    @Override
    public boolean Eliminar(String Codigo1, String Codigo2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método para obtener todas las ventas
     *
     * @return
     */
    @Override
    public List<Venta> ObtenerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta ObtenerPorCodigo(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
