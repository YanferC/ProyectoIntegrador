/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ECOFORGE.CONTROLADOR;

import ECOFORGE.MODELO.Apartamento;
import ECOFORGE.MODELO.CrudApartamento;
import ECOFORGE.MODELO.CrudProyecto;
import ECOFORGE.MODELO.CrudTorre;
import ECOFORGE.MODELO.Proyecto;
import ECOFORGE.MODELO.Torre;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author YANFER
 */
public class ControladorVenta {

    private final JComboBox<String> jcbProyecto;
    private final JComboBox<String> jcbTorre;
    private final JComboBox<String> jcbApartamento;

    private final CrudProyecto crudProyecto;
    private final CrudTorre crudTorre;
    private final CrudApartamento crudApartamento;

    public ControladorVenta(JComboBox<String> jcbProyecto, JComboBox<String> jcbTorre, JComboBox<String> jcbApartamento) {
        this.jcbProyecto = jcbProyecto;
        this.jcbTorre = jcbTorre;
        this.jcbApartamento = jcbApartamento;

        this.crudProyecto = new CrudProyecto();
        this.crudTorre = new CrudTorre();
        this.crudApartamento = new CrudApartamento();

        inicializarComboboxes();
    }

    private void inicializarComboboxes() {
        jcbProyecto.addActionListener(e -> seleccionarProyecto());
        jcbTorre.addActionListener(e -> seleccionarTorre());
        jcbApartamento.addActionListener(e -> seleccionarApartamento());

        cargarProyectos();
        jcbProyecto.setVisible(true);
        jcbTorre.setVisible(false);
        jcbApartamento.setVisible(false);
    }

    public void cargarProyectos() {
        jcbProyecto.removeAllItems();
        List<Proyecto> proyectos = crudProyecto.ObtenerTodo();
        for (Proyecto proyecto : proyectos) {
            jcbProyecto.addItem(proyecto.getCodigo_proyecto());
        }
    }

    private void seleccionarProyecto() {
        String codigoProyecto = (String) jcbProyecto.getSelectedItem();
        if (codigoProyecto != null) {
            cargarTorres(codigoProyecto);
            jcbProyecto.setVisible(false);
            jcbTorre.setVisible(true);
        }
    }

    private void cargarTorres(String codigoProyecto) {
        jcbTorre.removeAllItems();
        Torre torreContenedora = crudTorre.ObtenerPorCodigo(codigoProyecto);
        if (torreContenedora != null && torreContenedora.getTorresRelacionadas() != null) {
            for (Torre torre : torreContenedora.getTorresRelacionadas()) {
                jcbTorre.addItem(String.valueOf(torre.getNumero_torre()));
            }
        }
    }

    private void seleccionarTorre() {
        String numeroTorre = (String) jcbTorre.getSelectedItem();
        if (numeroTorre != null) {
            cargarApartamentos(numeroTorre);
            jcbTorre.setVisible(false);
            jcbApartamento.setVisible(true);
        }
    }

    private void cargarApartamentos(String numeroTorre) {
        jcbApartamento.removeAllItems();
        Apartamento aptContenedora = crudApartamento.ObtenerPorCodigo(numeroTorre);
        if (aptContenedora != null && aptContenedora.getAptRelacionadas() != null) {
            for (Apartamento apt : aptContenedora.getAptRelacionadas()) {
                jcbApartamento.addItem(String.valueOf(apt.getNumero_Apartamento()));
            }
        }
    }

    private void seleccionarApartamento() {
        String numeroApartamento = (String) jcbApartamento.getSelectedItem();
        if (numeroApartamento != null) {
            // Acción final o notificación al formulario principal
            System.out.println("Apartamento seleccionado: " + numeroApartamento);
        }
    }
}
