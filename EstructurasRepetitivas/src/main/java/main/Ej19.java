package main;

import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cosa = 0;

        do {
            System.out.println("Escriba un número del 1-5 para elegir una opción, escriba 0 para salir");
            cosa = sc.nextInt();
            switch (cosa) {
                case 1:
                    System.out.println("Ejercicio 1");
                    break;
                case 2:
                    System.out.println("Ejercicio 2");
                    break;
                case 3:
                    System.out.println("Ejercicio 3");
                    break;
                case 4:
                    System.out.println("Ejercicio 4");
                    break;
                case 5:
                    System.out.println("Ejercicio 5");
                    break;
                case 0:
                    System.out.println("El programa se ha cerrado con éxito");
                    break;
                default:
                    System.out.println("Número incorrecto, introduzca un número del 1 al 5 para volver a empezar, " +
                            "cualquier otro para finalizar");
                    cosa = sc.nextInt();
                    break;
            }
        } while (cosa > 0 && cosa < 6);
    }
}
