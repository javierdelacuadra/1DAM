package main;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una palabra o frase");
        String frase = sc.nextLine();
        System.out.println("Introduzca una serie de carácteres");
        String cadena = sc.nextLine();
        boolean coincide = true;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.substring(i, (i+cadena.length())).equals(cadena)) {
                coincide = true;
                break;
            }
            else {
                coincide = false;
            }
        }
        if (coincide) {
            System.out.println("La frase sí contiene la serie de carácteres introducidos");
        }
        else {
            System.out.println("La frase no contiene la serie de carácteres introducidos");
        }
    }
}
