package com.leviplanelles.lib;

import java.util.Arrays;

public class ArrayCosas {
    private static boolean relleno = false;
    /**
     * Suma arrays distintos en la misma posicion
     * @param array1 El primera array
     * @param array2 El array que le queremos suamr al primer array
     * @return Devuelve un array con el resultado de la suma
     */
    public static int[] sumarArrays(int[] array1, int[] array2){
        int[] resultadoSuma = new int[array1.length];
        for (int i = 0; i < resultadoSuma.length ; i++) {
            resultadoSuma[i] = array1[i] + array2[i];
        }
        return resultadoSuma;
    }

    /**
     * Divide arrays distintos en la misma posicion
     * @param array1 El primer array
     * @param array2 El array con el cual quieres dividir
     * @return Devuelve un array con los resultados de la division
     */
    public static float[] dividirArrays(int[] array1, int[] array2){
        float[] resultadoDivision = new float[array1.length];
        for (int i = 0; i < resultadoDivision.length ; i++) {
            resultadoDivision[i] = (float) array1[i] / array2[i];
        }
        return resultadoDivision;
    }

    /**
     * Booleano que comprueba si un numero esta en un array especificado
     * @param array Es el array en el cual queremos mirar si esta en numero introducido
     * @param numero Es el numero introducido
     * @return Devuelve un true o false
     */
    public static boolean comprobarSiEstaElNumero(double[] array, double numero) {
        boolean coincide = false;
        for (double num : array) {
            if (num == numero){
                coincide = true;
                break;
            }
        }
        return coincide;
    }

    /**
     * Devuelve los arrays multiplos del numero indicado
     * @param num Es el array
     * @param multiplo Es el numero indicado para que sea multiplo
     * @return
     */
    public static int[] arrayMultiplosDeNum(int[] num, int multiplo) {
        int tamanyo = multiplosDeNum(num,multiplo);
        int[] multiplos = new int[tamanyo];
        int contador = 0;
        for (int numero : num) {
            if (numero % multiplo == 0) {
                multiplos[contador] = numero;
                contador++;
            }
        }
        return multiplos;
    }

    /**
     * Devuelve los multiplos de un numero
     * @param num Es el array
     * @param multiplo Es el numero al que tiene que ser multiplo
     * @return
     */
    public static int multiplosDeNum(int[] num, int multiplo) {
        int conta = 0;
        for (int numero : num) {
            if (numero % multiplo == 0) {
                conta++;
            }
        }
        return conta;
    }

    /**
     * Muestra los arrays pares
     * @param array Es el array que quieres mostrar
     */
    public static void visualizarParesDeArray(int[] array) {
        int[] arrayPares = arrayMultiplosDeNum(array,2);
        System.out.println(Arrays.toString(arrayPares));
    }

    /**
     * Coje un array V y lo pasa a otro array P de forma inversa, es decir, el primero en el ultimo, etc
     * @param array Es el array al que le quieres dar vuelta
     * @return Devuelve el array de forma inversa
     */
    public static int[] ordenarArrayInversamente(int[] array){
        int cuenta = 0;
        int[] arrayP = new int[array.length];
        for (int i = array.length-1; i >= 0 ; i--) {
            arrayP[cuenta] = array[i];
            cuenta++;
        }
        return arrayP;
    }

    /**
     * Cuenta la cantidad de pares que hay en un array
     * @param array El array el cual queremos saber los pares
     * @return Devuelve la cantidad de pares
     */
    public static int contarPares(int[] array){
        int cuenta = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                cuenta += 1;
            }
        }
        return cuenta;
    }

    /**
     * Devuelve el arrayP con solo los pares
     * @param array Es el array introducido el cual solo quieres saber los pares
     * @return Devuelve el arrayP el cual solo hay pares
     */
    public static int[] arrayConLosParesSolo(int[] array){
        int j = 0;
        int[] arrayP = new int[contarPares(array)];
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                arrayP[j] = array[i];
                j++;
            }
        }
        return arrayP;
    }

    public static int determinarLongitudMaxima(double[] array, int decimales) {
        int longitudMaxima = 0;
        String formato = "%." + decimales + "f";
        for (double numero : array) {
            int longitudActual = String.format(formato, numero).length();
            if (longitudMaxima < longitudActual) {
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }

    /**
     * Multiplica arrays y lo muestra como matriz
     * @param arrayFilas Es el array que queremos como fila
     * @param arrayColumnas El array que queremos como columna
     * @return Una matriz con el resultado de las multiplicaciones entre las filas y las columnas
     */
    public static int[][] multiplicacionArraysMatriz(int[] arrayFilas, int[] arrayColumnas){
        int[][] matriz = new int[arrayFilas.length][arrayColumnas.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = arrayFilas[i] * arrayColumnas[j];
            }
        }
        return matriz;
    }
}
