package com.proyecto;

import com.toedter.calendar.JDateChooser;
import org.junit.jupiter.api.Test;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionFormClassTest {

    @Test
    public void testValidSelection() {             //Desconozco porque el test no puede leer los cvs
        // Mock objects
        JDateChooser dateChooser = new JDateChooser();
        JComboBox<Comunas> origenComboBox = new JComboBox<>();
        JComboBox<Comunas> destinoComboBox = new JComboBox<>();
        JFrame frame = new JFrame();

        // Mock data
        Comunas origenComuna = Comunas.NACIMIENTO;
        Comunas destinoComuna = Comunas.CONCEPCION;

        // Add items to combo boxes
        origenComboBox.addItem(origenComuna);
        destinoComboBox.addItem(destinoComuna);

        // Set date to tomorrow
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);
        dateChooser.setDate(tomorrow.getTime());

        // Create SelectionFormLogica instance
        SelectionFormLogica logic = new SelectionFormLogica(dateChooser, origenComboBox, destinoComboBox, frame);

        // Assertions
        assertEquals(origenComuna, logic.getOrigen());
        assertEquals(destinoComuna, logic.getDestino());
    }

    @Test
    public void testDateInPast() {
        // Mock objects
        JDateChooser dateChooser = new JDateChooser();
        JComboBox<Comunas> origenComboBox = new JComboBox<>();
        JComboBox<Comunas> destinoComboBox = new JComboBox<>();
        JFrame frame = new JFrame();

        // Set date to yesterday
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);
        dateChooser.setDate(yesterday.getTime());

        // Create SelectionFormLogica instance
        SelectionFormLogica logic = new SelectionFormLogica(dateChooser, origenComboBox, destinoComboBox, frame);

        // Assertions
        assertNull(logic.getOrigen());
        assertNull(logic.getDestino());
    }

    @Test
    public void testSameOrigenAndDestino() {
        // Mock objects
        JDateChooser dateChooser = new JDateChooser();
        JComboBox<Comunas> origenComboBox = new JComboBox<>();
        JComboBox<Comunas> destinoComboBox = new JComboBox<>();
        JFrame frame = new JFrame();

        // Mock data
        Comunas comunas = Comunas.CONCEPCION;

        // Add same item to both combo boxes
        origenComboBox.addItem(comunas);
        destinoComboBox.addItem(comunas);

        // Set date to tomorrow
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);
        dateChooser.setDate(tomorrow.getTime());

        // Create SelectionFormLogica instance
        SelectionFormLogica logic = new SelectionFormLogica(dateChooser, origenComboBox, destinoComboBox, frame);

        // Assertions
        assertNull(logic.getOrigen());
        assertNull(logic.getDestino());
    }
}
