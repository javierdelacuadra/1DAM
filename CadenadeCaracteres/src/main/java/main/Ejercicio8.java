package main;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o frase");
        String palabra = sc.nextLine();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.codePointAt(i) > 64 && palabra.codePointAt(i) < 91) {
                System.out.print(palabra.toLowerCase().charAt(i));
            }
            else if (palabra.codePointAt(i) > 96 && palabra.codePointAt(i) < 123) {
                System.out.print(palabra.toUpperCase().charAt(i));
            }
            else if (palabra.codePointAt(i) == 32) {
                System.out.print(" ");
            }
        }
    }
}
