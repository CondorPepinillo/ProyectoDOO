package com.proyecto;

import javax.swing.*;

public class SelectionForm1 extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox origenComboBox1;
    private JComboBox destinoComboBox1;
    private JButton submit;
    private JTextField fecha;
    private JPanel panel1;
    private JPanel labelTitulo;
    private JPanel panelConElementos;
    private JPanel panelOrigenYDestino;

    public SelectionForm1() {
        /**
         * Se crea la ventana y sus elementos principales
         */
        JFrame frame = new JFrame("Panel Principal");
        frame.getContentPane().add(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
