package main;

import java.util.Scanner;

public class Ej15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte el número de alumnos");
        int alumnos = sc.nextInt();

        if (alumnos >= 100) {
            System.out.println("El precio del viaje es de " + (alumnos*65) + " euros");
        }
        else if (alumnos >= 50) {
            System.out.println("El precio del viaje es de " + (alumnos*70) + " euros");
        }
        else if (alumnos >=30) {
            System.out.println("El precio del viaje es de " + (alumnos*90) + " euros");
        }
        else {
            System.out.println("El precio del viaje es de 4000 euros");
        }
    }
}
