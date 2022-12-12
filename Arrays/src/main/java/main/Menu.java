package main;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int numeroEjercicio = 0;

        do {
            System.out.println("Elija un número de ejercicio o pulse 0 para salir");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 1:
                    Ejercicio1 ej1 = new Ejercicio1();
                    ej1.ejercicio1(sc);
                    System.out.println();
                    break;
                case 2:
                    Ejercicio2 ej2 = new Ejercicio2();
                    ej2.ejercicio2(sc);
                    System.out.println();
                    break;
                case 3:
                    Ejercicio3 ej3 = new Ejercicio3();
                    ej3.ejercicio3(sc);
                    break;
                case 4:
                    Ejercicio4 ej4 = new Ejercicio4();
                    ej4.ejercicio4(r);
                    System.out.println();
                    break;
                case 5:
                    Ejercicio5 ej5 = new Ejercicio5();
                    ej5.ejercicio5(r);
                    System.out.println();
                    break;
                case 6:
                    Ejercicio6 ej6 = new Ejercicio6();
                    ej6.ejercicio6(sc);

                    break;
                case 7:
                    Ejercicio7 ej7 = new Ejercicio7();
                    ej7.ejercicio7(sc);
                    break;
                case 8:
                    Ejercicio8 ej8 = new Ejercicio8();
                    ej8.ejercicio8(sc, r);
                    System.out.println();
                    break;
                case 9:
                    Ejercicio9 ej9 = new Ejercicio9();
                    ej9.ejercicio9(r);
                    System.out.println();
                    break;
                case 10:
                    Ejercicio10 ej10 = new Ejercicio10();
                    ej10.ejercicio10(sc, r);
                    System.out.println();
                    break;
                case 11:
                    Ejercicio11 ej11 = new Ejercicio11();
                    ej11.ejercicio11(sc);
                    System.out.println();
                    break;
                case 12:
                    Ejercicio12 ej12 = new Ejercicio12();
                    ej12.ejercicio12(sc, r);
                    System.out.println();
                    break;
                case 13:
                    Ejercicio13 ej13 = new Ejercicio13();
                    ej13.ejercicio13(r);
                    System.out.println();
                    break;
                case 14:
                    Ejercicio14 ej14 = new Ejercicio14();
                    ej14.ejercicio14();
                    System.out.println();
                    break;
                case 15:
                    Ejercicio15 ej15 = new Ejercicio15();
                    ej15.ejercicio15(sc);
                    break;
                case 16:
                    Ejercicio16 ej16 = new Ejercicio16();
                    ej16.ejercicio16(sc, r);
                    break;
                case 0:
                    System.out.println("Ha salido del programa con éxito");
                    break;
                default:
                    System.out.println("El número de ejercicio seleccionado no existe");
                    break;

            }
        } while (numeroEjercicio > 0);
    }
}
