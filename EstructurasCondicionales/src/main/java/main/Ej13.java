package main;

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un día");
        int day = sc.nextInt();
        System.out.println("Introduzca un mes (en número)");
        int mes = sc.nextInt();
        System.out.println("Introduzca un año");
        int year = sc.nextInt();

        if (day > 31 || mes > 12) {
            System.out.println("La fecha no existe");
        }
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && day > 30) {
            System.out.println("La fecha no existe");
        }
        else if (mes == 2 && day == 29 && (year%4 == 0 && year%400 == 0)) {
            System.out.println("La fecha es correcta");
        }
        else if (mes == 2 && day == 29 && (year%4 == 0 && year%100 == 0)) {
            System.out.println("La fecha no existe");
        }
        else if (mes == 2 && day == 29 && (year%4 == 0)) {
            System.out.println("La fecha es correcta");
        }
        else if (mes == 2 && day > 28) {
            System.out.println("La fecha no existe");
        }
        else {
            System.out.println("La fecha es correcta");
        }
    }
}
