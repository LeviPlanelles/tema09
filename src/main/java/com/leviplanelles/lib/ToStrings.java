package com.leviplanelles.lib;

public class ToStrings {
    /**
     * Hace que un array double pase a ser un string
     *
     * @param array         Array double que queremos pasar a string
     * @param cantDecimales la cantidad de decimales que queremos mostrar
     * @return Devuelve el array double pero como string
     */
    public static String arrayToString(double[] array, int cantDecimales) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        String formato = "%." + cantDecimales + "f";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                coma = "";
            }
            sb.append(espacio).append(String.format(formato, array[i])).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Hace que un array entero pase a ser un string
     *
     * @param array Array entero que queremos pasar a string
     * @return Devuelve el array entero pero como string
     */
    public static String arrayToString(int[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                coma = "";
            }
            sb.append(espacio).append(array[i]).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String arrayToString(String[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                coma = "";
            }
            sb.append(espacio).append(array[i]).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Pasa de un array double a ponerlo en x columnas con sus decimales y con un pading de 2
     *
     * @param array     El array double que queremos
     * @param decimales La cantidad de decimales
     * @param columnas  La cantidad de columnas
     * @return Devuelve el array como string con su padding de 2 y sus respectivas columnas y decimales
     */
    public static String arrayToString(double[] array, int decimales, int columnas) {
        return arrayToString(array, decimales, columnas, 2);
    }

    /**
     * Determina la longitud mas larga de un array
     *
     * @param array     Es el array el cual queremos saber la longitud mas larga
     * @param decimales Es la cantidad de decimales la cual queremos formatear
     * @return
     */
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
     * Muestra un array como un string con las caracteristicas que se le indican
     *
     * @param array     Es el array en double que queremos mostrar
     * @param decimales La cantidad de decimales que queremos mostrar
     * @param columnas  La cantidad de columnas que queremos
     * @param padding   Es el padding que queremos que tengan entre las columnas
     * @return
     */
    public static String arrayToString(double[] array, int decimales, int columnas, int padding) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int tamanyoColumna = determinarLongitudMaxima(array, decimales) + padding;
        String formato = "%" + tamanyoColumna + "." + decimales + "f";
        String formatoColumna = "%-" + tamanyoColumna + "s";
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format(formatoColumna, String.format(formato, array[i])));
            if ((i + 1) % columnas == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Muestra una matriz bidimensional con los decimales y con el padding que le indiquemos
     *
     * @param matriz
     * @param decimales
     * @param padding
     * @return
     */
    public static String matrizToString(double[][] matriz, int decimales, int padding) {
        int anchoColumna = Matrices.determinarLongitudMaxima(matriz, decimales);
        String formato = "%" + anchoColumna + "." + decimales + "f";
        String formatoPadding = "%" + (anchoColumna + padding) + "s";
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz) {
            for (double valor : fila) {
                sb.append(String.format(formatoPadding, String.format(formato, valor)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String enumToString(Class enumClass) {
        Enum[] valores = (Enum[]) enumClass.getEnumConstants();

        StringBuilder resultado = new StringBuilder();
        resultado.append("[");
        for (int i = 0; i < valores.length; i++) {
            resultado.append(valores[i]);
            if (i < valores.length - 1) {
                resultado.append(", ");
            }
        }
        resultado.append("]");

        return resultado.toString();
    }
}