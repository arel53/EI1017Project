package Aplicacion.Resultado;

import Aplicacion.Resultado.Resultado;

import java.io.Serializable;


public class Documentacion extends Resultado implements Serializable {
    private static final long serialVersionUID=42L;
    String format;
    int pags;
    float espacio;

    public Documentacion(String id, double horas, String tipo, String format, int pags, float espacio){
        super(id,horas,tipo);
        this.format = format;
        this.pags = pags;
        this.espacio = espacio;
    }
    public Documentacion(String format, int pags, float espacio){
        this.format = format;
        this.pags = pags;
        this.espacio = espacio;
    }

    public Documentacion(String id, double horas, String tipo){

        super(id,horas,tipo);
    }
    public Documentacion(){

    }


}
