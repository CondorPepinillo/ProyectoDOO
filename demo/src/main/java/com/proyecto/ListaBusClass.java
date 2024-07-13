package com.proyecto;

import java.util.ArrayList;
import java.util.Date;

public class ListaBusClass {
    private ArrayList<Bus> ListaBusClass;
    public ListaBusClass(Date fecha){
        ListaBusClass = new ArrayList<>();
    }
    void addBus(Bus bus){
        ListaBusClass.add(bus);
    }

    Bus get(int row){
        return ListaBusClass.get(row);
    }
}

