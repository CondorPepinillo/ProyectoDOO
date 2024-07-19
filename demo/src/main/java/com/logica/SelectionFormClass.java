package com.logica;
import com.grafico.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class SelectionFormClass {
    private ComunasEnum origen;
    private ComunasEnum destino;

    public SelectionFormClass(JDateChooser dateChooser, JComboBox<ComunasEnum> origenComboBox1, JComboBox<ComunasEnum> destinoComboBox1, JFrame frame) throws IllegalArgumentException, NullPointerException {
        Calendar fechaAux = Calendar.getInstance();
        fechaAux.add(Calendar.DAY_OF_MONTH, -1);
        Date fechaAux2 = fechaAux.getTime();

        if (dateChooser.getDate() == null) {
            throw new NullPointerException("Selecciona una fecha");
        } else if (dateChooser.getDate().compareTo(fechaAux2) < 0) {
            throw new IllegalArgumentException("No puedes poner una fecha anterior");
        } else if (origenComboBox1.getSelectedItem() == destinoComboBox1.getSelectedItem()) {
            throw new IllegalArgumentException("No puedes poner el mismo origen y destino");
        } else if (origenComboBox1.getSelectedItem() != destinoComboBox1.getSelectedItem() && origenComboBox1 != null && destinoComboBox1 != null && dateChooser.getDate().compareTo(fechaAux2) >= 0) {
            origen = (ComunasEnum) origenComboBox1.getSelectedItem();
            destino = (ComunasEnum) destinoComboBox1.getSelectedItem();

            PasajesHorariosUI ventanaSeleccion = new PasajesHorariosUI(origen, destino, dateChooser.getDate());
            frame.dispose();
        }
    }

    public Object getOrigen() {
        return origen;
    }

    public Object getDestino() {
        return destino;
    }
}
