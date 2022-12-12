package main;

import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca número del dado (1-6): ");
        int numero = sc.nextInt();

        switch (numero) {
            case 1:
                System.out.println("En la cara opuesta está el seis");
                break;
            case 2:
                System.out.println("En la cara opuesta está el cinco");
                break;
            case 3:
                System.out.println("En la cara opuesta está el cuatro");
                break;
            case 4:
                System.out.println("En la cara opuesta está el tres");
                break;
            case 5:
                System.out.println("En la cara opuesta está el dos");
                break;
            case 6:
                System.out.println("En la cara opuesta está el uno");
                break;
            default:
                System.out.println("error: número incorrecto");
        }
    }
}