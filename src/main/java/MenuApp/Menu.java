package MenuApp;

import Aplicacion.EjecutarMétodos.*;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Proyecto.Proyecto;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void ejecutarMenu() {




        Scanner sn = new Scanner(System.in);

        boolean salir = false;


        System.out.format("\nVas a iniciar un proyecto");
        System.out.format("\nIntroduce el nombre del proyecto: ");
        String fichero = sn.nextLine();
        fichero = fichero + ".bin";
        Proyecto proyecto = Proyecto.iniciarProyecto(fichero);
        try{

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            proyecto = (Proyecto) ois.readObject();
            ois.close();
        }catch (FileNotFoundException e2){
            System.out.format("\nSe va a crear un fichero ya que no existe\n");
        }
        catch (Exception e1){
            System.out.format(e1.getMessage()+"\n");
        }




        while (!salir) {


            System.out.println(OpcionesMenu.getMenu());
            System.out.format("\n\nElige una opción: ");
            try {

                int opcion = sn.nextInt() - 1;
                OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);


                switch (opcionMenu) {
                    case ALTA_PERSONAS:
                        System.out.format("\nLa opción elegida es la 1\n\n");
                        AltaPersonas.ejecutarAltaPersonas(sn, proyecto);
                        break;

                    case ALTA_TAREA:
                        System.out.format("\nLa opción elegida es la 2\n\n");
                        AltaTareas.ejecutaAltaTareas(sn, proyecto);
                        break;
                    case FINALIZAR_TAREA:
                        System.out.format("\nLa opción elegida es la 3\n\n");
                        FinalizarTarea.ejecutarFinalizarTarea(sn, proyecto);
                        break;
                    case INTRODUCIR_PERSONA_TAREA:
                        System.out.format("\nLa opción elegida es la 4\n\n");
                        IntroducirPersonaTarea.ejectaIntroducirPersonaTarea(sn, proyecto);
                        break;
                    case ELIMINAR_PERSONA_TAREA:
                        System.out.format("\nLa opción elegida es la 5\n\n");
                        EliminarPersonaTarea.ejecutaEliminarPersonaTarea(sn, proyecto);
                        break;
                    case LISTAR_PERSONAS_PROYECTO:
                        System.out.format("\nLa opción elegida es la 6\n\n");
                        ListarPersonasProyecto.ejecutaListarPersonasProyecto(proyecto);
                        break;
                    case LISTAR_TAREAS_PROYECTO:
                        System.out.format("\nLa opción elegida es la 7\n\n");
                        ListarTareasProyecto.ejecutaListarTareasProyecto(proyecto);
                        break;

                    case LISTAR_PERSONAS_NO_RESPONSABLES:
                        System.out.format("\nLa opción elegida es la 8\n\n");
                        ListadoPersonasNoResponsablesTareas.ejecutarListadoPersonasNoResponsablesTareas(sn, proyecto);
                        break;

                    case LISTAR_TAREAS_VACIAS:
                        System.out.format("\nLa opción elegida es la 9\n\n");
                        ListadoTareaSinPersonasAsignada.ejecutarListadoPersonasSinTareaAsignada(proyecto);
                        break;

                    case CAMBIAR_COSTE:
                        System.out.format("\nLa opción elegida es la 10\n\n");
                        SetCoste.ejecutaSetCoste(sn,proyecto);
                        break;


                    case SALIR:
                        salir = true;


                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
                            oos.writeObject(proyecto);
                            oos.close();

                        }catch (Exception e){
                            System.out.format(e.getMessage());
                        }
                        System.out.format("\nVas a salir del menú\n\n");

                        break;


                    default:
                        System.out.println("Las opciones son entre 1 y 11");
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.format("\nDebes introducir un número entre 1 y 11");
                sn.nextLine();
            }catch (TareaNoExistente e){
                System.out.format(e.getMessage());
            }


        }

    }


}
