package Aplicacion.Modelo;

import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.EjecutarExcepciones.ExisteTitulo;
import Aplicacion.EjecutarExcepciones.NoAñadirPersona;
import Aplicacion.EjecutarExcepciones.NoEliminarPersona;
import Aplicacion.Excepcion.*;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.*;
import Aplicacion.Tareas.*;
import Aplicacion.Vista.ImplementacionVista;
import Aplicacion.Vista.Vista;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ImplementacionModelo implements Modelo {

    Proyecto proyecto;
    Vista vista;


    @Override
    public void setVista(ImplementacionVista vista) {
        this.vista = vista;
    }
    @Override
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public Proyecto getProyecto() {
        return proyecto;
    }
    @Override
    public List<Personas> getListarPersonas() {
        return proyecto.listarPersonas();
    }
    @Override
    public void insertarPersona(Personas persona) throws PersonaNoAñadida {
        proyecto.altaPersona(persona);
        //vista.actualizar();
        vista.actualizarTabla();

    }
    @Override
    public StringBuilder textoPersonas(List<Personas> datosSinTratar) {

        StringBuilder datosTratados = new StringBuilder();
        List<String> datosPersonas;
        Iterator<Personas> iterator = datosSinTratar.iterator();

        if (datosSinTratar.isEmpty())
            datosTratados.append("No hay personas registradas\n");
        else {
            datosTratados.append("Dni\tNombre\tCorreo electrónico\n");
            while (iterator.hasNext()) {
                Personas persona = iterator.next();
                datosPersonas = persona.getInfoPersonas();
                datosTratados.append(datosPersonas.get(0)).append("\t").append(datosPersonas.get(1)).append("\t").append(datosPersonas.get(2)).append("\n");
            }
        }
        return datosTratados;
    }
    @Override
    public StringBuilder textoTareas(List<Tareas> datosSinTratar) {
        StringBuilder datosTratados = new StringBuilder();
        List<String> datosTareas;
        Iterator<Tareas> iterator = datosSinTratar.iterator();
        if (datosSinTratar.isEmpty())
            datosTratados.append("No hay tareas\n");
        else {
            datosTratados.append("Título\t\t\tDescripción\t\t\tPersonas\t\t\tResponsable\t\t\tFinalizada\t\t\tID Resultado\t\t\tPrioridad\t\t\tCreacion\t\t\tFinalizado\t\t\tTipoFac\t\t\tCoste\t\t\tFacturación\t\t\tEtiquetas\n");
            while (iterator.hasNext()) {
                Tareas tarea = iterator.next();
                datosTareas = tarea.getInfoTareas();
                int i = 0;
                for (String string : datosTareas) {
                    datosTratados.append(string).append("\t\t\t");
                    i++;
                    /*if (i == 9)
                        datosTratados.append("\t");
                    i++;
                     */
                }
                datosTratados.append("\n");
            }
        }
        return datosTratados;

        //titulo,descrip,personas,responable,finalizada,idresul,prioridad,creac,finaliz,tipofac,coste,fac,etiquetas
    }
    @Override
    public void guardarFichero(File fichero) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        oos.writeObject(proyecto);
        oos.close();
    }
    @Override
    public void abrirFichero(File fichero) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        proyecto = (Proyecto) ois.readObject();
        ois.close();
    }
    @Override
    public List<Personas> listarPersonasNoResponsables() {
        List<Personas> personasNoResponsables;
        personasNoResponsables = UtilidadesParaListas.elementosConListaVacia(proyecto.listarPersonas());
        return personasNoResponsables;
    }
    @Override
    public List<Tareas> listarTareasSinPersonas() {
        List<Tareas> tareasSinPersonas;
        tareasSinPersonas = UtilidadesParaListas.elementosConListaVacia(proyecto.listarTareas());
        return tareasSinPersonas;
    }
    @Override
    public List<Tareas> listarTareas() {
        return proyecto.listarTareas();
    }
    @Override
    public void insertarPersonaTarea(String id, String DNI) throws PersonaNoExistente, TareaNoExistente, PersonaNoAñadida {
        Personas persona = proyecto.getPersona(DNI);
        Tareas tarea = proyecto.getTarea(id);
        NoAñadirPersona.ejecutaAñadirPersonaExcepcion(DNI.toUpperCase(), tarea.getLista());
        tarea.introducirPersonaTarea(persona);
        //vista.actualizar();
        vista.actualizarTabla();

    }
    @Override
    public void eliminarPersonaTarea(String id, String DNI) throws PersonaNoExistente, TareaNoExistente{
        Personas persona = proyecto.getPersona(DNI);
        Tareas tarea = proyecto.getTarea(id);
        NoEliminarPersona.ejecutaNoEliminarPersona(DNI.toUpperCase(), tarea.getLista());
        tarea.eliminarPersonaTarea(persona);
        if(persona.equals(tarea.getResponsable()))
            tarea.eliminarResponsable();
        //vista.actualizar();
        vista.actualizarTabla();

    }
    @Override
    public void finalizarTarea(String id) throws TareaNoExistente {
        Tareas tarea = proyecto.getTarea(id);
        tarea.finalizarTarea();
        //vista.actualizar();
        vista.actualizarTabla();

    }
    @Override
    public void cambiarCosteTarea(String id, String coste) throws TareaNoExistente {
        Tareas tarea = proyecto.getTarea(id);

        tarea.setCoste(Double.parseDouble(coste));


        ExisteTitulo.ejecutaNoExisteTitulo(id, proyecto.listarTareas());

        calcularFacturacion calculoFacturacion = tarea.getCalcularFacturacion();

        tarea.setFacturacion(calculoFacturacion.calculoFactura(Double.parseDouble(coste)));

        //vista.actualizar();
        vista.actualizarTabla();

    }
    @Override
    public void altaTarea(String titulo, String descripcion, List<String> personas, String responsable, String prioridad, String idResultado, String nHoras, String tipoResultado, String resultadoEsperado, List<String> etiquetas, String coste, String tipoFac) throws PersonaNoExistente, PersonaNoAñadida, TareaExistente, TareaNoExistente {
        List<Personas> personasFinales = new LinkedList<>();

        Personas personaResponsable;
        Personas p;
        String s1 = "";

        for (String s : personas) {
            try {

                s1 = s;
                p = proyecto.getPersona(s);
                NoAñadirPersona.ejecutaAñadirPersonaExcepcion(s, personasFinales);
                personasFinales.add(p);
            } catch (PersonaNoExistente e) {
                vista.noExistePersona(s1);
            }
        }

        if(responsable.equals("")) {
            personaResponsable = new Personas();
        }
        else
            try {
                personaResponsable=proyecto.getPersona(responsable);
            }
            catch (PersonaNoExistente e) {
                throw new PersonaNoExistente("No existe la persona responsable que estas tratando de añadir");
            }

        Resultado resultado;

        if (resultadoEsperado.equals("DOCUMENTACION"))
            resultado = new Documentacion(idResultado, Integer.parseInt(nHoras), tipoResultado);
        else if (resultadoEsperado.equals("PROGRAMA"))
            resultado = new Programa(idResultado, Double.parseDouble(nHoras), tipoResultado);
        else if (resultadoEsperado.equals("PAGWEB"))
            resultado = new PagWeb(idResultado, Double.parseDouble(nHoras), tipoResultado);
        else
            resultado = new Biblioteca(idResultado, Double.parseDouble(nHoras), tipoResultado);




        calcularFacturacion facturacion;
        if (tipoFac.equals("URGENTE")) {
            facturacion = new Urgente();
        } else if (tipoFac.equals("DESCUENTO")) {
            facturacion = new Descuento();
        } else {
            facturacion = new ConsumoInterno();
        }


        Tareas tarea = Tareas.createTarea(titulo, descripcion, personasFinales, personaResponsable, Integer.parseInt(prioridad), resultado, etiquetas, facturacion, Double.parseDouble(coste), facturacion.calculoFactura(Double.parseDouble(coste)));

        proyecto.altaTarea(tarea);
        //vista.actualizar();
        vista.actualizarTabla();
    }
    @Override
    public Tabla crearTablaPersonas() {
        ModeloTablaPersonas modeloTablaPersonas = new ModeloTablaPersonas(proyecto.listarPersonas());
        return new Tabla(modeloTablaPersonas);
    }
    @Override
    public Tabla crearTablaTareas() {
        ModeloTablaTareas modeloTablaTareas = new ModeloTablaTareas(proyecto.listarTareas());
        return new Tabla(modeloTablaTareas);
    }


    @Override

    public ModeloTablaPersonas actualizarTabla() {
        return new ModeloTablaPersonas(proyecto.listarPersonas());
    }
    @Override
    public ModeloTablaTareas actualizarTablaTareas() {
        return new ModeloTablaTareas(proyecto.listarTareas());
    }
    @Override
    public ModeloTablaTareas actualizarTablaTareasSinPersonas() {
        return new ModeloTablaTareas(UtilidadesParaListas.elementosConListaVacia(proyecto.listarTareas()));
    }

    @Override
    public ModeloTablaPersonas actualizarTablaPersonasNoResponasbles() {
        return new ModeloTablaPersonas(UtilidadesParaListas.elementosConListaVacia(proyecto.listarPersonas()));
    }
    @Override
    public void abrirNuevoProyecto(){
        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplementacionControlador controlador = new ImplementacionControlador();
        vista.setControlador(controlador);
        vista.setModelo(modelo);
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.run();
            }
        });
    }


}
