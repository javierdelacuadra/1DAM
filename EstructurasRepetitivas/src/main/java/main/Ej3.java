package main;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        int numeroinicial = 0;
        double suma = 0;
        int contador = 0;
        System.out.println("Escribe un número");
        numeroinicial = sc.nextInt();
        do {
            System.out.println("Escribe otro número");
            numero = sc.nextInt();
            contador++;
            suma = suma + numero;
        } while (numero != 0);
        System.out.println("Los números introducidos suman " + (suma + numeroinicial) + " y su media es "
                + ((suma + numeroinicial) / contador));
    }
}
