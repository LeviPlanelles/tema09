package com.leviplanelles.Ejercicio7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
    static Map<Currency,Double> monedaCambioEuro = new HashMap<>();
    public enum Currency {
        USD,GBP,INR,AUD,CAD,ARS,BOB,CLP,VEZ,CRC,CUP,DOP,MXN,DEFAULT
    }
    public static void main(String[] args) {
        monedaCambioEuro.put(Currency.USD,1.1045);
        monedaCambioEuro.put(Currency.GBP,0.8490);
        monedaCambioEuro.put(Currency.INR,94.07);
        monedaCambioEuro.put(Currency.AUD,1.811);
        monedaCambioEuro.put(Currency.CAD,1.559);
        monedaCambioEuro.put(Currency.ARS,1175.42);
        monedaCambioEuro.put(Currency.BOB,7.54);
        monedaCambioEuro.put(Currency.CLP,1056.0);
        monedaCambioEuro.put(Currency.VEZ,4661.0);
        monedaCambioEuro.put(Currency.CRC,547.1);
        monedaCambioEuro.put(Currency.CUP,26.06);
        monedaCambioEuro.put(Currency.DOP,69.12);
        monedaCambioEuro.put(Currency.MXN,22.04);
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        double cantidad = 0;

        do {
            try {
                System.out.print("Introduce la cantidad de dinero a cambiar: ");
                cantidad = Double.parseDouble(scanner.nextLine());
                if (cantidad > 0) {
                    valido = true;
                } else {
                    System.err.println("No puedes cambiar 0€ o menos!");
                }
            } catch (NumberFormatException nfe) {
                valido = false;
            }
        }while (!valido);

        System.out.print("Moneda a cambiar (ej. USD,AUD,MXN...): ");
        String cambio = scanner.nextLine().toUpperCase().trim();
        Currency moneda = switch (cambio) {
            case "USD" -> Currency.USD;
            case "GBP" -> Currency.GBP;
            case "INR" -> Currency.INR;
            case "AUD" -> Currency.AUD;
            case "CAD" -> Currency.CAD;
            case "ARS" -> Currency.ARS;
            case "BOB" -> Currency.BOB;
            case "CLP" -> Currency.CLP;
            case "VEZ" -> Currency.VEZ;
            case "CRC" -> Currency.CRC;
            case "CUP" -> Currency.CUP;
            case "DOP" -> Currency.DOP;
            case "MXN" -> Currency.MXN;
            default -> Currency.DEFAULT;
        };
        System.out.println(calcularCambio(cantidad,moneda));
    }
    public static double calcularCambio(double cantidad, Currency moneda) {
        if (moneda.equals(moneda.DEFAULT)) return -1;
        if (monedaCambioEuro.containsKey(moneda)) {
            return cantidad * monedaCambioEuro.get(moneda);
        }
        return 0;
    }
}
