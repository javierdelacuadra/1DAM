package main;

import java.util.Random;

public class Ejercicio1 {
    public void ejercicio1(Random r) {
        r = new Random();

        int[] array = new int[20];
        boolean esCorrecto = false;
        boolean divisibleEntre5 = false;
        boolean maxNumeroPrimo = false;
        boolean maximoNumerosMayores = false;
        int contador = 0;
        int sumaDivisibleEntre5 = 0;
        int sumaPares = 0;
        int media = 0;
        int contadorMayores = 0;
        int contadorPrimos = 0;

        do {
            //relleno array
            for (int i = 0; i < array.length; i++) {
                array[i] = r.nextInt(100);
            }
            //comprueba condición 1
            for (int i = 0; i < array.length; i++) {
                if (i % 5 == 0) {
                    sumaDivisibleEntre5 += array[i];
                }
                if (array[i] % 2 == 0) {
                    sumaPares += array[i];
                }
            }
            if (sumaDivisibleEntre5 < sumaPares) {
                divisibleEntre5 = true;
            }

            //comprueba condición 2
            boolean esPrimo;
            int valor;
            for (int i = 0; i < array.length; i++) {
                valor = 2;
                esPrimo = true;
                while (valor < array[i]) {
                    if ((array[i] % (valor)) == 0) {
                        esPrimo = false;
                    } else if ((array[i] / valor) < 2) {
                        valor = array[i] + 1;
                    }
                    if (!esPrimo) {
                        valor = array[i] + 1;
                    }
                    valor++;
                }
                if (esPrimo) {
                    contadorPrimos++;
                }
            }
            if (contadorPrimos <= 7) {
                maxNumeroPrimo = true;
            }

            //comprueba condición 3
            for (int i = 0; i < array.length; i++) {
                media += array[i];
            }
            media = media / array.length;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > media) {
                    contadorMayores++;
                }
            }
            if (contadorMayores <= 15) {
                maximoNumerosMayores = true;
            }

            if (divisibleEntre5 && maximoNumerosMayores && maxNumeroPrimo) {
                esCorrecto = true;
                break;
            }
            //reset
            sumaPares = 0;
            sumaDivisibleEntre5 = 0;
            media = 0;
            divisibleEntre5 = false;
            maximoNumerosMayores = false;
            maxNumeroPrimo = false;
            contadorMayores = 0;
            contadorPrimos = 0;
            contador++;
        } while (contador < 10000);
        if (!esCorrecto) {
            System.out.println("No se ha encontrado una cadena que coincida con ");
        } else {
            System.out.println("La cadena encontrada es:");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}