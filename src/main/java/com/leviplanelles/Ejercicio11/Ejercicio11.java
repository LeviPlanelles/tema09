package com.leviplanelles.Ejercicio11;

import com.leviplanelles.lib.IO;

import java.sql.SQLOutput;
import java.util.List;

public class Ejercicio11 {
    private static Centro centro = new Centro();
    public static void main(String[] args) {
        menuPrincipal();
        System.out.println(centro);
    }
    public static void menuPrincipal() {
        int choice;
        do {
            System.out.println("----------------------");
            System.out.println("- GESTIÓN DEL CENTRO -");
            System.out.println("----------------------");
            System.out.println();
            System.out.println("1. Alta alumno");
            System.out.println("2. Alta asignaturas");
            System.out.println("3. Alta grupos");
            System.out.println("4. Alta aulas");
            System.out.println("5. Alta profesores");
            System.out.println("6. Filtro de datos");
            System.out.println("----------------------");
            System.out.println("0. Salir");
            System.out.println();

            choice = IO.solicitarInt("Elige una opción: ", 0,6);
            switch (choice) {
                case 0 -> {}
                case 1 -> {
                    altaAlumno();
                }
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
            }
        }while (choice != 0);
    }
    public static void altaAlumno() {
        String nombre = IO.solicitarString("Nombre: ");
        int contador = 1;
        for (Grupo grupo : centro.getGrupos()) {
            System.out.println(String.valueOf(contador) + " " + grupo.getNombre());
            contador++;
        }
        int idGrupo = IO.solicitarInt("Elige un grupo (nombre): ",1,5);
        String nombreGrupo = switch (idGrupo) {
            case 1 -> "DAM";
            case 2 -> "DAW";
            case 3 -> "ASIR";
            case 4 -> "SMX";
            case 5 -> "ENFERMERIA";
            default -> throw new IllegalStateException("Unexpected value: " + idGrupo);
        };
        Grupo grupo = centro.buscarGrupoNombre(nombreGrupo);
        List<Asignatura> asignaturas = centro.generarAsignarutasAuto(3);
        centro.getAlumnos().add(centro.altaAlumno(nombreGrupo,grupo,asignaturas));
    }

    public static void altaAsignaruta() {
        String nombre = IO.solicitarString("Nombre: ");
        int contador = 0;
        for (Profesor profesor : centro.getProfesores()) {
            System.out.println(profesor.getNombre());
            contador++;
        }
        String nombreProfe = IO.solicitarString("Nombre del profesor: ");
        Profesor profe = null;
        for (Profesor profesor : centro.getProfesores()) {
            if (nombreProfe.equals(profesor.getNombre())) {
                profe = profesor;
            }
        }
        centro.getAsignaturas().add(centro.altaAsignatura(nombre,profe));
    }
}
