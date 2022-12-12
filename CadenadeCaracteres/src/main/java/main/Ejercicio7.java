package main;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o frase");
        String palabra = sc.nextLine();
        System.out.println("Escribe un carácter");
        String caracter1 = sc.nextLine();


        while (caracter1.length() != 1) {
            System.out.println("El carácter introducido no es correcto, introduzca otro");
            caracter1 = sc.nextLine();
        }

        System.out.println("Escribe otro carácter");
        String caracter2 = sc.nextLine();

        while (caracter2.length() != 1) {
            System.out.println("El carácter introducido no es correcto, introduzca otro");
            caracter2 = sc.nextLine();
        }

        String resultado = palabra.replace(caracter1, caracter2);
        System.out.println(resultado);

    }
}
