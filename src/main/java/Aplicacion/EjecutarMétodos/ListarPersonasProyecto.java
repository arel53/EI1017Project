package Aplicacion.EjecutarMétodos;

import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;

import java.io.Serializable;
import java.util.List;

public class ListarPersonasProyecto{

    public static void ejecutaListarPersonasProyecto(Proyecto proyecto){

        System.out.println("\nEsta es la lista de personas\n");

        List<Personas> personas = proyecto.listarPersonas();

        StringBuilder sb = new StringBuilder();

        for (Personas persona : personas){
            sb.append(persona);
            sb.append("\n");
        }


        System.out.format(sb.toString());
        System.out.format("\n");

    }
}
