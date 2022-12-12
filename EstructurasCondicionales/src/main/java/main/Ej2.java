package main;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un número");
        double numero = sc.nextInt();

        if (numero == 0){
            System.out.println("El número escrito es 0");
        }
        else if (numero > 0) {
            System.out.println("El número escrito es positivo");
        }
        else if (numero < 0) {
            System.out.println("El número escrito es negativo");
        }
    }
}
