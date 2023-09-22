package Aplicacion.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class AñadirEtiquetas {

    private JFrame ventana;
    private List<String> etiquetas = new LinkedList<>();
    private JLabel textoEtiqueta = new JLabel("Introduce etiqueta: ");
    private JTextField etiqueta = new JTextField();
    private JButton añadir = new JButton("Añadir etiqueta");
    private JButton vaciarEtiquetas = new JButton("Vaciar Etiquetas");
    private JTextField etiquetasQueVasAAñadir;


    public void vaciarEtiquetas(){
        etiquetas = new LinkedList<>();
    }
    public void vaciar(){
        etiqueta.setText("");
    }

    public int sizeEtiquetas(){
        return etiquetas.size();
    }

    public void añadirEtiquetasEstaTarea(){
        if (!etiquetas.contains(etiqueta.getText()))
            etiquetas.add(etiqueta.getText());
    }

    public void actualizarEtiquetasQueVasAAñadir(){
        etiquetasQueVasAAñadir.setText("");
        etiquetasQueVasAAñadir.setText(Integer.toString(sizeEtiquetas()));
    }

    public List<String> getEtiquetas(){
        return etiquetas;
    }

    public void abrirVentana(){
        ventana.setVisible(true);
    }


    public AñadirEtiquetas(JTextField etiquetasQueVasAAñadir){
        this.etiquetasQueVasAAñadir = etiquetasQueVasAAñadir;

        ventana = new JFrame("Añadir Etiqueta");

        Container contenedor;
        ventana.setLayout(new GridLayout(2,2));
        contenedor = ventana.getContentPane();

        contenedor.add(textoEtiqueta);
        contenedor.add(etiqueta);
        contenedor.add(añadir);
        contenedor.add(vaciarEtiquetas);
        actualizarEtiquetasQueVasAAñadir();

        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirEtiquetasEstaTarea();
                actualizarEtiquetasQueVasAAñadir();
                vaciar();
            }

        });

        vaciarEtiquetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarEtiquetas();
                actualizarEtiquetasQueVasAAñadir();
                vaciar();
            }
        });



    }
}
