package main;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio11 ej11 = new Ejercicio11();
        ej11.ejercicio11(sc);
    }

    public void ejercicio11(Scanner sc) {

        int[] array = new int[10];

        for (int i = 0; i < 5; i++) {
            System.out.println("Escriba un número");
            array[i] = sc.nextInt();
        }
        System.out.println("Escriba un número para continuar la serie");
        int numero = sc.nextInt();

        for (int i = 5; i < array.length; i++) {
            array[i] = numero + array[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
