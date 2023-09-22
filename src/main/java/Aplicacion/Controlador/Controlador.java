package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Vista.ImplementacionVista;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Controlador {
    void setModelo(ImplementacionModelo modelo);
    void setVista(ImplementacionVista vista);
    void insertarPersona() throws PersonaNoAñadida;
    void insertarPersonaTarea() throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente;
    void eliminarPersonaTarea() throws  TareaNoExistente, PersonaNoExistente;
    void finalizarTarea() throws TareaNoExistente;
    void cambiarCosteTarea() throws TareaNoExistente;
    void altaTarea() throws TareaExistente, PersonaNoAñadida, PersonaNoExistente, TareaNoExistente;
    void listarPersonasNoResponsables();
    void listarTareasSinPersonas();
    void abrirNuevoProyecto();
    void cerrarGuardarFichero() throws IOException;

    }
