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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.CallableStatement;

public class CrudVentas implements ClienteAddedListener, Crud<Venta> {
    
    private CreandoVentaVista vista;
   /** 
    public CrudVentas(CreandoVentaVista vista) {
        this.vista = vista;
    }*/
    /**
     * Método para crear una Venta
     *
     * @param venta
     * @return
     */
    @Override
    public boolean Crear(Venta venta) {
        String sql = "{ call inc_Venta(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            Date sqlDate = new Date(venta.getFecha_Venta().getTime());
            Date sqlDate2 = new Date(venta.getFecha_Escritura().getTime());

            statement.setInt(1, venta.getId());
            statement.setInt(2, venta.getPrecio_Total_Venta());
            statement.setString(3, venta.getTipo_Pago());
            statement.setDate(4, sqlDate);
            statement.setDate(5, sqlDate2);
            statement.setString(6, venta.getMatricula());
            statement.setString(7, venta.getNumero_IdCliente());
            statement.setString(8, venta.getNumero_idAsesor());
            statement.setInt(9, venta.getNumero_Apartamento());
            

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear la Venta: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para actualizar una venta
     *
     * @param venta
     * @return
     */
    @Override
    public boolean Actualizar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        String sql = "{ call eliminar_Venta(?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo1);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar la Venta: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar la Venta: " + e.getMessage());
            }
            return false;
        }
    }

    /**
     * Método para obtener todas las ventas
     *
     * @return
     */
    @Override
    public List<Venta> ObtenerTodo() {
         String sql = "{ ? = call obtener_Todas_Ventas }";
        List<Venta> listaVenta = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Venta venta;
                    venta = new Venta(
                            resultSet.getInt("ID"),
                            resultSet.getInt("PRECIO_TOTALVENTA"),
                            resultSet.getString("TIPO_PAGO"),
                            resultSet.getDate("fecha_Venta"),
                            resultSet.getDate("fecha_Escritura"),
                            resultSet.getString("matricula"),
                            resultSet.getString("numero_IdCliente"),
                            resultSet.getString("numero_idAsesor"),
                            resultSet.getInt("numero_Apartamento")
                    );
                    listaVenta.add(venta);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las ventas: " + e.getMessage());
        }

        return listaVenta;
    }

    @Override
    public Venta ObtenerPorCodigo(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ObtenerID() {
        String nuevoIdVenta = "";
        String sql = "SELECT obtener_Id_Venta FROM dual";

        try (Connection conexion = DatabaseConnection.getConexion(); PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                nuevoIdVenta = resultSet.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el id de la venta: " + e.getMessage());
        }
        return nuevoIdVenta;
    }
    
   @Override
    public void onClienteAdded() {
        vista.clienteAgregado(); // Llamar al método que habilita el botón
    }
}
