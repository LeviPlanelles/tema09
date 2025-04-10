package com.leviplanelles.lib;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class IO {
    public static Scanner scanner = new Scanner(System.in);
    /**
     * Solicita un texto y valida su longitud este comprendida entre lMin y lMax
     * @param msj Mensaje que se mostrará la usuario
     * @param lMin Minimo de carácteres
     * @param lMax Máximo de carácteres
     * @return Texto leido validado
     */
    public static String solicitarString(String msj) {
        String texto = "";
        boolean valido = false;
        System.out.print(msj);
        do {
            texto = scanner.nextLine();
            if (!texto.trim().isEmpty()) {
                valido = true;
            } else {
                System.err.println("No has puesto nada...");
            }
        } while (!valido);
        return texto;
    }

    /**
     * Solicita un texto y valida su longitud este comprendida entre nMin y nMax, te devuelve el numero puesto
     * @param msj El mensaje con el que se solicita el número
     * @param nMin Número mínimo permitido
     * @param nMax Número máximo permitido
     * @return devuelve el número introducido
     */
    public static int solicitarInt(String msj,int nMin, int nMax) {
        int num = 0;
        boolean valido = false;
        System.out.print(msj);
        do {
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= nMin && num <= nMax) {
                    valido = true;
                }else {
                    System.err.println("El número tiene que estar comprendido entre el " + nMin + " y " + nMax + ".");
                }
            } catch (NumberFormatException nfe) {
                valido = false;
                System.err.println("Formato invalido.");
            }
        }while (!valido);

        return num;
    }

    public static double solicitarDouble(String msj) {
        double num = 0;
        boolean valido = false;
        System.out.print(msj);
        do {
            try {
                num = Double.parseDouble(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException nfe) {
                valido = false;
                System.err.println("Formato invalido.");
            }
        }while (!valido);
        return num;
    }

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        String vocales = "aáàAÁÀeéèEÉÈiíìIÍÌoóòOÓÒuúùUÚÙ";
        return vocales.indexOf(c) >= 0;
    }
    public static boolean esConsonante(char c) {
        return Character.isLetter(c) && !esVocal(c);
    }
    public static int contarConsonantes(String texto) {
        int consonantes = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (esConsonante(texto.charAt(i))) {
                consonantes++;
            }
        }
        return consonantes;
    }
    public static int contarVocales(String texto) {
        int vocales = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (esVocal(texto.charAt(i))) {
                vocales++;
            }
        }
        return vocales;
    }
    public static int contarPalabras(String texto) {
        texto = texto.trim();
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }
    public static double aleatorio(double valorMin, double valorMax) {
        Random random = new Random();
        return valorMin + random.nextDouble() * (valorMax - valorMin);
    }
    public static int[] crearArrayEnteros(int tamanio, int numMax) {
        return crearArrayEnteros(tamanio,0,numMax);
    }
    public static int[] crearArrayEnteros(int tamanio,int numMin, int numMax) {
        Random random = new Random();
        int[] enteros = new int[tamanio];
        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = random.nextInt(numMin, numMax + 1);
        }
        return enteros;
    }
    public static void visualizarArrayEnteros(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    /**
     * Funcion que te invierte un array
     * @param arr un array
     * @return el array invertido
     */
    public static int[] invertirArr(int[] arr) {
        int[] arrInvertido = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInvertido[i] = arr[(arr.length-1)-i];
        }
        return arrInvertido;
    }
    public static void close() {
        scanner.close();
    }
    public static int multiplosDeNum(int[] numeros,int multiplo) {
        int contador = 0;
        for (int numero : numeros) {
            if (numero % multiplo == 0) {
                contador++;
            }
        }
        return contador;
    }
    public static int[] arrayMultiplosDeNum(int[] numeros,int multiplo) {
        int tamanio = multiplosDeNum(numeros,multiplo);
        if (tamanio == 0) {
            return null;
        }
        int[] multiplos5 = new int[tamanio];
        int contador = 0;
        for (int numero : numeros) {
            if (numero % multiplo == 0) {
                multiplos5[contador] = numero;
                contador++;
            }
        }
        return multiplos5;
    }
    public static double[][] crearMatrizAleatoria(int filas, int columnas, double valorMin, double valorMax) {
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio(valorMin,valorMax);
            }
        }
        return matriz;
    }
    public static int[][] crearMatrizAleatoria(int filas, int columnas, int valorMin, int valorMax) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(valorMin,valorMax+1);
            }
        }
        return matriz;
    }
    public static String matrizToString(double[][] matriz, int decimales, int padding) {
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz) {
            for (double valor : fila) {
                sb.append(valor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static int determinarLongitudMaxima(double[][] matriz, int decimales) {
        int longitudMaxima = 0;
        for (double[] fila : matriz) {
            int longitud = determinarLongitudMaxima(fila,decimales);
            if (longitud > longitudMaxima) {
                longitudMaxima = longitud;
            }
        }
        return longitudMaxima;
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
}
