/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 */
import ECOFORGE.VISTA.PanelCliente.ClienteAddedListener;
import ECOFORGE.VISTA.VentaVista;
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

public class ControladorVentas implements ClienteAddedListener {
    private VentaVista vista;
    private DatabaseConnection dbConnection;
    private Connection connection;
    
    
    public ControladorVentas(VentaVista vista) {
        dbConnection = new DatabaseConnection();
        this.vista = vista;
    }
    
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
    
    
    
    @Override
    public void onClienteAdded() {
        vista.clienteAgregado(); // Llamar al método que habilita el botón
    }
}
