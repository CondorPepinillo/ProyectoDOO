package com.builder;

import com.grafico.PasajesHorariosUI;
import com.logica.ComunasEnum;
import com.logica.DataClass;
import com.logica.PasajesHorariosClass;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

public class PasajesHorariosBuilder implements Builder{
    public DataClass dataClass;
    public ComunasEnum origen;
    public ComunasEnum destino;
    public Date fecha;

    private PasajesHorariosClass pasajesHorariosClass;
    public PasajesHorariosUI pasajesHorariosUI;

    @Override
    public Builder origen(ComunasEnum origen) {
        this.origen = origen;
        return this;
    }

    @Override
    public Builder destino(ComunasEnum destino) {
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
        return null;
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
    public Builder busData(DataClass dataClass) {
        this.dataClass = dataClass;
        return this;
    }

    @Override
    public Builder pasajesHorariosUI(PasajesHorariosUI pasajesHorariosUI) {
        this.pasajesHorariosUI = pasajesHorariosUI;
        return this;
    }


    @Override
    public PasajesHorariosClass build() throws IOException {
        this.pasajesHorariosClass = new PasajesHorariosClass(this);
        return this.pasajesHorariosClass;
    }
}