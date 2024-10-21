/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
public class Cliente {

    private String numero_Identificacion;
    private String nombreCompleto;
    private String sisben;
    private Integer subsidio_Ministerio;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    // Constructor
    public Cliente(String numero_Identificacion, String nombreCompleto, String sisben,Integer subsidio_Ministerio ,String direccion, String telefono, String correoElectronico) {
        this.numero_Identificacion = numero_Identificacion;
        this.nombreCompleto = nombreCompleto;
        this.sisben = sisben;
        this.subsidio_Ministerio = subsidio_Ministerio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    // Getters y Setters
    public String getNumero_Identificacion() {
        return numero_Identificacion;
    }

    public void setNumero_Identificacion(String numero_Identificacion) {
        this.numero_Identificacion = numero_Identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getSubsidio_Ministerio() {
        return subsidio_Ministerio;
    }

    public void setSubsidio_Ministerio(Integer subsidio_Ministerio) {
        this.subsidio_Ministerio = subsidio_Ministerio;
    }
    
    
}
