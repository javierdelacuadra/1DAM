package main;

import java.util.Random;

public class Ejercicio13 {
    public static void main(String[] args) {
        Random r = new Random();
        Ejercicio13 ej13 = new Ejercicio13();
        ej13.ejercicio13(r);
    }

    public void ejercicio13(Random r) {

        int[] array = new int[10];
        int[] arrayPares = new int[10];
        int[] arrayImpares = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(50);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayPares[i] = array[i];
            } else if (array[i] % 2 != 0) {
                arrayImpares[i] = array[i];
            }
        }
        for (int i = 0; i < arrayPares.length; i++) {
            System.out.print(arrayPares[i] + " ");
        }

        for (int i = 0; i < arrayImpares.length; i++) {
            System.out.print(arrayImpares[i] + " ");
        }
    }
}
