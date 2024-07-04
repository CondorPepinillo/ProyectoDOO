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
    private int Asientos = 40;
    private ArrayList<Integer> listaAsientos = new ArrayList<>();
    private ArrayList<JButton> botonesAsientos = new ArrayList<>(); // ArrayList para almacenar los botones
    private int asientoSeleccionado = -1;

    /**
     Se crear un panel principal que luego se divide en otros dos paneles izquiedo y derecho, esto para dividir adecuadamete la pantalla
    **/
    public Bus(Comunas origen, Comunas destino, Date fecha, String horaSalida, String precio) {
        JFrame frame = new JFrame("Panel Principal");
        frame.setSize(1000, 800);
        JPanel panel1 = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        GridLayout layoutButtons = new GridLayout(10, 2);
        BorderLayout borderLayout = new BorderLayout();
        panel1.setLayout(borderLayout);
        panel1.add("West", panelLeft);
        panel1.add("East", panelRight);
        panelLeft.setLayout(layoutButtons);
        panelRight.setLayout(layoutButtons);

        for (int i = 0; i < Asientos; i++) {
            listaAsientos.add(0);
            System.out.println(listaAsientos.get(i));
        }

        listaAsientos.set(20, 1);

        for (int i = 0; i < Asientos; i++) {
            JButton button = new JButton("" + (i + 1)); // Crear el botón
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

                        //ABIR SIGUIENTE VENTANA
                        new VentanaPago(origen, destino, fecha, horaSalida, precio, button.getText());
                    }
                }
            });

            if (i < Asientos / 2) {
                panelLeft.add(button); // Añadir el botón al panel izquierdo
            } else {
                panelRight.add(button); // Añadir el botón al panel derecho
            }
        }

        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

