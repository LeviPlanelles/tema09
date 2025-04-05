package com.leviplanelles.Ejercicio6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio6 {
    static Map<String,String> parejas = new HashMap<>();
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal () {
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        int choice = 0;
        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Introducir parejas de palabras.");
            System.out.println("2. Traducir palabras.");
            System.out.println("0. Salir de la aplicación.");
            System.out.println();

            do {
                try {
                    System.out.print("Elige una opción: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 0 && choice < 2) {
                        valido = true;
                    }
                } catch (NumberFormatException nfe) {
                    valido = false;
                }
            }while (!valido);

            switch (choice) {
                case 1 -> {
                    int cantidad = 0;
                    valido = false;
                    do {
                        try {
                            System.out.print("Cuantas quieres introducir: ");
                            cantidad = Integer.parseInt(scanner.nextLine());
                            if (cantidad >= 1) {
                                valido = true;
                            }
                        } catch (NumberFormatException nfe) {
                            valido = false;
                        }
                    }while (!valido);
                    introducirParejasPalabras(cantidad);
                }
                case 2 -> {
                    System.out.print("Palabra a buscar: ");
                    String palabra = scanner.nextLine();
                    traducirPalabras(palabra);
                }
                case 0 -> {}
            }
        }while (choice != 0);
    }
    public static void introducirParejasPalabras(int cantidad) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce la palabra en inglés: ");
            String ingles = scanner.nextLine();
            System.out.print("Introduce la traducción al castellano: ");
            String castellano = scanner.nextLine();
            parejas.put(ingles,castellano);
        }
    }
    public static void traducirPalabras(String busqueda) {
        if (parejas.containsKey(busqueda)) {
            System.out.println(parejas.get(busqueda));
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }
}
