package com.proyecto;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class pasajesHorariosUI {
    private JPanel panel1;
    private JPanel busesLabelsPanel;
    private JTable ListaBuses;
    private JScrollPane scrollPane;

    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    String[] col;
    Object[][] data;

    public pasajesHorariosUI(Comunas origen, Comunas destino, Date fecha){

        JFrame frame = new JFrame("Panel Seleccion Bus");
        col = new String[]{"Empresa", "Salida", "Llegada", "Duracion", "Asientos", "Precio"};
        data = getData();
        ListaBuses = new JTable(data, col);
        scrollPane = new JScrollPane(ListaBuses);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;

        /**
         * @param SalidaAux nos va ayudar a poner una hora a "fecha" para que esta sea la hora de salida programada
         */
        Calendar salidaAux = Calendar.getInstance();
        salidaAux.setTime(fecha);
        /**
         * @param llegadaAux nos va ayudar a poner una hora a "fecha" para que esta sea la hora de llegada programada
         */
        Calendar llegadaAux = Calendar.getInstance();
        llegadaAux.setTime(fecha);

        /**
         * Se crean las distintas instancias
         */
        for(int i = 0; i < 8; i++){
            salidaAux.set(Calendar.HOUR_OF_DAY, 8 + 2*i);
            salidaAux.set(Calendar.MINUTE, 0);
            salidaAux.set(Calendar.SECOND, 0);
            Date salida = salidaAux.getTime();

            llegadaAux.set(Calendar.HOUR_OF_DAY, 10 + 2*i);
            llegadaAux.set(Calendar.MINUTE, 0);
            llegadaAux.set(Calendar.SECOND, 0);
            Date llegada = llegadaAux.getTime();

            System.out.println(salida);
            System.out.println(llegada);
            Bus bus = new Bus(salida, llegada);
        }
    }
    // Falta modificar para que lea un achivo distinto dependiendo del destino elegido, necesito ayuda con eso
    Object[][] getData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("..\\ProyectoDOO\\demo\\src\\buses\\ConcepcionLosAngeles.csv"));
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
