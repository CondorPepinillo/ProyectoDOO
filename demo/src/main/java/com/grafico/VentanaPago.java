package com.grafico;
import com.builder.PasajeBuilder;
import com.builder.VentanaPagoBuilder;
import com.logica.Pasaje;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class VentanaPago extends JFrame {
    private JPanel panelPrincipal;
    private JButton descargarPasajeButton;

    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private String numeroAsiento;
    private String tipoAsiento;

    public VentanaPago(VentanaPagoBuilder builder) {
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
                Pasaje pasaje = (Pasaje) new PasajeBuilder()
                        .origen(origen)
                        .destino(destino)
                        .fecha(fecha)
                        .horaSalida(horaSalida)
                        .precio(precio)
                        .numeroAsiento(numeroAsiento)
                        .tipoAsiento(tipoAsiento)
                        .build();
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