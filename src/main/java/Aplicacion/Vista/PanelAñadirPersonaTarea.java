package Aplicacion.Vista;

import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;
import java.util.LinkedList;
import java.util.List;

public class PanelAñadirPersonaTarea {

    private JFrame ventana;
    private List<String> personas = new LinkedList<>();
    private JLabel textoDni = new JLabel("Introduce dni");
    private JTextField dni = new JTextField();
    private JButton añadir = new JButton("Añadir persona");
    private JButton vaciarPersonas = new JButton("Vaciar Personas");
    private JTextField personasQueVasAAñadir;


    public void abrirVentana(){
        ventana.setVisible(true);
    }




    public void añadirPersonaEstaTarea(){
        if (!personas.contains(dni.getText()))
            personas.add(dni.getText());
    }
    public void vaciarPersonas(){
        personas = new LinkedList<>();
    }
    public int sizePersonas(){
        return personas.size();
    }

    public void vaciar(){
        dni.setText("");
    }

    public void actualizarPersonasQueVasAAñadir(){
        personasQueVasAAñadir.setText("");
        personasQueVasAAñadir.setText(Integer.toString(sizePersonas()));
    }

    public List<String> getPersonas(){
        return personas;
    }

    public PanelAñadirPersonaTarea(JTextField personasQueVasAAñadir){
        this.personasQueVasAAñadir = personasQueVasAAñadir;
        ventana = new JFrame("Añadir persona");
        Container contenedor;
        ventana.setLayout(new GridLayout(2,2));
        contenedor = ventana.getContentPane();
        contenedor.add(textoDni);
        contenedor.add(dni);
        contenedor.add(añadir);
        contenedor.add(vaciarPersonas);
        actualizarPersonasQueVasAAñadir();
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirPersonaEstaTarea();
                actualizarPersonasQueVasAAñadir();
                vaciar();
            }
        });

        vaciarPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarPersonas();
                actualizarPersonasQueVasAAñadir();
                vaciar();
            }
        });


    }
}
