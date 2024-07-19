package com.logica;

import javax.swing.*;

public class BusClass {
    private JTable ListaBuses;
    private int rows;

    // Constructor modificado para aceptar JTable si no estaba previamente incluido
    public BusClass(int rows, JTable ListaBuses) {
        this.ListaBuses = ListaBuses;
        this.rows = rows;
    }

    // Método restarAsiento movido de Bus a BusLogica
    public void restarAsiento() throws IllegalArgumentException {
        // Obtener el valor actual de número de asientos
        Object valor = ListaBuses.getValueAt(rows, 4);
        // Convertir el valor a entero de manera segura
        int numeroAsientos = 0;
        if (valor != null) {
                // Intentar convertir el valor a entero
                numeroAsientos = Integer.parseInt(valor.toString());

                // Restar 1 al número de asientos
                numeroAsientos--;

                // Actualizar el valor en la tabla
                ListaBuses.setValueAt(numeroAsientos, rows, 4);
        } else {
            throw new IllegalArgumentException("El valor de número de asientos no puede ser nulo");
        }
    }

}