package Aplicacion.EjecutarMétodos;

import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasNoResponsablesTareas{


    public static void ejecutarListadoPersonasNoResponsablesTareas(Scanner sn, Proyecto proyecto){

        List<Personas> personasNoResponsables = new LinkedList<>();

        personasNoResponsables = UtilidadesParaListas.elementosConListaVacia(proyecto.listarPersonas());

        System.out.println("Las personas no responsables de ninguna tarea són :");

        for (Personas persona : personasNoResponsables){
            System.out.format("DNI --> %s,Nombre --> %s\n",persona.getClave(), persona.getNombre());
        }
        System.out.format("\n");

    }
}
