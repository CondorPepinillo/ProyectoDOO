package com.logica;

import java.io.BufferedReader;
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
        br = new BufferedReader(new FileReader(getFilePath()));

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


    public String getFilePath() throws IllegalArgumentException{
        String filePath = null;
        if (origen.equals(ComunasEnum.CONCEPCION) && destino.equals(ComunasEnum.LOS_ANGELES)){
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionLosAngeles.csv";
        }
        else if(origen.equals(ComunasEnum.CONCEPCION) && destino.equals(ComunasEnum.NACIMIENTO)){
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionNacimiento.csv";
        }
        else if(origen.equals(ComunasEnum.LOS_ANGELES) && destino.equals(ComunasEnum.CONCEPCION)){
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesConcepcion.csv";
        }
        else if(origen.equals(ComunasEnum.LOS_ANGELES) && destino.equals(ComunasEnum.NACIMIENTO)){
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesNacimiento.csv";
        }
        else if(origen.equals(ComunasEnum.NACIMIENTO) && destino.equals(ComunasEnum.CONCEPCION)){
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\NacimientoConcepcion.csv";
        }
        else if(origen.equals(ComunasEnum.NACIMIENTO) && destino.equals(ComunasEnum.LOS_ANGELES)) {
            filePath = "..\\ProyectoDOO\\demo\\src\\buses\\NacimientoLosAngeles.csv";
        }

        if (filePath == null){
            throw new IllegalArgumentException("No se encuentran los datos de origen y destino seleccionados");
        }

        return filePath;
    }
}
