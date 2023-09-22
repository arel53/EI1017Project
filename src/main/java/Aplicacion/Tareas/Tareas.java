package Aplicacion.Tareas;

import Aplicacion.Fecha.Fecha;
import Aplicacion.Listas.tieneLista;
import Aplicacion.Persona.Personas;
import Aplicacion.Resultado.Resultado;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import Aplicacion.Listas.tieneClave;

public class Tareas implements tieneLista<Personas>,tieneClave<String>,Serializable {
    private static final long serialVersionUID=42L;
    Informacion informacion;
    Fecha creacion;
    Fecha finalizacion;
    Participantes participantes;
    calcularFacturacion calculofacturacion;
    double coste;
    double facturacion;

    public Tareas(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas){

        this.informacion = new Informacion(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
        creacion = Fecha.fechaActual();
        finalizacion = new Fecha();

    }

    public Tareas(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas, calcularFacturacion calculofacturacion, double coste, double facturacion){

        this.informacion = new Informacion(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
        creacion = Fecha.fechaActual();
        finalizacion = new Fecha();
        this.calculofacturacion = calculofacturacion;
        this.coste = coste;
        this.facturacion = facturacion;

    }

    public Tareas(){
        informacion = new Informacion();
        participantes = new Participantes();
        creacion = new Fecha();
        finalizacion = new Fecha();
    }


    public boolean introducirPersonaTarea(Personas persona){
        return participantes.personas.add(persona);
    }


    public boolean eliminarPersonaTarea(Personas personas){
        return participantes.personas.remove(personas);
    }

    public boolean eliminarResponsable(){
        Personas personas= new Personas();
        this.participantes.responsable=personas;
        return true;
    }


    public String  finalizarTarea(){
        informacion.finalizado = true;
        this.finalizacion = Fecha.fechaActual();
        return "La tarea " + informacion.titulo + " se ha marcado como finalizada";
    }

    public String toString(){
        return "Título: " + getClave() +"\nDescripción: "+getDescripcion()+ "\nPersonas: "+ getLista() + "\nResponsable: "+getResponsable() +"\n¿Finalizada?: " + getFinalizado() + "\n Id del resultado: " + getResultado().getIdResultado() +"\nPrioridad: "+getPrioridad()+ "\nFecha creación: "+ getCreacion() +
                "\nFecha finalización: " + getFechaFinalizacion()+ "\nTipo facturación: " + getTipoFacturacion().toString() + "\nCoste: "+ getCoste() + "€\nFacturación: "+ getFacturacion() +"€"+"\nEtiquetas: "+ getEtiquetas().toString()+"\n\n";
    }

    public static Tareas createTarea(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas, calcularFacturacion calculofacturacion, double coste,double facturacion){
        return new Tareas(titulo.toLowerCase(),descripcion,personas,responsable,prioridad,resultado,etiquetas,calculofacturacion,coste,facturacion);
    }


    public String getDescripcion() {
        return informacion.descripcion;
    }

    public Resultado getResultado() {
        return informacion.resultado;
    }


    public List<String> getEtiquetas() {
        return informacion.etiquetas;
    }

    public int getPrioridad() {
        return informacion.prioridad;
    }



    public Personas getResponsable() {
        return participantes.responsable;
    }

    public Fecha getCreacion() {
        return creacion;
    }

    public Fecha getFechaFinalizacion() {
        return finalizacion;
    }

    public boolean getFinalizado(){
        return informacion.finalizado;
    }

    @Override
    public List<Personas> getLista() {
        return  participantes.personas;
    }

    @Override
    public String getClave() {
        return informacion.titulo;
    }


    public double getCoste(){
        return coste;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setCoste(double coste){
        this.coste = coste;
    }

    public calcularFacturacion getTipoFacturacion(){
        return calculofacturacion;
    }

    public void setFacturacion(double facturacion){
        this.facturacion = facturacion;
    }

    public calcularFacturacion getCalcularFacturacion(){
        return calculofacturacion;
    }

    public List<String> getInfoTareas(){
        List<String> tareas = new LinkedList<>();
        tareas.add(getClave());
        tareas.add(getDescripcion());
        tareas.add(tratarListaPersonas(getLista()));
        tareas.add(getResponsable().getNombre());
        if (getFinalizado())
            tareas.add("Finalizado");
        else
            tareas.add("No finalizado");
        tareas.add(getResultado().getIdResultado());
        tareas.add(Integer.toString(getPrioridad()));
        tareas.add(getCreacion().toString());
        tareas.add(getFechaFinalizacion().toString());
        tareas.add(getTipoFacturacion().toString());
        tareas.add(Double.toString(getCoste()));
        tareas.add(Double.toString(getFacturacion()));
        tareas.add(getEtiquetas().toString());

        //titulo,descrip,personas,responable,finalizada,idresul,prioridad,creac,finaliz,tipofac,coste,fac,etiquetas

     return tareas;
    }

    private String tratarListaPersonas(List<Personas> personas){
        StringBuilder tratado = new StringBuilder();
        for (Personas personas1: personas){
            tratado.append(personas1.getClave()).append(" ");
        }
        return tratado.toString();
    }
}
