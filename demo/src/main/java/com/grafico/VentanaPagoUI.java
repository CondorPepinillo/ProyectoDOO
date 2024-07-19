package com.grafico;
import com.builder.PasajeBuilder;
import com.builder.VentanaPagoBuilder;
import com.logica.PasajeClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class VentanaPagoUI extends JFrame {
    private JPanel panelPrincipal;
    private JButton descargarPasajeButton;

    private ComunasEnum origen;
    private ComunasEnum destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private String numeroAsiento;
    private String tipoAsiento;

    public VentanaPagoUI(VentanaPagoBuilder builder) {
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        this.horaSalida = builder.horaSalida;
        this.precio = builder.precio;
        this.numeroAsiento = builder.numeroAsiento;
        this.tipoAsiento = builder.tipoAsiento;
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
                try {
                    PasajeClass pasajeClass = (PasajeClass) new PasajeBuilder()
                            .origen(origen)
                            .destino(destino)
                            .fecha(fecha)
                            .horaSalida(horaSalida)
                            .precio(precio)
                            .numeroAsiento(numeroAsiento)
                            .tipoAsiento(tipoAsiento)
                            .build();
                } catch (IOException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }/**
     * Método necesario para inicializar los componentes del formulario.
     * IntelliJ IDEA genera y llama a este método automáticamente en tiempo de compilación.
     * No es necesario escribirlo manualmente, pero es crucial llamarlo en el constructor.
     */
    private void $$$setupUI$$$() {
        // IntelliJ IDEA genera el cuerpo de este método automáticamente.
    }
}