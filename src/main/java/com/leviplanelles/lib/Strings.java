package com.leviplanelles.lib;

public class Strings {
    /**
     * Coje la primera letra y la hace mayusculas
     * @param palabra Coje la palabra introducida por el usuario
     * @return Devuelve la misma palabra, pero la primera en mayusculas
     */
    public static String ponerPrimeraLetraEnMayusculas(String palabra) {
        char caracterPrimero = palabra.toUpperCase().charAt(0);
        return caracterPrimero + palabra.substring(1);
    }

    /**
     * Devuelve el total de vocales y consonates de una frase/palabra
     * @param oracion La frase/oracion/palabra que introduzca el usuario
     * @return Devuelve el total de vocales y consonantes
     */
    public static String contarVocalesYConsonantes(String oracion){
        int voc = 0;
        int cons = 0;
        oracion = oracion.toLowerCase();
        for (int i = 0; i <= oracion.length()-1; i++){
            char caracter = oracion.charAt(i);
            switch (caracter){
                case 'a','e','i','o','u' -> voc++;
                case 'b','c','d','f','g','h','j','k','l','m','n','ñ','p','q','r','s','t','v','w','x','y','z' -> cons++;
            }
        }
        return "La frase tiene un total de "+ cons +" consonantes, y un total de "+ voc +" vocales" ;
    }

    /**
     * Cuanta la cantidad de espacios introducidos por el usuario
     * @param oracion Es la palabra/oracion/frase que introduce el usuario
     * @return Devuelve la cantidad de espacios que hay en la frase mediante un string
     */
    public static String contarEspacios(String oracion){
        int numEspacio = 0;
        oracion = oracion.trim();
        for (int i = 0; i<= oracion.length()-1; i++){
            char caracter = oracion.charAt(i);
            switch (caracter){
                case ' '-> numEspacio++;
            }
        }
        return "Hay "+ numEspacio+" unidades de espacio";
    }

    /**
     * Coje una frase que introduzca el usuario y busca la palabra mas larga y la muestra por pantalla junto a su longitud
     * @param frase Es la frase introducida por el usuario
     * @return Devuelve la palabra mas larga de la frase y su cantidad de caracteres
     */
    public static String palabraMasLarga(String frase){
        StringBuilder sb = new StringBuilder();
        frase = frase.toLowerCase();
        String pala;
        int longitud;
        int totalLetras = 0;
        String palabraLarga = "";
        String[] palabra = frase.split("\\s");
        for (int i = 0; i< palabra.length; i++){
            pala = palabra[i];
            longitud = pala.length();
            if (longitud>=totalLetras){
                totalLetras = longitud;
                palabraLarga = pala;
            }
        }
        sb.append("La palabra mas larga introducida es la palabra ").append(palabraLarga).append(" con un total de ").append(totalLetras).append(" caracteres/letras");
        return sb.toString();
    }

    /**
     * Repite las veces que haya introducido el usuario la frase escrita
     * @param frase Es la frase escrita por el usuario
     * @param repeticion Es la cantidad de veces que se va a tener que escribir la frase
     * @return Devuelve la frase escrita las veces indicadas
     */
    public static String repetirFraseXVeces(String frase, int repeticion){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeticion; i++){
            sb.append(frase).append("\n");
        }
        return sb.toString();
    }

    /**
     * Muestra la frase pero cada palabra es en una linea aparte
     * @param frase Es la frase introducida por el usuario y lo muestra
     */
    public static void mostrarPalabrasPorLinea(String frase){
        String[] palabra = frase.split("\\s");
        for (int i = 0; i < palabra.length; i++){
            System.out.println(palabra[i]);
        }
    }

    /**
     * Muestra palabra por palabra las palabras de la frase en una columna, y en la del al lado muetra los caracteres de cada palabra
     * @param frase Es la frase introducida por el usuario.
     */
    public static void mostrarPalabraMasLongitud(String frase){
        String[] palabra = frase.split("\\s");
        String pala;
        for (int i = 0; i< palabra.length; i++){
            pala = palabra[i];
            System.out.printf("%-20s %d\n", palabra[i], pala.length());
        }
    }

    /**
     * Coje la frase introducida por el usuarioo y solo escribe las letras impares
     * @param frase La frese introducida por el usuario
     * @return Devuelve la frase pero solo los caracteres impares
     */
    public static String posicionesImpares(String frase){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frase.length(); i += 2){
            sb.append(frase.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Booleano que te dice si la palabra es Palindroma
     * @param frase La frase introducida por el usuario
     * @return Devuelve true o false depende de si es o no es Polindroma
     */
    public static boolean esPalindroma(String frase){
        StringBuilder sb = new StringBuilder();
        boolean result;
        frase = frase.toLowerCase();
        frase = frase.trim();
        sb.append(frase);
        String revFrase = sb.reverse().toString();
        result = frase.equals(revFrase);
        return result;
    }

    /**
     * Cambia todos los digitos de una frase por *
     * @param frase Frase intrducida por el usuario
     * @return Frase con los numeros con forma de *
     */
    public static String sustituirNumeros (String frase){
        return frase.replaceAll("\\d+","*");
    }

    /**
     * Pide una palabra y te dice la cantidad de vocales que hay
     */
    public static void contarVocales(){
        String palabra = SolicitarCosas.solicitarString("Introduzca una palabra", 1, 75);
        String voc = "aeiouáéíóúàèìòùAEIOUÁÉÍÓÚÀÈÌÒÙ";
        int contVoc = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (voc.indexOf(palabra.charAt(i)) != -1) {
                contVoc++;
            }
        }

        System.out.println("La palabra contiene " + contVoc + " vocales.");
    }
}
