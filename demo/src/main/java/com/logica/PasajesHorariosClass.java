package com.logica;

import com.builder.BusBuilder;
import com.builder.PasajesHorariosBuilder;
import com.grafico.BusUI;
import com.grafico.ComunasEnum;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;


public class PasajesHorariosClass {
    private JTable ListaBuses;
    private ComunasEnum origen;
    private ComunasEnum destino;
    private Date fecha;
    private int rows;
    private ListaBusClass listaBusClass;

    public PasajesHorariosClass(PasajesHorariosBuilder builder) throws IOException {
        this.ListaBuses = builder.ListaBuses;
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        rows = ListaBuses.getRowCount();
        if(rows <= 0){
            throw new IllegalArgumentException("NO puede ser 0 o menor");
        }
        listaBusClass = new ListaBusClass(fecha);
        for(int i = 0; i < rows; i++){
            BusUI busUI = (BusUI) new BusBuilder()
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
            listaBusClass.addBus(busUI);
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
            throw new IllegalArgumentException("No se selecciono fila");
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
            throw new IllegalArgumentException("No se selecciono fila");
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
