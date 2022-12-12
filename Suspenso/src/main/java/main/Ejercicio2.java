package main;

import servicios.GenerarBaraja;

import java.util.Scanner;

public class Ejercicio2 {
    public void ejercicio2(Scanner sc) {
        sc = new Scanner(System.in);

        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaCartas = generarbaraja.generarBaraja(40);

        int numeroJugadores;
        int contadorCarta = 0;

        System.out.println("Escriba el número de jugadores que van a jugar");
        numeroJugadores = sc.nextInt();
        int[] cartasJugadores = new int[numeroJugadores * 3];
        int[] cartasEchadas = new int[numeroJugadores];
        int[] cartasConseguidas = new int[numeroJugadores];
        int[] guardadoElecciones = new int[numeroJugadores * 2];

        int turnoJugador = 0;
        int cartaAEchar;
        int ganador = 0;
        int ganador2 = 0;
        boolean quedanCartas = true;
        boolean empate = false;
        int contadorRonda = 0;
        int contadorGuardado = 0;

        //reparto inicial
        for (int i = 0; i < cartasJugadores.length; i++) {
            cartasJugadores[i] = barajaCartas[contadorCarta];
            contadorCarta++;
        }

        do {
            if (contadorRonda % 3 == 0 && contadorRonda != 0) {
                for (int i = 0; i < cartasJugadores.length; i++) {
                    cartasJugadores[i] = barajaCartas[contadorCarta];
                    contadorCarta++;
                }
            }
            System.out.println("Comienza la ronda " + (contadorRonda + 1));
            //los jugadores eligen cual echan
            for (int i = 0; i < numeroJugadores; i++) {
                System.out.print("Jugador " + (turnoJugador + 1) + ", tus cartas son ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(cartasJugadores[j + (turnoJugador * 3)] + " ");
                }
                System.out.println();
                System.out.println("Elige del 1 al 3 cuál quieres echar para jugar (si la carta es igual a 0 es que ya has jugado esa carta)");
                cartaAEchar = sc.nextInt();
                while (cartaAEchar < 0 || cartaAEchar > 3 || cartasJugadores[(cartaAEchar + (turnoJugador * 3)) - 1] == 0) {
                    System.out.println("No se puede echar esa carta");
                    cartaAEchar = sc.nextInt();
                }
                cartasEchadas[i] = cartasJugadores[(cartaAEchar + (turnoJugador * 3)) - 1];
                guardadoElecciones[contadorGuardado] = cartaAEchar;
                contadorGuardado++;
                turnoJugador++;
            }
            //resultados de la ronda
            for (int i = 0; i < numeroJugadores - 1; i++) {
                if (cartasEchadas[ganador] <= cartasEchadas[i + 1]) {
                    if (cartasEchadas[ganador] == cartasEchadas[i + 1]) {
                        empate = true;
                        ganador2 = i + 1;
                    } else {
                        ganador++;
                        empate = false;
                    }
                }
            }
            if (empate) {
                if (barajaCartas[contadorCarta] > barajaCartas[contadorCarta + 1]) {
                    cartasConseguidas[ganador] += 5;
                    System.out.println("Tras el desempate, el ganador es el jugador " + (ganador + 1));
                } else if (barajaCartas[contadorCarta] < barajaCartas[contadorCarta + 1]) {
                    cartasConseguidas[ganador2] += 5;
                    System.out.println("Tras el desempate, el ganador es el jugador " + ganador2);
                }
                contadorCarta += 2;
            } else {
                System.out.println("El ganador de la ronda es el jugador " + (ganador + 1));
                cartasConseguidas[ganador] += 3;
            }
            if (contadorCarta + (3 * numeroJugadores) > 40 && (contadorRonda+1) % 3 == 0) {
                quedanCartas = false;
            }
            turnoJugador = 0;
            if ((contadorRonda + 1) % 3 != 0) {
                for (int i = 0; i <= cartasJugadores.length + 1; i++) {
                    if (guardadoElecciones[turnoJugador] == ((i + 1) % (4))) {
                        cartasJugadores[(guardadoElecciones[turnoJugador] + (turnoJugador * 3) - 1)] = 0;
                        turnoJugador++;
                    }
                    if (numeroJugadores > 3 && guardadoElecciones[numeroJugadores - 1] == 3) {
                        cartasJugadores[cartasJugadores.length - 1] = 0;
                    } else if (numeroJugadores > 3 && guardadoElecciones[numeroJugadores - 1] == 2) {
                        cartasJugadores[cartasJugadores.length - 2] = 0;
                    }
                    if (turnoJugador > numeroJugadores - 1) {
                        i = 9999;
                    }
                }
            }
            //reset
            empate = false;
            turnoJugador = 0;
            ganador = 0;
            ganador2 = 0;
            contadorGuardado = 0;
            contadorRonda++;
        } while (quedanCartas);
        System.out.println("El juego ha concluido, calculando resultados...");
        for (int i = 0; i < numeroJugadores - 1; i++) {
            if (cartasConseguidas[ganador] < cartasConseguidas[i + 1]) {
                ganador++;
            }
        }
        System.out.println("El ganador del juego es el jugador " + (ganador + 1) + " y ha conseguido quedarse con " + cartasConseguidas[ganador] + " cartas");
    }
}
