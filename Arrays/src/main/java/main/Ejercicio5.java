package main;

import java.util.Random;

public class Ejercicio5 {
    public static void main(String[] args) {
        Random r = new Random();
        Ejercicio5 ej5 = new Ejercicio5();
        ej5.ejercicio5(r);
    }

    public void ejercicio5(Random r) {

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[20];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = r.nextInt(50);
        }
        for (int i = 0; i < array1.length; i++) {
            array2[i] = r.nextInt(50);
        }
        for (int i = 0; i < array3.length; i++) {
            if (i % 2 == 0) {
                array3[i] = array1[i / 2];
                System.out.print(array3[i] + " ");
            } else {
                array3[i] = array2[i / 2];
                System.out.print(array3[i] + " ");
            }
        }
    }
}
