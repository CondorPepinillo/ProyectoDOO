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
                Calendar fechaAux = Calendar.getInstance();
                fechaAux.add(Calendar.DAY_OF_MONTH, -1);
                Date fechaAux2 = fechaAux.getTime();

                try {
                    if (dateChooser.getDate().compareTo(fechaAux2) < 0) {
                        throw new IllegalArgumentException("No puedes poner una fecha anterior");
                    }

                    if (dateChooser.getDate() == null) {
                        throw new NullPointerException();
                    }

                    if (origenComboBox1.getSelectedItem() == destinoComboBox1.getSelectedItem()){
                        throw new IllegalArgumentException("No puedes poner el mismo origen y destino");
                    }

                    if (origenComboBox1.getSelectedItem() != destinoComboBox1.getSelectedItem() &&
                            origenComboBox1 != null && destinoComboBox1 != null &&
                            dateChooser.getDate().compareTo(fechaAux2) >= 0) {

                        origen = (Comunas) origenComboBox1.getSelectedItem();
                        destino = (Comunas) destinoComboBox1.getSelectedItem();

                        pasajesHorariosUI ventanaSeleccion = new pasajesHorariosUI(origen, destino, dateChooser.getDate());
                        frame.dispose();
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                catch (NullPointerException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

    }

    public Comunas getOrigen() {
        return origen;
    }

    public Comunas getDestino() {
        return destino;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
