/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import javax.swing.JTextField;

public class ControladorCajaTexto {

    // Permitir solo números
    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Permitir números y el carácter de retroceso
        if (!(Character.isDigit(caracter) || Character.isISOControl(caracter))) {
            evt.consume(); // Descartar el evento si no es un número ni un retroceso
        }
    }

    // Permitir solo letras
    public void soloLetras(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Permitir letras, espacios y el carácter de retroceso
        if (!(Character.isLetter(caracter) || Character.isSpaceChar(caracter) || Character.isISOControl(caracter))) {
            evt.consume(); // Descartar el evento si no es una letra, espacio ni un retroceso
        }
    }

    // Método para restringir la longitud del texto
    public void longitudCaracter(JTextField textField, int maxLength, java.awt.event.KeyEvent evt) {
        if (textField.getText().length() >= maxLength) {
            evt.consume(); // Bloquea la entrada si se supera la longitud permitida
        }
    }
}
