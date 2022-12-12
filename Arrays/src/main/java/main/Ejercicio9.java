package main;

import java.util.Random;

public class Ejercicio9 {
    public static void main(String[] args) {
        Random r = new Random();
        Ejercicio9 ej9 = new Ejercicio9();
        ej9.ejercicio9(r);
    }

    public void ejercicio9(Random r) {

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(50);
        }
        int numero = array[9];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = numero;
        System.out.print(array[0] + " ");
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
