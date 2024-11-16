/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YANFER
 */
public class Torre {
    private Integer numero_torre, numero_pisos;
    private String codigo_proyecto;
    private List<Torre> torresRelacionadas;

    public Torre(Integer numero_torre, Integer numero_pisos, String codigo_proyecto){
        this.numero_torre = numero_torre;
        this.numero_pisos = numero_pisos;
        this.codigo_proyecto = codigo_proyecto;
        this.torresRelacionadas = new ArrayList<>();
    }

    public List<Torre> getTorresRelacionadas() {
        return torresRelacionadas;
    }

    public void setTorresRelacionadas(List<Torre> torresRelacionadas) {
        this.torresRelacionadas = torresRelacionadas;
    }

    public Integer getNumero_torre() {
        return numero_torre;
    }

    public void setNumero_torre(Integer numero_torre) {
        this.numero_torre = numero_torre;
    }

    public Integer getNumero_pisos() {
        return numero_pisos;
    }

    public void setNumero_pisos(Integer numero_pisos) {
        this.numero_pisos = numero_pisos;
    }

    public String getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(String codigo_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
    }
    
}
