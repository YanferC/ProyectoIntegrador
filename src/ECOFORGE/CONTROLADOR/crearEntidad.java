/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 */
public abstract class crearEntidad {
    
    public void ejecutarOperacion(){
        Crud crud = armarCrud();
    }
    
    public abstract Crud armarCrud();
}
