package Aplicacion.Fecha;

import java.io.Serializable;
import java.time.LocalDate;

public class Fecha implements Serializable {

    private static final long serialVersionUID=42L;
    int dia;
    int mes;
    int año;

    public Fecha(int dia,int mes,int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha(){}


    public String toString(){
        return dia + "/" + mes + "/" + año;
    }

    public static Fecha fechaActual(){
        return new Fecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    }



}
