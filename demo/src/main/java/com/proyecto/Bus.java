package com.proyecto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Bus {
    private JPanel panel1;

    public Bus(){
        JFrame frame = new JFrame("Panel Principal");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
