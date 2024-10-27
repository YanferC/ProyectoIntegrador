/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import java.sql.Connection;

/**
 *
 * @author YANFER
 */
public class ControladorConectar {

    private DatabaseConnection dbConnection;
    private Connection connection;

    // Constructor para inicializar dbConnection
    public ControladorConectar(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Método para conectar
    public void conectar() {
        if (dbConnection != null) {
            connection = dbConnection.connect(); // Conectar a la base de datos
        } else {
            System.out.println("Error: dbConnection no ha sido inicializado.");
        }
    }

    // Método opcional para obtener la conexión
    public Connection getConexion() {
        return connection;
    }
}
