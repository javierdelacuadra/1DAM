package main;

import java.util.Random;

public class Ejercicio4 {
    public static void main(String[] args) {
        Random r = new Random();
        Ejercicio4 ej4 = new Ejercicio4();
        ej4.ejercicio4(r);
    }

    public void ejercicio4(Random r) {

        int[] array1 = new int[10];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = r.nextInt(50);
        }
        for (int j = 0; j < (array1.length / 2); j++) {
            System.out.print(array1[j] + " " + array1[array1.length - j - 1] + " ");
        }
    }
}