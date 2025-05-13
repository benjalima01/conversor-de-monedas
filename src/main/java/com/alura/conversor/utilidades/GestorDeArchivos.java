package com.alura.conversor.utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestorDeArchivos {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(Colores.NEGRITA + "dd/MM/yyyy HH:mm:ss");

    public static void guardarEnArchivoHistorial(String conversionRealizada) {
        try {
            File file = new File("HistorialConversiones.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(conversionRealizada + '\n');
            writer.close();
            System.out.println(Colores.VERDE + "Se guardó en el historial." + Colores.RESET);
        } catch (Exception e) {
            System.out.println(Colores.ROJO + "Error al guardar en el historial.");
            e.printStackTrace();
        }
    }

    public static void lecturaDeHistorial() {
        try {
            File archivo = new File("HistorialConversiones.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(Colores.ROJO+ "Archivo de historial no encontrado.");
        }
    }

    public static void registroConMarcasDeTiempo(String conversionRealizada) {
        try {
            File file = new File("RegistroMarcasDeTiempo.txt");
            FileWriter writer = new FileWriter(file, true);
            LocalDateTime ahora = LocalDateTime.now();
            String fechaFormateada = ahora.format(FORMATO_FECHA);

            writer.write(conversionRealizada + " | Fecha: " + fechaFormateada + '\n');
            writer.close();
            System.out.println(Colores.VERDE + "Registro con marca de tiempo guardado." + Colores.RESET);
        } catch (Exception e) {
            System.out.println(Colores.ROJO + "Error al guardar el registro con marca de tiempo.");
            e.printStackTrace();
        }
    }

    public static void lecturaDeRegistro() {
        try {
            File archivo = new File("RegistroMarcasDeTiempo.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(Colores.ROJO + "Archivo de registro no encontrado.");
        }
    }
}