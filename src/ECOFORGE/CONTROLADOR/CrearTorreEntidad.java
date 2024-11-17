/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.CrudTorre;

/**
 *
 * @author YANFER
 */
public class CrearTorreEntidad extends crearEntidad {

    @Override
    public Crud armarCrud() {
        return new CrudTorre();
    }
    
}
