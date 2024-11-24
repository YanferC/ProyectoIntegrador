/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author YANFER
 */
public class CalculosDatos {

    public Integer Calcular_Valor_Total(Integer valor_apt, Integer Sub_ministerio) {
        String sql = "{ ? = call VALOR_TOTAL_VENTA(?, ?) }";
        Integer valor_total = null;

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el parámetro de salida
            statement.registerOutParameter(1, java.sql.Types.NUMERIC);

            // Configurar los parámetros de entrada
            statement.setInt(2, valor_apt);
            statement.setInt(3, Sub_ministerio);

            // Ejecutar la función
            statement.execute();

            // Obtener el valor de salida
            valor_total = statement.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error al calcular el valor total de la venta: " + e.getMessage());
        }

        return valor_total;
    }

    public Integer ObtenerValorApartamento(Integer numeroApt, Integer numeroTorre) {
        String sql = "{ ? = call VALOR_APARTAMENTO(?, ?) }";
        Integer valorApartamento = null;

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el parámetro de salida
            statement.registerOutParameter(1, java.sql.Types.NUMERIC);

            // Configurar los parámetros de entrada
            statement.setInt(2, numeroApt);
            statement.setInt(3, numeroTorre);

            // Ejecutar la función
            statement.execute();

            // Obtener el valor de salida
            valorApartamento = statement.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error al obtener el valor del apartamento: " + e.getMessage());
        }

        return valorApartamento;
    }

    public Integer ObtenerSubsidioMinisterio(Integer numeroCliente) {
        String sql = "{ ? = call VALOR_SUBSIDIO_MINISTERIO(?) }";
        Integer valorSubsidio = null;

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el parámetro de salida
            statement.registerOutParameter(1, java.sql.Types.NUMERIC);

            // Configurar el parámetro de entrada
            statement.setInt(2, numeroCliente);

            // Ejecutar la función
            statement.execute();

            // Obtener el valor de salida
            valorSubsidio = statement.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error al obtener el subsidio ministerio: " + e.getMessage());
        }

        return valorSubsidio;
    }
    
    public Integer CalcularValorCuota(Integer idVenta, Integer numeroCuotas, Double porcentajeInteres) {
        String sql = "{ ? = call CALCULAR_VALOR_CUOTA(?, ?, ?) }";
        Integer valorCuota = null;

        try (Connection conexion = DatabaseConnection.getConexion(); CallableStatement statement = conexion.prepareCall(sql)) {

            // Registrar el parámetro de salida
            statement.registerOutParameter(1, java.sql.Types.NUMERIC);

            // Configurar los parámetros de entrada
            statement.setInt(2, idVenta);               // ID de la venta
            statement.setInt(3, numeroCuotas);          // Número de cuotas
            statement.setDouble(4, porcentajeInteres);  // Porcentaje de interés

            // Ejecutar la función
            statement.execute();

            // Obtener el valor de salida
            valorCuota = statement.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error al calcular el valor de la cuota: " + e.getMessage());
        }

        return valorCuota;
    }
}
