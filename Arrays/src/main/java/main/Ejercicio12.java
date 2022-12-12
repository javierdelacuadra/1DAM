package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Ejercicio12 ej12 = new Ejercicio12();
        ej12.ejercicio12(sc, r);
    }

    public void ejercicio12(Scanner sc, Random r) {

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(50);
        }
        System.out.println("Elige una posición (0-9) para eliminarla");
        int posicion = sc.nextInt();

        array[posicion - 1] = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
