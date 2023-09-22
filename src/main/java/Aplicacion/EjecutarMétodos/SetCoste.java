package Aplicacion.EjecutarMétodos;

import Aplicacion.EjecutarExcepciones.ExisteTitulo;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;
import Aplicacion.Tareas.calcularFacturacion;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SetCoste {

    public static void ejecutaSetCoste(Scanner sn, Proyecto proyecto){


        System.out.format("\nIntroduce el título de la tarea cuyo coste quieres cambiar --> ");
        sn.nextLine();


        String titulo = sn.nextLine();


        Tareas tareas;
        try {

            ExisteTitulo.ejecutaNoExisteTitulo(titulo,proyecto.listarTareas());
            tareas = proyecto.getTarea(titulo);

            System.out.format("Introduce el nuevo coste de la tarea --> ");

            double coste = sn.nextDouble();

            calcularFacturacion calculoFacturacion = tareas.getCalcularFacturacion();

            tareas.setCoste(coste);
            tareas.setFacturacion(calculoFacturacion.calculoFactura(coste));

            System.out.format("La nueva factura es de %1.2f €",tareas.getFacturacion());

        }
        catch (TareaNoExistente e){
            System.out.println("\nLa tarea no existe");
        }
        catch (InputMismatchException e1){
            System.out.println("\nEl dato a introducir debe ser un valor numérico");
        }






    }
}
