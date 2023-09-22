package Aplicacion.Excepcion;

import java.io.Serializable;

public class TareaNoExistente extends Exception{
    public TareaNoExistente(){
        super("\nLa tarea no existe\n");
    }
    public TareaNoExistente(String s){super(s);}
}
