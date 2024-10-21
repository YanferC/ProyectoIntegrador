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

public class Cuota {
    private Integer id;
    private Integer numero_Cuota;
    private Date fecha_Vencimiento;
    private Integer monto_Cuota; 
    private String estado_Cuota;
    private String numero_Iden_Ase;
    private Integer intereses;
    private Integer id_Venta;

    public Cuota(Integer id, Integer numero_Cuota, Date fecha_Vencimiento, Integer monto_Cuota, String estado_Cuota, String numero_Iden_Ase, Integer intereses, Integer id_Venta) {
        this.id = id;
        this.numero_Cuota = numero_Cuota;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.monto_Cuota = monto_Cuota;
        this.estado_Cuota = estado_Cuota;
        this.numero_Iden_Ase = numero_Iden_Ase;
        this.intereses = intereses;
        this.id_Venta = id_Venta;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero_Cuota() {
        return numero_Cuota;
    }

    public Date getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public Integer getMonto_Cuota() {
        return monto_Cuota;
    }

    public String getEstado_Cuota() {
        return estado_Cuota;
    }

    public String getNumero_Asesor() {
        return numero_Iden_Ase;
    }

    public Integer getIntereses() {
        return intereses;
    }

    public Integer getId_Venta() {
        return id_Venta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero_Cuota(Integer numero_Cuota) {
        this.numero_Cuota = numero_Cuota;
    }

    public void setFecha_Vencimiento(Date fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public void setMonto_Cuota(Integer monto_Cuota) {
        this.monto_Cuota = monto_Cuota;
    }

    public void setEstado_Cuota(String estado_Cuota) {
        this.estado_Cuota = estado_Cuota;
    }

    public void setNumero_Asesor(String numero_Asesor) {
        this.numero_Iden_Ase = numero_Asesor;
    }

    public void setIntereses(Integer intereses) {
        this.intereses = intereses;
    }

    public void setId_Venta(Integer id_Venta) {
        this.id_Venta = id_Venta;
    }
    
    
}
