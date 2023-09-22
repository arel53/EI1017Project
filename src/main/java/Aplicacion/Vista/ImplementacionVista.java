package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Proyecto.Proyecto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ImplementacionVista extends WindowAdapter implements Vista {


    private Controlador controlador;
    private Modelo modelo;
    private JFrame ventana = new JFrame("Proyecto");
    private PanelPersonas vistaPersonas;
    private PanelTareas vistaTareas;
    File f;
    private JButton cambiarProyecto;

    Image carpeta = Toolkit.getDefaultToolkit().getImage("src/main/java/Aplicacion/Imagenes/carpeta.png");
    Image proyecto = Toolkit.getDefaultToolkit().getImage("src/main/java/Aplicacion/Imagenes/proyecto2.png");


    @Override
    public void run(){

        this.f = ventanaAbrirFichero();
        ventana.setIconImage(proyecto);

        JTabbedPane pestañas = new JTabbedPane();
        vistaPersonas = new PanelPersonas(modelo,ventana, controlador);
        vistaTareas = new PanelTareas(modelo,ventana, controlador);
        cambiarProyecto = new JButton("Cambiar de proyecto");


        pestañas.add("Personas",vistaPersonas);
        pestañas.add("Tareas",vistaTareas);

        ventana.add(pestañas);
        vistaPersonas.addComponente(cambiarProyecto);



        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarGuardarFichero();
                System.exit(0);
            }
        });

        cambiarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarGuardarFichero();
                ventana.dispose();
                abrirNuevoProyecto();
            }
        });


        ventana.pack();
        ventana.setLocationRelativeTo(null);

    }
    @Override
    public void setModelo(ImplementacionModelo modelo){
        this.modelo = modelo;
    }
    @Override
    public void setControlador(ImplementacionControlador controladora){
        this.controlador = controladora;
    }

    @Override
    public void actualizar(){

        vistaPersonas.actualizarTabla();
        vistaTareas.actualizarTabla();
    }
    @Override
    public void actualizarTabla(){
        vistaPersonas.actualizarTabla();
        vistaTareas.actualizarTabla();
    }
    @Override
    public File ventanaAbrirFichero(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichero binario","bin"));
        fileChooser.setDialogTitle("Elige un fichero (Para crear nuevo fichero introducir el nombre del proyecto + .bin)");
        ventana.setIconImage(carpeta);

        File f1 = new File("..\\ProgAvanzada-master");
        fileChooser.setCurrentDirectory(f1);
        int resultado = fileChooser.showDialog(ventana,"Elige un fichero");
        File f = null;
        switch (resultado){
            case JFileChooser.CANCEL_OPTION:
                System.exit(0);
                break;
            case JFileChooser.APPROVE_OPTION:
                f = fileChooser.getSelectedFile();
                try{
                    modelo.abrirFichero(f);
                }
                catch (FileNotFoundException e1){
                    new VentanaEmergente(ventana,"Se va a crear un nuevo fichero ya que el introducido no existe", true);
                    modelo.setProyecto(Proyecto.iniciarProyecto(f.toString()));
                }catch (Exception e2){
                    new VentanaEmergente(ventana,e2.getMessage(),true);
                }
                break;
            case JFileChooser.ERROR_OPTION:
                new VentanaEmergente(ventana,"Error",true);
                System.exit(0);
                break;
        }
        return f;
    }
    @Override
    public void cerrarGuardarFichero(){
        try {
            modelo.guardarFichero(f);
        }
        catch (IOException e){
            new VentanaEmergente(ventana,e.getMessage(),true);
        }
    }
    @Override
    public void abrirNuevoProyecto(){
        controlador.abrirNuevoProyecto();
    }
    @Override
    public void noExistePersona(String dni){
        new VentanaEmergente(ventana,"La persona '"+ dni + "' no existe y por lo tanto no se va a añadir a esta persona en la tarea", true);
    }

    @Override
    public String getDniPanelPersonas(){
        return vistaPersonas.getDni();
    }
    @Override
    public String getNombrePanelPersonas(){
        return vistaPersonas.getNombre();
    }
    @Override
    public String getCorreoPanelPersonas(){
        return vistaPersonas.getCorreo();
    }
    @Override
    public String getTituloAltaTarea(){
        return vistaTareas.getTituloAltaTarea();
    }
    @Override
    public String getDescripcionAltaTarea(){
        return vistaTareas.getDescripcionAltaTarea();
    }
    @Override
    public String getResponsableAltaTarea(){
        return vistaTareas.getResponsableAltaTarea();
    }
    @Override
    public String getPrioridadAltaTarea(){
        return vistaTareas.getPrioridadAltaTarea();
    }
    @Override
    public String getIdResultadoAltaTarea(){
        return vistaTareas.getIdResultadoAltaTarea();
    }
    @Override
    public String getTipoResultadoAltaTarea(){
        return vistaTareas.getTipoResultadoAltaTarea();
    }
    @Override
    public String getNhorasAltaTarea(){
        return vistaTareas.getNhorasAltaTarea();
    }
    @Override
    public String getResultadoEsperadoAltaTarea(){
        return vistaTareas.getResultadoEsperadoAltaTarea();
    }
    @Override
    public String getTipoFacturaAltaTarea(){
        return vistaTareas.getTipoFacturaAltaTarea();
    }
    @Override
    public String getCosteAltaTarea(){
        return vistaTareas.getCosteAltaTarea();
    }
    @Override
    public List<String> getEtiquetasAltaTarea(){
        return vistaTareas.getEtiquetasAltaTarea();
    }


    @Override
    public List<String> getPersonasAltaTarea(){
        return vistaTareas.getPersonasAltaTarea();
    }
    @Override
    public String getDniPanelTareas() {
        return vistaTareas.getPersona();
    }

    @Override
    public String getTituloPanelTareas() {
        return vistaTareas.getTitulo();
    }

    @Override
    public String getCostePanelTareas() {
        return vistaTareas.getCoste();
    }

    @Override
    public File getF(){
        return f;
    }




}
