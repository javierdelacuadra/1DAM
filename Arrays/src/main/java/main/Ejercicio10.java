package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Ejercicio10 ej10 = new Ejercicio10();
        ej10.ejercicio10(sc, r);
    }

    public void ejercicio10(Scanner sc, Random r) {

        int[] array = new int[10];
        int[] tempArray = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(50);
        }

        System.out.println("Escriba la cantidad de posiciones que quiere desplazar la cadena");
        int posicion = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[Math.abs(10 + i - posicion) % 10];
        }
        for (int i = 0; i < tempArray.length; i++) {
            System.out.print(tempArray[i] + " ");
        }
    }
}
