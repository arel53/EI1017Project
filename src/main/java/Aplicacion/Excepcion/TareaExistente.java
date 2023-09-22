package Aplicacion.Excepcion;

import java.io.Serializable;

public class TareaExistente extends Exception{
    public TareaExistente(){
        super("La tarea ya está introducida en el proyecto.");
    }
}
