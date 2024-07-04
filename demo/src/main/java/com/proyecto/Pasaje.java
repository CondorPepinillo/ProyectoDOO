package com.proyecto;

import java.util.Date;

public class Pasaje {
    private Date fecha;
    private String horaSalida;
    private int asiento;
    private Comunas origen;
    private Comunas destino;

    public Pasaje(Date fecha, String horaSalida, int asiento, Comunas origen, Comunas destino) {
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.asiento = asiento;
        this.origen = origen;
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getAsiento() {
        return asiento;
    }

    public Comunas getOrigen() {
        return origen;
    }

    public Comunas getDestino() {
        return destino;
    }
}