package main;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una palabra o frase");
        String frase = sc.nextLine();
        System.out.println("Introduzca una serie de carácteres");
        String cadena = sc.nextLine();

        if ((frase.substring(0, (cadena.length())).equals(cadena))) {
            System.out.println("La frase comienza por la cadena introducida");
        }
        else {
            System.out.println("La frase no comienza por la cadena introducida");
        }
    }
}
