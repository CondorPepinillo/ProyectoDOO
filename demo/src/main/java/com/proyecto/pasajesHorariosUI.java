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

    Comunas getOrigen(){
        return origen;
    }
    Comunas getDestino(){
        return destino;
    }
    public String getHorarioSalidaSeleccionado() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 1);
        } else {
            return null;
        }
    }

    public String getPrecio() {
        int selectedRow = ListaBuses.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se ha seleccionado una fila
            return (String) ListaBuses.getValueAt(selectedRow, 5);
        } else {
            return null;
        }
    }

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
