package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Modelo.Tabla;

import javax.swing.*;
import java.awt.*;

public class PanelListarTareasSinPersonas {

    JFrame ventana = new JFrame("Listar tareas sin personas");
    JTextArea areaDatosLista = new JTextArea(20,10);
    Controlador controladora;
    Modelo modelo;
    Tabla tabla;

    Image tarea = Toolkit.getDefaultToolkit().getImage("src/main/java/Aplicacion/Imagenes/tareas.png");


    public PanelListarTareasSinPersonas(Controlador controladora, Modelo modelo){

        this.controladora = controladora;
        this.modelo = modelo;
        ventana.setIconImage(tarea);

        /*JScrollPane panel = new JScrollPane(areaDatosLista);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        actualizar();

        ventana.getContentPane().add(panel);

        ventana.setBounds(100, 100, 1250, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        areaDatosLista.setEditable(false);*/

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        tabla=modelo.crearTablaTareas();
        actualizarTabla();
        contenedor.add(new JScrollPane(tabla));
        ventana.getContentPane().add(contenedor);
        actualizarTabla();
        ventana.setBounds(100, 100, 1250, 300);
        ventana.setLocationRelativeTo(null);
        //ventana.pack();
        ventana.setVisible(true);


    }

    public void actualizar(){
        StringBuilder datos = modelo.textoTareas(modelo.listarTareasSinPersonas());
        areaDatosLista.setText("");
        areaDatosLista.append(String.valueOf(datos));

    }
    public void actualizarTabla(){
        tabla.setModel(modelo.actualizarTablaTareasSinPersonas());
    }

}
