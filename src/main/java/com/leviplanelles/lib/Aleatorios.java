package com.leviplanelles.lib;

import java.util.Random;

public class Aleatorios {
    public static double aleatorio(double valorMinimo, double valorMaximo){
        Random random = new Random();
        return valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
    }
    public static int aleatorio(int valorMinimo, int valorMaximo){
        Random random = new Random();
        return valorMinimo + random.nextInt((valorMaximo - valorMinimo));
    }

    public static void rellenarArrayAleatoriamente(double[] array, double valorMinimo, double valorMaximo){
        Random random = new Random();
        for (int i = 0; i< array.length; i++){
            array[i] = aleatorio(valorMinimo, valorMaximo);
        }
    }
    public static void rellenarArrayAleatoriamente(int[] array, int valorMinimo, int valorMaximo){
        for (int i = 0; i< array.length; i++){
            array[i] = aleatorio(valorMinimo, valorMaximo);
        }
    }

    public static int[] rellenarArrayAleatoriamente(int tamanyo, int valorMinimo, int valorMaximo){
        Random random = new Random();
        int[] enteros = new int[tamanyo];
        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = random.nextInt(valorMinimo, valorMaximo + 1);
        }
        return enteros;

    }
    public static double[][] crearMatrizAleatoria(int filas, int columnas, double valorMinimo, double valorMaximo){
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j< matriz[i].length; j++){
                matriz[i][j] = aleatorio(valorMinimo,valorMaximo);
            }
        }
        return matriz;
    }

    /**
     * Saca un numero aleatorio en el margen que le indiquemos
     * @param numMin El numero minimo
     * @param numMax El numero maximo
     * @return Saca el numero aleatorio
     */
    public static int nnumeroAleatorio(int numMin, int numMax){
        Random rng = new Random();
        int numero = rng.nextInt(numMin,numMax+1);
        return numero;
    }
}
