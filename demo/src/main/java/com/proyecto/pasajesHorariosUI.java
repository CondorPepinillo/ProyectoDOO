package com.proyecto;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class pasajesHorariosUI {
    private JPanel panel1;
    private JLabel vainas;
    private JPanel busesLabelsPanel;

    private Comunas origen;
    private Comunas destino;
    private Date fecha;

    public pasajesHorariosUI(Comunas origen, Comunas destino, Date fecha){
        JFrame frame = new JFrame("Panel Seleccion Bus");
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;

        Calendar salidaAux = Calendar.getInstance();
        salidaAux.setTime(fecha);

        Calendar llegadaAux = Calendar.getInstance();
        llegadaAux.setTime(fecha);


        for(int i = 0; i < 8; i++){
            salidaAux.set(Calendar.HOUR_OF_DAY, 8 + 2*i);
            salidaAux.set(Calendar.MINUTE, 0);
            salidaAux.set(Calendar.SECOND, 0);
            Date salida = salidaAux.getTime();

            llegadaAux.set(Calendar.HOUR_OF_DAY, 10 + 2*i);
            llegadaAux.set(Calendar.MINUTE, 0);
            llegadaAux.set(Calendar.SECOND, 0);
            Date llegada = llegadaAux.getTime();

            System.out.println(salida);
            System.out.println(llegada);
            Bus bus = new Bus(salida, llegada);
        }
    }
}
