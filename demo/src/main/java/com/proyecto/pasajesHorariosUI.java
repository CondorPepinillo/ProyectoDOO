package com.proyecto;

import javax.swing.*;
import java.util.Date;

public class pasajesHorariosUI {
    private JPanel panel1;
    private JLabel Caracteristicas;
    private JButton buttonOpt1;
    private JLabel opt1;
    private JButton buttonOpt2;
    private JButton buttonOpt3;
    private JLabel opt2;
    private JLabel opt3;

    private Comunas origen;
    private Comunas destino;
    private Date fecha;

    public pasajesHorariosUI(Comunas origen, Comunas destino, Date fecha){
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }
}
