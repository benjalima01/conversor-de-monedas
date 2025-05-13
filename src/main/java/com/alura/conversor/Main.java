package com.alura.conversor;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConversorApi conversor = new ConversorApi();




        while (true) {
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1- USD a ARS");
            System.out.println("2- ARS a USD");
            System.out.println("3- EUR a USD");
            System.out.println("4- BRL a USD");
            System.out.println("5- USD a COP ");
            System.out.println("6- ARS a BRL");
            System.out.println("7- Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Cerrando el conversor...");
                break;
            }
            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            String base = "";
            String destino = "";

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
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            try {
                double resultado = conversor.findAll(base, destino, monto);
                System.out.println("La conversión entre " + base + " y " + destino + " es: $" + resultado + " " + destino);
            } catch (Exception e) {
                System.out.println("No se pudo obtener la conversión.");
            }

        }
        }
    }

