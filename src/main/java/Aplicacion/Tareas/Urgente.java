package Aplicacion.Tareas;

import java.io.Serializable;

public class Urgente implements calcularFacturacion,Serializable {
    private static final long serialVersionUID=42L;

    double SOBRE = 1.3;
    @Override
    public double calculoFactura(double coste){

        return coste * SOBRE;

    }
    @Override
    public String toString(){
        return "Urgente                 ";
    }
}
