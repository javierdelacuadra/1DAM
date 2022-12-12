package main;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un número");
        double numero1 = sc.nextDouble();
        System.out.println("Escriba otro número");
        double numero2 = sc.nextDouble();

        if (numero2 == 0){
            System.out.println("No se puede realizar la división");
        }
        else {
            System.out.println("El resultado de su división es " + (numero1/numero2));
        }
    }
}
