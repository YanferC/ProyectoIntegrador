/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;


/*
 * @author Sebastian
 */
import ECOFORGE.CONTROLADOR.Crud;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudApartamento implements Crud<Apartamento> {

    //// APARTAMENTOS
    /**
     * Método para crear un Apartamento
     *
     * @param apartamento
     * @return
     */
    @Override
    public boolean Crear(Apartamento apartamento) {
        String sql = "{ call inc_Apartamento(?, ?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setInt(1, apartamento.getNumero_Apartamento());
            statement.setInt(2, apartamento.getValor_Apartamento());
            statement.setString(3, apartamento.getTipo_Inmueble());
            statement.setInt(4, apartamento.getArea());
            statement.setInt(5, apartamento.getNumero_Torre());

            // Ejecuta el procedimiento
            statement.execute();
            return true;  // Devuelve true si se ejecuta correctamente

        } catch (SQLException e) {
            System.out.println("Error al crear el apartamento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para actualizar un Apartamento
     *
     * @param apartamento
     * @return
     */
    @Override
    public boolean Actualizar(Apartamento apartamento) {
        String sql = "{ call mod_datos_Apartamento(?, ?, ?, ?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Establece los parámetros para el procedimiento
            statement.setInt(1, apartamento.getNumero_Apartamento());
            statement.setInt(2, apartamento.getValor_Apartamento());
            statement.setString(3, apartamento.getTipo_Inmueble());
            statement.setInt(4, apartamento.getArea());
            statement.setInt(5, apartamento.getNumero_Torre());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el apartamento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para eliminar un Apartamento
     *
     * @param Codigo1
     * @param Codigo2
     * @return
     */
    @Override
    public boolean Eliminar(String Codigo1, String Codigo2) {
        String sql = "{ call eliminar_apartamento(?, ?) }";
        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            statement.setString(1, Codigo1);
            statement.setString(2, Codigo2);
            statement.execute();
            return true;  // Elimina exitosamente si no hay dependencias.

        } catch (SQLException e) {
            if (e.getErrorCode() == 2292) {  // Error ORA-02292: restricción de integridad referencial violada - registro secundario encontrado
                System.out.println("Error al eliminar el apartamento: Existen registros relacionados en otras tablas.");
            } else {
                System.out.println("Error al eliminar el apartamento: " + e.getMessage());
            }
            return false;
        }
    }

    /**
     * Método para obtener todos los apartamentos
     *
     * @return
     */
    @Override
    public List<Apartamento> ObtenerTodo() {
        String sql = "{ ? = call obtener_Todos_Apartamentos }";
        List<Apartamento> listaApartamentos = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como el cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Apartamento apartamento;
                    apartamento = new Apartamento(
                            resultSet.getInt("numero_Apartamento"),
                            resultSet.getInt("valor_Apartamento"),
                            resultSet.getString("tipo_Inmueble"),
                            resultSet.getInt("area"),
                            resultSet.getInt("numero_Torre"));
                    listaApartamentos.add(apartamento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los apartamentos: " + e.getMessage());
        }

        return listaApartamentos;
    }

    @Override
    public Apartamento ObtenerPorCodigo(String Codigo) {
        String sql = "{ ? = call obtener_apt_por_torre(?) }";
        Apartamento resultado = new Apartamento(0,0,"", 0, Integer.valueOf(Codigo)); // Apartamento principal como contenedor

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el primer parámetro como cursor de salida
            statement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            // Registrar el segundo parámetro como el numero de torre
            statement.setString(2, Codigo);

            // Ejecutar la función
            statement.execute();

            // Obtener el cursor como ResultSet
            try (ResultSet resultSet = (ResultSet) statement.getObject(1)) {
                while (resultSet.next()) {
                    Apartamento apt = new Apartamento(
                            resultSet.getInt("numero_Apartamento"),
                            0, // Si hay más datos, puedes agregarlos aquí
                            "",
                            0,
                            Integer.valueOf(Codigo)
                    );
                    resultado.getAptRelacionadas().add(apt); // Añadir a la lista
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los apartamentos de la torre: " + e.getMessage());
        }

        return resultado;
    }

    @Override
    public String ObtenerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
