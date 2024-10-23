/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author sebastian
 */
public class Apartamento { //Declaramos las variables//
    private Integer numero_Apartamento;
    private Integer valor_Apartamento;
    private String tipo_Inmueble;
    private Integer area;
    private Integer numero_Torre;

    public Apartamento(Integer numero_Apartamento, Integer valor_Apartamento, String tipo_Inmueble, Integer area, Integer numero_Torre) {
        this.numero_Apartamento = numero_Apartamento;
        this.valor_Apartamento = valor_Apartamento;
        this.tipo_Inmueble = tipo_Inmueble;
        this.area = area;
        this.numero_Torre = numero_Torre;
    }

    public Integer getNumero_Apartamento() {
        return numero_Apartamento;
    }

    public void setNumero_Apartamento(Integer numero_Apartamento) {
        this.numero_Apartamento = numero_Apartamento;
    }

    public Integer getValor_Apartamento() {
        return valor_Apartamento;
    }

    public void setValor_Apartamento(Integer valor_Apartamento) {
        this.valor_Apartamento = valor_Apartamento;
    }

    public String getTipo_Inmueble() {
        return tipo_Inmueble;
    }

    public void setTipo_Inmueble(String tipo_Inmueble) {
        this.tipo_Inmueble = tipo_Inmueble;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getNumero_Torre() {
        return numero_Torre;
    }

    public void setNumero_Torre(Integer numero_Torre) {
        this.numero_Torre = numero_Torre;
    }
    
    
}
