/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Parámetros de conexión
    private static final String URL = "jdbc:oracle:thin:@LAPTOP-T7R63ESD:1521:xe";
    private static final String USER = "EcoForge";
    private static final String PASSWORD = "EcoForge";
    private static Connection connection = null;

    // Constructor privado para evitar la creación de instancias
    private DatabaseConnection() {
    }

    // Método para obtener la conexión (Singleton)
    public static Connection getConexion() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
