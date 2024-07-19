package com.logica;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class DataClassTest {

    @Test
    void testGetData() throws IOException {
        // Arrange
        ComunasEnum origen = ComunasEnum.CONCEPCION;
        ComunasEnum destino = ComunasEnum.LOS_ANGELES;

        DataClass dataClass = new DataClass(origen, destino);

        // Act
        Object[][] data = dataClass.getData();

        // Assert
        assertNotNull(data);
        assertTrue(data.length > 0);
        assertTrue(data[0].length > 0);
    }  //DESCONOZCO PORQUE EN TEST NO PUEDE ENCONTRAR LA RUTA

    @Test
    void testGetDataWithInvalidFile() {
        // Arrange
        ComunasEnum origen = ComunasEnum.CONCEPCION;
        ComunasEnum destino = ComunasEnum.CONCEPCION; // Invalid destination for testing

        DataClass dataClass = new DataClass(origen, destino);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dataClass.getData();
        });
    }

    // Puedes agregar más pruebas para cubrir otros casos y escenarios
}
