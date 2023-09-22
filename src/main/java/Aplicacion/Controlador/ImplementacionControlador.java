package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Persona.Personas;
import Aplicacion.Vista.ImplementacionVista;
import Aplicacion.Vista.Vista;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ImplementacionControlador implements Controlador {


    private Modelo modelo;
    private Vista vista;





    @Override
    public void setModelo(ImplementacionModelo modelo){
        this.modelo = modelo;
    }
    @Override
    public void setVista(ImplementacionVista vista){
        this.vista = vista;
    }


    @Override
    public void insertarPersona() throws PersonaNoAñadida {
        Personas persona;
        persona = Personas.createPersona(vista.getDniPanelPersonas().toUpperCase(), vista.getNombrePanelPersonas(), vista.getCorreoPanelPersonas(), modelo.getProyecto().listarPersonas());
        modelo.insertarPersona(persona);
    }
    @Override
    public void insertarPersonaTarea() throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente {
        modelo.insertarPersonaTarea(vista.getTituloPanelTareas(), vista.getDniPanelTareas());
    }
    @Override
    public void eliminarPersonaTarea() throws TareaNoExistente, PersonaNoExistente {
        modelo.eliminarPersonaTarea(vista.getTituloPanelTareas(), vista.getDniPanelTareas());
    }

    @Override
    public void finalizarTarea() throws TareaNoExistente{
        modelo.finalizarTarea(vista.getTituloPanelTareas());
    }
    @Override
    public void cambiarCosteTarea() throws TareaNoExistente {
        modelo.cambiarCosteTarea(vista.getTituloPanelTareas(), vista.getCostePanelTareas());

    }
    @Override
    public void altaTarea() throws TareaExistente, PersonaNoAñadida, PersonaNoExistente, TareaNoExistente {

        modelo.altaTarea(vista.getTituloAltaTarea(), vista.getDescripcionAltaTarea(), vista.getPersonasAltaTarea(), vista.getResponsableAltaTarea(), vista.getPrioridadAltaTarea(), vista.getIdResultadoAltaTarea(), vista.getNhorasAltaTarea(), vista.getTipoResultadoAltaTarea(), vista.getResultadoEsperadoAltaTarea(), vista.getEtiquetasAltaTarea(), vista.getCosteAltaTarea(), vista.getTipoFacturaAltaTarea());
        //titulo,descrip,personas,responable,idresul,prioridad,creac,tipofac,coste,fac,etiquetas
    }
    @Override
    public void listarPersonasNoResponsables(){
        modelo.listarPersonasNoResponsables();
    }
    @Override
    public void listarTareasSinPersonas() {
        modelo.listarTareasSinPersonas();
    }
    @Override
    public void abrirNuevoProyecto(){
        modelo.abrirNuevoProyecto();
    }

    @Override
    public void cerrarGuardarFichero() throws IOException {
        modelo.guardarFichero(vista.getF());
    }


}
