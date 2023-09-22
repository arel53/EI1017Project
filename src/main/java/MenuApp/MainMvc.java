package MenuApp;

import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Vista.ImplementacionVista;

import javax.swing.*;

public class MainMvc {
    public static void main(String[] args) {

        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionControlador controladora = new ImplementacionControlador();
        ImplementacionModelo modelo = new ImplementacionModelo();
        modelo.setVista(vista);
        controladora.setVista(vista);
        controladora.setModelo(modelo);
        vista.setControlador(controladora);
        vista.setModelo(modelo);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.run();
            }
        });
    }

}
