package com.leviplanelles.Ejercicio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio9 {
    static Map<String,String> parejas = new HashMap<>();
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal () {
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        int choice = 0;
        do {
            System.out.println("GESTIÓN DICCIONARIO");
            System.out.println("===================");
            System.out.println("1. Añadir palabra.");
            System.out.println("2. Modificar palabra.");
            System.out.println("3. Eliminar palabra.");
            System.out.println("4. Consultar palabra.");
            System.out.println("5. Mostrar diccionario.");
            System.out.println("------------------------");
            System.out.println("0. Salir");
            System.out.println();

            do {
                try {
                    System.out.print("Elige una opción: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 0 && choice <= 5) {
                        valido = true;
                    }
                } catch (NumberFormatException nfe) {
                    valido = false;
                }
            }while (!valido);

            switch (choice) {
                case 1 -> {
                    System.out.print("Introduce la palabra: ");
                    String palabra = scanner.nextLine();
                    System.out.print("Introduce la definicion de la palabra: ");
                    String definicion = scanner.nextLine();
                    introducirParejasPalabras(palabra,definicion);
                }
                case 2 -> {
                    System.out.print("Palabra a buscar: ");
                    String palabra = scanner.nextLine();
                    modificarPalabra(palabra);
                }
                case 3 -> {
                    System.out.print("Palabra a eliminar: ");
                    String palabra = scanner.nextLine();
                    if (parejas.containsKey(palabra)) {
                        parejas.remove(palabra);
                    }else {
                        System.err.println("Na nai del paraguai que esa palabra no existe en el diccionario");
                    }
                }
                case 4 -> {
                    System.out.print("Palabra a consultar: ");
                    String busqueda = scanner.nextLine();
                    consultarPalabra(busqueda);
                }
                case 5 -> {
                    for (Map.Entry<String, String> pareja : parejas.entrySet()) {
                        System.out.println("Palabra: " + pareja.getKey() + ", Definición: " + pareja.getValue());
                    }
                }
                case 0 -> {}
            }
        }while (choice != 0);
    }

    public static void introducirParejasPalabras(String palabra,String definicion) {
        if (!parejas.containsKey(palabra)) {
            parejas.put(palabra,definicion);
        } else {
            System.err.println("Esa palabra ya existe!");
        }
    }

    public static void modificarPalabra(String busqueda) {
        Scanner scanner = new Scanner(System.in);
        if (parejas.containsKey(busqueda)) {
            System.out.println("Anterior definición: " + parejas.get(busqueda));
            System.out.print("Nueca definición: ");
            String nuevaDefinicion = scanner.nextLine();
            parejas.put(busqueda,nuevaDefinicion);
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }
    public static void consultarPalabra(String busqueda) {
        if (parejas.containsKey(busqueda)) {
            System.out.println(parejas.get(busqueda));
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

}
