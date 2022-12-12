package main;

import java.util.Scanner;

public class Ej11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un número");
        double numero = sc.nextDouble();

        if (numero <= 0) {
            System.out.println("Un número primo no puede ser negativo o 0");
        }
        else if (numero == 2 || numero == 3 || numero == 5 || numero == 7 || numero == 11 || numero == 13 || numero == 17 || numero == 19) {
            System.out.println("El número es primo");
        } else if (numero%2 == 0 || numero%3 == 0 || numero%5 == 0 || numero%7 == 0 || numero%11 == 0 || numero%13 == 0 || numero%17 == 0 || numero%19 == 0 || numero == 1) {
            System.out.println("El número no es primo");
        } else {
            System.out.println("El número es primo");
        }
    }
}
