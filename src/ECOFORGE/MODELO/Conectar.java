/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

import java.sql.Connection;

/**
 *
 * @author YANFER
 */
public class Conectar {

    private DatabaseConnection dbConnection;
    private Connection connection;

    // Constructor para inicializar dbConnection
    public Conectar(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Método para conectar
    public void conectar() {
        if (dbConnection != null) {
           // connection = dbConnection.connect(); // Conectar a la base de datos
        } else {
            System.out.println("Error: dbConnection no ha sido inicializado.");
        }
    }

    // Método opcional para obtener la conexión
    public Connection getConexion() {
        return connection;
    }
}
