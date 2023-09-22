package Aplicacion.EjecutarMétodos;

import Aplicacion.EjecutarExcepciones.NoAñadirPersona;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.util.Scanner;

public class IntroducirPersonaTarea{

    public static void ejectaIntroducirPersonaTarea(Scanner sn , Proyecto proyecto) throws TareaNoExistente {
        sn.nextLine();


        System.out.format("\nIntroduce el título de la tarea --> ");


        String titulo = sn.nextLine();
        Tareas tarea = proyecto.getTarea(titulo);

        try {

            proyecto.getTarea(titulo);


        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona;

            persona = proyecto.getPersona(dni);

            NoAñadirPersona.ejecutaAñadirPersonaExcepcion(dni,tarea.getLista());

            tarea.introducirPersonaTarea(persona);
            System.out.format("\nSe ha añadido correctamente a la persona en la tarea");


        }catch (TareaNoExistente | PersonaNoExistente e){
            System.out.format(e.getMessage());
        }
        catch (PersonaNoAñadida e1){
            System.out.format("\nLa persona ya existía");
        }

        System.out.format("\n");


    }
}
