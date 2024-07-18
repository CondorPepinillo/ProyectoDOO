package com.proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class PasajesHorariosClassTest {

    private JTable mockListaBuses;
    private Comunas mockOrigen;
    private Comunas mockDestino;
    private Date mockFecha;

    @BeforeEach
    void setUp() {
        // Configurar objetos simulados para las pruebas
        mockListaBuses = new JTable();
        mockOrigen = Comunas.NACIMIENTO;  // Ejemplo de uso del enum Comunas
        mockDestino = Comunas.CONCEPCION; // Ejemplo de uso del enum Comunas
        mockFecha = new Date();
    }

    @Test
    void testConstructorValidData() {
        // Crear instancia de PasajesHorariosLogica usando el Builder
        PasajesHorariosLogica instance = new PasajesHorariosLogica.Builder()
                .ListaBuses(mockListaBuses)
                .origen(mockOrigen)
                .destino(mockDestino)
                .fecha(mockFecha)
                .build();

        assertNotNull(instance);
    }

    @Test
    void testGetHorarioSalidaSeleccionado() {
        // Simular datos en la tabla
        String[][] data = {{"Bus1", "10:00", "NACIMIENTO", "CONCEPCION", "100", "Tipo1", "1", "Asiento1"}};
        String[] columnNames = {"Bus", "Hora", "Origen", "Destino", "Precio", "Tipo", "Piso", "Asiento"};
        mockListaBuses.setModel(new DefaultTableModel(data, columnNames));

        // Crear instancia de PasajesHorariosLogica
        PasajesHorariosLogica instance = new PasajesHorariosLogica.Builder()
                .ListaBuses(mockListaBuses)
                .origen(mockOrigen)
                .destino(mockDestino)
                .fecha(mockFecha)
                .build();

        // Probar el método getHorarioSalidaSeleccionado
        String horario = instance.getHorarioSalidaSeleccionado(0);
        assertEquals("10:00", horario);
    }

    // Añadir pruebas similares para otros métodos como getPrecio, getPiso, etc.
}
