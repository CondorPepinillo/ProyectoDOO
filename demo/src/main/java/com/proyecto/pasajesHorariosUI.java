package com.proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

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
        Data datos = new Data(origen, destino);
        col = new String[]{"Empresa", "Salida", "Llegada", "Duracion", "Asientos", "Precio", "Piso", "Tipo"};
        data = datos.getData();

        DefaultTableModel model = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ListaBuses = new JTable(model);
        //PasajesHorariosLogica pasajesHorariosLogica = new PasajesHorariosLogica(ListaBuses, origen, destination, fecha);
        PasajesHorariosLogica pasajesHorariosLogica = new PasajesHorariosLogica.Builder()
                .ListaBuses(ListaBuses)
                .origen(origen)
                .destino(destination)
                .fecha(fecha)
                .build();

        ListaBuses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Click en row: " + ListaBuses.getSelectedRow());
                pasajesHorariosLogica.mostrarBus(ListaBuses.getSelectedRow());
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
}
