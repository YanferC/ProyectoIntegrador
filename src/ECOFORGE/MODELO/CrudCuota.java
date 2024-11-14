/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import ECOFORGE.MODELO.Cuota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.awt.*;

public class CrudCuota {

    private DatabaseConnection dbConnection;
    private Connection connection;

    public CrudCuota() {
        //dbConnection = new DatabaseConnection();
    }

   /** public void conectar() {
        connection = dbConnection.connect(); // Conectar a la base de datos
    }

    // Método para crear un cuota
    public boolean crearCuota(Cuota cuota) {
        String sql = "INSERT INTO cuota (ID, NUMERO_CUOTA, FECHA_VENCIMIENTO, MONTO_CUOTA, ESTADO_CUOTA, NUMERO_IDEN_ASE, INTERESES, ID_VENTA) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            Date sqlDate = new Date(cuota.getFecha_Vencimiento().getTime());
            statement.setInt(1, cuota.getId());
            statement.setInt(2, cuota.getNumero_Cuota());
            statement.setDate(3, sqlDate);
            statement.setInt(4, cuota.getMonto_Cuota());
            statement.setString(5, cuota.getEstado_Cuota());
            statement.setString(6, cuota.getNumero_Asesor());
            statement.setInt(7, cuota.getIntereses());
            statement.setInt(8, cuota.getId_Venta());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear cuota: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un cuota por id
    public Cuota obtenerCuota(Integer id) {
        String sql = "SELECT * FROM cuota WHERE id = ?";
        Cuota cuota = null;
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cuota = new Cuota(
                        resultSet.getInt("id"),
                        resultSet.getInt("numero_Cuota"),
                        resultSet.getDate("fecha_Vencimiento"),
                        resultSet.getInt("monto_Cuota"),
                        resultSet.getString("estado_Cuota"),
                        resultSet.getString("numero_Iden_Ase"),
                        resultSet.getInt("intereses"),
                        resultSet.getInt("id_Venta")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cuota: " + e.getMessage());
        }
        return cuota;
    }

    // Método para actualizar un cuota
    public boolean actualizarCuota(Cuota cuota) {
        String sql = "UPDATE cuota SET INTERESES = ?, FECHA_VENCIMIENTO = ?, MONTO_CUOTA = ?, "
                + " ESTADO_CUOTA = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            Date sqlDate = new Date(cuota.getFecha_Vencimiento().getTime());
            statement.setInt(1, cuota.getIntereses());
            statement.setDate(2, sqlDate);
            statement.setInt(3, cuota.getMonto_Cuota());
            statement.setString(4, cuota.getEstado_Cuota());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cuota: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Cuota
    public boolean eliminarCuota(Integer Id) {
        String sql = "DELETE FROM Cuota WHERE Id = ?";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Cuota: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los cuotas
    public List<Cuota> obtenerTodasLasCuotas() {
        String sql = "SELECT * FROM cuota";
        List<Cuota> listaCuotas = new ArrayList<>();
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cuota cuota = new Cuota(
                        resultSet.getInt("id"),
                        resultSet.getInt("numero_Cuota"),
                        resultSet.getDate("fecha_Vencimiento"),
                        resultSet.getInt("monto_Cuota"),
                        resultSet.getString("estado_Cuota"),
                        resultSet.getString("numero_Iden_Ase"),
                        resultSet.getInt("intereses"),
                        resultSet.getInt("id_Venta")
                );
                listaCuotas.add(cuota);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cuotas: " + e.getMessage());
        }
        return listaCuotas;
    }

    public void llenarTablaCuotas(JTable tablaCuotas) {
        /**
         * DefaultTableModel modelo = new DefaultTableModel();
         *
         * // Definir las columnas modelo.addColumn("Id");
         * modelo.addColumn("Numero Cuota"); modelo.addColumn("Fecha
         * Vencimiento"); modelo.addColumn("Monto Cuota");
         * modelo.addColumn("Estado Cuota"); modelo.addColumn("Asesor");
         * modelo.addColumn("Intereses");
        modelo.addColumn("Venta");
         

        // Crear el modelo de la tabla con las columnas definidas
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{
                    "Id", "Numero Cuota", "Fecha Vencimiento",
                    "Monto Cuota", "Estado Cuota", "Asesor",
                    "Intereses", "Venta"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Bloquear edición de las celdas
            }
        };

        // Obtener todos las Cuotas
        List<Cuota> listaCuota = obtenerTodasLasCuotas();

        // Agregar los datos al modelo
        for (Cuota cuota : listaCuota) {
            Object[] fila = {
                cuota.getId(),
                cuota.getNumero_Cuota(),
                cuota.getFecha_Vencimiento(),
                cuota.getMonto_Cuota(),
                cuota.getEstado_Cuota(),
                cuota.getNumero_Asesor(),
                cuota.getIntereses(),
                cuota.getId_Venta()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tablaCuotas.setModel(modelo);

        // Personalizar apariencia
        tablaCuotas.setBackground(Color.decode("#AFE5EF")); // Fondo personalizado
        tablaCuotas.setForeground(Color.BLACK);             // Texto en negro
        tablaCuotas.setSelectionBackground(new Color(100, 150, 255)); // Fondo al seleccionar
        tablaCuotas.setSelectionForeground(Color.WHITE);    // Texto al seleccionar
    }*/
}
