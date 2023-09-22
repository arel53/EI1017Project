package Aplicacion.Excepcion;

import java.io.Serializable;

public class PersonaNoAñadida extends Exception{
    public PersonaNoAñadida(){
        super("La persona no se añadió\n");
    }
    public PersonaNoAñadida(String s){super(s);}


}
