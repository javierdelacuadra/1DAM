package main;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int numeroEjercicio = 0;

        do {
            System.out.println("Elija el ejercicio que quiere probar (1 o 2)");
            numeroEjercicio = sc.nextInt();
            if (numeroEjercicio == 1) {
                Ejercicio1 ejercicio1 = new Ejercicio1();
                ejercicio1.ejercicio1(r);
                System.out.println();
            }
            else if (numeroEjercicio == 2) {
                Ejercicio2 ejercicio2 = new Ejercicio2();
                ejercicio2.ejercicio2(sc);
            }
            else {
                System.out.println("Ese número de ejercicio no está disponible");
            }
        } while (numeroEjercicio == 1 || numeroEjercicio == 2);

    }
}
