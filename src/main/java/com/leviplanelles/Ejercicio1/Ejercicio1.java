package com.leviplanelles.Ejercicio1;


import com.leviplanelles.lib.Aleatorios;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        System.err.println(numeros);
        ArrayList<Integer> arrayListOrdenado = arrayOrdenadoParesImpares(numeros);
        System.out.println(arrayListOrdenado);
    }

    /**
     * Genera numeros eneteros aleatoriamente y los mete en el Array
     * @param numeros Es el Array con los valores enteros
     */
    public static void generarNumerosAleatorios(int[] numeros){
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = Aleatorios.nnumeroAleatorio(0,50);
        }
    }

    /**
     * Metodo que pasa un ArrayDeEnteros a un ArrayList, ordenandolos primero los pares y luego los impares
     * @param num Es el array de numeros enteros que queremos ordenar por pares a impares
     * @return Devuelve un ArrayList de enteros con los valores del array introducido de forma que primero son los pares y luego los impares
     */
    public static ArrayList<Integer> arrayOrdenadoParesImpares(int[] num){
        ArrayList<Integer> paresImpares = new ArrayList<>(num.length);
        for (int i = 0; i < num.length ; i++) {
            if (num[i] % 2 == 0){
                paresImpares.add(num[i]);
            }
        }
        for (int i = 0; i < num.length ; i++) {
            if (num[i] % 2 != 0) {
                paresImpares.add(num[i]);
            }
        }
        return paresImpares;
    }

}
