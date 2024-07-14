package com.proyecto;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BusInfo {

    private static final String[] PATHS = {
            "..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionLosAngeles.csv",
            "..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionNacimiento.csv",
            "..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesConcepcion.csv",
            "..\\ProyectoDOO\\demo\\src\\buses\\LosAngelesNacimiento.csv",
            "..\\ProyectoDOO\\demo\\src\\buses\\NacimientoConcepcion.csv",
            "..\\ProyectoDOO\\demo\\src\\buses\\NacimientoLosAngeles.csv"
    };

    public static void initializeBusSeats() {
        for (String path : PATHS) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    int floor = Integer.parseInt(data[6]);
                    int seats;
                    int type;
                    if (data[7] == "Clasico") {
                        type = 1;
                    } else {
                        type = 2;
                    }
                    if (2 == type) {
                        seats = floor == 1 ? 40 : 20;
                    } else {
                        seats = 40;
                    }

                    //BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
                    //writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + seats + "," + data[5] + "," + data[6] + "," + data[7] + "\n");
                    
                    System.out.println("Bus from " + path + " on floor " + floor + " has " + seats + " seats.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void startApplication() {
        SelectionForm1 ventana = new SelectionForm1();
    }
}
