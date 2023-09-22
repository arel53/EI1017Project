package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Listas.tieneClave;
import Aplicacion.Tareas.Tareas;

import java.util.List;

public class ExisteTitulo {

    public static <T extends tieneClave<E>, E>void ejecutaExisteTitulo(E titulo, List<T> tareas) throws TareaExistente {

        if (!UtilidadesParaListas.insertarEnLista(titulo,tareas))
            throw new TareaExistente();
    }
    public static <T extends tieneClave<E>, E>void ejecutaNoExisteTitulo(E titulo, List<T> tareas) throws  TareaNoExistente {

        if (UtilidadesParaListas.insertarEnLista(titulo,tareas))
            throw new TareaNoExistente();
    }

}
