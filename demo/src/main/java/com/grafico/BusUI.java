package com.grafico;

import com.builder.BusBuilder;
import com.builder.VentanaPagoBuilder;
import com.logica.ComunasEnum;
import com.logica.PasajesHorariosClass;
import com.logica.SelectionObserver;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class BusUI {
    private ComunasEnum origen;
    private ComunasEnum destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private String tipoAsiento;
    private int floor;
    private int rows;
    private int seats;
    private PasajesHorariosUI pasajesHorariosUI;

    private ArrayList<Integer> listaAsientos = new ArrayList<>();
    private ArrayList<JButton> botonesAsientos = new ArrayList<>(); // ArrayList para almacenar los botones
    private JFrame frame;

    /**
     Se crear un panel principal que luego se divide en otros dos paneles izquiedo y derecho, esto para dividir adecuadamete la pantalla
    **/
    public BusUI(BusBuilder builder) {
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        this.horaSalida = builder.horaSalida;
        this.precio = builder.precio;
        this.tipoAsiento = builder.tipoAsiento;
        this.floor = builder.floor;
        this.rows = builder.rows;
        this.seats = builder.seats;
        this.pasajesHorariosUI = builder.pasajesHorariosUI;

        frame = new JFrame("Panel Principal");
        JPanel panel1 = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        GridLayout layoutButtons = new GridLayout(this.seats/4, 2);
        BorderLayout borderLayout = new BorderLayout();
        panel1.setLayout(borderLayout);
        JLabel floorLabel = new JLabel(floor == 1 ? "Piso 1" : "Piso 2", SwingConstants.CENTER);
        panel1.add(floorLabel, BorderLayout.NORTH);
        panel1.add("West", panelLeft);
        panel1.add("East", panelRight);
        panelLeft.setLayout(layoutButtons);
        panelRight.setLayout(layoutButtons);

        for (int i = 0; i < seats; i++) {
            listaAsientos.add(0);
        }

        int startLabel = floor == 1 ? 1 : 21;

        for (int i = 0; i < seats; i++) {
            int labelNumber = startLabel + i;
            JButton button = new JButton("" + labelNumber); // Crear el botón
            if (listaAsientos.get(i) != 0){
                button.setBackground(Color.RED);
            }
            botonesAsientos.add(button); // Agregar el botón al ArrayList

            int finalI = i;
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        if(listaAsientos.get(finalI) != 0){
                            System.out.println("Asiento " + button.getText() + " ya  está ocupado");
                            throw new IllegalArgumentException("Asiento " + button.getText() + " ya está ocupado");
                        } else{
                            System.out.println("Botón " + button.getText() + " clickeado.");
                            listaAsientos.set(finalI, 1);
                            button.setBackground(Color.RED);
                            //ABIR SIGUIENTE VENTANA
                            pasajesHorariosUI.actualizarAsientos(rows);
                            //new VentanaPago(origen, destino, fecha, horaSalida, tipoAsiento, precio, button.getText());
                            new VentanaPagoBuilder()
                                    .origen(origen)
                                    .destino(destino)
                                    .fecha(fecha)
                                    .horaSalida(horaSalida)
                                    .tipoAsiento(tipoAsiento)
                                    .precio(precio)
                                    .numeroAsiento(button.getText())
                                    .build();
                        }
                    } catch (IllegalArgumentException | IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            if (i < seats / 2) {
                panelLeft.add(button); // Añadir el botón al panel izquierdo
            } else {
                panelRight.add(button); // Añadir el botón al panel derecho
            }
        }

        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        if (seats <= 20) {
            frame.setPreferredSize(new Dimension(250, 200));
        } else {
            frame.setPreferredSize(new Dimension(250, 400));
        }
        frame.pack();
    }

    public void mostrarBus(){
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public int getRows() {
        return rows;
    }
}

