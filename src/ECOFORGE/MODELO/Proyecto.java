/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author ANDRES
 */
public class Proyecto {
    private Integer codigo_proyecto;
    private String nombre_proyecto;

    public Proyecto(Integer codigo_proyecto, String nombre_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
        this.nombre_proyecto = nombre_proyecto;
    }

    public Integer getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(Integer codigo_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }
    
}
