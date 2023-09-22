package Aplicacion.EjecutarMétodos;

import Aplicacion.EjecutarExcepciones.ExisteTitulo;
import Aplicacion.EjecutarExcepciones.NoAñadirPersona;
import Aplicacion.EjecutarExcepciones.OpcionFueraDeRango;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.*;
import Aplicacion.Tareas.*;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AltaTareas {


    public static void ejecutaAltaTareas(Scanner sn, Proyecto proyecto) {
        sn.nextLine();

        List<Personas> personas = new LinkedList<>();
        List<String> etiquetas = new LinkedList<>();

        System.out.format("\nVas a introducir la tarea :");

        System.out.format("Introduce el título --> ");
        String titulo = sn.nextLine();

        try {

            ExisteTitulo.ejecutaExisteTitulo(titulo, proyecto.listarTareas());


            System.out.format("\nIntroduce la descripción --> ");
            String descrip = sn.nextLine();
            System.out.format("\nVas a introducir las personas que realizan esta tarea (si has terminado introduce la letra q): \n");

            int contador = 1;
            Personas p;
            while (true) {

                try {

                    System.out.format("\nEl dni de la persona nº(" + (contador++) + ") es --> ");
                    String dni = sn.next();
                    if (dni.equals("q"))
                        break;
                    p = proyecto.getPersona(dni);
                    NoAñadirPersona.ejecutaAñadirPersonaExcepcion(dni, personas);
                    personas.add(p);
                } catch (PersonaNoExistente | PersonaNoAñadida e) {
                    System.out.println(e.getMessage());
                }


            }


            Personas personaResponsable = null;
            while (true) {
                try {


                    System.out.format("\nIntroduce el DNI de la persona responsable --> ");
                    String personaR = sn.next();
                    Personas persona = proyecto.getPersona(personaR);


                    if (personaR.equals("q"))
                        break;
                    else if (persona != null) {
                        personaResponsable = proyecto.getPersona(personaR);
                        break;
                    }
                } catch (PersonaNoExistente e) {
                    System.out.println(e.getMessage());
                }


            }

            System.out.format("\nIntroduce la prioridad (entero) --> ");
            int prioridad = sn.nextInt();

            System.out.format("\nIntroduce el id del resultado --> ");
            String id = sn.next();

            System.out.format("\nIntroduce el nº de horas invertido en su producción --> ");
            double horas = sn.nextDouble();

            System.out.format("\nElija la opcion\n\n(interno) si es resultado interno\n(comercializado) si está destinado a ser comercializado\n--> ");
            String tipo = sn.next();

            System.out.format("\nIndica el resultado esperado \n1. Documentación\n2. Programa\n3. Biblioteca\n4. Pag. Web\n--> ");
            int opcion = sn.nextInt();
            Resultado resultado = null;


            if (opcion == 1)
                resultado = new Documentacion(id, horas, tipo);
            else if (opcion == 2)
                resultado = new Programa(id, horas, tipo);

            else if (opcion == 3)
                resultado = new Biblioteca(id, horas, tipo);
            else if (opcion == 4)
                resultado = new PagWeb(id, horas, tipo);
            else OpcionFueraDeRango.ejecutarOpcionFueraRango(opcion, 4);

            System.out.format("\nIndica la etiqueta que quieres añadir (q si has terminado) --> ");
            sn.nextLine();

            contador = 1;
            while (true) {
                System.out.format("\nEtiqueta nº(" + (contador++) + ") --> ");
                String etiqueta = sn.next();
                if (etiqueta.equals("q"))
                    break;
                etiquetas.add(etiqueta);

            }

            System.out.format("\nIntroduce el coste de la tarea --> ");
            double coste = sn.nextDouble();

            System.out.format("\nIntroduce nº según el tipo\n1. Urgente\n2. Consumo interno\n3. Descuento\n--> ");

            opcion = sn.nextInt();

            calcularFacturacion facturacion;

            while (true) {
                if (opcion == 1) {
                    facturacion = new Urgente();
                    break;
                } else if (opcion == 2) {
                    facturacion = new ConsumoInterno();
                    break;
                } else if (opcion == 3) {
                    facturacion = new Descuento();
                    break;
                } else
                    OpcionFueraDeRango.ejecutarOpcionFueraRango(opcion, 3);
            }


            Tareas tarea = Tareas.createTarea(titulo, descrip, personas, personaResponsable, prioridad, resultado, etiquetas, facturacion, coste, facturacion.calculoFactura(coste));


            proyecto.altaTarea(tarea);


            System.out.format("\nEl calculo de la facturación es de %1.2f euros", tarea.getFacturacion());

        } catch (TareaExistente e) {
            System.out.format("\nLa tarea %s ya existía y no se ha añadido", titulo);

        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.format("\nOpción incorrecta");
        }

        System.out.format("\n");


    }
}

