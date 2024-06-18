package com.proyecto;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

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

    public SelectionForm1() {
        /**
         * Se crea la ventana y sus elementos principales
         */
        JFrame frame = new JFrame("Panel Principal");
        frame.getContentPane().add(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
                if(origenComboBox1.getSelectedItem() != destinoComboBox1.getSelectedItem() && origenComboBox1 != null & destinoComboBox1 != null){
                    pasajesHorariosUI ventanaSeleccion = new pasajesHorariosUI((Comunas) origenComboBox1.getSelectedItem(), (Comunas) destinoComboBox1.getSelectedItem(), dateChooser.getDate());
                    frame.dispose();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
