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
    private String tipo_Pago;
    private Date fecha_Venta;
    private Date fecha_Escritura;
    private String matricula;
    private String numero_IdCliente;
    private String numero_idAsesor;
    private Integer numero_Apartamento;

    public Venta(Integer id, Integer precio_Total_Venta, String tipo_Pago, Date fecha_Venta, Date fecha_Escritura, String matricula, String numero_IdCliente, String numero_idAsesor, Integer numero_Apartamento) {
        this.id = id;
        this.precio_Total_Venta = precio_Total_Venta;
        this.tipo_Pago = tipo_Pago;
        this.fecha_Venta = fecha_Venta;
        this.fecha_Escritura = fecha_Escritura;
        this.matricula = matricula;
        this.numero_IdCliente = numero_IdCliente;
        this.numero_idAsesor = numero_idAsesor;
        this.numero_Apartamento = numero_Apartamento;
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

    public String getTipo_Pago() {
        return tipo_Pago;
    }

    public void setTipo_Pago(String tipo_Pago) {
        this.tipo_Pago = tipo_Pago;
    }

    public Date getFecha_Venta() {
        return fecha_Venta;
    }

    public void setFecha_Venta(Date fecha_Venta) {
        this.fecha_Venta = fecha_Venta;
    }

    public Date getFecha_Escritura() {
        return fecha_Escritura;
    }

    public void setFecha_Escritura(Date fecha_Escritura) {
        this.fecha_Escritura = fecha_Escritura;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNumero_IdCliente() {
        return numero_IdCliente;
    }

    public void setNumero_IdCliente(String numero_IdCliente) {
        this.numero_IdCliente = numero_IdCliente;
    }

    public String getNumero_idAsesor() {
        return numero_idAsesor;
    }

    public void setNumero_idAsesor(String numero_idAsesor) {
        this.numero_idAsesor = numero_idAsesor;
    }

    public Integer getNumero_Apartamento() {
        return numero_Apartamento;
    }

    public void setNumero_Apartamento(Integer numero_Apartamento) {
        this.numero_Apartamento = numero_Apartamento;
    }
    
    
    
    
}
