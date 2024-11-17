/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.CrudCliente;

/**
 *
 * @author YANFER
 */
public class CrearClienteEntidad extends crearEntidad {

    @Override
    public Crud armarCrud() {
        return new CrudCliente();
    }
    
}
