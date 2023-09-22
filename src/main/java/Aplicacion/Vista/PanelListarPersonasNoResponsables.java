package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Modelo.Tabla;

import javax.swing.*;
import java.awt.*;

public class PanelListarPersonasNoResponsables {


    JFrame ventana=new JFrame("Listar personas no responsables");JTextArea areaDatos=new JTextArea();
    Controlador controladora;
    Modelo modelo;
    Tabla tabla;

    Image persona = Toolkit.getDefaultToolkit().getImage("src/main/java/Aplicacion/Imagenes/persona.jpg");



    public PanelListarPersonasNoResponsables(Controlador controladora, Modelo modelo){
        this.controladora = controladora;
        this.modelo=modelo;

        ventana.setIconImage(persona);
        /*JScrollPane panel= new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        actualizar();
        ventana.getContentPane().add(panel);

        ventana.setBounds(100, 100, 450, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        areaDatos.setEditable(false);*/

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        tabla=modelo.crearTablaPersonas();
        contenedor.add(new JScrollPane(tabla));
        ventana.getContentPane().add(contenedor);
        actualizarTabla();
        ventana.setBounds(100, 100, 1250, 300);
        ventana.setLocationRelativeTo(null);
        //ventana.pack();
        ventana.setVisible(true);

    }


    public void actualizar(){
        StringBuilder datos = modelo.textoPersonas(modelo.listarPersonasNoResponsables());
        areaDatos.setText("");
        areaDatos.append(String.valueOf(datos));

    }

    public void actualizarTabla(){
        tabla.setModel(modelo.actualizarTablaPersonasNoResponasbles());
    }
}
