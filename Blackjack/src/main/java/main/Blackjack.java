package main;

import servicios.GenerarBaraja;

import java.util.Scanner;

public class Blackjack {
    public void blackjack(Scanner sc) {

        //Generar baraja y mezclar
        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaCartas = generarbaraja.generarBaraja(40);

        int numeroJugadores;
        int contadorCarta = 0;
        int opcionesMenu;
        int contadorRonda = 0;
        int normas;
        int puntuacionBanca = 0;

        System.out.println("Escriba el número de jugadores que van a jugar");
        numeroJugadores = sc.nextInt();
        int[] apuestas = new int[numeroJugadores * 5];
        int[] dineroJugadores = new int[numeroJugadores];
        int[] puntuacionJugadores = new int[numeroJugadores * 4];

        //Explicación del juego
        do {
            System.out.println("Escribe 1 para ver las normas del juego o escribe 2 para empezar a jugar");
            normas = sc.nextInt();
            if (normas == 1) {
                System.out.println("El objetivo del blackjack es conseguir sumar lo más cercano a 21 puntos sin pasarte.");
                System.out.println("Se juegan 5 rondas, y en cada ronda puedes apostar para sumar dinero. En el juego empiezas con 500€");
                System.out.println("Por cada ronda se te reparten 2 cartas, y puedes pedir más cartas de una en una para intentar alcanzar 21,");
                System.out.println("o plantarte para quedarte con las cartas que tienes y finalizar la ronda.");
                System.out.println("Si tienes más puntuación que la banca, ganas la ronda y duplicas el dinero de tu apuesta");
            } else if (normas == 2) {
                System.out.println("Comienza el juego!");
                System.out.println("El balance inicial de todos los jugadores es de 500€");
            } else {
                System.out.println("Opción no disponible");
            }
        } while (normas != 2);
        //relleno la cartera del jugador
        for (int i = 0; i < numeroJugadores; i++) {
            dineroJugadores[i] = 500;
        }

        do {
            //apuestas
            for (int i = 0; i < numeroJugadores; i++) {
                if (dineroJugadores[i] <= 0) {
                    i++;
                }
                System.out.println("Elija la cantidad de dinero que quiere apostar el jugador " + (i + 1) + " en la ronda " + (contadorRonda + 1));
                apuestas[i] = sc.nextInt();
                while (apuestas[i] >= dineroJugadores[i] || apuestas[i] < 1) {
                    if (apuestas[i] < 1) {
                        System.out.println("No se puede apostar una cantidad de dinero negativo, vuelva a introducir la cantidad");
                    } else {
                        System.out.println("No puede apostar una cantidad superior a la que tiene, vuelva a introducir la cantidad");
                    }
                    apuestas[i] = sc.nextInt();
                }
                dineroJugadores[i] -= apuestas[i];
            }
            //reparto cartas del jugador y la banca
            System.out.println("Comienza la ronda " + (contadorRonda + 1));
            System.out.println("Repartiendo cartas...");

            for (int i = 0; i < (numeroJugadores); i++) {
                puntuacionJugadores[i] = barajaCartas[i];
                puntuacionJugadores[i] += barajaCartas[i + numeroJugadores];
                contadorCarta += 2;
            }

            do {
                puntuacionBanca += barajaCartas[contadorCarta];
                contadorCarta++;
            } while (puntuacionBanca < 17);

            //pedir carta o plantarse
            for (int i = 0; i < numeroJugadores; i++) {
                System.out.println("Tu puntuación actual es de " + puntuacionJugadores[i]);
                do {
                    if (dineroJugadores[i] <= 0) {
                        i++;
                    }
                    System.out.println("Elija 1 para pedir una carta nueva o elija 2 para plantarse y terminar la ronda (Jugador " + (i + 1) + ")");
                    opcionesMenu = sc.nextInt();
                    if (opcionesMenu == 1) {
                        //pedir carta
                        puntuacionJugadores[i] += barajaCartas[contadorCarta];
                        contadorCarta++;
                        System.out.println("Tu puntuación actual es de " + puntuacionJugadores[i]);
                        if (puntuacionJugadores[i] > 21) {
                            System.out.println("Te has pasado de 21, pasando al siguiente jugador...");
                            opcionesMenu = 2;
                        }
                    } else if (opcionesMenu == 2 && i < numeroJugadores) {
                        System.out.println("Pasando al siguiente jugador...");
                    } else if (opcionesMenu == 2) {
                        System.out.println("Terminando la ronda...");
                    } else {
                        System.out.println("esa opción no está disponible");
                    }
                } while (opcionesMenu != 2);
            }

            //calcular resultados de la ronda, 1 gana, 2 pierde, 3 empate
            int[] ganadores = new int[numeroJugadores];

            for (int i = 0; i < numeroJugadores; i++) {
                if (puntuacionJugadores[i] > 21) {
                    ganadores[i] = 2;
                } else if (puntuacionBanca > 21) {
                    ganadores[i] = 1;
                } else if (puntuacionJugadores[i] > puntuacionBanca) {
                    ganadores[i] = 1;
                } else if (puntuacionJugadores[i] < puntuacionBanca) {
                    ganadores[i] = 2;
                } else {
                    ganadores[i] = 3;
                }
            }

            //resultados de la ronda

            for (
                    int i = 0;
                    i < numeroJugadores; i++) {
                if (ganadores[i] == 1) {
                    System.out.println("El jugador " + (i + 1) + " ha ganado la ronda y se lleva " + ((apuestas[i]) * 2));
                    dineroJugadores[i] += (apuestas[i] * 2);
                } else if (ganadores[i] == 2) {
                    System.out.println("El jugador " + (i + 1) + " ha perdido la ronda y " + apuestas[i] + " euros");
                } else if (ganadores[i] == 3) {
                    System.out.println("El jugador " + (i + 1) + " ha empatado la ronda");
                    dineroJugadores[i] += (apuestas[i]);
                }
            }
            System.out.println("La puntuación de la banca en esta ronda fue de " + puntuacionBanca);
            if (contadorRonda < 4) {
                for (int i = 0; i < numeroJugadores; i++) {
                    System.out.println("El balance del jugador " + (i + 1) + " es de " + dineroJugadores[i]);
                }
            }
            //reset de variables
            for (int i = 0; i < numeroJugadores; i++) {
                puntuacionJugadores[i] = 0;
            }
            puntuacionBanca = 0;
            contadorCarta = 0;
            contadorRonda++;
            barajaCartas = generarbaraja.generarBaraja(40);
            System.out.println("Ronda " + (contadorRonda) + " finalizada");
        } while (contadorRonda < 5);
        //resultados finales
        for (int i = 0; i < numeroJugadores; i++) {
            if (dineroJugadores[i] <= 0) {
                System.out.println("El jugador " + (numeroJugadores + 1) + " se quedó en bancarrota");
            } else {
                System.out.println("El jugador " + (numeroJugadores + 1) + " ha acabado las 5 rondas con " + dineroJugadores[i] + " euros");
            }
        }
    }
}