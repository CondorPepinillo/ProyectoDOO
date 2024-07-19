package com.builder;

import com.grafico.PasajesHorariosUI;
import com.logica.ComunasEnum;
import com.logica.DataClass;
import com.logica.PasajesHorariosClass;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public interface Builder {
    public Builder origen(ComunasEnum origen);

    public Builder destino(ComunasEnum destino);

    public Builder fecha(Date fecha);

    public Builder horaSalida(String horaSalida);

    public Builder precio(String precio);

    public Builder numeroAsiento(String numeroAsiento);

    public Builder tipoAsiento(String tipoAsiento);

    public Builder listaBuses(JTable ListaBuses);

    public Builder floor(int floor);

    public Builder rows(int rows);

    public Builder table(JTable table);

    public Builder busData(DataClass dataClass);

    public Builder pasajesHorariosUI(PasajesHorariosUI pasajesHorariosUI);

    public Object build() throws IOException, FileNotFoundException;
}

