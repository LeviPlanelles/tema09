package com.leviplanelles.lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fechas {
    /**
     * Calcula la edad de una persona a traves de su fecha completa de nacimiento
     * @param fechaNacimiento La fecha de nacimiento del usuario indicada en el main
     * @return Devuelve los años
     */
    public static int calcularEdad(LocalDate fechaNacimiento){
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(fechaNacimiento, hoy);
        return period.getYears();
    }

    /**
     * Indica tu edad en dias
     * @param fechaNacimiento La fecha de nacimiento introducida por el usuario
     * @return Devuelve la cantidad de dias de vida desde que nacio hasta ahora con un long
     */
    public static long calcularEdadDias(LocalDate fechaNacimiento){
        LocalDate hoy = LocalDate.now();
        long dias = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
        return dias;
    }

    /**
     * Resta la cantidad de dias introducidos por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que restar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate restarDias(LocalDate fecha){
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de dias que quiera restar con un máximo de 1095 dias dias(3 años)", 1, 1096);
        return fecha.minusDays(cosaSumar);
    }
    /**
     * Suma la cantidad de dias introducido por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que sumar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate sumarDias(LocalDate fecha){
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de dias que quiera sumar con un máximo de 1095 dias dias(3 años)", 1, 1096);
        return fecha.plusDays(cosaSumar);
    }

    /**
     * Resta los meses indicados por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que restar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate restarMeses(LocalDate fecha){
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de meses que quiera restar con un máximo de 50 meses", 1, 51);
        return fecha.minusMonths(cosaSumar);
    }

    /**
     * Modifica la fecha a una que escriba el usuario
     * @return Devuelve la fecha introducida por el usuario
     */
    public static LocalDate modificacionFecha(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaMod = SolicitarCosas.solicitarString("Indique la fecha que quieras poner", 1, 11);
        return LocalDate.parse(fechaMod, dateTimeFormatter);
    }


    /**
     * Suma los años indicacos por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que sumar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate sumarAnyos(LocalDate fecha) {
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de años que quiera sumar con un máximo de 100 años", 1, 101);
        return fecha.plusYears(cosaSumar);
    }

    /**
     * Resta los años indicados por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que restar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate restarAnyo(LocalDate fecha){
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de años que quiera restar con un máximo de 100 años", 1, 101);
        return fecha.minusYears(cosaSumar);
    }

    /**
     * Suma la cantidad de meses endicados por el usuario
     * @param fecha Es la fecha indicada la cual le tendremos que sumar a esta
     * @return Devuelve la nueva fecha
     */
    public static LocalDate sumarMeses(LocalDate fecha){
        int cosaSumar = SolicitarCosas.solicitarEntero("Indique la cantidad de meses que quiera sumar con un máximo de 50 meses", 1, 51);
        return fecha.plusMonths(cosaSumar);
    }
}
