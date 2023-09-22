package Aplicacion.Tareas;

import Aplicacion.Persona.Personas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Participantes implements Serializable {
    private static final long serialVersionUID=42L;

    List<Personas> personas;
    Personas responsable;

    public Participantes(List<Personas> personas, Personas responsable){

        this.personas = new LinkedList<>(personas);
        this.responsable = responsable;
    }

    public Participantes() {
    }
}
