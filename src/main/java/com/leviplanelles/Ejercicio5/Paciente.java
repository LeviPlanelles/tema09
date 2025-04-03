package com.leviplanelles.Ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Paciente {
    public enum Sexo {
        M,F
    }
    public enum MensajeIMC {
        INSUFICIENTE("Peso Insuficiente"),
        NORMAL("Peso Normal"),
        GRADO1("Sobrepeso Grado I"),
        GRADO2("Sobrepeso Grado II"),
        GRADO3("Sobrepeso Grado III"),
        POR_DEFECTO("Por defecto");

        private String texto;
        private MensajeIMC(String texto) {
            this.texto = texto;
        }

        @Override
        public String toString() {
            return texto;
        }
    }
    private static int contadorIdentificadores = 1;
    private int identificador;
    private final String nombre;
    private LocalDate fechaNac;
    private Sexo genero;
    private double altura;
    private double peso;

    public Paciente(String nombre, LocalDate fechaNac, Sexo genero, double altura, double peso) {
        this.identificador = contadorIdentificadores++;
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

    public static int[] pacientesPorSexo(List<Paciente> pacientes) {
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

    public static MensajeIMC mensajeIMC(Paciente paciente) {
        MensajeIMC mensajeIMC = MensajeIMC.POR_DEFECTO;
        double weight = getIndiceMasaCorporal(paciente);
        if (weight < 18.5) {
            mensajeIMC = MensajeIMC.INSUFICIENTE;
        } else if (weight < 24.9) {
            mensajeIMC = MensajeIMC.NORMAL;
        } else if (weight <= 26.9) {
            mensajeIMC = MensajeIMC.GRADO1;
        } else if (weight <= 29.9) {
            mensajeIMC = MensajeIMC.GRADO2;
        } else if (weight > 29.9) {
            mensajeIMC = MensajeIMC.GRADO3;
        }
        return mensajeIMC;
    }

    public static double getIndiceMasaCorporal(Paciente paciente) {
        return paciente.getPeso() / (paciente.getAltura() * paciente.getAltura());
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

    @Override
    public String toString() {
        return "Paciente{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", genero=" + genero +
                ", altura=" + altura +
                ", peso=" + peso +
                "}\n";
    }
}
