package Aplicacion.Tareas;

import java.io.Serializable;


public class Descuento implements calcularFacturacion,Serializable {
    private static final long serialVersionUID=42L;

    double DESCUENTO = 0.90;


    @Override
    public double calculoFactura(double coste) {

        return coste * DESCUENTO;
    }

    @Override
    public String toString(){
        return "Descuento          ";
    }

}
