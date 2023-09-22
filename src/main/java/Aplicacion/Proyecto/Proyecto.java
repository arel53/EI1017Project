package Aplicacion.Proyecto;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;


public class Proyecto implements Serializable{
    private static final long serialVersionUID=42L;
    String nombre;
    List<Personas> personas;
    List<Tareas> tareas;

    public Proyecto(String nombre){
        this.nombre = nombre.toLowerCase();
        this.personas = new LinkedList<>();
        this.tareas = new LinkedList<>();
    }

    public Proyecto(){
        personas = new LinkedList<>();
        tareas = new LinkedList<>();
    }

    public String toString(){
        return "Proyecto --> " + nombre;
    }

    public static Proyecto iniciarProyecto(String nombre){
        return new Proyecto(nombre);
    }

    public void altaPersona(Personas persona) throws PersonaNoAñadida {
        if (persona.getClave().equals(""))
            throw new PersonaNoAñadida("No se ha añadido a la persona ya que el campo del DNI está vacio");
        if (!UtilidadesParaListas.insertarEnLista(persona.getClave(), personas))
            throw new PersonaNoAñadida("No se ha añadido a la persona '" + persona.getClave() + "'");
        personas.add(persona);
    }

    public boolean altaTarea(Tareas tarea) throws TareaExistente {
        if (!UtilidadesParaListas.insertarEnLista(tarea.getClave(), tareas)) {
            throw new TareaExistente();
        }

        tarea.getResponsable().addPersonaTareas(tarea);
        return tareas.add(tarea);
    }


    public List<Personas> listarPersonas(){
        return personas;
    }

    public List<Tareas> listarTareas(){
        return tareas;
    }

    public Personas getPersona(String dni) throws PersonaNoExistente {

        for (Personas p : personas){
            if (p.getDni().equals(dni.toUpperCase())){
                return p;
            }
        }

        throw new PersonaNoExistente();
    }

    public Tareas getTarea(String tarea) throws TareaNoExistente {

        for (Tareas t : tareas){
            if (t.getClave().equals(tarea.toLowerCase()))
                return t;
        }
        throw new TareaNoExistente();
    }

    public String getNombre(){
        return nombre;
    }




}
