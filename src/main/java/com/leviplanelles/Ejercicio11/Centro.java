package com.leviplanelles.Ejercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Centro {
    private final List<Aula> aulas;
    private List<Alumno> alumnos;
    private List<Profesor> profesores;
    private List<Grupo> grupos;
    private List<Asignatura> asignaturas;

    public Centro() {
        this.aulas = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.profesores = aniadirProfesores(10);
        this.grupos = aniadirGrupos();
        this.asignaturas = new ArrayList<>();
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public Alumno altaAlumno(String nombre, Grupo grupo, List<Asignatura> asignaturas) {
        return new Alumno(nombre,grupo,asignaturas);
    }

    public Asignatura altaAsignatura(String nombre, Profesor profesor) {
        return new Asignatura(nombre, profesor);
    }

    public boolean altaProfesor(String dni, String nombre, int sueldo) {
        profesores.add(new Profesor(dni, nombre, sueldo));
        return true;
    }

    public Grupo altaGrupo(String codigo, String nombre, Aula aula) {
        for (Grupo grupo : grupos) {
            if (codigo.equals(grupo.getCodigo())) {
                throw new RuntimeException("Ya existe este grupo");
            }
        }
        return new Grupo(codigo, nombre, aula);
    }

    public boolean altaAula(String codigo, double metrosCuadrados) {
        for (Aula aula : aulas) {
            if (codigo.equals(aula.getCodigo())) {
                return false;
            }
        }
        aulas.add(new Aula(codigo, metrosCuadrados));
        return true;
    }

    public List<Asignatura> generarAsignarutasAuto(int cantidad) {
        Random random = new Random();
        List<Asignatura> asignaturas1 = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String codigo = "SUBJ-" + random.nextInt(100,1001) + String.valueOf(random.nextInt(65,91));
            String[] nombres = {
                    "Lucas", "Valentina", "Mateo", "Sofía", "Liam",
                    "Isabella", "Noah", "Camila", "Thiago", "Martina",
                    "Benjamín", "Emma", "Alejandro", "Mía", "Daniel",
                    "Olivia", "Julián", "Abigail", "Gabriel", "Victoria"
            };
            String[] nombreAsignaturas = {
                    "FOL", "INGLES", "PROGRAMACION", "BASE DE DATOS", "LENGUAJE DE MARCAS", "ENTORNOS", "SISTEMAS"
            };
            String dni = random.nextInt(500000,600000) + String.valueOf(random.nextInt(65,91));
            Profesor profesor = new Profesor(dni, nombres[random.nextInt(0, nombres.length)], random.nextInt(600,3000));
            asignaturas1.add(new Asignatura(nombreAsignaturas[random.nextInt(0, nombreAsignaturas.length)],profesor));
        }
        return asignaturas1;
    }

    private ArrayList<Grupo> aniadirGrupos() {
        Random random = new Random();
        ArrayList<Grupo> gruposArr = new ArrayList<>();
        String[] nombres = {"DAM", "DAW", "ASIR", "SMX", "ENFERMERIA"};
        for (int i = 0; i < nombres.length; i++) {
            String codigo = "GRP-" + random.nextInt(100,1001) + String.valueOf(random.nextInt(65,91));
            String codigoAula = "CLASS-" + random.nextInt(100,1001) + String.valueOf(random.nextInt(65,91));
            Aula aula = new Aula(codigoAula, random.nextDouble(10,30));
            gruposArr.add(new Grupo(codigo,nombres[i],aula));
        }
        return gruposArr;
    }

    private ArrayList<Profesor> aniadirProfesores(int cantidad) {
        Random random = new Random();
        ArrayList<Profesor> profesorArrayList = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String dni = random.nextInt(60000,7000000) + String.valueOf(random.nextInt(65,91));
            String[] nombres = {
                    "Lucas", "Valentina", "Mateo", "Sofía", "Liam",
                    "Isabella", "Noah", "Camila", "Thiago", "Martina",
                    "Benjamín", "Emma", "Alejandro", "Mía", "Daniel",
                    "Olivia", "Julián", "Abigail", "Gabriel", "Victoria"
            };
            int sueldo = random.nextInt(500,3000);
            profesorArrayList.add(new Profesor(dni,nombres[random.nextInt(0, nombres.length)], sueldo));
        }
        return profesorArrayList;
    }

    public Grupo buscarGrupoNombre(String nombre) throws RuntimeException{
        for (Grupo grupo : grupos)  {
            if (nombre.equals(grupo.getNombre())) {
                return grupo;
            }
        }
        throw new RuntimeException("No se ha encontrado ese grupo");
    }

    @Override
    public String toString() {
        return "Centro{" +
                "aulas=" + aulas +
                ", alumnos=" + alumnos +
                ", profesores=" + profesores +
                ", grupos=" + grupos +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
