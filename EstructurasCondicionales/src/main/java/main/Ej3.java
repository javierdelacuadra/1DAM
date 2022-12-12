package main;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un número");
        double numero = sc.nextInt();

        if (numero%2 == 0) {
            System.out.println("El número escrito es par");
        }
        else {
            System.out.println("El número escrito es impar");
        }
    }
}
