package Aplicacion.Listas;


import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UtilidadesParaListas implements Serializable {


    public static <T extends tieneLista<E>,E> List<T> elementosConListaVacia(List<T> objetos){

        List<T> objetosListasVacias = new LinkedList<>();

        for (T objeto : objetos){

            if(objeto.getLista().isEmpty() ){
                objetosListasVacias.add(objeto);
            }
        }

        return objetosListasVacias;
    }


    public static <T extends tieneClave<E> , E> boolean insertarEnLista(E  clave, List<T> objetos){

        for (T objeto : objetos){

            if (objeto.getClave().equals(clave))
                return false;
        }
        return true;

    }

}
