package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Modelo.Tabla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPersonas extends JPanel{

    private Controlador controladora;
    private JFrame vista;
    private Modelo modelo;
    //private JTextArea zonaTextoPersonas = new JTextArea(20,80);
    private JTextField dniPersonas;
    private Container contenedor;
    JPanel panelOpciones;
    Tabla tabla;
    PanelAltaPersona panelAltaPersona;


    public PanelPersonas(Modelo modelo, JFrame vista, Controlador controladora){

        this.controladora = controladora;
        this.vista = vista;
        this.modelo = modelo;

        JButton insertarPersona = new JButton("Insertar persona");
        JButton listarPersonasnoResponsables = new JButton("Listar personas no responsables");



        /*JLabel dni = new JLabel("Dni de la persona: ");
        dniPersonas = new JTextField(10);*/




       // StringBuilder datos =modelo.textoPersonas(modelo.getListarPersonas());

        /*JScrollPane panel = new JScrollPane(zonaTextoPersonas);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rellenarArea(datos);*/



        insertarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAltaPersona = new PanelAltaPersona(controladora);
            }
        });

        listarPersonasnoResponsables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PanelListarPersonasNoResponsables(controladora,modelo);
            }
        });




        JPanel personas = new JPanel();




        contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        panelOpciones = new JPanel();

        panelOpciones.add(personas);
        panelOpciones.add(insertarPersona);
        panelOpciones.add(listarPersonasnoResponsables);

        contenedor.add(panelOpciones);
        //contenedor.add(panel);

        tabla = modelo.crearTablaPersonas();
        contenedor.add(new JScrollPane(tabla));
        add(contenedor);
        actualizarTabla();
        vista.pack();
       // zonaTextoPersonas.setForeground(Color.BLACK);
       // zonaTextoPersonas.setEditable(false);


    }

    /*private void rellenarArea(StringBuilder sb){
        zonaTextoPersonas.setText("");
        zonaTextoPersonas.append(String.valueOf(sb));
    }*/

   /* public void actualizar(){

        StringBuilder datos =modelo.textoPersonas(modelo.getListarPersonas());
        rellenarArea(datos);
    }*/

    public void addComponente(JButton boton){
        panelOpciones.add(boton,BorderLayout.NORTH);
    }

    public void actualizarTabla(){
        tabla.setModel(modelo.actualizarTabla());
    }

    public String getDni(){
        return panelAltaPersona.getDni();
    }
    public String getNombre(){
        return panelAltaPersona.getNombre();
    }
    public String getCorreo(){
        return panelAltaPersona.getCorreo();
    }
}
