package com.logica;

import static org.junit.jupiter.api.Assertions.*;

import com.builder.PasajeBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PasajeClassTest { //De nuevo da error de no poder leer los cvs pero por otro lado los pasejes se escriben bien

    private PasajeBuilder mockBuilder;
    private PasajeClass pasaje;

    @BeforeEach
    void setUp() {
        // Configuración inicial para cada prueba
        mockBuilder = (PasajeBuilder) new PasajeBuilder()
                .origen(ComunasEnum.CONCEPCION)
                .destino(ComunasEnum.LOS_ANGELES)
                .fecha(new Date())
                .horaSalida("10:00")
                .precio("10000")
                .numeroAsiento("1")
                .tipoAsiento("Normal");
    }

    @Test
    void testConstructorWithValidData() throws IOException {
        // Arrange & Act
        pasaje = new PasajeClass(mockBuilder);

        // Assert
        assertNotNull(pasaje);
        assertEquals(ComunasEnum.CONCEPCION, pasaje.getOrigen());
        assertEquals(ComunasEnum.LOS_ANGELES, pasaje.getDestino());
        assertNotNull(pasaje.getFecha());
        assertEquals("10:00", pasaje.getHoraSalida());
        assertEquals(1, pasaje.getAsiento());
    }

    @Test
    void testDescargarPasajePDF() throws IOException {
        // Arrange
        pasaje = new PasajeClass(mockBuilder);
        String directoryPath = "../ProyectoDOO/";
        String fileName = "Pasaje.pdf";
        File file = new File(directoryPath + fileName);

        // Act
        pasaje.descargarPasajePDF();

        // Assert
        assertTrue(file.exists());

        // Limpiar después de la prueba
        file.delete();
    }

    // Otros métodos de prueba según sea necesario

    @AfterEach
    void tearDown() {
        // Limpiar recursos después de cada prueba si es necesario
    }
}
