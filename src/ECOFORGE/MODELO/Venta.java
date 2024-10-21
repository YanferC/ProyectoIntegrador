/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
import java.util.Date;

public class Venta {
    private Integer id;
    private Integer precio_Total_Venta;
    private Integer tipo_Pago;
    private Date fecha_Venta;
    private Integer numero_Cuotas;
    private String matricula;
    private Date fecha_Escritura;
    private Integer numero_Apartamento;
    private Integer numero_Ident_Cli;

    public Venta(Integer id, Integer precio_Total_Venta, Integer tipo_Pago, Date fecha_Venta, Integer numero_Cuotas, String matricula, Date fecha_Escritura, Integer numero_Apartamento, Integer numero_Ident_Cli) {
        this.id = id;
        this.precio_Total_Venta = precio_Total_Venta;
        this.tipo_Pago = tipo_Pago;
        this.fecha_Venta = fecha_Venta;
        this.numero_Cuotas = numero_Cuotas;
        this.matricula = matricula;
        this.fecha_Escritura = fecha_Escritura;
        this.numero_Apartamento = numero_Apartamento;
        this.numero_Ident_Cli = numero_Ident_Cli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecio_Total_Venta() {
        return precio_Total_Venta;
    }

    public void setPrecio_Total_Venta(Integer precio_Total_Venta) {
        this.precio_Total_Venta = precio_Total_Venta;
    }

    public Integer getTipo_Pago() {
        return tipo_Pago;
    }

    public void setTipo_Pago(Integer tipo_Pago) {
        this.tipo_Pago = tipo_Pago;
    }

    public Date getFecha_Venta() {
        return fecha_Venta;
    }

    public void setFecha_Venta(Date fecha_Venta) {
        this.fecha_Venta = fecha_Venta;
    }

    public Integer getNumero_Cuotas() {
        return numero_Cuotas;
    }

    public void setNumero_Cuotas(Integer numero_Cuotas) {
        this.numero_Cuotas = numero_Cuotas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha_Escritura() {
        return fecha_Escritura;
    }

    public void setFecha_Escritura(Date fecha_Escritura) {
        this.fecha_Escritura = fecha_Escritura;
    }

    public Integer getNumero_Apartamento() {
        return numero_Apartamento;
    }

    public void setNumero_Apartamento(Integer numero_Apartamento) {
        this.numero_Apartamento = numero_Apartamento;
    }

    public Integer getNumero_Ident_Cli() {
        return numero_Ident_Cli;
    }

    public void setNumero_Ident_Cli(Integer numero_Ident_Cli) {
        this.numero_Ident_Cli = numero_Ident_Cli;
    }
    
    
}
