package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.Programa;
import Aplicacion.Tareas.Tareas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AltaPersonasTestExcepcion {

    Proyecto proyecto;
    @BeforeEach
    void preparaProyecto(){
        proyecto = new Proyecto();
    }

    Personas persona;
    @BeforeEach
    void addPersonaTarea() throws PersonaNoAñadida, TareaExistente {
        persona = new Personas("1","1","1");
        proyecto.altaPersona(persona);
        Tareas tarea1 = new Tareas("1", "", new LinkedList<>(), persona, 1, new Programa(), new LinkedList<>());
        proyecto.altaTarea(tarea1);
    }

    @Test
    void altaPersonasExcepcionPersonaNoAñadida(){
        try {
            proyecto.altaPersona(persona);
            fail("No se ha lanzado la excepcion");
        }catch (PersonaNoAñadida e){
            assertTrue(true);
        }
    }





}