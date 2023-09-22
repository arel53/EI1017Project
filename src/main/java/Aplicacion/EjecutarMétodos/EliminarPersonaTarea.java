package Aplicacion.EjecutarMétodos;

import Aplicacion.EjecutarExcepciones.NoEliminarPersona;
import Aplicacion.Excepcion.*;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.util.Scanner;

public class EliminarPersonaTarea {

    public static void ejecutaEliminarPersonaTarea(Scanner sn, Proyecto proyecto) {

        System.out.format("Introduce el título de la tarea --> ");
        sn.nextLine();


        String titulo = sn.nextLine();

        try {
            Tareas tarea = proyecto.getTarea(titulo);

            proyecto.getTarea(titulo);


            System.out.format("\nIntroduce el DNI de la persona --> ");

            String dni = sn.next();

            Personas persona = proyecto.getPersona(dni);




            NoEliminarPersona.ejecutaNoEliminarPersona(dni, tarea.getLista());

            if (tarea.eliminarPersonaTarea(persona))
                System.out.println("Se ha eliminado correctamente");

        } catch (TareaNoExistente  | PersonaNoExistente e) {
            System.out.format(e.getMessage());
        }
        System.out.format("\n");
    }
}
