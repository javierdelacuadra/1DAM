package main;

import java.util.Scanner;

public class JuegoCartas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaJugador1 = generarbaraja.generarBaraja(40);
        int[] barajaJugador2 = generarbaraja.generarBaraja(40);

        int[] puntuacionJugador1 = new int[10];
        int[] puntuacionJugador2 = new int[10];
        int contador = 0;
        int posicion = 0;
        int numero = 1;
        int puntosFinalesJ1 = 0;
        int puntosFinalesJ2 = 0;
        int verBarajas;

        System.out.println("Pulse 1 si quiere ver las barajas generadas, pulse 2 si quiere empezar el juego");
        verBarajas = sc.nextInt();
        if (verBarajas == 1) {
            System.out.println("Jugador 1:");
            for (int i = 0; i < barajaJugador1.length; i++) {
                if (i == (barajaJugador1.length) - 1) {
                    System.out.println(barajaJugador1[i]);
                } else {
                    System.out.print(barajaJugador1[i] + "-");
                }
            }
            System.out.println("Jugador 2:");
            for (int i = 0; i < barajaJugador2.length; i++) {
                if (i == (barajaJugador2.length) - 1) {
                    System.out.println(barajaJugador2[i]);
                } else {
                    System.out.print(barajaJugador2[i] + "-");
                }
            }
            System.out.print("\n");
        } else if (verBarajas == 2) {
            System.out.println("Comenzando el juego...");
        } else {
            System.out.println("Opción no disponible, comienza el juego");
        }

        for (int i = 0; i < barajaJugador1.length; i++) {
            if (barajaJugador1[i] == numero) {
                puntuacionJugador1[posicion] += (i + 1);
                contador++;
            }
            if (contador == 4) {
                contador = 1;
                posicion++;
                numero++;
                i = 0;
            }
        }
        contador = 0;
        posicion = 0;
        numero = 1;
        for (int i = 0; i < barajaJugador2.length; i++) {
            if (barajaJugador2[i] == numero) {
                puntuacionJugador2[posicion] += (i + 1);
                contador++;
            }
            if (contador == 4) {
                contador = 1;
                posicion++;
                numero++;
                i = 0;
            }
        }
        for (int i = 0; i < puntuacionJugador1.length; i++) {
            if (puntuacionJugador1[i] > puntuacionJugador2[i]) {
                puntosFinalesJ1++;
            } else if (puntuacionJugador2[i] > puntuacionJugador1[i]) {
                puntosFinalesJ2++;
            }
        }
        System.out.println("La puntuación del jugador 1 es de " + puntosFinalesJ1 + " puntos");
        System.out.println("La puntuación del jugador 2 es de " + puntosFinalesJ2 + " puntos");
        if (puntosFinalesJ1 > puntosFinalesJ2) {
            System.out.println("El jugador 1 es el ganador");
        } else if (puntosFinalesJ2 > puntosFinalesJ1) {
            System.out.println("El jugador 2 es el ganador");
        } else {
            System.out.println("Los 2 jugadores empataron");
        }
    }
}