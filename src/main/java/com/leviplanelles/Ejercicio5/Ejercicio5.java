package com.leviplanelles.Ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = new Paciente("Levi", LocalDate.of(1980,02,12), Paciente.Sexo.F,1.63,57);
        Paciente paciente1 = new Paciente("Levi1", LocalDate.of(1990,03,7), Paciente.Sexo.F,1.74,60.5);
        Paciente paciente2 = new Paciente("Levi2", LocalDate.of(1967,03,20), Paciente.Sexo.F,1.62,50.8);
        Paciente paciente3 = new Paciente("Levi3", LocalDate.of(1972,04,20), Paciente.Sexo.M,1.78,72.5);
        Paciente paciente4 = new Paciente("Levi4", LocalDate.of(1960,02,29), Paciente.Sexo.M,1.8,82.5);

        pacienteList.add(paciente);
        pacienteList.add(paciente1);
        pacienteList.add(paciente2);
        pacienteList.add(paciente3);
        pacienteList.add(paciente4);
        int[] mayorMenor = Paciente.mayorMenor(pacienteList);
        int indiceMayor = mayorMenor[0];
        int indiceMenor = mayorMenor[1];
        System.out.printf("PACIENTE MAYOR Edad: %d Sexo: %s\n",pacienteList.get(indiceMayor).getEdad(),pacienteList.get(indiceMayor).getGenero());
        System.out.printf("PACIENTE MENOR Edad: %d Sexo: %s\n",pacienteList.get(indiceMenor).getEdad(),pacienteList.get(indiceMenor).getGenero());
        System.out.println();

        int[] porSexo = Paciente.pacientesPorSexo(pacienteList);
        System.out.println("Cantidad de pacientes por sexos:");
        System.out.printf("Hombres: %d  Mujeres %d\n",porSexo[0],porSexo[1]);
        System.out.println();

        for (Paciente p : pacienteList) {
            System.out.printf("Paciente número %d: %s\n",p.getIdentificador(), p.mensajeIMC());
        }

    }
}
