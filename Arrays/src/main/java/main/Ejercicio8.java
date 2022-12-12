package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Ejercicio8 ej8 = new Ejercicio8();
        ej8.ejercicio8(sc, r);
    }

    public void ejercicio8(Scanner sc, Random r) {

        int[] array1 = new int[10];
        int[] tempArray = new int[10];

        for (int i = 0; i < 8; i++) {
            array1[i] = r.nextInt(50);
        }
        System.out.println("Escriba el número a posicionar");
        int numero = sc.nextInt();

        System.out.println("Escriba la posición en la que colocar el número anterior");
        int posicion = sc.nextInt();

        for (int i = 0; i < posicion - 1; i++) {
            tempArray[i] = array1[i];
        }
        tempArray[posicion - 1] = numero;
        for (int i = posicion; i < array1.length; i++) {
            tempArray[i] = array1[i - 1];
        }
        for (int i = 0; i < tempArray.length - 1; i++) {
            System.out.print(tempArray[i] + " ");
        }
    }
}
