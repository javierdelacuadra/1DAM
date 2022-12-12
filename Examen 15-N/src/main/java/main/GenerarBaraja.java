package main;

import java.util.Random;

public class GenerarBaraja {
    public int[] generarBaraja(int numeroCartas) {
        int[] barajaCartas = new int[numeroCartas];
        barajar(barajaCartas);
        return barajaCartas;
    }

    private void barajar(int[] barajaCartas) {
        Random r = new Random();
        int numeroCarta = 1;
        int contador = 1;

        for (int i = 0; i < barajaCartas.length; i++) {
            int random = r.nextInt(39);
            if (barajaCartas[random] == 0) {
                barajaCartas[random] = numeroCarta;
                contador++;
            } else {
                i--;
            }
            if (contador > 4) {
                contador = 1;
                numeroCarta++;
            }
            if (numeroCarta == 10 && contador == 3) {
                i++;
            }
        }
        for (int i = 0; i < barajaCartas.length; i++) {
            if (barajaCartas[i] == 0) {
                barajaCartas[i] = 10;
            }
        }
    }
}
