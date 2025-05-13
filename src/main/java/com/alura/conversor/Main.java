package com.alura.conversor;

import com.alura.conversor.api.ConversorApi;
import com.alura.conversor.utilidades.GestorDeArchivos;
import com.alura.conversor.utilidades.Colores;


import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConversorApi conversor = new ConversorApi();


        while (true) {
            System.out.printf(Colores.NEGRITA + "***************************************************\n");
            System.out.println(Colores.NEGRITA + Colores.CYAN + "Bienvenido al conversor de monedas" + Colores.RESET);
            System.out.println(Colores.VERDE + Colores.NEGRITA + "1) USD -> ARS");
            System.out.println(Colores.VERDE + "2) ARS -> USD");
            System.out.println(Colores.VERDE + "3) EUR -> USD");
            System.out.println(Colores.VERDE + "4) BRL -> USD");
            System.out.println(Colores.VERDE + "5) USD -> COP");
            System.out.println(Colores.VERDE + "6) ARS -> BRL");
            System.out.println(Colores.AZUL + "7) Elegir moneda manualmente");
            System.out.println(Colores.AMARILLO + "8) Ver historial");
            System.out.println(Colores.AMARILLO + "9) Ver registro con marcas de tiempo");
            System.out.println(Colores.ROJO + "10) Salir" + Colores.RESET);
            System.out.printf(Colores.NEGRITA + "***************************************************\n");

            System.out.print(Colores.NEGRITA + "Elija una opción: " + Colores.RESET);

            int opcion = scanner.nextInt();

            if (opcion == 10) {
                System.out.println(Colores.NEGRITA + Colores.ROJO + "Cerrando el conversor..." + Colores.RESET);
                break;
            }

            String base = "";
            String destino = "";
            double monto = 0;

            switch (opcion) {
                case 1:
                    base = "USD";
                    destino = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    destino = "USD";
                    break;
                case 3:
                    base = "EUR";
                    destino = "USD";
                    break;
                case 4:
                    base = "BRL";
                    destino = "USD";
                    break;
                case 5:
                    base = "USD";
                    destino = "COP";
                    break;
                case 6:
                    base = "ARS";
                    destino = "BRL";
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.print("Ingrese la moneda base (por ejemplo: " + Colores.VERDE + "USD" + "): " + Colores.RESET);
                    base = scanner.nextLine().toUpperCase();
                    System.out.print("Ingrese la moneda destino (por ejemplo: " + Colores.VERDE + "ARS" + "): " + Colores.RESET);
                    destino = scanner.nextLine().toUpperCase();
                    break;
                case 8:
                    System.out.println(Colores.AMARILLO + "Historial de conversiones:" + Colores.RESET);
                    GestorDeArchivos.lecturaDeHistorial();
                    continue;
                case 9:
                    System.out.println(Colores.AMARILLO + "Registro con marcas de tiempo:" + Colores.RESET);
                    GestorDeArchivos.lecturaDeRegistro();
                    continue;
                default:
                    System.out.println(Colores.ROJO + "Opción no válida." + Colores.RESET);
                    break;
            }
            System.out.print(Colores.NEGRITA + "Ingrese el monto a convertir: " + Colores.RESET);
            monto = scanner.nextDouble();

            try {
                double resultado = conversor.findAll(base, destino, monto);
                System.out.printf("La conversión entre " + Colores.VERDE +
                        " %s" + Colores.RESET + " y " + Colores.VERDE + "%s" +
                        Colores.RESET + " es: " + Colores.VERDE + "$%.2f %s\n", base, destino, resultado, destino);
                String registro = monto + " " + base + " -> " + resultado + " " + destino;
                GestorDeArchivos.guardarEnArchivoHistorial(registro);
                GestorDeArchivos.registroConMarcasDeTiempo(registro);
            } catch (Exception e) {
                System.out.println(Colores.ROJO + Colores.NEGRITA + "No se pudo obtener la conversión." + Colores.RESET);
            }

        }
    }
}

