package com.proyecto;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase SelectionForm1, clase que se encarga de iniciar la ventana principal y de la seleccion de elementos del viaje siendo estos la comuna de origen, comuna de destino y fecha del viaje
 */
public class SelectionForm1 extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<Comunas> origenComboBox1;
    private JComboBox<Comunas> destinoComboBox1;
    private JButton submit;
    private JPanel panel1;
    private JPanel labelTitulo;
    private JPanel panelConElementos;
    private JPanel panelOrigenYDestino;
    private JPanel panelFecha;


    JDateChooser dateChooser = new JDateChooser();

    private Comunas origen;
    private Comunas destino;

    public SelectionForm1() {
        /**
         * Se crea la ventana y sus elementos principales
         */
        JFrame frame = new JFrame("Panel Principal");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panelFecha.add(dateChooser);

        Comunas[] comunas = new Comunas[]{Comunas.CONCEPCION, Comunas.LOS_ANGELES, Comunas.NACIMIENTO};

        for (Comunas comuna : comunas) {
            origenComboBox1.addItem(comuna);
            destinoComboBox1.addItem(comuna);
        }

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new SelectionFormLogica(dateChooser, origenComboBox1, destinoComboBox1, frame);
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
