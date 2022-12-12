package main;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cosa = 1;
        System.out.println("Escriba un número");
        int numero = sc.nextInt();
        do {
            cosa = cosa*(numero--);
        } while (numero > 1);
        System.out.println("El resultado es " +  cosa);
    }
}
