package Aplicacion.Vista;

import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;

import java.io.File;
import java.util.List;

public interface Vista {

    // CORREGIDO: Aquí faltan los métodos que puede utilizar el controlador para
    //   interrogar sobre la vista

    void run();
    void setModelo(ImplementacionModelo modelo);
    void setControlador(ImplementacionControlador controladora);
    void actualizar();
    void actualizarTabla();
    File ventanaAbrirFichero();
    void cerrarGuardarFichero();
    void noExistePersona(String dni);
    String getDniPanelPersonas();
    String getNombrePanelPersonas();
    String getCorreoPanelPersonas();
    String getTituloAltaTarea();
    String getDescripcionAltaTarea();
    String getResponsableAltaTarea();
    String getPrioridadAltaTarea();
    String getIdResultadoAltaTarea();
    String getTipoResultadoAltaTarea();
    String getNhorasAltaTarea();
    String getResultadoEsperadoAltaTarea();
    String getTipoFacturaAltaTarea();
    String getCosteAltaTarea();
    List<String> getPersonasAltaTarea();
    List<String> getEtiquetasAltaTarea();
    String getDniPanelTareas();
    String getTituloPanelTareas();
    String getCostePanelTareas();
    File getF();
    void abrirNuevoProyecto();


}
