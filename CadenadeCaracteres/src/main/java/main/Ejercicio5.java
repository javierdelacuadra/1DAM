package main;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba su nombre completo");
        String nombre = sc.nextLine();

        int longitud = nombre.length();
        int a = 0;
        int cosa1 = nombre.indexOf(" ");
        char cosa = nombre.charAt(cosa1);
        System.out.print(nombre.toUpperCase().charAt(0) + " ");
        while (a < longitud) {
            if (nombre.charAt(a) == cosa) {
                System.out.print(nombre.toUpperCase().charAt(a + 1) + " ");
            }
            a++;
        }
    }
}