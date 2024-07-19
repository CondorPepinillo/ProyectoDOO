package com.logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionFormClassTest {

    @Test
    void testConstructorValidInput() {
        // Arrange
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date()); // Set today's date
        JComboBox<ComunasEnum> origenComboBox = new JComboBox<>(ComunasEnum.values());
        JComboBox<ComunasEnum> destinoComboBox = new JComboBox<>(ComunasEnum.values());
        JFrame frame = new JFrame();

        origenComboBox.setSelectedIndex(1);
        destinoComboBox.setSelectedIndex(2);

        SelectionFormClass form = new SelectionFormClass(dateChooser, origenComboBox, destinoComboBox, frame);

        // Assert
        assertNotNull(form.getOrigen());
        assertNotNull(form.getDestino());
        assertNotEquals(form.getOrigen(), form.getDestino());
    }

    @Test
    void testConstructorNullDateChooser() {
        // Arrange
        JDateChooser dateChooser = null;
        JComboBox<ComunasEnum> origenComboBox = new JComboBox<>(ComunasEnum.values());
        JComboBox<ComunasEnum> destinoComboBox = new JComboBox<>(ComunasEnum.values());
        JFrame frame = new JFrame();

        // Act + Assert
        assertThrows(NullPointerException.class, () -> new SelectionFormClass(dateChooser, origenComboBox, destinoComboBox, frame));
    }

    @Test
    void testConstructorInvalidDate() {
        // Arrange
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date(System.currentTimeMillis() - 86400000)); // Set yesterday's date
        JComboBox<ComunasEnum> origenComboBox = new JComboBox<>(ComunasEnum.values());
        JComboBox<ComunasEnum> destinoComboBox = new JComboBox<>(ComunasEnum.values());
        JFrame frame = new JFrame();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new SelectionFormClass(dateChooser, origenComboBox, destinoComboBox, frame));
    }

    @Test
    void testConstructorSameOrigDest() {
        // Arrange
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        ComunasEnum[] comunas = ComunasEnum.values();
        JComboBox<ComunasEnum> origenComboBox = new JComboBox<>(comunas);
        JComboBox<ComunasEnum> destinoComboBox = new JComboBox<>(comunas);
        destinoComboBox.setSelectedItem(comunas[0]); // Set both to the same value
        JFrame frame = new JFrame();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new SelectionFormClass(dateChooser, origenComboBox, destinoComboBox, frame));
    }
}
