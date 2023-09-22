package Aplicacion.Resultado;

import Aplicacion.Resultado.Resultado;

import java.io.Serializable;

public class Programa extends Resultado implements Serializable {
    private static final long serialVersionUID=42L;

    String lenguaje;
    int lineas;
    int modulos;

    public Programa(String id, double horas, String tipo, String lenguaje, int lineas, int modulos){
        super(id, horas, tipo);
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Programa(String lenguaje, int lineas, int modulos){
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Programa(String id, double horas, String tipo){
        super(id,horas,tipo);

    }
    public Programa(){

    }

}
