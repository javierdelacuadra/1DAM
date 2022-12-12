package main;

import java.util.Scanner;

public class Ej12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un año");
        int year = sc.nextInt();
        if (year%4 == 0 && year%400 == 0) {
            System.out.println("El año es bisiesto");
        }
        else if (year%4 == 0 && year%100 == 0) {
            System.out.println("El año no es bisiesto");
        }
        else if (year%4 == 0) {
            System.out.println("El año es bisiesto");
        }
        else {
            System.out.println("El año no es bisiesto");
        }
    }
}
