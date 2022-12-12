package main;

import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un mes en número (del 1 al 12)");
        int mes = sc.nextInt();

        if (mes == 1 || mes == 3 ||mes == 5 ||mes == 7 ||mes == 8 ||mes == 10 ||mes == 12) {
            System.out.println("El mes tiene 31 días");
        }
        else if (mes == 4 ||mes == 6 ||mes == 9 ||mes == 11) {
            System.out.println("El mes tiene 30 días");
        }
        else if (mes == 2) {
            System.out.println("El mes tiene 28 días");
        }
        else {
            System.out.println("El número introducido no corresponde con ningún mes");
        }
    }
}
