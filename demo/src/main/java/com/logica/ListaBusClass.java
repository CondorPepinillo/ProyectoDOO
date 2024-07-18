package com.logica;
import com.grafico.BusUI;

import java.util.ArrayList;
import java.util.Date;

public class ListaBusClass {
    private ArrayList<BusUI> listaBusClassUIS;
    public ListaBusClass(Date fecha){
        listaBusClassUIS = new ArrayList<>();
    }
    void addBus(BusUI busUI){
        listaBusClassUIS.add(busUI);
    }

    BusUI get(int row){
        return listaBusClassUIS.get(row);
    }
}

