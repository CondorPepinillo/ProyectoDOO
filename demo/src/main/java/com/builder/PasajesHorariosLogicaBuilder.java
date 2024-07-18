package com.builder;

import com.grafico.Comunas;
import com.logica.PasajesHorariosLogica;

import javax.swing.*;
import java.util.Date;

public class PasajesHorariosLogicaBuilder implements Builder{
    public JTable ListaBuses;
    public Comunas origen;
    public Comunas destino;
    public Date fecha;

    @Override
    public Builder origen(Comunas origen) {
        this.origen = origen;
        return this;
    }

    @Override
    public Builder destino(Comunas destino) {
        this.destino = destino;
        return this;
    }

    @Override
    public Builder fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    @Override
    public Builder horaSalida(String horaSalida) {
        return null;
    }

    @Override
    public Builder precio(String precio) {
        return null;
    }

    @Override
    public Builder numeroAsiento(String numeroAsiento) {
        return null;
    }

    @Override
    public Builder tipoAsiento(String tipoAsiento) {
        return null;
    }

    @Override
    public Builder listaBuses(JTable ListaBuses) {
        this.ListaBuses = ListaBuses;
        return this;
    }

    @Override
    public Builder floor(int floor) {
        return null;
    }

    @Override
    public Builder rows(int rows) {
        return null;
    }

    @Override
    public Builder table(JTable table) {
        return null;
    }

    @Override
    public PasajesHorariosLogica build(){
        return new PasajesHorariosLogica(this);
    }
}
