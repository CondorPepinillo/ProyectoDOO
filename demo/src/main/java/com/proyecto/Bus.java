package com.proyecto;

import java.util.ArrayList;
import java.util.Date;

public class Bus {
    public Bus(){
        ArrayList<Integer> asientosValue = new ArrayList<Integer>(40);
        for(int i = 0; i < asientosValue.size(); i++){
            asientosValue.set(i,0);
        };
    }
}
