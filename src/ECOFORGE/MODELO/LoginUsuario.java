/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.MODELO;

/**
 *
 * @author YANFER
 */
public class LoginUsuario {
    private String ID_USUARIO; 
    private String TIPO_ROL;
    private String DESCRIPCION_ROL;
    private String CONTRASENA;

    public LoginUsuario(String ID_USUARIO, String TIPO_ROL, String DESCRIPCION_ROL, String CONTRASENA) {
        this.ID_USUARIO = ID_USUARIO;
        this.TIPO_ROL = TIPO_ROL;
        this.DESCRIPCION_ROL = DESCRIPCION_ROL;
        this.CONTRASENA = CONTRASENA;
    }

    public String getID_USUARIO() {
        return ID_USUARIO;
    }

    public String getTIPO_ROL() {
        return TIPO_ROL;
    }

    public String getDESCRIPCION_ROL() {
        return DESCRIPCION_ROL;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setID_USUARIO(String ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public void setTIPO_ROL(String TIPO_ROL) {
        this.TIPO_ROL = TIPO_ROL;
    }

    public void setDESCRIPCION_ROL(String DESCRIPCION_ROL) {
        this.DESCRIPCION_ROL = DESCRIPCION_ROL;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }
    
    
}
