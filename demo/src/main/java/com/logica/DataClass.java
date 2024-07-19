package com.logica;

import com.grafico.ComunasEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataClass {
    private ComunasEnum origen;
    private ComunasEnum destino;

    public DataClass(ComunasEnum origen, ComunasEnum destino){
        this.origen = origen;
        this.destino = destino;
    }

    public Object[][] getData() throws IOException {
        BufferedReader br = null;
        if (origen.equals(ComunasEnum.CONCEPCION) && destino.equals(ComunasEnum.LOS_ANGELES)){
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionLosAngeles.csv"));
        }
        else if(origen.equals(ComunasEnum.CONCEPCION) && destino.equals(ComunasEnum.NACIMIENTO)){
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionNacimiento.csv"));
        }
        else if(origen.equals(ComunasEnum.LOS_ANGELES) && destino.equals(ComunasEnum.CONCEPCION)){
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesConcepcion.csv"));
        }
        else if(origen.equals(ComunasEnum.LOS_ANGELES) && destino.equals(ComunasEnum.NACIMIENTO)){
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesNacimiento.csv"));
        }
        else if(origen.equals(ComunasEnum.NACIMIENTO) && destino.equals(ComunasEnum.CONCEPCION)){
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\NacimientoConcepcion.csv"));
        }
        else if(origen.equals(ComunasEnum.NACIMIENTO) && destino.equals(ComunasEnum.LOS_ANGELES)) {
            br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\NacimientoLosAngeles.csv"));
        }

        if (br == null){
            throw new FileNotFoundException("No se encuentran los datos de origen y destino seleccionados");
        }

        ArrayList<String> list = new ArrayList<>();
        String str = "";
        while ((str = br.readLine()) != null){
            list.add(str);
        }
        int n = list.get(0).split(",").length;
        Object[][] data = new Object[list.size()][n];
        for (int i = 0; i < list.size(); i++){
            data[i] = list.get(i).split(",");
        }
        br.close();
        return data;

    }
}
