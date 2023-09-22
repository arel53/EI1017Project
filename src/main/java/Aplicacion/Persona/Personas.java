package Aplicacion.Persona;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Tareas.Tareas;
import Aplicacion.Listas.tieneLista;
import Aplicacion.Listas.tieneClave;

import java.io.Serializable;
import java.util.*;

public class Personas implements tieneLista<Tareas>,tieneClave<String>, Serializable {

    private static final long serialVersionUID=42L;

    public String dni;
    public String nombre;
    public String correo;
    public List<Tareas> tareas;


    public Personas(String dni,String nombre, String correo){
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = new LinkedList<>();


    }

    public Personas(String dni,String nombre, String correo, List<Tareas> tareas){
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = tareas;


    }

    public Personas(){
        tareas = new LinkedList<>();
    }

    public String toString(){
        return "Dni --> " + dni +" Nombre --> "+ nombre;
    }


    public static Personas createPersona(String dni,String nombre, String correo , List<Personas> personas) throws PersonaNoAñadida {
        return new Personas(dni.toUpperCase(),nombre,correo);
    }

    public void addPersonaTareas(Tareas tarea){
        this.tareas.add(tarea);
    }

    public String getNombre(){
        return nombre;
    }


    public String getCorreo(){
        return correo;
    }

    public String getDni(){
        return dni;
    }


    @Override
    public List<Tareas> getLista() {
        return tareas;
    }

    @Override
    public String getClave() {
        return dni;
    }

    public LinkedList<String> getInfoPersonas(){
        LinkedList<String> vector = new LinkedList<>();
        vector.add(getClave());
        vector.add(getNombre());
        vector.add(getCorreo());
        return vector;
    }
}
