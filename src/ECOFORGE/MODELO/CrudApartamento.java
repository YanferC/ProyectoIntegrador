/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;


/*
 * @author Sebastian
 */
import ECOFORGE.MODELO.Apartamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CrudApartamento {

    private final Connection conexion;

    public CrudApartamento(Conectar controladorConectar) {
        this.conexion = controladorConectar.getConexion();
    }

    // Método para crear un Apartamento
    public boolean crearApartamento(Apartamento apartamento) {
        String sql = "INSERT INTO Apartamento (NUMERO_APARTAMENTO, VALOR_APARTAMENTO , tipo_Inmueble, area, numero_Torre) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, apartamento.getNumero_Apartamento());
            statement.setInt(2, apartamento.getValor_Apartamento());
            statement.setString(3, apartamento.getTipo_Inmueble());
            statement.setInt(4, apartamento.getArea());
            statement.setInt(5, apartamento.getNumero_Torre());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para leer un Apartamento por cédula
    public Apartamento obtenerApartamento(String numero_Apartamento) {
        String sql = "SELECT * FROM Apartamento WHERE numero_Apartamento = ?";
        Apartamento apartamento = null;
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, numero_Apartamento);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                apartamento = new Apartamento(
                        resultSet.getInt("numero_Apartamento"),
                        resultSet.getInt("valor_Apartamento"),
                        resultSet.getString("tipo_Inmueble"),
                        resultSet.getInt("area"),
                        resultSet.getInt("numero_Torre")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Apartamento: " + e.getMessage());
        }
        return apartamento;
    }

    // Método para actualizar un Apartamento
    public boolean actualizarApartamento(Apartamento apartamento) {
        String sql = "UPDATE Apartamento SET valor_Apartamento = ?, tipo_Inmueble = ?, area = ?, numero_Torre = ?"
                + " Where numero_apartamento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, apartamento.getValor_Apartamento());
            statement.setString(2, apartamento.getTipo_Inmueble());
            statement.setInt(3, apartamento.getArea());
            statement.setInt(4, apartamento.getNumero_Torre());
            statement.setInt(5, apartamento.getNumero_Apartamento());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un Apartamento
    public boolean eliminarApartamento(Integer Numero_Apartamento) {
        String sql = "DELETE FROM Apartamento WHERE numero_Apartamento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, Numero_Apartamento);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Apartamento: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los Apartamentos
    public List<Apartamento> obtenerTodosLosApartamentos() {
        String sql = "SELECT * FROM Apartamento";
        List<Apartamento> listaApartamentos = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento(
                        resultSet.getInt("numero_Apartamento"),
                        resultSet.getInt("valor_Apartamento"),
                        resultSet.getString("tipo_Inmueble"),
                        resultSet.getInt("area"),
                        resultSet.getInt("numero_Torre")
                );
                listaApartamentos.add(apartamento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Apartamentos: " + e.getMessage());
        }
        return listaApartamentos;
    }

}
