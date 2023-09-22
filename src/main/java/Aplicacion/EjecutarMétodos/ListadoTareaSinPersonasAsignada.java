package Aplicacion.EjecutarMétodos;

import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ListadoTareaSinPersonasAsignada{

    public static void ejecutarListadoPersonasSinTareaAsignada(Proyecto proyecto){


        List<Tareas> tareasSinPersonaAsignada = UtilidadesParaListas.elementosConListaVacia(proyecto.listarTareas());
        if (tareasSinPersonaAsignada.isEmpty())
            System.out.format("No hay ninguna tarea sin personas asignadas\n");
        else {
            for (Tareas tareas : tareasSinPersonaAsignada) {
                System.out.format("Titulo --> %s\n", tareas.getClave());
            }
        }
        System.out.format("\n");
    }
}
