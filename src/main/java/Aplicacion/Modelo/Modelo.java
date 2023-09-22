package Aplicacion.Modelo;

import Aplicacion.Excepcion.*;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;
import Aplicacion.Vista.ImplementacionVista;

import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Modelo {

    void setVista(ImplementacionVista vista);
    void setProyecto(Proyecto proyecto);
    Proyecto getProyecto();
    void insertarPersona(Personas persona) throws PersonaNoAñadida;
    StringBuilder textoPersonas(List<Personas> datosSinTratar);
    StringBuilder textoTareas(List<Tareas> datosSinTratar);
    void guardarFichero(File fichero) throws IOException;
    void abrirFichero(File fichero) throws IOException, ClassNotFoundException;
    List<Personas> listarPersonasNoResponsables();
    List<Tareas> listarTareasSinPersonas();
    List<Tareas> listarTareas();
    void insertarPersonaTarea(String id, String DNI) throws PersonaNoExistente, TareaNoExistente, PersonaNoAñadida;
    void eliminarPersonaTarea(String id, String DNI) throws PersonaNoExistente, TareaNoExistente;
    void finalizarTarea(String id) throws TareaNoExistente;
    void cambiarCosteTarea(String id,String coste) throws TareaNoExistente;
    public void altaTarea( String titulo, String descripcion, List<String> personas, String responsable, String prioridad, String idResultado,String nHoras, String tipoResultado ,String resultadoEsperado ,List<String> etiquetas,String coste, String tipoFac ) throws PersonaNoExistente, PersonaNoAñadida, TareaExistente, TareaNoExistente;
    Tabla crearTablaPersonas();
    Tabla crearTablaTareas();

    ModeloTablaPersonas actualizarTabla();
    ModeloTablaTareas actualizarTablaTareas();
    ModeloTablaTareas actualizarTablaTareasSinPersonas();
    ModeloTablaPersonas actualizarTablaPersonasNoResponasbles();
    void abrirNuevoProyecto();
    List<Personas> getListarPersonas();
}
