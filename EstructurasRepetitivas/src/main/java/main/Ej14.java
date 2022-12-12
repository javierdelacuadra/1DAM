package main;

import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el kilómetro en el que se encuentra el primer coche");
        double kilometro1 = sc.nextDouble();
        System.out.println("Indique el kilómetro en el que se encuentra el segundo coche");
        double kilometro2 = sc.nextDouble();

        double cosa = Math.abs(kilometro1-kilometro2);
        double resultado = 0;
        if (kilometro1 < 0 || kilometro2 < 0) {
            System.out.println("Las distancias no pueden ser negativas");
        }
        else if(kilometro1 > kilometro2) {
            resultado = kilometro2 + (cosa/2);
            System.out.println("Se encuentran en el kilómetro " + resultado);
        }
        else if (kilometro2 > kilometro1) {
            resultado = kilometro1 + (cosa/2);
            System.out.println("Se encuentran en el kilómetro " + resultado);
        }
        else {
            System.out.println("._.");
        }
    }
}
