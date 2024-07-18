package com.builder;

import com.grafico.Bus;
import com.grafico.Comunas;
import com.grafico.VentanaPago;
import com.logica.PasajesHorariosLogica;

import javax.swing.*;
import java.util.Date;

public interface Builder {
    public Builder origen(Comunas origen);

    public Builder destino(Comunas destino);

    public Builder fecha(Date fecha);

    public Builder horaSalida(String horaSalida);

    public Builder precio(String precio);

    public Builder numeroAsiento(String numeroAsiento);

    public Builder tipoAsiento(String tipoAsiento);

    public Builder listaBuses(JTable ListaBuses);

    public Builder floor(int floor);

    public Builder rows(int rows);

    public Builder table(JTable table);

    public Object build();
}

