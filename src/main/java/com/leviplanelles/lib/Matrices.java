package com.leviplanelles.lib;

import java.util.Scanner;

public class Matrices {
    /**
     * Determina la longitud maxima de una matriz
     * @param matriz Es la matriz la cual queremos saber la longitud maxima
     * @param decimales La cantidad de decimales que queremos
     * @return Devuelve la longitud maxima
     */
    public static int determinarLongitudMaxima(double[][] matriz, int decimales){
        int longitudMaxima = 0;
        for (double[] fila : matriz){
            int longitud = ArrayCosas.determinarLongitudMaxima(fila,decimales);
            if (longitud > longitudMaxima){
                longitudMaxima = longitud;
            }
        }
        return longitudMaxima;
    }

    public static double[][] crearMatriz(int filas, int columnas){
        Scanner input = new Scanner(System.in);
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j <matriz[i].length; j++){
                System.out.printf("Introduzca el valor que quiera a la fila %d columna %d", i, j);
                matriz[i][j] = Double.parseDouble(input.nextLine());
            }
        }
        return matriz;
    }


}
