package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.Scanner;

public class FinalizarTarea{



    public static void ejecutarFinalizarTarea(Scanner sn, Proyecto proyecto) throws TareaNoExistente {

        sn.nextLine();
        System.out.format("Vas a finalizar una tarea\n");
        System.out.format("Escribe el nombre de la tarea para finalizarla --> ");

        String titulo = sn.nextLine();

        Tareas tarea = proyecto.getTarea(titulo);

        System.out.println(tarea.finalizarTarea());
        System.out.format("\n");

    }
}
