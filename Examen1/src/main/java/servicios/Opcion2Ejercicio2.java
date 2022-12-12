package servicios;

import java.util.Random;

public class Opcion2Ejercicio2 {
    public void opcion2Ej2(Random r) {

        int[] numeros = new int[10];
        int[] operaciones = new int[9];
        double resultado;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(10) + 1;
        }
        for (int i = 0; i < operaciones.length; i++) {
            operaciones[i] = r.nextInt(4) + 1;
        }
        resultado = numeros[0];
        for (int i = 0; i < operaciones.length; i++) {
            if (operaciones[i] == 1) {
                resultado += numeros[i + 1];
            } else if (operaciones[i] == 2) {
                resultado -= numeros[i + 1];
            } else if (operaciones[i] == 3) {
                resultado = (resultado * numeros[i + 1]);
            } else if (operaciones[i] == 4) {
                resultado = (resultado / numeros[i + 1]);
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < operaciones.length; i++) {
            System.out.print(operaciones[i] + " ");
        }
        System.out.println("\n" + "El resultado es " + resultado);
    }
}