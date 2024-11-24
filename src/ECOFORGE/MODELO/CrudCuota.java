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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.CallableStatement;

public class CrudCuota implements  Crud<Cuota>{

   /**
    * 
    * @param cuota
    * @return 
    */
    @Override
    public boolean Crear(Cuota cuota) {
        String sql = "{ call inc_cuotas(?, ?, ?, ?, ?, ?, ?) }";
        
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establecer parámetros para el procedimiento usando el objeto 'cuota'
            statement.setInt(1, cuota.getId_Venta());              // p_id_venta
            statement.setDate(2, (Date) cuota.getFecha_Vencimiento());            // p_fecha_base
            statement.setDouble(3, cuota.getMonto_Cuota());        // p_monto_cuota
            statement.setString(4, cuota.getEstado_Cuota());       // p_estado_cuota
            statement.setString(5, cuota.getNumero_Asesor());   // p_numero_id_asesor
            statement.setDouble(6, cuota.getIntereses());         // p_intereses
            statement.setInt(7, cuota.getNum_Cuotas());            // p_num_cuotas

            // Ejecutar el procedimiento
            statement.execute();
            return true;  // Devuelve true si la ejecución es exitosa

        } catch (SQLException e) {
            System.out.println("Error al crear las cuotas: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * 
     * @param cuota
     * @return 
     */
    @Override
    public boolean Actualizar(Cuota cuota) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
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
     * 
     * @return 
     */
    @Override
    public List<Cuota> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todas_Cuotas }";
        List<Cuota> listaCuota = new ArrayList<>();
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Cuota cuota;
                    cuota = new Cuota(
                            resultSet.getInt("ID"),
                            resultSet.getInt("NUMERO_CUOTA"),
                            resultSet.getDate("FECHA_VENCIMIENTO"),
                            resultSet.getInt("MONTO_CUOTA"),
                            resultSet.getString("ESTADO_CUOTA"),
                            resultSet.getString("NUMERO_IDASESOR"),
                            resultSet.getInt("INTERESES"),
                            resultSet.getInt("ID_VENTA"),
                            0
                    );  
                    listaCuota.add(cuota);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las Cuotas: " + e.getMessage());
        }

        return listaCuota;
    }
    
    /**
     * 
     * @param Codigo
     * @return 
     */
    @Override
    public Cuota ObtenerPorCodigo(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
