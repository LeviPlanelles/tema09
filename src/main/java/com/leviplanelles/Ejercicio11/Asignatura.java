package com.leviplanelles.Ejercicio11;

import java.util.Objects;
import java.util.Random;

public class Asignatura {
    Random random = new Random();
    private final String codigo;
    private final String nombre;
    private Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.codigo = "SUBJ-" + random.nextInt(100,1001) + String.valueOf(random.nextInt(65,91));;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
