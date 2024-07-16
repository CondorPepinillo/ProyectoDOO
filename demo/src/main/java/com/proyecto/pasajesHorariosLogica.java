package com.proyecto;

import javax.swing.*;
import java.util.Date;


public class PasajesHorariosLogica {
    private JTable ListaBuses;
    private Comunas origen;
    private Comunas destino;
    private Date fecha;

    private int rows;
    private ListaBusClass listaBusClass;

    public  PasajesHorariosLogica(Builder builder){
        this.ListaBuses = builder.ListaBuses;
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;

        rows = ListaBuses.getRowCount();
        listaBusClass = new ListaBusClass(fecha);
        for(int i = 0; i < rows; i++){
            Bus bus = new Bus.Builder()
            .origen(origen)
            .destino(destino)
            .fecha(fecha)
            .horaSalida(getHorarioSalidaSeleccionado(i))
            .precio(getPrecio(i))
            .floor(getPiso())
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
        listaBusClass.get(row).mostrarBus();
    }

    public static class Builder{
        private JTable ListaBuses;
        private Comunas origen;
        private Comunas destino;
        private Date fecha;


        public PasajesHorariosLogica.Builder ListaBuses(JTable ListaBuses){
            this.ListaBuses = ListaBuses;
            return this;
        }

        public PasajesHorariosLogica.Builder origen(Comunas origen){
            this.origen = origen;
            return this;
        }

        public PasajesHorariosLogica.Builder destino(Comunas destino){
            this.destino = destino;
            return this;
        }

        public PasajesHorariosLogica.Builder fecha(Date fecha){
            this.fecha = fecha;
            return this;
        }

        public PasajesHorariosLogica build(){
            return new PasajesHorariosLogica(this);
        }
    }
}
