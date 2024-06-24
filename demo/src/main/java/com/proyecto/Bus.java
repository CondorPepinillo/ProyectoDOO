package com.proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Bus {

    private int Asientos = 40;
    ArrayList<Integer> listaAsientos = new ArrayList<>();

    public Bus(){
        JFrame frame = new JFrame("Panel Principal");
        frame.setSize(600, 800);
        JPanel panel1 = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRigth = new JPanel();
        GridLayout layoutButtons = new GridLayout(10, 2);
        BorderLayout borderLayout = new BorderLayout();
        panel1.setLayout(borderLayout);
        panel1.add("West",panelLeft);
        panel1.add("East",panelRigth);
        panelLeft.setLayout(layoutButtons);
        panelRigth.setLayout(layoutButtons);

        for(int i = 0; i < Asientos; i++){
          listaAsientos.add(0);
            System.out.println(listaAsientos.get(i));
        }

        for(int i = 0; i < Asientos; i++){
            if(i < Asientos/2){
                panelLeft.add(new Button("" + (i + 1)));
            }
            else{
                panelRigth.add(new Button("" + (i+1)));
            }
        }
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
