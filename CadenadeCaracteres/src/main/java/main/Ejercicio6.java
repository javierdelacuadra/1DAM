package main;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        int longitud = palabra.length();

        for (int i = 0; i < longitud; i++) {
            System.out.print(palabra.charAt(longitud-i-1));
        }
    }
}
