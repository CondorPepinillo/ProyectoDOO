package com.builder;

import com.logica.ComunasEnum;

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

    public Object build() throws IOException, FileNotFoundException;
}

