package main;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        boolean esPalindromo = true;
        int longitud = palabra.length();

        int i;
        if (longitud % 2 == 0) {
            for (i = 0; i <= ((longitud / 2) - 1); i++) {
                if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                    esPalindromo = false;
                    break;
                }
            }
        } else {
            for (i = 0; i < ((longitud / 2)); i++) {
                if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                    esPalindromo = false;
                    break;
                }
            }
        }
        if (esPalindromo) {
            System.out.println("La palabra introducida es un palíndromo");
        }
        else {
            System.out.println("La palabra introducida no es un palíndromo");
        }
    }
}
