package com.logica;

import com.builder.PasajesHorariosLogicaBuilder;
import com.grafico.Bus;
import com.grafico.Comunas;

import javax.swing.*;
import java.util.Date;


public class PasajesHorariosLogica {
    private JTable ListaBuses;
    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    private int rows;
    private ListaBusClass listaBusClass;

    public  PasajesHorariosLogica(PasajesHorariosLogicaBuilder builder){
        this.ListaBuses = builder.ListaBuses;
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        rows = ListaBuses.getRowCount();
        if(rows <= 0){
            System.err.println("NO puede ser 0 o menor");
        }
        listaBusClass = new ListaBusClass(fecha);
        for(int i = 0; i < rows; i++){
            Bus bus = new Bus.Builder()
            .origen(origen)
            .destino(destino)
            .fecha(fecha)
            .horaSalida(getHorarioSalidaSeleccionado(i))
            .precio(getPrecio(i))
                    .tipoAsiento(getTipoAsiento(i))
            .floor(getPiso(i))
            .rows(i)
                    .table(ListaBuses)
                    .build();
            listaBusClass.addBus(bus);
        }
    }
    /**
     *
     * @return Horirio, retorna el elemento horario de la fila clickiada castiado en String
     */
    public String getHorarioSalidaSeleccionado(int i) {
        int selectedRow = i;
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 1);
        } else {
            System.err.println("No se selecciono fila");
            return null;
        }
    }

    /**
     *
     * @return  Precio, retorna el elemento precio de la fila clickiada castiado en String
     */
    public String getPrecio(int i) {
        int selectedRow = i;
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 5);
        } else {
            System.err.println("No se selecciono fila");
            return null;
        }
    }
    /**
     *
     * @return  Piso, retorna el piso del bus en el que se viaja (piso 1 o piso 2) castiado en String
     */
    public int getPiso(int i) {
        int selectedRow = i;
        if (selectedRow != -1) {
            String pisoStr = (String) ListaBuses.getValueAt(selectedRow, 6);
            return Integer.parseInt(pisoStr);
        } else {
            return -1;
        }
    }

    public String getTipoAsiento(int i){
        int selectedRow = i;
        if (selectedRow != -1) {
            return (String) ListaBuses.getValueAt(selectedRow, 7);
        } else {
            return null;
        }
    }

    public void mostrarBus(int row){
        listaBusClass.get(row).mostrarBus();
    }

}
