/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

/**
 *
 * @author YANFER
 */
import ECOFORGE.VISTA.PanelCliente.ClienteAddedListener;
import ECOFORGE.VISTA.Venta;
public class ControladorVentas implements ClienteAddedListener {
    private Venta vista;

    public ControladorVentas(Venta vista) {
        this.vista = vista;
    }

    @Override
    public void onClienteAdded() {
        vista.clienteAgregado(); // Llamar al método que habilita el botón
    }
}
