package MenuApp;

public enum OpcionesMenu {


    ALTA_PERSONAS("Dar de alta a las personas que trabajan en el proyecto."),
    ALTA_TAREA("Dar de alta tareas."),
    FINALIZAR_TAREA("Marcar tarea como finalizada."),
    INTRODUCIR_PERSONA_TAREA("Introducir una persona a una tarea."),
    ELIMINAR_PERSONA_TAREA("Eliminar una persona de una tarea."),
    LISTAR_PERSONAS_PROYECTO("Listar las personas asignadas a un proyecto."),
    LISTAR_TAREAS_PROYECTO("Listar las tareas de un proyecto."),
    LISTAR_PERSONAS_NO_RESPONSABLES("Listar las personas que no son responsables"),
    LISTAR_TAREAS_VACIAS("Listar las tareas sin personas asignadas"),
    CAMBIAR_COSTE("Cambiar el coste de una tarea"),
    SALIR("Cerrar menú.");

    String descrip;
    OpcionesMenu(String descrip) {
        this.descrip = descrip;
    }

    public static OpcionesMenu getOpcion(int pos){
        return values()[pos];
    }
    public String getDescripcion(){
        return this.descrip;
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();

        System.out.format("\nOpciones :\n\n");

        for (OpcionesMenu opcion : OpcionesMenu.values()){
            sb.append(opcion.ordinal() + 1);
            sb.append(".-");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
