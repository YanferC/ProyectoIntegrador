/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 * @param <T>
 */
public abstract class crearEntidad<T> {
    
    public void ejecutarOperacion(){
        Crud<T> crud = armarCrud();
    }
    
    public abstract Crud<T> armarCrud();
}
