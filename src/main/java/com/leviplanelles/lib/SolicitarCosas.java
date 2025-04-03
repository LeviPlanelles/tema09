package com.leviplanelles.lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SolicitarCosas {
    /**
     * Solicita un texto y valida que su longitud esté comprendida entre longitudMinima y longitudMaxima,
     * no esté en blanco ni sea solo espacios.
     */
    public static String solicitarString(String mensaje, int longitudMinima, int longitudMaxima) {
        Scanner scanner = new Scanner(System.in);
        String resultado;
        boolean valido;

        do {
            System.out.println(mensaje);
            resultado = scanner.nextLine();
            valido = resultado != null && !resultado.trim().isEmpty() && resultado.length() >= longitudMinima && resultado.length() <= longitudMaxima;
            if (!valido) {
                if (resultado == null || resultado.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco o ser solo espacios.");
                } else {
                    System.err.printf("La longitud no es correcta, debe estar entre %d - %d\n", longitudMinima, longitudMaxima);
                }
            }
        } while (!valido);
        return resultado.trim();
    }

    /**
     * Solicita al usuario un entero entre numMin y numMax, validando que sea un número válido y no esté en blanco.
     */
    public static Integer solicitarEntero(String mensaje, int numMin, int numMax) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean valido;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            valido = false;
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                num = Integer.parseInt(entrada.trim());
                valido = num >= numMin && num <= numMax;
                if (!valido) {
                    System.err.printf("El número no es válido, debe estar entre %d - %d\n", numMin, numMax);
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número entero.");
            }
        } while (!valido);
        return num;
    }

    public static Integer solicitarEnteroNoLimit(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean valido;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            valido = false;
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                num = Integer.parseInt(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número entero.");
            }
        } while (!valido);
        return num;
    }

    /**
     * Solicita al usuario un double entre numMin y numMax, validando que sea un número válido y no esté en blanco.
     */
    public static Double solicitarDoubles(String mensaje, double numMin, double numMax) {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        boolean valido;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            valido = false;
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                num = Double.parseDouble(entrada.trim());
                valido = num >= numMin && num <= numMax;
                if (!valido) {
                    System.err.printf("El número no es válido, debe estar entre %.2f - %.2f\n", numMin, numMax);
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número decimal o entero.");
            }
        } while (!valido);
        return num;
    }

    /**
     * Solicita un array de doubles, validando cada entrada.
     */
    public static void solicitarDatosArray(double[] array) {
        Scanner input = new Scanner(System.in);
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean valido = false;
            while (!valido) {
                System.out.printf("a[%d]?\n", i);
                String entrada = input.nextLine();
                try {
                    if (entrada.trim().isEmpty()) {
                        System.err.println("La entrada no puede estar en blanco.");
                    } else {
                        array[i] = Double.parseDouble(entrada.trim());
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Entrada no válida. Por favor, introduzca un número decimal o entero.");
                }
            }
        }
    }

    /**
     * Solicita un array de enteros, validando cada entrada.
     */
    public static void solicitarDatosArray(int[] array) {
        Scanner input = new Scanner(System.in);
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean valido = false;
            while (!valido) {
                System.out.printf("a[%d]?\n", i);
                String entrada = input.nextLine();
                try {
                    if (entrada.trim().isEmpty()) {
                        System.err.println("La entrada no puede estar en blanco.");
                    } else {
                        array[i] = Integer.parseInt(entrada.trim());
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Entrada no válida. Por favor, introduzca un número entero.");
                }
            }
        }
    }

    /**
     * Solicita un array de caracteres, validando cada entrada.
     */
    public static void solicitarDatosArray(char[] array) {
        Scanner input = new Scanner(System.in);
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean valido = false;
            while (!valido) {
                System.out.printf("a[%d]?\n", i);
                String entrada = input.nextLine();
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                } else if (entrada.length() == 1) {
                    array[i] = entrada.charAt(0);
                    valido = true;
                } else {
                    System.err.println("Entrada no válida. Por favor, introduzca un único carácter.");
                }
            }
        }
    }

    /**
     * Solicita un entero con un mínimo, validando que no esté en blanco.
     */
    public static int solicitarInt(String msj, int nMin) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean valido;

        do {
            System.out.println(msj);
            String entrada = input.nextLine();
            valido = false;
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                num = Integer.parseInt(entrada.trim());
                valido = num >= nMin;
                if (!valido) {
                    System.err.println("Número introducido incorrecto, debe ser mayor o igual a " + nMin + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número entero.");
            }
        } while (!valido);
        return num;
    }

    /**
     * Solicita un número double, validando que sea un número y no esté en blanco.
     */
    public static double obtenerNumero(String mensaje) {
        Scanner input = new Scanner(System.in);
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensaje);
            String entrada = input.nextLine();
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                numero = Double.parseDouble(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("No válido, por favor introduzca un número.");
            }
        }
        return numero;
    }

    /**
     * Booleano que te dice si el String introducido es un número o cualquier otra cosa.
     */
    public static boolean esNumero(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return false;
        }
        String patron = "^[+-]?\\d*(\\.\\d+)?$";
        return entrada.matches(patron);
    }

    /**
     * Solicita un valor booleano al usuario (true o false), validando que no esté en blanco.
     */
    public static boolean solicitarBoolean(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        boolean resultado = false;

        do {
            System.out.println(mensaje + " (true/false)");
            String entrada = scanner.nextLine();
            if (entrada.trim().isEmpty()) {
                System.err.println("La entrada no puede estar en blanco.");
            } else if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
                resultado = Boolean.parseBoolean(entrada);
                valido = true;
            } else {
                System.err.println("Entrada no válida. Por favor, ingrese 'true' o 'false'.");
            }
        } while (!valido);
        return resultado;
    }

    /**
     * Solicita una fecha al usuario en el formato especificado, validando que no esté en blanco.
     */
    public static LocalDate solicitarFecha(String mensaje, String formatoFormato) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFormato);
        LocalDate fecha = null;
        boolean valido = false;

        do {
            System.out.println(mensaje + " (" + formatoFormato + "):");
            String entrada = scanner.nextLine();
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                fecha = LocalDate.parse(entrada.trim(), formatter);
                valido = true;
            } catch (DateTimeParseException e) {
                System.err.println("Fecha no válida. Por favor, introduzca la fecha en el formato " + formatoFormato + ".");
            }
        } while (!valido);
        return fecha;
    }

    /**
     * Solicita al usuario un double con un número mínimo, validando que no esté en blanco.
     */
    public static Double solicitarDoubleConMinimo(String mensaje, double numeroMinimo) {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        boolean valido;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            valido = false;
            try {
                if (entrada.trim().isEmpty()) {
                    System.err.println("La entrada no puede estar en blanco.");
                    continue;
                }
                num = Double.parseDouble(entrada.trim());
                valido = num >= numeroMinimo;
                if (!valido) {
                    System.err.printf("El número debe ser mayor o igual a %.2f\n", numeroMinimo);
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número válido.");
            }
        } while (!valido);
        return num;
    }

    /**
     * Solicita un texto al usuario sin límite de longitud, validando que no esté en blanco.
     */
    public static String solicitarStringSinLimite(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String resultado;
        boolean valido;

        do {
            System.out.println(mensaje);
            resultado = scanner.nextLine();
            valido = !resultado.trim().isEmpty();
            if (!valido) {
                System.err.println("La entrada no puede estar en blanco o ser solo espacios.");
            }
        } while (!valido);
        return resultado.trim();
    }

    /**
     * Solicita un solo carácter al usuario, validando que no esté en blanco y sea un único carácter.
     */
    public static char solicitarCaracter(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        char caracter = '\0';
        boolean valido = false;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            if (entrada.trim().isEmpty()) {
                System.err.println("La entrada no puede estar en blanco.");
            } else if (entrada.length() == 1) {
                caracter = entrada.charAt(0);
                valido = true;
            } else {
                System.err.println("Entrada no válida. Por favor, ingrese un único carácter.");
            }
        } while (!valido);
        return caracter;
    }
}
