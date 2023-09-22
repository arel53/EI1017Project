package Aplicacion.Resultado;



import java.io.Serializable;

public class Biblioteca extends Programa  implements Serializable{

    private static final long serialVersionUID=42L;

    public Biblioteca(String id, double horas, String tipo, String lenguaje, int lineas, int modulos){
        this.id = id;
        this.horas = horas;
        this.tipo = tipo;
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Biblioteca(String lenguaje, int lineas, int modulos){
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Biblioteca(String id, double horas, String tipo){
        super(id,horas,tipo);
    }
    public Biblioteca(){

    }
}
