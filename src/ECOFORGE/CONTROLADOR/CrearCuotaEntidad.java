/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.CrudCuota;

/**
 *
 * @author YANFER
 */
public class CrearCuotaEntidad extends crearEntidad {

    @Override
    public Crud armarCrud() {
        return new CrudCuota();
    }
    
}
