package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ListarTareasProyecto{

    public static void ejecutaListarTareasProyecto(Proyecto proyecto){
        System.out.println("\nEsta es la lista de tareas\n");

        List<Tareas> tareas = proyecto.listarTareas();

        StringBuilder sb = new StringBuilder();

        for (Tareas tarea : tareas){
            sb.append(tarea);
            sb.append("\n");
        }

        System.out.println(sb);
        System.out.format("\n");
    }
}
