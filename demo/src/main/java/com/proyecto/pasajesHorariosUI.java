package com.proyecto;

import javax.swing.*;
import java.util.Date;

public class pasajesHorariosUI {
    private JPanel panel1;
    private JLabel vainas;

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

    }



}
