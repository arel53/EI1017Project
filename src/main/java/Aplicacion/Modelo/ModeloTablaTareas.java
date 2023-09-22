package Aplicacion.Modelo;

import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ModeloTablaTareas extends AbstractTableModel {

    final List<String> cabeceras = Arrays.asList("Título","Descripción","Personas","Responsable","Finalizada","Id. Resultado","Prioridad","Creación","Finalizado","Tipo Fac.","Coste","Facturación","Etiquetas");
    List<Tareas> datos;

    public ModeloTablaTareas(final List<Tareas> datos){
        this.datos = datos;
    }

    public ModeloTablaTareas setDatos(final List<Tareas> datos){
        this.datos = datos;
        return this;
    }





    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) return datos.get(rowIndex).getClave();
        if (columnIndex == 1) return datos.get(rowIndex).getDescripcion();
        if (columnIndex == 2) {
            List<String> dni= new LinkedList<>();
            for(Personas personas:datos.get(rowIndex).getLista()){
                dni.add(personas.getClave());
            }
            return dni;
        };
        if (columnIndex == 3)
            if (datos.get(rowIndex).getResponsable().getClave() == null)
                return "No tiene";
            else
                return datos.get(rowIndex).getResponsable().getClave();

        if (columnIndex == 4) {
            if (!datos.get(rowIndex).getFinalizado()){
                return "No finalizada";
            }
            else return "Finalizada";
        }
        if (columnIndex == 5) return datos.get(rowIndex).getResultado().getIdResultado();
        if (columnIndex == 6) return datos.get(rowIndex).getPrioridad();
        if (columnIndex == 7) return datos.get(rowIndex).getCreacion();
        if (columnIndex == 8) return datos.get(rowIndex).getFechaFinalizacion();
        if (columnIndex == 9) return datos.get(rowIndex).getTipoFacturacion();
        if (columnIndex == 10) return datos.get(rowIndex).getCoste();
        if (columnIndex == 11) return datos.get(rowIndex).getFacturacion();
        if (columnIndex == 12) return datos.get(rowIndex).getEtiquetas();
        else return "";
    }

    public String getColumnName(int column){
        return cabeceras.get(column);
    }
}
