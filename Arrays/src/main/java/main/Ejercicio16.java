package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Ejercicio16 ej16 = new Ejercicio16();
        ej16.ejercicio16(sc, r);
    }

    public void ejercicio16(Scanner sc, Random r) {
        int[] notasAlumnos = new int[15];
        double media1 = 0;
        double media2 = 0;
        double media3 = 0;

        for (int i = 0; i < notasAlumnos.length; i++) {
            notasAlumnos[i] = r.nextInt(10);
        }
        for (int i = 0; i < notasAlumnos.length; i++) {
            if (i < 5) {
                media1 += notasAlumnos[i];
            } else if (i < 10) {
                media2 += notasAlumnos[i];
            } else {
                media3 += notasAlumnos[i];
            }
        }
        System.out.println("Escriba el número del alumno cuya nota media quiere mirar (1-5)");
        int numeroAlumno = sc.nextInt();
        double mediaAlumno = 0;
        switch (numeroAlumno) {
            case 1:
                for (int i = 0; i < notasAlumnos.length; i++) {
                    if ((i+1)%5 == 1) {
                        mediaAlumno += notasAlumnos[i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < notasAlumnos.length; i++) {
                    if ((i+1)%5 == 2) {
                        mediaAlumno += notasAlumnos[i];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < notasAlumnos.length; i++) {
                    if ((i+1)%5 == 3) {
                        mediaAlumno += notasAlumnos[i];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < notasAlumnos.length; i++) {
                    if ((i+1)%5 == 4) {
                        mediaAlumno += notasAlumnos[i];
                    }
                }
                break;
            case 5:
                for (int i = 0; i < notasAlumnos.length; i++) {
                    if ((i+1)%5 == 0) {
                        mediaAlumno += notasAlumnos[i];
                    }
                }
                break;
            default:
                System.out.println("El alumno seleccionado no existe");
                break;
        }
        mediaAlumno = mediaAlumno/3;
        media1 = media1/5;
        media2 = media2/5;
        media3 = media3/5;

        System.out.println("Las medias de los trimestres son " + media1 + ", " + media2 + " y "
                + media3 + ", y la media del alumno " + numeroAlumno + " es " + mediaAlumno);
    }
}
