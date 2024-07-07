package com.proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class pasajesHorariosUITest {
    pasajesHorariosUI test;
    @BeforeEach
    void setUp() {
        test = new pasajesHorariosUI(Comunas.LOS_ANGELES, Comunas.NACIMIENTO, new Date(1720825360));

    }

    @Test
    void getData() {
    }

    @Test
    void getOrigen() {
        assertNotEquals(null, test.getOrigen());
        assertNotEquals(test.getDestino(), test.getOrigen());
    }

    @Test
    void getDestino() {
        assertNotEquals(null, test.getDestino());
        assertNotEquals(test.getOrigen(), test.getDestino());
    }


    //Los siguientes test funciones parecen no funcionar con JUNIT test

    @Test
    void getHorarioSalidaSeleccionado() {
        try {
            Thread.sleep(10000); // Pausa durante 60 minutos (1 segundo = 1000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals(Optional.ofNullable(null), test.getHorarioSalidaSeleccionado());
    }

    @Test
    void getPrecio() {
        try {
            Thread.sleep(10000); // Pausa durante 60 minutos (1 segundo = 1000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals(Optional.ofNullable(null), test.getPrecio());
    }

    @Test
    void getPiso() {
        try {
            Thread.sleep(10000); // Pausa durante 60 minutos (1 segundo = 1000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals(Optional.ofNullable(null), test.getPiso());
    }
}