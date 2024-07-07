package com.proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionForm1Test {
    SelectionForm1 ventana;
    @BeforeEach
    void setUp() {
        ventana = new SelectionForm1();
        try {
            Thread.sleep(10000); // Pausa durante 60 minutos (1 segundo = 1000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getOrigen() {
        assertNotEquals(null, ventana.getOrigen());
        assertNotEquals(ventana.getDestino(), ventana.getOrigen());
    }

    @Test
    void getDestino() {
        assertNotEquals(null, ventana.getDestino());
        assertNotEquals(ventana.getOrigen(), ventana.getDestino());
    }
}