package main;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio6 ej6 = new Ejercicio6();
        ej6.ejercicio6(sc);
    }

    public void ejercicio6(Scanner sc) {

        int[] array1 = new int[12];
        int[] array2 = new int[12];
        int[] array3 = new int[24];
        int contador = 0;

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Escriba un número");
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Escriba un número");
            array2[i] = sc.nextInt();
        }
        for (int i = 0; i < array3.length; i++) {

        }
    }
}
