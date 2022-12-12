package main;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroGenerado = (int) (Math.random() * 100 + 1);
        int numeroEscrito;
        System.out.println(numeroGenerado);
        System.out.println("Tiene 10 intentos para adivinar un número del 1 al 100");
        numeroEscrito = sc.nextInt();
        int contador = 10;

        do {
                contador--;
                System.out.println("Número incorrecto, inténtelo de nuevo, le quedan " + contador + " intentos");
                numeroEscrito = sc.nextInt();
            } while (contador > 1 && numeroEscrito != numeroGenerado);
        if (contador == 1) {
            System.out.println("Te has quedado sin intentos, el número era " + numeroGenerado);
        }
        else {
            System.out.println("Has acertado el número");
        }
    }
}
