package com.builder;

import com.logica.ComunasEnum;
import com.logica.PasajeClass;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

public class PasajeBuilder implements Builder{
    public ComunasEnum origen;
    public ComunasEnum destino;
    public Date fecha;
    public String horaSalida;
    public String precio;
    public String numeroAsiento;
    public String tipoAsiento;

    private PasajeClass pasajeClass;

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
        this.horaSalida = horaSalida;
        return this;
    }

    @Override
    public Builder precio(String precio) {
        this.precio = precio;
        return this;
    }

    @Override
    public Builder numeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
        return this;
    }

    @Override
    public Builder tipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
        return this;
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
    public Object build() throws IOException {
        this.pasajeClass = new PasajeClass(this);
        return pasajeClass;
    }
}
