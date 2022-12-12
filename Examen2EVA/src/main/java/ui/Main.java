package ui;

import modelo.Asignatura;
import servicios.Servicios;
import ui.common.Constantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Servicios servicios = new Servicios();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println(Constantes.MENU_INICIAL);
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    matricularAlumno(sc);
                    break;
                case 2:
                    addNota(sc);
                    break;
                case 3:
                    System.out.println(servicios.listaProfesoresOrdenada());
                    break;
                case 4:
                    calcularNotaMedia(sc);
                    break;
                default:
            }
        } while (opcion != 0);

    }

    private static void matricularAlumno(Scanner sc) {
        Servicios servicios = new Servicios();
        System.out.println(Constantes.INTRODUCE_EL_DNI_DEL_ALUMNO_A_MATRICULAR);
        String dni = sc.nextLine();
        System.out.println(Constantes.INTRODUCE_EL_NOMBRE_DE_LA_ASIGNATURA);
        String asignatura = sc.nextLine();
        if (servicios.matricularAlumno(dni, asignatura)) {
            System.out.println(Constantes.ALUMNO_MATRICULADO_CON_ÉXITO_EN + asignatura);
        } else System.out.println(Constantes.NO_SE_PUDO_MATRICULAR_AL_ALUMNO);

    }

    private static void addNota(Scanner sc) {
        Servicios servicios = new Servicios();
        System.out.println("Introduce el dni del alumno al que añadir nota");
        String dni = sc.nextLine();
        System.out.println(Constantes.INTRODUCE_EL_NOMBRE_DE_LA_ASIGNATURA);
        String asignatura = sc.nextLine();
        System.out.println("Introduce la nota del alumno");
        int nota = sc.nextInt();
        sc.nextLine();
        Asignatura a = new Asignatura(asignatura,nota);
        if (servicios.addNota(dni, a)) {
            System.out.println("Nota añadida con éxito");
        } else System.out.println("No se pudo añadir la nota");
    }

    private static void calcularNotaMedia(Scanner sc) {
        Servicios servicios = new Servicios();
        System.out.println("Introduce el dni del alumno del que sacar la nota media");
        String dni = sc.nextLine();
        if (servicios.notaMedia(dni) >= 0) {
            System.out.println("La nota del alumno con dni " + dni + " es " + servicios.notaMedia(dni));
        } else System.out.println("No se pudo calcular la nota media");
    }
}