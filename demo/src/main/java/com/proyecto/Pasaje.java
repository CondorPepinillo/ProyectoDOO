package com.proyecto;

import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.*;
import java.util.Date;

/**
 *Clase Pasaje, se encarga de escribir tu pasaje tanto en consola como en un archivo txt
 */
public class Pasaje {
    private Comunas origen;
    private Comunas destino;
    private Date fecha;
    private String horaSalida;
    private String precio;
    private int asiento;
    private String tipoAsiento;

    public Pasaje(Builder builder) {
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.fecha = builder.fecha;
        this.horaSalida = builder.horaSalida;
        this.precio = builder.precio;
        this.asiento = Integer.parseInt(builder.asiento);
        this.tipoAsiento = builder.tipoAsiento;

        System.out.println("      BUSES BIO-BIO        \n\n");
        System.out.println("Origen: "+ origen + "\n");
        System.out.println("Destino: "+ destino + "\n\n");
        System.out.println("Fecha Viaje: " + fecha.getDate() + "/" + (fecha.getMonth()+1)+ "/"+ (fecha.getYear()+1900) + "\n");
        System.out.println("Hora Viaje: " + horaSalida + "\n");
        System.out.println("Asiento: " + asiento + "\n\n");
        System.out.println("Tipo Asiento: " + tipoAsiento + "\n\n");
        System.out.println("Valor Pasaje: " + precio);

        descargarPasajePDF();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getAsiento() {
        return asiento;
    }

    public Comunas getOrigen() {
        return origen;
    }

    public Comunas getDestino() {
        return destino;
    }

    public void descargarPasajePDF() {
        String baseFileName = "Pasaje";
        String fileExtension = ".pdf";
        String directoryPath = "../ProyectoDOO/";

        //Verificar si existe el archivo base existe
        int count = 0;
        String fileName = baseFileName + fileExtension;
        File file = new File(directoryPath + fileName);
        while (file.exists()) {
            count++;
            fileName = baseFileName + " (" + count + ")" + fileExtension;
            file = new File(directoryPath + fileName);
        }

        try (PdfWriter pdfWriter = new PdfWriter(file)) {
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4);

            // Añadir barra azul superior con texto alineado a la izquierda
            Table headerTable = new Table(UnitValue.createPercentArray(new float[]{1, 4}));
            headerTable.setWidth(UnitValue.createPercentValue(100));
            headerTable.setBackgroundColor(ColorConstants.BLUE);
            headerTable.setHeight(25);

            Cell textCell = new Cell().add(new Paragraph("PASAJE BUS BIO-BIO")
                            .setBold()
                            .setFontColor(ColorConstants.WHITE)
                            .setTextAlignment(TextAlignment.LEFT))
                    .setBorder(null);

            headerTable.addCell(textCell);
            headerTable.addCell(new Cell().add(new Paragraph("")).setBorder(null));

            document.add(headerTable);

            // Crear tabla principal para disposición
            float[] mainTableWidths = {1, 2, 1}; // Tres columnas: etiquetas, información, código de barras
            Table mainTable = new Table(UnitValue.createPercentArray(mainTableWidths));
            mainTable.setWidth(UnitValue.createPercentValue(100));

            // Columna 1: etiquetas
            Table labelsTable = new Table(UnitValue.createPercentArray(new float[]{1}));
            labelsTable.addCell(new Cell().add(new Paragraph("Origen:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Destino:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Fecha:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Hora de Salida:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Asiento:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Tipo de Asiento:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));
            labelsTable.addCell(new Cell().add(new Paragraph("Precio:").setBold()).setBorder(null).setBackgroundColor(ColorConstants.WHITE));

            mainTable.addCell(new Cell().add(labelsTable).setBorder(null));

            // Columna 2: información del pasaje
            Table infoTable = new Table(UnitValue.createPercentArray(new float[]{1}));
            infoTable.addCell(new Cell().add(new Paragraph(origen.toString())));
            infoTable.addCell(new Cell().add(new Paragraph(destino.toString())));
            infoTable.addCell(new Cell().add(new Paragraph(fecha.getDate() + "/" + (fecha.getMonth() + 1) + "/" + (fecha.getYear() + 1900))));
            infoTable.addCell(new Cell().add(new Paragraph(horaSalida)));
            infoTable.addCell(new Cell().add(new Paragraph(String.valueOf(asiento))));
            infoTable.addCell(new Cell().add(new Paragraph(tipoAsiento)));
            infoTable.addCell(new Cell().add(new Paragraph(precio)));

            mainTable.addCell(new Cell().add(infoTable).setBorder(null));

            // Columna 3: código de barras (rotado)
            Table barcodeTable = new Table(UnitValue.createPercentArray(new float[]{1}));
            Barcode128 barcode = new Barcode128(pdfDocument);
            barcode.setCode(getCode());
            Image barcodeImage = new Image(barcode.createFormXObject(pdfDocument));
            barcodeImage.setWidth(150);
            barcodeImage.setHeight(75);

            barcodeTable.addCell(new Cell().add(barcodeImage).setBorder(null));

            mainTable.addCell(new Cell().add(barcodeTable).setBorder(null));

            document.add(mainTable);

            // Añadir línea azul en la parte inferior
            document.add(new Paragraph("")
                    .setBackgroundColor(ColorConstants.BLUE)
                    .setHeight(25)
                    .setMarginTop(1));

            document.close();
            pdfDocument.close();

            System.out.println("Pasaje descargado en PDF");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getCode() {
        double eightDigits = 10000000 + Math.random() * 90000000;
        String barcode = String.valueOf((int) eightDigits);
        return barcode;
    }

    public static class Builder{
        private Comunas origen;
        private Comunas destino;
        private Date fecha;
        private String horaSalida;
        private String precio;
        private String asiento;
        private String tipoAsiento;


        public Pasaje.Builder origen(Comunas origen){
            this.origen = origen;
            return this;
        }

        public Pasaje.Builder destino(Comunas destino) {
            this.destino = destino;
            return this;
        }

        public Pasaje.Builder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        public Pasaje.Builder horaSalida(String horaSalida) {
            this.horaSalida = horaSalida;
            return this;
        }

        public Pasaje.Builder precio(String precio) {
            this.precio = precio;
            return this;
        }

        public Pasaje.Builder asiento(String asiento) {
            this.asiento = asiento;
            return this;
        }

        public Pasaje.Builder tipoAsiento(String tipoAsiento){
            this.tipoAsiento = tipoAsiento;
            return this;
        }

        public Pasaje build(){
            return new Pasaje(this);
        }

    }
}