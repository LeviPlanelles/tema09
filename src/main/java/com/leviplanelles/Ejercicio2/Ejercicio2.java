package com.leviplanelles.Ejercicio2;

import com.leviplanelles.lib.Aleatorios;

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Double> numeros = new ArrayList<>();
        rellenarArrayListDouble(numeros);
        System.out.println(numeros.toString());

        ArrayListEstadisticas arrayListEstadisticas = new ArrayListEstadisticas(numeros);
        System.out.println("Minimo: "+ arrayListEstadisticas.minimo());
        System.out.println("Maximo: "+ arrayListEstadisticas.maximo());
        System.out.println("Sumatorio: "+ arrayListEstadisticas.sumatorio());
        System.out.println("Media: " + arrayListEstadisticas.media());
        System.out.println("Moda: "+ arrayListEstadisticas.moda());

    }

    public static void rellenarArrayListDouble(ArrayList<Double> numeros){
        double nums;
        for (int i = 0; i < 50 ; i++) {
            nums = Aleatorios.aleatorio(0,50);
            numeros.add(nums);
        }
    }

}
