/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.CrudProyecto;


/**
 *
 * @author YANFER
 */
public class CrearProyectoEntidad extends crearEntidad {
    
    @Override
    public Crud armarCrud() {
        return new CrudProyecto();
    }
    
}
