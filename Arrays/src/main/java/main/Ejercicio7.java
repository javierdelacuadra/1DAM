package main;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio7 ej7 = new Ejercicio7();
        ej7.ejercicio7(sc);
    }

    public void ejercicio7(Scanner sc) {

        int[] array1 = new int[10];
        boolean esCreciente = true;
        boolean esDecreciente = true;

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Escriba un número");
            array1[i] = sc.nextInt();
        }
        for (int i = 1; i < ((array1.length) - 1); i++) {
            if ((array1[i] > array1[i - 1]) && esCreciente) {
                esDecreciente = false;
            } else if ((array1[i] < array1[i - 1]) && esDecreciente) {
                esCreciente = false;
            } else {
                esCreciente = false;
                esDecreciente = false;
            }
        }
        if (esCreciente) {
            System.out.println("Los números están de forma creciente");
        } else if (esDecreciente) {
            System.out.println("Los números están de forma decreciente");
        } else {
            System.out.println("Los números están desordenados");
        }
    }
}
