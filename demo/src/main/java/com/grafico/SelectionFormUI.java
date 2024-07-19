package com.grafico;

import com.logica.SelectionFormClass;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Clase SelectionForm1, clase que se encarga de iniciar la ventana principal y de la seleccion de elementos del viaje siendo estos la comuna de origen, comuna de destino y fecha del viaje
 */
public class SelectionFormUI extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<ComunasEnum> origenComboBox1;
    private JComboBox<ComunasEnum> destinoComboBox1;
    private JButton submit;
    private JPanel panel1;
    private JPanel labelTitulo;
    private JPanel panelConElementos;
    private JPanel panelOrigenYDestino;
    private JPanel panelFecha;


    JDateChooser dateChooser = new JDateChooser();

    public SelectionFormUI() {
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

        ComunasEnum[] comunas = new ComunasEnum[]{ComunasEnum.CONCEPCION, ComunasEnum.LOS_ANGELES, ComunasEnum.NACIMIENTO};

        for (ComunasEnum comuna : comunas) {
            origenComboBox1.addItem(comuna);
            destinoComboBox1.addItem(comuna);
        }

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new SelectionFormClass(dateChooser, origenComboBox1, destinoComboBox1, frame);
                } catch (IllegalArgumentException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public JButton getSubmit(){  //Se usa para el test
        return submit;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
