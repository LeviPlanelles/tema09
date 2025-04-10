package com.leviplanelles.Ejercicio11;

import com.leviplanelles.lib.IO;

import java.sql.SQLOutput;
import java.util.*;

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
                case 2 -> {
                    altaAsignaruta();
                }
                case 3 -> {
                    altaGrupo();
                }
                case 4 -> {
                    altaAula();
                }
                case 5 -> {
                    altaProfesor();
                }
                case 6 -> {
                    menuFiltro();
                }
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
        for (Profesor profesor : centro.getProfesores()) {
            System.out.println(profesor.getNombre());
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
    public static void altaGrupo() {
        String codigo = IO.solicitarString("Código del nuevo grupo: ");
        String nombre = IO.solicitarString("Nombre del grupo: ");
        for (Aula aula : centro.getAulas()) {
            System.out.println(aula);
        }
        String codAula = IO.solicitarString("Selecciona un aula (código): ");
        for (Aula aula : centro.getAulas()) {
            if (codigo.equals(aula.getCodigo())) {
                centro.getGrupos().add(centro.altaGrupo(codigo,nombre,aula));
            }
        }
    }
    public static void altaAula() {
        String codigo = IO.solicitarString("Código de la nueva aula: ");
        double metrosCuadrados = IO.solicitarDouble("Metros cuadrados del aula: ");
        centro.getAulas().add(centro.altaAula(codigo,metrosCuadrados));
    }
    public static void altaProfesor() {
        String dni = IO.solicitarString("DNI: ");
        String nombre = IO.solicitarString("nombre: ");
        int sueldo = IO.solicitarInt("Sueldo: ",500,3000);
        centro.getProfesores().add(centro.altaProfesor(dni,nombre,sueldo));
    }

    public static void menuFiltro(){
        System.out.println("1. Mostrar alumnos por grupo");
        System.out.println("2. Mostrar alumnos por profesor");
        System.out.println("3. Mostrar centro");
        System.out.println("---------------------------------");
        System.out.println("0. Volver al menu principal");

        int choice = IO.solicitarInt("Elije: ",0,3);
        switch (choice) {
            case 0 -> {}
            case 1 -> {
                porGrupo();
            }
            case 2 -> {
                porProfesor();
            }
            case 3-> System.out.println(centro);
        }

    }
    public static void porGrupo(){
        Map<Grupo,ArrayList<Alumno>> mapaGrupos = centro.porGrupo();
        for (Map.Entry<Grupo, ArrayList<Alumno>> entrada : mapaGrupos.entrySet()) {
            Grupo grupo = entrada.getKey();
            ArrayList<Alumno> alumnos = entrada.getValue();

            System.out.println("Grupo: " + grupo);

            for (Alumno alumno : alumnos) {
                System.out.println("  - " + alumno);
            }
        }
    }
    public static void porProfesor() {
        System.out.println("Lo siento no tengo ni idea.");
    }
}
