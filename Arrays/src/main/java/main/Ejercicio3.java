package main;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio3 ej3 = new Ejercicio3();
        ej3.ejercicio3(sc);
    }

    public void ejercicio3(Scanner sc) {

        double[] array = new double[5];
        double mediaPositivos = 0;
        int contadorPositivos = 0;
        double mediaNegativos = 0;
        int contadorNegativos = 0;
        int contadorCeros = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Escriba el valor del número " + (i + 1));
            array[i] = sc.nextInt();
            if (array[i] < 0) {
                contadorNegativos++;
                mediaNegativos += array[i];
            } else if (array[i] > 0) {
                contadorPositivos++;
                mediaPositivos += array[i];
            } else {
                contadorCeros++;
            }
        }
        System.out.println("La media de los números positivos es " + (mediaPositivos / contadorPositivos) +
                " , la de los negativos es " + (mediaNegativos / contadorNegativos) + " y hay " + contadorCeros + " ceros");
    }
}
