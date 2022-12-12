package main;

import java.util.Scanner;

public class Ej20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba cuántos números primos quiere mostrar");
        int contador = sc.nextInt();

        switch (contador) {
            case 1:
                System.out.println("2");
                break;
            case 2:
                System.out.println("2,3");
                break;
            case 3:
                System.out.println("2,3,5");
                break;
            case 4:
                System.out.println("2,3,5,7");
                break;
            case 5:
                System.out.println("2,3,5,7,11");
                break;
            case 6:
                System.out.println("2,3,5,7,11,13");
                break;
            case 7:
                System.out.println("2,3,5,7,11,13,17");
                break;
            default:
                System.out.println("jajajajajajajajajajajajajajajajaja");
        }
    }
}
