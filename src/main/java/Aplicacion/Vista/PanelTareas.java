package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Modelo.Tabla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class PanelTareas extends JPanel{

    Modelo modelo;
    JFrame vista;
    Controlador controladora;
    JTextField textoDni;
    JTextField textoIdTarea;
    JTextField textoCoste;
    private JTextArea zonaTextoTareas = new JTextArea(25, 40);
    private Container contenedor;
    private JButton listar =new JButton("Listar");
    Tabla tabla;
    JPanel panelOpciones;
    PanelAltaTarea panelAltaTarea;





    public PanelTareas(Modelo modelo, JFrame vista, Controlador controladora){

        this.modelo = modelo;
        this.vista = vista;
        this.controladora = controladora;

        JLabel idTarea = new JLabel("Id tarea: ");
        textoIdTarea = new JTextField(5);
        JLabel dniPersona = new JLabel("DNI :");
        textoDni = new JTextField(10);
        JLabel coste = new JLabel("Coste: ");
        textoCoste = new JTextField(5);



        JButton altaTarea = new JButton("Alta tarea");
        JButton finalizarTarea = new JButton("Finalizar tarea");
        JButton introducirPersona = new JButton("Introducir persona");
        JButton eliminarPersona = new JButton("Eliminar persona");
        JButton listarTareasSinPersonas = new JButton("Listar tareas sin personas");
        JButton cambiarCosteTarea = new JButton("Cambiar coste");


        JPanel panel = new JPanel();
        panel.add(idTarea);
        panel.add(textoIdTarea);
        panel.add(dniPersona);
        panel.add(textoDni);
        panel.add(coste);
        panel.add(textoCoste);
        panel.add(altaTarea);
        panel.add(finalizarTarea);
        panel.add(introducirPersona);
        panel.add(eliminarPersona);
        panel.add(listarTareasSinPersonas);
        panel.add(cambiarCosteTarea);



        /*JScrollPane parteDatos = new JScrollPane(zonaTextoTareas);
        parteDatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        parteDatos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contenedor.add(parteDatos);*/

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        contenedor.add(panel);
        tabla=modelo.crearTablaTareas();
        contenedor.add(new JScrollPane(tabla));
        add(contenedor);
        actualizarTabla();
        vista.pack();




        altaTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelAltaTarea = new PanelAltaTarea(controladora);

            }
        });
        finalizarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarTarea();
                vaciar();
            }
        });

        introducirPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarPersonaTarea();
                vaciar();
            }
        });

        eliminarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            eliminarPersonaTarea();
            vaciar();
            }
        });
        listarTareasSinPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PanelListarTareasSinPersonas(controladora, modelo);
            }
        });

        cambiarCosteTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarCosteTarea();
                vaciar();

            }
        });
        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTareasSinPersonas();
            }
        });



    }

    /*public void rellenarArea(StringBuilder sb){
        zonaTextoTareas.setText("");
        zonaTextoTareas.append(String.valueOf(sb));

    }

    public void actualizar(){
        StringBuilder datos = modelo.textoTareas(modelo.listarTareas());
        rellenarArea(datos);
    }*/
    private void insertarPersonaTarea(){

        try {
            controladora.insertarPersonaTarea();
        }
        catch (PersonaNoAñadida | PersonaNoExistente | TareaNoExistente e){
            new VentanaEmergente(vista,e.getMessage(),true);
        }

    }

    public void listarTareasSinPersonas(){
        controladora.listarTareasSinPersonas();
    }

   private void eliminarPersonaTarea(){

        try {
            controladora.eliminarPersonaTarea();
        }
        catch (TareaNoExistente | PersonaNoExistente  e ){
            new VentanaEmergente(vista,e.getMessage(),true);
        }
    }

    private void finalizarTarea(){
        try {
            controladora.finalizarTarea();
        }
        catch (TareaNoExistente e ){
            new VentanaEmergente(vista,e.getMessage(),true);
        }
    }

    private void cambiarCosteTarea(){
        try {
            controladora.cambiarCosteTarea();
        }
        catch (TareaNoExistente e ){
            new VentanaEmergente(vista,e.getMessage(),true);
        }
        catch (NumberFormatException e1){
            new VentanaEmergente(vista,"El valor de coste debe de ser numérico",true);
        }
    }
    public void vaciar() {
        textoDni.setText("");
        textoIdTarea.setText("");
        textoCoste.setText("");
    }

    public void actualizarTabla(){
        tabla.setModel(modelo.actualizarTablaTareas());
    }



    String getTituloAltaTarea(){
        return panelAltaTarea.getTitulo();
    }

    String getDescripcionAltaTarea(){
        return panelAltaTarea.getDescripcion();
    }

    String getResponsableAltaTarea(){
        return panelAltaTarea.getResponsable();
    }

    String getPrioridadAltaTarea(){
        return panelAltaTarea.getPrioridad();
    }

    String getIdResultadoAltaTarea(){
        return panelAltaTarea.getIdResultado();
    }

    String getTipoResultadoAltaTarea(){
        return panelAltaTarea.getTipoResultado();
    }

    String getNhorasAltaTarea(){
        return panelAltaTarea.getNhoras();
    }

    String getResultadoEsperadoAltaTarea(){
        return panelAltaTarea.getResultadoEsperado();
    }

    String getTipoFacturaAltaTarea(){
        return panelAltaTarea.getTipoFactura();
    }

    String getCosteAltaTarea(){
        return panelAltaTarea.getCoste();
    }

    List<String> getPersonasAltaTarea(){
        return panelAltaTarea.getPersonas();
    }
    List<String> getEtiquetasAltaTarea(){
        return panelAltaTarea.getEtiquetas();
    }

    String getTitulo(){
        return textoIdTarea.getText();
    }
    String getPersona(){
        return textoDni.getText();
    }

    String getCoste(){
        return textoCoste.getText();
    }
}
