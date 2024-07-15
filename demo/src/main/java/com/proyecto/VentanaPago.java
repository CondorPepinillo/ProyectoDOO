package com.proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class VentanaPago extends JFrame {
    private JPanel panelPrincipal;
    private JButton descargarPasajeButton;

    public VentanaPago(Comunas origen, Comunas destino, Date fecha, String horaSalida, String precio, String numeroAsiento) {
        // Configura la ventana
        setTitle("Ventana de Pago");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Inicializa los componentes del formulario
        $$$setupUI$$$();

        // Configura los valores recibidos como parámetros
        // Aquí puedes configurar los componentes de la UI según los datos recibidos

        // Añade el panel principal al JFrame
        setContentPane(panelPrincipal);
        setPreferredSize(new Dimension(400, 250));
        pack(); // Ajusta el tamaño de la ventana a los componentes
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
        descargarPasajeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Pasaje pasaje = new Pasaje(origen, destino, fecha, horaSalida, precio, numeroAsiento);
                Pasaje pasaje = new Pasaje.Builder()
                        .origen(origen)
                        .destino(destino)
                        .fecha(fecha)
                        .horaSalida(horaSalida)
                        .precio(precio)
                        .asiento(numeroAsiento)
                        .build();
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