package com.logica;
import com.grafico.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class SelectionFormLogica {
    private Comunas origen;
    private Comunas destino;

    public SelectionFormLogica(JDateChooser dateChooser, JComboBox<Comunas> origenComboBox1, JComboBox<Comunas> destinoComboBox1, JFrame frame) {
        Calendar fechaAux = Calendar.getInstance();
        fechaAux.add(Calendar.DAY_OF_MONTH, -1);
        Date fechaAux2 = fechaAux.getTime();

        try {
            if (dateChooser.getDate().compareTo(fechaAux2) < 0) {
                throw new IllegalArgumentException("No puedes poner una fecha anterior");
            }

            if (dateChooser.getDate() == null) {
                throw new NullPointerException();
            }

            if (origenComboBox1.getSelectedItem() == destinoComboBox1.getSelectedItem()) {
                throw new IllegalArgumentException("No puedes poner el mismo origen y destino");
            }

            if (origenComboBox1.getSelectedItem() != destinoComboBox1.getSelectedItem() &&
                    origenComboBox1 != null && destinoComboBox1 != null &&
                    dateChooser.getDate().compareTo(fechaAux2) >= 0) {

                origen = (Comunas) origenComboBox1.getSelectedItem();
                destino = (Comunas) destinoComboBox1.getSelectedItem();

                pasajesHorariosUI ventanaSeleccion = new pasajesHorariosUI(origen, destino, dateChooser.getDate());
                frame.dispose();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object getOrigen() {
        return origen;
    }

    public Object getDestino() {
        return destino;
    }
}
