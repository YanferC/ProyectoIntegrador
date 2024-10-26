/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;
import ECOFORGE.VISTA.ProyectoVista;
import  ECOFORGE.VISTA.TorreVista;
/**
 *
 * @author juans
 */
public class ControladorVistaTorreProyecto {
    private ProyectoVista proyectoVista;
    private TorreVista torreVista;
    
    public ControladorVistaTorreProyecto(ProyectoVista proyectoVista){
        this.proyectoVista = proyectoVista;
    }
    
    public void abrirTorreVistaConCodigo(){
        String codigoProyecto = proyectoVista.getCodigoProyecto();
        
        torreVista = new TorreVista();
        torreVista.setCodigoProyecto(codigoProyecto);
        
        torreVista.setVisible(true);
    }
    
}
