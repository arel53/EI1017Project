package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Listas.tieneClave;
import Aplicacion.Persona.Personas;

import java.util.List;

public class NoEliminarPersona {
    public static<T extends tieneClave<E>, E > void ejecutaNoEliminarPersona(E clave, List<T> lista) throws PersonaNoExistente {

        //No existe la persona si devuelve true
        if(UtilidadesParaListas.insertarEnLista(clave,lista)){
                throw new PersonaNoExistente("La persona no se ha eliminado ya que no existe");
        }
    }


}
