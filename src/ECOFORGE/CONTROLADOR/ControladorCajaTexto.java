/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

public class ControladorCajaTexto {
    
    public void soloNumeros(java.awt.event.KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    public void soloLetras(java.awt.event.KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
        }
    }
}

