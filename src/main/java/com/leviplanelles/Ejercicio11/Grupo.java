package com.leviplanelles.Ejercicio11;

import java.util.Objects;

public class Grupo {
    private final String codigo;
    private final String nombre;
    private Aula aula;

    public Grupo(String codigo, String nombre, Aula aula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.aula = aula;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(codigo, grupo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aula=" + aula +
                '}';
    }
}
