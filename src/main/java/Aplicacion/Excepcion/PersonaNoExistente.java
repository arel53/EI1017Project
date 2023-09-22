package Aplicacion.Excepcion;

public class PersonaNoExistente extends Exception{
    public PersonaNoExistente(String s){
        super(s);
    }
    public PersonaNoExistente(){
        super("No existe la persona");
    }
}
