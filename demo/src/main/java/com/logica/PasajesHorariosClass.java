package com.logica;

import com.builder.BusBuilder;
import com.builder.PasajesHorariosBuilder;
import com.grafico.BusUI;
import com.grafico.PasajesHorariosUI;

import java.io.IOException;
import java.util.Date;


public class PasajesHorariosClass implements SelectionObserver{
    private Object[][] busData;
    private ComunasEnum origen;
    private ComunasEnum destino;
    private Date fecha;
    private ListaBusClass listaBusClass;
    private PasajesHorariosUI pasajesHorariosUI;

    public PasajesHorariosClass(PasajesHorariosBuilder builder) throws IOException {
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        this.busData = builder.dataClass.getData();
        this.pasajesHorariosUI = builder.pasajesHorariosUI;

        if(busData.length <= 0){
            throw new IllegalArgumentException("No hay datos disponibles para los buses seleccionados.");
        }

    }

    @Override
    public void update(int rowIndex) throws IOException {
        listaBusClass = new ListaBusClass(fecha);
        for(int i = 0; i < busData.length; i++){

            BusUI busUI = (BusUI) new BusBuilder()
                    .origen(origen)
                    .destino(destino)
                    .fecha(fecha)
                    .horaSalida((String) busData[i][1])
                    .precio((String) busData[i][5])
                    .tipoAsiento((String) busData[i][7])
                    .floor(Integer.parseInt((String) busData[i][6]))
                    .rows(i)
                    .pasajesHorariosUI(pasajesHorariosUI)
                    .build();
            listaBusClass.addBus(busUI);

        }
        listaBusClass.get(rowIndex).mostrarBus();
    }
}
