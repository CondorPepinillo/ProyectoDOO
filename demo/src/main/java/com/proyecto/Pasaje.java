package com.proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Pasaje {
    private Date fecha;
    private String horaSalida;
    private int asiento;
    private Comunas origen;
    private Comunas destino;

    public Pasaje(Comunas origen, Comunas destino, Date fecha, String horaSalida, String precio, String asiento) {
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.asiento = Integer.parseInt(asiento);
        this.origen = origen;
        this.destino = destino;

        System.out.println("      BUSES BIO-BIO        \n\n");
        System.out.println("Origen: "+ origen + "\n");
        System.out.println("Destino: "+ destino + "\n\n");
        System.out.println("Fecha Viaje: " + fecha + "\n");
        System.out.println("Hora Viaje: " + horaSalida + "\n");
        System.out.println("Asiento: " + asiento + "\n\n");
        System.out.println("Valor Pasaje: " + precio);


        File file = new File("../ProyectoDOO/Pasaje.txt");
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n      BUSES BIO-BIO        \n\n");
            bw.write("Origen: "+ origen + "\n");
            bw.write("Destino: "+ destino + "\n\n");
            bw.write("Fecha Viaje: " + fecha + "\n");
            bw.write("Hora Viaje: " + horaSalida + "\n");
            bw.write("Asiento: " + asiento + "\n\n");
            bw.write("Valor Pasaje: " + precio);

            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getAsiento() {
        return asiento;
    }

    public Comunas getOrigen() {
        return origen;
    }

    public Comunas getDestino() {
        return destino;
    }
}