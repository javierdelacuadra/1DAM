package servicios;

import java.util.Random;

public class Opcion1Ejercicio1 {
    public void opcion1Ej1(Random r) {

        int[] numeros = new int[10];
        int[] posiciones = new int[10];
        int[] resultado = new int[10];
        int numero = 1;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(10) + 1;
        }
        for (int i = 0; i < posiciones.length; i++) {
            if (numeros[i] == numero) {
                posiciones[numero - 1] += 1;
            }
            if (i == 9 && numero == 10) {
                i = 10;
            } else if (i == 9) {
                i = -1;
                numero++;
            }
        }
        numero = 1;
        int posicion = 0;
        for (int i = 0; i < resultado.length; i++) {
            if (posiciones[numero - 1] == 0) {
                numero++;
            } else if (posiciones[numero - 1] != 0) {
                for (int j = 0; j < posiciones[i]; j++) {
                    resultado[posicion] = numero;
                    posicion++;
                }
                numero++;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.print(posiciones[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }
}