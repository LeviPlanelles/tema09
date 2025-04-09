package com.leviplanelles.Ejercicio11;

import java.util.Objects;

public class Aula {
    private final String codigo;
    private final double metrosCuadrados;

    public Aula(String codigo, double metrosCuadrados) {
        this.codigo = codigo;
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return Objects.equals(codigo, aula.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Aula{" +
                "codigo='" + codigo + '\'' +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}
