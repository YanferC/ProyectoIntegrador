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

    private static String url = "jdbc:oracle:thin:@Sebastian:1521:xe"; // Cambia los parámetros según tu BD
    private static String user = "EcoForge";
    private static String password = "EcoForge";
    private static Connection connection = null;

    // Método para conectar
    public static Connection getConexion() {
        try {
            // Cargar el controlador JDBC de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Conectar a la base de datos
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    // Método para cerrar la conexión
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
   /** // Parámetros de conexión
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection connection = null;

    // Constructor privado para evitar la creación de instancias
    public DatabaseConnection() {
    }

    // Método para configurar la conexión de acuerdo con el tipo de usuario
    public static void configurarConexion(String tipoUsuario) {
        // Configura la base de datos según el tipo de usuario (por ejemplo, Asesor o Admin)
        switch (tipoUsuario) {
            case "1" -> {
                URL = "jdbc:oracle:thin:@LAPTOP-T7R63ESD:1521:xe";
                USER = "ECOFORGE";
                PASSWORD = "ECOFORGE";
            }
            case "2" -> {
                URL = "jdbc:oracle:thin:@LAPTOP-T7R63ESD:1521:xe";
                USER = "ECOFORGE";
                PASSWORD = "ECOFORGE";
            }
            default -> {
                // Base de datos por defecto
                URL = "jdbc:oracle:thin:@LAPTOP-T7R63ESD:1521:xe";
                USER = "ECOFORGE";
                PASSWORD = "ECOFORGE";
            }
        }
    }

    // Método para obtener la conexión (Singleton)
    public static Connection getConexion() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                if (URL == null || USER == null || PASSWORD == null) {
                    throw new SQLException("La configuración de la conexión no ha sido definida.");
                }
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión al usuario: " + USER);
            } catch (SQLException e) {
                System.out.println("Error al obtener la conexión: " + e.getMessage());
            }
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
    }*/
}
