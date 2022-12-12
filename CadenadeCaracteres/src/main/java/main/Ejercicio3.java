package main;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        System.out.println("Escribe una letra");
        String letra = sc.nextLine();
        int contador = 0;
        int longitud = palabra.length();
        int a = 0;
        char cosa = letra.toUpperCase().charAt(0);

        while (a < longitud) {

            if (palabra.toUpperCase().charAt(a) == cosa) {
                contador++;
            }
            a++;
        }
        System.out.println("La palabra " + palabra + " tiene el carácter " + letra + " " + contador + " veces");

    }
}
