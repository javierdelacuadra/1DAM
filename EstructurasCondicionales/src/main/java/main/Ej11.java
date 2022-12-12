package main;

import java.util.Scanner;

public class Ej11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la longitud del primer cateto de un triángulo");
        int lado1 =sc.nextInt();
        System.out.println("Introduzca la longitud del segundo cateto de un triángulo");
        int lado2 =sc.nextInt();
        System.out.println("Introduzca la longitud de la hipotenusa de un triángulo");
        int lado3 =sc.nextInt();

        if (Math.pow(lado3,2) == (Math.pow(lado2,2)+Math.pow(lado1,2))) {
            System.out.println("El triángulo es rectángulo");
        }
        else if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("El triángulo es equilátero");
        }
        else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            System.out.println("El triángulo es isósceles");
        }
        else {
            System.out.println("El triángulo es escaleno");
        }
    }
}
