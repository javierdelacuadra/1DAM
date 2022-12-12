package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio2 ej2 = new Ejercicio2();
        ej2.ejercicio2(sc);
    }

    public void ejercicio2(Scanner sc) {

        int[] array1 = new int[5];

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Escriba un número");
            array1[i] = sc.nextInt();
        }
        for (int j = array1.length; j > 0; j--) {
            System.out.print(array1[j - 1] + " ");
        }
    }
}
