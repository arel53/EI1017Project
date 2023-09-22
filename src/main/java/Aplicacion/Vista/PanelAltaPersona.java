package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Excepcion.PersonaNoAñadida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaPersona {
    private Controlador controladora;
    private JTextField dni = new JTextField(10);
    private JTextField nombre = new JTextField(20);
    private JTextField correo = new JTextField(20);
    private JButton insertar = new JButton("Insertar");
    private JButton listar= new JButton("Listar");
    private JFrame ventana= new JFrame("Insertar cliente");

    Image persona = Toolkit.getDefaultToolkit().getImage("src/main/java/Aplicacion/Imagenes/persona.jpg");


    public PanelAltaPersona(Controlador controladora){
        this.controladora = controladora;
        ventana.setLayout(new GridLayout(4,2));
        ventana.setIconImage(persona);
        Container contenedor=ventana.getContentPane();

        contenedor.add(new JLabel("DNI"));
        contenedor.add(dni);
        contenedor.add(new JLabel("Nombre"));
        contenedor.add(nombre);
        contenedor.add(new JLabel("Correo"));
        contenedor.add(correo);
        contenedor.add(insertar);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);







        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarPersona();
                vaciar();
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPersonasNoResponsables();
            }
        });

    }
    public void vaciar() {
        nombre.setText("");
        dni.setText("");
        correo.setText("");
    }

    private void insertarPersona(){

        try {
            controladora.insertarPersona();
        }
        catch (PersonaNoAñadida e){
            new VentanaEmergente(ventana,e.getMessage(),true);
        }
    }

    private void listarPersonasNoResponsables(){
            controladora.listarPersonasNoResponsables();

    }

    public String getDni(){
        return dni.getText();
    }

    String getNombre(){
        return nombre.getText();
    }

    String getCorreo(){
        return correo.getText();
    }


}
