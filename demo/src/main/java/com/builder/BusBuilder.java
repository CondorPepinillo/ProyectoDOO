package com.builder;

import com.grafico.Bus;
import com.grafico.Comunas;

import javax.swing.*;
import java.util.Date;

public class BusBuilder implements Builder{
    public Comunas origen;
    public Comunas destino;
    public Date fecha;
    public String horaSalida;
    public String precio;
    public String tipoAsiento;
    public int floor;
    public int rows;
    public JTable table;

    private Bus bus;

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
        return null;
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
        this.floor = floor;
        return this;
    }

    @Override
    public Builder rows(int rows) {
        this.rows = rows;
        return this;
    }

    @Override
    public Builder table(JTable table) {
        this.table = table;
        return this;
    }

    @Override
    public Object build() {
        this.bus = new Bus(this);
        return this.bus ;
    }
}
