package main;

import servicios.Opcion1Ejercicio1;
import servicios.Opcion1Ejercicio2;
import servicios.Opcion2Ejercicio1;
import servicios.Opcion2Ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int numeroEjercicio = 1;

        while (numeroEjercicio != 0) {
            System.out.println("Elija un número de ejercicio (1-4) o escriba 0 para salir");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 1:
                    Opcion1Ejercicio1 opcion1Ejercicio1 = new Opcion1Ejercicio1();
                    opcion1Ejercicio1.opcion1Ej1(r);
                    break;
                case 2:
                    Opcion1Ejercicio2 opcion1Ejercicio2 = new Opcion1Ejercicio2();
                    opcion1Ejercicio2.opcion1Ej2();
                    break;
                case 3:
                    Opcion2Ejercicio1 opcion2Ejercicio1 = new Opcion2Ejercicio1();
                    opcion2Ejercicio1.opcion2Ej1();
                    break;
                case 4:
                    Opcion2Ejercicio2 opcion2Ejercicio2 = new Opcion2Ejercicio2();
                    opcion2Ejercicio2.opcion2Ej2(r);
                    break;
                case 0:
                    System.out.println("Ha salido del programa");
                    break;
                default:
                    System.out.println("Opción no disponible");
                    break;
            }
            System.out.println();
        }
    }
}
