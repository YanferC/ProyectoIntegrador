/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
public class Asesor {

    private String numero_Identificacion;
    private String nombre_Completo;
    private String direccion;
    private String telefono;
    private String correo_Electronico;

    public Asesor(String numero_Identificacion, String nombre_Completo, String direccion, String telefono, String correo_Electronico) {
        this.numero_Identificacion = numero_Identificacion;
        this.nombre_Completo = nombre_Completo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo_Electronico = correo_Electronico;
    }

    public String getNumero_Identificacion() {
        return numero_Identificacion;
    }

    public String getNombre_Completo() {
        return nombre_Completo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo_Electronico() {
        return correo_Electronico;
    }

    public void setNumero_Identificacion(String numero_Identificacion) {
        this.numero_Identificacion = numero_Identificacion;
    }

    public void setNombre_Completo(String nombre_Completo) {
        this.nombre_Completo = nombre_Completo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        this.correo_Electronico = correo_Electronico;
    }

}
