package main;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contadorpositivos = 0;
        int contadornegativos = 0;
        int contadorcero = 0;

        System.out.println("Elija cuantos números quiere introducir");
        int numinicial = sc.nextInt();
        int micasa = numinicial;

        while (numinicial >= 1) {
            numinicial--;
            System.out.println("Escriba otro número");
            int numero = sc.nextInt();
            if (numero > 0) {
                contadorpositivos++;
            } else if (numero < 0) {
                contadornegativos++;
            } else {
                contadorcero++;
            }
        }
        if (micasa <= 0) {
            System.out.println("No se ha podido iniciar el programa");
        } else {
            System.out.println("De los números escritos, " + contadorpositivos + " eran positivos, " + contadornegativos +
                    " eran negativos, y " + contadorcero + " eran 0");
        }
    }
}