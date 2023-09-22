package Aplicacion.Tareas;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.Programa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FacturacionTest {

    private static final double DESC = 0.9;
    private static final double SOBRE = 1.3;

    Proyecto proyecto;
    @BeforeEach
    void preparaProyecto(){
        proyecto = new Proyecto();
    }


    @Test
    void calculoFactura() throws PersonaNoAñadida, TareaExistente {
        calcularFacturacion fac1;
        calcularFacturacion fac2;
        calcularFacturacion fac3;
        double coste;
        for (int i = 0; i < 1000; i++) {
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);
            fac1 = new Urgente();
            fac2 = new ConsumoInterno();
            fac3 = new Descuento();
            coste = i * 100;


            Tareas tarea1 = new Tareas(Integer.toString(-i), "1", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac1,coste,fac1.calculoFactura(coste));
            Tareas tarea2 = new Tareas(Integer.toString((i *10) + 1), "2", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac2,coste,fac2.calculoFactura(coste));
            Tareas tarea3 = new Tareas(Integer.toString((i *50)+2), "3", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac3,coste,fac3.calculoFactura(coste));
            proyecto.altaTarea(tarea1);
            proyecto.altaTarea(tarea2);
            proyecto.altaTarea(tarea3);

            assertEquals(coste* SOBRE, tarea1.getFacturacion());
            assertEquals(coste, tarea2.getFacturacion());
            assertEquals(coste * DESC, tarea3.getFacturacion());
        }
    }

}