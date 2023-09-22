package Aplicacion.EjecutarMétodos;

import Aplicacion.EjecutarExcepciones.ExisteTitulo;
import Aplicacion.EjecutarExcepciones.NoAñadirPersona;
import Aplicacion.EjecutarExcepciones.OpcionFueraDeRango;
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

class AltaPersonasTestExcepciones {

    Proyecto proyecto;
    @BeforeEach
    void preparaProyecto(){
        proyecto = new Proyecto();
    }
    Scanner sn;
    @BeforeEach
    void preparaScan(){
        sn = new Scanner(System.in);
    }

    Tareas tarea1;
    Personas persona;
    Personas persona1;
    @BeforeEach
    void addPersonaTarea() throws PersonaNoAñadida, TareaExistente {
        persona = new Personas("1","1","1");
        proyecto.altaPersona(persona);
        persona1=new Personas("2","2","2");
        proyecto.altaPersona(persona1);
        tarea1 = new Tareas("1", "", new LinkedList<>(), persona, 1, new Programa(), new LinkedList<>());
        proyecto.altaTarea(tarea1);
    }



    @Test
   void ejecutarAltaTareaExcepcionTareaExistente() {
        try{
            proyecto.altaTarea(tarea1);
            fail("No se ha lanzado la excepción");
        }
        catch (TareaExistente e){
            assertTrue(true);
        }



    }

    @Test
    void existeTitulo(){
        try {
            ExisteTitulo.ejecutaExisteTitulo(tarea1.getClave(),proyecto.listarTareas());
            fail("No se ha lanzado la excepción");
        }catch (TareaExistente e){
            assertTrue(true);
        }
    }

    @Test
    void OpcionFueraDeRango(){
        int opción =10;
        int rango = 5;
        try {
            OpcionFueraDeRango.ejecutarOpcionFueraRango(opción,rango);
            fail("No se ha lanzado la excepción");
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }
    }

    @Test
    void NoAñadirPersona(){
        try {
            NoAñadirPersona.ejecutaAñadirPersonaExcepcion(persona.getClave(),proyecto.listarPersonas());
            fail("No se ha lanzado la excepción");

        }
        catch (PersonaNoAñadida e){
            assertTrue(true);

        }
    }


}