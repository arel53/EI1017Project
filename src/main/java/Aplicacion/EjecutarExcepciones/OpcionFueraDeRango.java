package Aplicacion.EjecutarExcepciones;

public class OpcionFueraDeRango{

    public static void ejecutarOpcionFueraRango(int opcion, int rango)throws IndexOutOfBoundsException{
        if(opcion > rango || opcion < 1){
            throw new IndexOutOfBoundsException();
        }
    }
}
