package main;

import java.util.Scanner;

public class Ej12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        int dinero = 0;
        int resultado = 0;

        while (contador < 12) {
            contador++;
            System.out.println("¿Cuántos euros depositó el mes " + contador + "?");
            dinero = sc.nextInt();
            resultado += dinero;
        }
        System.out.println("En 12 meses ahorró " + resultado + " euros");
    }
}
