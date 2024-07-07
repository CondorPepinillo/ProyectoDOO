package com.proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Clase pasajesHorariosUI
 * Esta clase se encarga de manejar la seleccion del viaje acorde de las preferencias del usurio o cliente, los viajes presentan diversos factores como la hora, el tipo de bus y el tipo de asiento
 */

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

    /**
     *
     * @param origin es la comuna desde la que se toma el viaje
     * @param destination la comuna de destino del viaje
     * @param fecha el dia del viaje
     */

    public pasajesHorariosUI(Comunas origin, Comunas destination, Date fecha){
        this.origen = origin;
        this.destino = destination;
        this.fecha = fecha;

        JFrame frame = new JFrame("Panel Seleccion Bus");
        col = new String[]{"Empresa", "Salida", "Llegada", "Duracion", "Asientos", "Precio", "Piso", "Tipo"};
        data = getData();

        DefaultTableModel model = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ListaBuses = new JTable(model);

        ListaBuses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Click en row: " + ListaBuses.getSelectedRow());
                Bus bus = new Bus(origin, destination, fecha, getHorarioSalidaSeleccionado(), getPrecio(), getPiso());
                frame.dispose();
            }
        });

        scrollPane = new JScrollPane(ListaBuses);
        frame.setLocationRelativeTo(null);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


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

    /**
     *
     * @return origen,  retorna la comuna de origen
     */
    Comunas getOrigen(){
        return origen;
    }

    /**
     *
     * @return destino,  retorna la comuna de destino
     */
    Comunas getDestino(){
        return destino;
    }

    /**
     *
     * @return Horirio, retorna el elemento horario de la fila clickiada castiado en String
     */
    public String getHorarioSalidaSeleccionado() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 1);
        } else {
            return null;
        }
    }

    /**
     *
     * @return  Precio, retorna el elemento precio de la fila clickiada castiado en String
     */
    public String getPrecio() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 5);
        } else {
            return null;
        }
    }
    /**
     *
     * @return  Piso, retorna el piso del bus en el que se viaja (piso 1 o piso 2) castiado en String
     */
    public int getPiso() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) {
            String pisoStr = (String) ListaBuses.getValueAt(selectedRow, 6);
            return Integer.parseInt(pisoStr);
        } else {
            return -1;
        }
    }
}
