package com.alura.conversor;

import com.alura.conversor.api.ConversorApi;
import com.alura.conversor.utilidades.GestorDeArchivos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConversorApi conversor = new ConversorApi();


        while (true) {
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1) USD a ARS");
            System.out.println("2) ARS a USD");
            System.out.println("3) EUR a USD");
            System.out.println("4) BRL a USD");
            System.out.println("5) USD a COP ");
            System.out.println("6) ARS a BRL");
            System.out.println("7) Elegir moneda manualmente");
            System.out.println("8) Ver historial");
            System.out.println("9) Ver registro con marcas de tiempo");
            System.out.println("10) Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 9) {
                System.out.println("Cerrando el conversor...");
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
                    System.out.print("Ingrese la moneda base (por ejemplo: USD): ");
                    base = scanner.nextLine().toUpperCase();

                    System.out.print("Ingrese la moneda destino (por ejemplo: ARS): ");
                    destino = scanner.nextLine().toUpperCase();
                    break;
                case 8:
                    System.out.println("Historial de conversiones:");
                    GestorDeArchivos.lecturaDeHistorial();
                    continue;
                case 9:
                    System.out.println("Registro con marcas de tiempo:");
                    GestorDeArchivos.lecturaDeRegistro();
                    continue;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            System.out.print("Ingrese el monto a convertir: ");
            monto = scanner.nextDouble();

            try {
                double resultado = conversor.findAll(base, destino, monto);
                System.out.printf("La conversión entre %s y %s es: $%.2f %s\n", base, destino, resultado, destino);
                String registro = monto + " " + base + " -> " + resultado + " " + destino;
                GestorDeArchivos.guardarEnArchivoHistorial(registro);
                GestorDeArchivos.registroConMarcasDeTiempo(registro);
            } catch (Exception e) {
                System.out.println("No se pudo obtener la conversión.");
            }

        }

    }


}

