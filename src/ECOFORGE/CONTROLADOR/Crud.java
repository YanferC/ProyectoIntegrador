/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import java.util.List;

/**
 *
 * @author YANFER
 * @param <T>
 */
public interface Crud<T> {
    public boolean Crear(T objeto);
    public boolean Actualizar(T objeto);
    public boolean Eliminar(String Codigo);
    public List<T> ObtenerTodo();
    public T ObtenerPorCodigo(String Codigo);
    public String ObtenerID();
}
