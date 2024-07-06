package com.proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Bus {

    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private ArrayList<Integer> listaAsientos = new ArrayList<>();
    private ArrayList<JButton> botonesAsientos = new ArrayList<>(); // ArrayList para almacenar los botones
    private int asientoSeleccionado = -1;

    /**
     Se crear un panel principal que luego se divide en otros dos paneles izquiedo y derecho, esto para dividir adecuadamete la pantalla
    **/
    public Bus(Comunas origen, Comunas destino, Date fecha, String horaSalida, String precio, int floor) {
        int seats = floor == 1 ? 20 : 40;
        JFrame frame = new JFrame("Panel Principal");
        JPanel panel1 = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        GridLayout layoutButtons = new GridLayout(seats/4, 2);
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

        int startLabel = seats == 20 ? 1 : 21;

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
                    if(listaAsientos.get(finalI) != 0){
                        System.out.println("Asiento " + button.getText() + " ya  esta ocupado");
                    }
                    else{
                        System.out.println("Botón " + button.getText() + " clickeado.");
                        listaAsientos.set(finalI, 1);
                        button.setBackground(Color.RED);
                        //ABIR SIGUIENTE VENTANA
                        new VentanaPago(origen, destino, fecha, horaSalida, precio, button.getText());
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if (seats <= 20) {
            frame.setPreferredSize(new Dimension(250, 200));
        } else {
            frame.setPreferredSize(new Dimension(250, 400));
        }
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}

