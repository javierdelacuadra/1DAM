package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio1 ej1 = new Ejercicio1();
        ej1.ejercicio1(sc);
    }

    public void ejercicio1(Scanner sc) {
        int[] array1 = new int[5];

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Escriba un número");
            array1[i] = sc.nextInt();
        }
        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + " ");
        }
    }
}

