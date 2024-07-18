package com.logica;

import com.grafico.Comunas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Data{
    private Comunas origen;
    private Comunas destino;

    public Data(Comunas origen, Comunas destino){
        this.origen = origen;
        this.destino = destino;
    }

    public Object[][] getData(){
        try{
            BufferedReader br = null;
            if (origen.equals(Comunas.CONCEPCION) && destino.equals(Comunas.LOS_ANGELES)){
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionLosAngeles.csv"));
            }
            else if(origen.equals(Comunas.CONCEPCION) && destino.equals(Comunas.NACIMIENTO)){
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionNacimiento.csv"));
            }
            else if(origen.equals(Comunas.LOS_ANGELES) && destino.equals(Comunas.CONCEPCION)){
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesConcepcion.csv"));
            }
            else if(origen.equals(Comunas.LOS_ANGELES) && destino.equals(Comunas.NACIMIENTO)){
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesNacimiento.csv"));
            }
            else if(origen.equals(Comunas.NACIMIENTO) && destino.equals(Comunas.CONCEPCION)){
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\NacimientoConcepcion.csv"));
            }
            else if(origen.equals(Comunas.NACIMIENTO) && destino.equals(Comunas.LOS_ANGELES)) {
                br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\NacimientoLosAngeles.csv"));
            }

            if (br == null){
                return null;
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
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
