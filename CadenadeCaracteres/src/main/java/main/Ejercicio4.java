package main;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una frase");
        String frase = sc.nextLine();
        int contador = 0;
        int longitud = frase.length();
        int a = 0;
        int cosa1 = frase.indexOf(" ");
        char cosa = frase.charAt(cosa1);

        while (a < longitud) {
            if (frase.charAt(a) == cosa) {
                contador++;
            }
            a++;
        }
        System.out.println("La frase tiene " + (contador+1) + " palabras");
    }
}
