package com.builder;

import com.grafico.ComunasEnum;
import com.grafico.VentanaPagoUI;

import javax.swing.*;
import java.util.Date;

public class VentanaPagoBuilder implements Builder{
    public ComunasEnum origen;
    public ComunasEnum destino;
    public Date fecha;
    public String horaSalida;
    public String precio;
    public String numeroAsiento;
    public String tipoAsiento;

    private VentanaPagoUI ventanaPagoUI;

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
    public VentanaPagoUI build() {
        this.ventanaPagoUI = new VentanaPagoUI(this);
        return this.ventanaPagoUI;
    }
}
