package main;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio15 ej15 = new Ejercicio15();
        ej15.ejercicio15(sc);
    }

    public void ejercicio15(Scanner sc) {

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Escriba un número");
            array[i] = sc.nextInt();
        }
        System.out.println("Escriba un número para comprobar si está en el array");
        int numero = sc.nextInt();
        int posicion = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                posicion = i + 1;
            }
        }
        if (posicion == 0) {
            System.out.println("El número no está en el array");
        } else {
            System.out.println("El número está en la posición " + posicion);
        }
    }
}