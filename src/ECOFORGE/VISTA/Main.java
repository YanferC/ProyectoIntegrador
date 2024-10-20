/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.VISTA;

/**
 *
 * @author YANFER
 */
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del formulario Login
        Login login = new Login();
        
        // Configuración básica del formulario
        login.setVisible(true); // Hacer que el formulario sea visible
        login.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al salir
    }
}
