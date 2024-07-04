package com.proyecto;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class VentanaPago extends JFrame {
    private JPanel panelPrincipal;
    private JButton descargarPasajeButton;

    public VentanaPago(Comunas origen, Comunas destino, Date fecha, String horaSalida, String precio, String numeroAsiento) {
        // Configura la ventana
        setTitle("Ventana de Pago");
        setSize(500, 400); // Ajusta el tamaño según sea necesario
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Inicializa los componentes del formulario
        $$$setupUI$$$();

        // Configura los valores recibidos como parámetros
        // Aquí puedes configurar los componentes de la UI según los datos recibidos

        // Añade el panel principal al JFrame
        setContentPane(panelPrincipal);

        pack(); // Ajusta el tamaño de la ventana a los componentes
        setVisible(true);
        descargarPasajeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pasaje pasaje = new Pasaje(origen, destino, fecha, horaSalida, precio, numeroAsiento);
            }
        });
    }

    /**
     * Método necesario para inicializar los componentes del formulario.
     * IntelliJ IDEA genera y llama a este método automáticamente en tiempo de compilación.
     * No es necesario escribirlo manualmente, pero es crucial llamarlo en el constructor.
     */
    private void $$$setupUI$$$() {
        // IntelliJ IDEA genera el cuerpo de este método automáticamente.
    }
}