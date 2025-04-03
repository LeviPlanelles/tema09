package com.leviplanelles.Ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Paciente {
    public enum Sexo {
        M,F
    }
    public enum MensajeIMC {
        INSUFICIENTE, NORMAL, GRADO1, GRADO2, GRADO3;
    }

    private int identificador = 1;
    private final String nombre;
    private LocalDate fechaNac;
    private Sexo genero;
    private double altura;
    private double peso;

    public Paciente(String nombre, LocalDate fechaNac, Sexo genero, double altura, double peso) {
        identificador++;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }

    public int[] mayorMenor(List<Paciente> pacientes) {
        int[] pacientesMayorMenor = new int[2];
        Paciente auxEdadMenor = pacientes.get(0);
        Paciente auxEdadMayor = pacientes.get(0);
        int idMenor = 0;
        int idMayor = 0;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getFechaNac().isBefore(auxEdadMenor.getFechaNac())) {
                auxEdadMenor = pacientes.get(i);
                idMenor = i;
            }
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getFechaNac().isAfter(auxEdadMayor.getFechaNac())) {
                auxEdadMayor = pacientes.get(i);
                idMayor = i;
            }
        }
        pacientesMayorMenor[0] = idMenor;
        pacientesMayorMenor[1] = idMayor;
        return pacientesMayorMenor;
    }

    public int[] pacientesPorSexo(List<Paciente> pacientes) {
        int male = 0;
        int female = 0;
        for (Paciente paciente : pacientes) {
            switch (paciente.getGenero()) {
                case F -> female++;
                case M -> male++;
            }
        }
        int[] pacientesPorSexo = {male,female};
        return pacientesPorSexo;
    }
    /*
    public MensajeIMC mensajeIMC(Paciente paciente) {
        if ()
    }*/

    public double getIndiceMasaCorporal(Paciente paciente) {
        return paciente.getPeso() / Math.sqrt(paciente.getAltura());
    }

    public int getEdad(Paciente paciente) {
        return Period.between(paciente.getFechaNac(),LocalDate.now()).getYears();
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public Sexo getGenero() {
        return genero;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
