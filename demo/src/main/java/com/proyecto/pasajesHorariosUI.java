package com.proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    public pasajesHorariosUI(Comunas origin, Comunas destination, Date fecha){
        this.origen = origin;
        this.destino = destination;
        this.fecha = fecha;

        JFrame frame = new JFrame("Panel Seleccion Bus");
        col = new String[]{"Empresa", "Salida", "Llegada", "Duracion", "Asientos", "Precio"};
        data = getData();

        DefaultTableModel model = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ListaBuses = new JTable(model);

        scrollPane = new JScrollPane(ListaBuses);
        frame.setLocationRelativeTo(null);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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

    Comunas getOrigen(){
        return origen;
    }
    Comunas getDestino(){
        return destino;
    }
}
