package com.proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 *Clase Pasaje, se encarga de escribir tu pasaje tanto en consola como en un archivo txt
 */
public class Pasaje {
    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private int asiento;

    public Pasaje(Builder builder) {
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        this.horaSalida = builder.horaSalida;
        this.precio = builder.precio;
        this.asiento = Integer.parseInt(builder.asiento);

        System.out.println("      BUSES BIO-BIO        \n\n");
        System.out.println("Origen: "+ origen + "\n");
        System.out.println("Destino: "+ destino + "\n\n");
        System.out.println("Fecha Viaje: " + fecha.getDate() + "/" + (fecha.getMonth()+1)+ "/"+ (fecha.getYear()+1900) + "\n");
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
            bw.write("Fecha Viaje: " + fecha.getDate() + "/" +  (fecha.getMonth()+1)+ "/"+ (fecha.getYear()+1900) + "\n");
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


    public static class Builder{
        private Comunas origen;
        private Comunas destino;
        private Date fecha;
        private String horaSalida;
        private String precio;
        private String asiento;


        public Pasaje.Builder origen(Comunas origen){
            this.origen = origen;
            return this;
        }

        public Pasaje.Builder destino(Comunas destino) {
            this.destino = destino;
            return this;
        }

        public Pasaje.Builder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        public Pasaje.Builder horaSalida(String horaSalida) {
            this.horaSalida = horaSalida;
            return this;
        }

        public Pasaje.Builder precio(String precio) {
            this.precio = precio;
            return this;
        }

        public Pasaje.Builder asiento(String asiento) {
            this.asiento = asiento;
            return this;
        }

        public Pasaje build(){
            return new Pasaje(this);
        }

    }
}