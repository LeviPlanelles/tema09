package com.leviplanelles.Ejercicio11;

import java.util.List;
import java.util.Objects;

public class Alumno {
    private static int contadorId = 0;
    private final int identificador;
    private final String nombre;
    private Grupo grupo;
    private List<Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo, List<Asignatura> asignaturas) {
        this.identificador = ++contadorId;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return identificador == alumno.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
