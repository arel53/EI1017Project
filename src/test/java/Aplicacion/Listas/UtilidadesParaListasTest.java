package Aplicacion.Listas;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.Programa;
import Aplicacion.Tareas.Tareas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesParaListasTest <T> {

    Proyecto proyecto;

    @BeforeEach
    void preparaProyecto() {
        proyecto = new Proyecto();
    }

    Personas personaCon;
    Personas personaSin;
    Tareas tarea1;

    @BeforeEach
    void crearPersonasTareas() throws PersonaNoAñadida, TareaExistente {


        personaCon = new Personas("1", "1", "1");
        personaSin = new Personas("2", "2", "2");
        proyecto.altaPersona(personaCon);
        proyecto.altaPersona(personaSin);

        tarea1 = new Tareas("1", "", new LinkedList<>(), personaCon, 1, new Programa(), new LinkedList<>());

        proyecto.altaTarea(tarea1);
    }

    @Test
    void elementosConListaVacia () throws PersonaNoAñadida, TareaExistente, PersonaNoExistente {




        List<Personas> objetos = new LinkedList<>();
        personaCon = proyecto.getPersona(personaCon.getClave());
        objetos.add(personaCon);
        personaSin = proyecto.getPersona(personaSin.getClave());
        objetos.add(personaSin);
        List<Personas> elementosConListaVacia = UtilidadesParaListas.elementosConListaVacia(objetos);

        assertEquals(elementosConListaVacia.get(0),personaSin);
    }

    @Test
    void insertarEnLista() {
        assertFalse(UtilidadesParaListas.insertarEnLista(personaCon.getClave(),proyecto.listarPersonas()));

        assertTrue(UtilidadesParaListas.insertarEnLista("12525",proyecto.listarPersonas()));

        assertFalse(UtilidadesParaListas.insertarEnLista(tarea1.getClave(),proyecto.listarTareas()));
        assertTrue(UtilidadesParaListas.insertarEnLista("15252525",proyecto.listarTareas()));
    }
}