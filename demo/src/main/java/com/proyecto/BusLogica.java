package com.proyecto;

import javax.swing.*;

public class BusLogica {
    private JTable ListaBuses;
    private int rows;

    // Constructor modificado para aceptar JTable si no estaba previamente incluido
    public BusLogica(int rows, JTable ListaBuses) {
        this.ListaBuses = ListaBuses;
        this.rows = rows;
    }

    // Método restarAsiento movido de Bus a BusLogica
    public void restarAsiento() {
        // Obtener el valor actual de número de asientos
        Object valor = ListaBuses.getValueAt(rows, 4);
        // Convertir el valor a entero de manera segura
        int numeroAsientos = 0;
        if (valor != null) {
            try {
                // Intentar convertir el valor a entero
                numeroAsientos = Integer.parseInt(valor.toString());

                // Restar 1 al número de asientos
                numeroAsientos--;

                // Actualizar el valor en la tabla
                ListaBuses.setValueAt(numeroAsientos, rows, 4);
            } catch (NumberFormatException e) {
                // Manejar el caso donde el valor no se puede convertir a entero
                System.err.println("No se pudo convertir el valor a entero: " + e.getMessage());
            }
        } else {
            // Manejar el caso donde el valor es nulo
            System.err.println("El valor en la posición indicada es nulo.");
        }
    }

}