package main;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un número");
        int numero1 = sc.nextInt();
        System.out.println("Escriba otro número");
        int numero2 = sc.nextInt();

        if (numero1>numero2) {
            System.out.println("El primer número es mayor que el segundo");
        }
        else {
            System.out.println("El segundo número es mayor que el primero");
        }
    }
}
