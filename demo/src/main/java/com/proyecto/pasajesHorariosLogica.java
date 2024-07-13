package com.proyecto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;


public class PasajesHorariosLogica {
    private JTable ListaBuses;
    private int rows;
    private ArrayList<Bus> ListaBusClass;

    public  PasajesHorariosLogica(JTable ListaBuses, Comunas origen, Comunas destino, Date fecha){
        this.ListaBuses = ListaBuses;
        rows = ListaBuses.getRowCount();
        ListaBusClass = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            Bus bus = new Bus(origen, destino, fecha, getHorarioSalidaSeleccionado(), getPrecio(), getPiso());
            ListaBusClass.add(bus);
        }
    }
    /**
     *
     * @return Horirio, retorna el elemento horario de la fila clickiada castiado en String
     */
    public String getHorarioSalidaSeleccionado() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 1);
        } else {
            return null;
        }
    }

    /**
     *
     * @return  Precio, retorna el elemento precio de la fila clickiada castiado en String
     */
    public String getPrecio() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 5);
        } else {
            return null;
        }
    }
    /**
     *
     * @return  Piso, retorna el piso del bus en el que se viaja (piso 1 o piso 2) castiado en String
     */
    public int getPiso() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) {
            String pisoStr = (String) ListaBuses.getValueAt(selectedRow, 6);
            return Integer.parseInt(pisoStr);
        } else {
            return -1;
        }
    }

    public void mostrarBus(int row){
        ListaBusClass.get(row).mostrarBus();
    }
}
