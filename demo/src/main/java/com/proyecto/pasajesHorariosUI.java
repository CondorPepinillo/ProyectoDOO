package com.proyecto;

import javax.swing.*;
import java.util.Date;

public class pasajesHorariosUI {
    private JPanel panel1;

    private Comunas origen;
    private Comunas destino;
    private Date fecha;

    public pasajesHorariosUI(Comunas origen, Comunas destino, Date fecha){
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }
}
