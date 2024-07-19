package com.logica;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.builder.PasajesHorariosBuilder;
import com.grafico.PasajesHorariosUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Date;

public class PasajesHorariosClassTest {  //De nuevo desconozco cual es problema de los junit test con los cvs

    private PasajesHorariosUI mockPasajesHorariosUI;
    private PasajesHorariosBuilder mockBuilder;
    private DataClass mockData;

    @BeforeEach
    void setUp() throws IOException {
        // Configuración inicial para cada prueba
        mockPasajesHorariosUI = new PasajesHorariosUI(ComunasEnum.CONCEPCION, ComunasEnum.LOS_ANGELES, new Date());
        mockData = new DataClass(ComunasEnum.CONCEPCION, ComunasEnum.LOS_ANGELES);
        mockBuilder = (PasajesHorariosBuilder) new PasajesHorariosBuilder()
                .origen(ComunasEnum.CONCEPCION)
                .destino(ComunasEnum.LOS_ANGELES)
                .fecha(new Date())
                .busData(mockData);
    }

    @Test
    void testUpdateAddsBusToList() throws IOException {
        // Arrange
        PasajesHorariosClass pasajesHorarios = new PasajesHorariosClass(mockBuilder);
        // Usamos la implementación ListaBusClass

        // Act
        pasajesHorarios.update(0);
        // Assert
        assertNotNull(pasajesHorarios.getListaBusClass());
        assertNotEquals(null , pasajesHorarios.getListaBusClass().get(0));
        // Agrega más aserciones según sea necesario para verificar el comportamiento esperado
    }

    @Test
    void testUpdateShowsBus() throws IOException {
        // Arrange
        PasajesHorariosClass pasajesHorarios = new PasajesHorariosClass(mockBuilder);

        // Act
        pasajesHorarios.update(0);

        // Assert
        assertNotNull(pasajesHorarios.getListaBusClass());
        assertEquals("7:00", pasajesHorarios.getListaBusClass().get(0).getHoraSalida());
        // Agrega más aserciones según sea necesario para verificar el comportamiento esperado
    }

    // Puedes agregar más pruebas para cubrir otros casos y escenarios

}
