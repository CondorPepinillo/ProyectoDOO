package com.grafico;

import com.builder.PasajesHorariosBuilder;
import com.logica.ComunasEnum;
import com.logica.DataClass;
import com.logica.PasajesHorariosClass;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;

/**
 * Clase pasajesHorariosUI
 * Esta clase se encarga de manejar la seleccion del viaje acorde de las preferencias del usurio o cliente, los viajes presentan diversos factores como la hora, el tipo de bus y el tipo de asiento
 */

public class PasajesHorariosUI {
    private JPanel panel1;
    private JPanel busesLabelsPanel;
    private JTable ListaBuses;
    private JScrollPane scrollPane;
    private ComunasEnum origen;
    private ComunasEnum destino;
    private Date fecha;
    String[] col;
    Object[][] data;

    /**
     *
     * @param origin es la comuna desde la que se toma el viaje
     * @param destination la comuna de destino del viaje
     * @param fecha el dia del viaje
     */

    public PasajesHorariosUI(ComunasEnum origin, ComunasEnum destination, Date fecha) {
        this.origen = origin;
        this.destino = destination;
        this.fecha = fecha;

        JFrame frame = new JFrame("Panel Seleccion Bus");
        col = new String[]{"Empresa", "Salida", "Llegada", "Duracion", "Asientos", "Precio", "Piso", "Tipo"};

        try {
            DataClass datos = new DataClass(origen, destino);
            data = datos.getData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Por favor reiniciar programa.", "Error", JOptionPane.ERROR_MESSAGE);
            data = new Object[][]{};
        }

        DefaultTableModel model = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ListaBuses = new JTable(model);
        //PasajesHorariosLogica pasajesHorariosLogica = new PasajesHorariosLogica(ListaBuses, origen, destination, fecha);
        try {
            PasajesHorariosClass pasajesHorariosClass = (PasajesHorariosClass) new PasajesHorariosBuilder()
                    .listaBuses(ListaBuses)
                    .origen(origen)
                    .destino(destino)
                    .fecha(fecha)
                    .build();

            ListaBuses.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("Click en row: " + ListaBuses.getSelectedRow());
                    pasajesHorariosClass.mostrarBus(ListaBuses.getSelectedRow());
                }
            });
        } catch (IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

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
