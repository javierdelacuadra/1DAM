package main;

import java.util.Scanner;

public class Ej15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        System.out.println("¿En cuántos meses tiene que pagar su producto?");
        int meses = sc.nextInt();
        System.out.println("¿Cuánto tuvo que pagar el primer mes?");
        int precioInicial = sc.nextInt();
        int precioFinal = precioInicial;

        while (contador != meses) {
            contador++;
            precioFinal = precioFinal+precioFinal;
        }
        System.out.println("En total debe pagar " + (precioFinal-precioInicial) + " euros, lo que es una media de " +
                ((precioFinal-precioInicial)/meses) + " euros al mes durante " + meses + " meses");
    }
}
