package com.proyecto;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import javax.swing.*;
import java.awt.*;


class SelectionForm1Test {

    private SelectionForm1 selectionForm;

    @BeforeEach
    public void setUp() {
        SwingUtilities.invokeLater(() -> {
            selectionForm = new SelectionForm1();
        });
    }

    @AfterEach
    public void tearDown() {
        SwingUtilities.invokeLater(() -> {
            selectionForm.dispose();
        });
    }

    @Test
    @DisplayName("Verificar clic en botón submit")
    public void testButtonClick() {
        SwingUtilities.invokeLater(() -> {
            // Simular un clic en el botón submit
            selectionForm.submit.doClick();           //Haga submit pulico para que el test funcione

            // Verificar que se haya creado una instancia de SelectionFormLogica
            JFrame[] frames = (JFrame[]) JFrame.getFrames();
            boolean found = false;
            for (JFrame frame : frames) {
                if (frame.getTitle().equals("Panel Principal")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "No se encontró la ventana principal 'Panel Principal'");
        });
    }

    @Test
    @DisplayName("Verificar propiedades de la ventana principal")
    public void testMainFrameProperties() {
        SwingUtilities.invokeLater(() -> {
            // Verificar propiedades de la ventana principal
            JFrame[] frames = (JFrame[]) JFrame.getFrames();
            boolean found = false;
            for (JFrame frame : frames) {
                if (frame.getTitle().equals("Panel Principal")) {
                    assertEquals(new Dimension(400, 200), frame.getSize(),
                            "La ventana principal no tiene las dimensiones esperadas");
                    assertEquals(Frame.getFrames()[0].getLocation(), frame.getLocation(),
                            "La ventana principal no está centrada correctamente");
                    found = true;
                    break;
                }
            }
            assertTrue(found, "No se encontró la ventana principal 'Panel Principal'");
        });
    }
}
