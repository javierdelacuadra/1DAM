package main;

import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Para hacer una potencia se necesita la base y el exponente");
        System.out.println("Escriba la base");
        double base = sc.nextInt();
        System.out.println("Escriba el exponente");
        double exponente = sc.nextInt();

        if (exponente == 0) {
            System.out.println("El resultado es 1");
        }
        else if (exponente > 0) {
            System.out.println("El resultado es " + (Math.pow(base,exponente)));
        }
        else if (exponente < 0) {
            System.out.println("El resultado es " + (1/(Math.pow(base,Math.abs(exponente)))));
        }
    }
}
