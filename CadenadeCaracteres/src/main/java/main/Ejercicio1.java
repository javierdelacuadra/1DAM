package main;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba una palabra");
        String palabra = sc.nextLine();

        int contador = palabra.length();

        for (int i = 0; i < contador ; i++) {
            System.out.print(palabra.charAt(i)+" ");
        }
    }
}
