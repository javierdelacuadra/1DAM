package main;

import servicios.GenerarBaraja;

import java.util.Scanner;

public class JediEjercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaCartas = generarbaraja.generarBaraja(40);

        int numeroJugadores;
        int chewbacca;

        System.out.println("Escriba el número de jugadores que van a jugar");
        numeroJugadores = sc.nextInt();
        while (numeroJugadores < 1) {
            System.out.println("El mínimo de jugadores necesarios para poder jugar es 2");
            numeroJugadores = sc.nextInt();
        }
        System.out.println("Elige la posición de juego de chui");
        chewbacca = sc.nextInt();
        while (chewbacca < 1 || chewbacca > numeroJugadores) {
            System.out.println("Esa posición no está disponible");
            chewbacca = sc.nextInt();
        }
        int[] apuestas = new int[numeroJugadores * numeroJugadores];
        int[] cartasJugadores = new int[numeroJugadores];
        int[] contadorVecesPerdidas = new int[numeroJugadores];
        boolean[] jugadorMuerto = new boolean[numeroJugadores];
        boolean[] ganadorRonda = new boolean[numeroJugadores];
        boolean[] ganadorJuego = new boolean[numeroJugadores];

        int contadorCarta = 0;
        int contadorRonda = 0;
        int turnoJugador = 1;
        int cambioCarta;
        int cambiarCarta;

        //apuestas (están a partir del 1)
        for (int i = 1; i < numeroJugadores+1; i++) {
            System.out.println("Elija la cantidad de dinero que quiere apostar el jugador " + (turnoJugador) + " en la ronda " + (contadorRonda + 1));
            apuestas[i] = sc.nextInt();
            while (apuestas[i] < apuestas[i-1]) {
                System.out.println("No se puede apostar una cantidad menor a la del jugador anterior, introduzca una cantidad superior");
                apuestas[i] = sc.nextInt();
            }
            turnoJugador++;
            turnoJugador = (turnoJugador%(numeroJugadores+1));
            if (turnoJugador == 0) {
                turnoJugador++;
            }
        }

        do {
            //reparto
            for (int i = 0; i < numeroJugadores; i++) {
                cartasJugadores[i] = barajaCartas[contadorCarta];
                contadorCarta++;
            }
            int algo;
            //juego
            for (int i = 0; i < numeroJugadores-1; i++) {
                algo = 0;
                System.out.println("Jugador " + (turnoJugador) + ", tu carta es un " + cartasJugadores[i]);
                while (algo == 0) {
                    System.out.println("Elija 1 para cambiar su carta con el jugador de la derecha o elija 2 para quedarse con su carta");
                    cambiarCarta = sc.nextInt();
                    if (cambiarCarta == 1) {
                        if (cartasJugadores[i] < cartasJugadores[i+1] && turnoJugador+1 == chewbacca) {
                            System.out.println("No has podido cambiar tu carta y has muerto despedazado");
                            algo = 1;
                            jugadorMuerto[i] = true;
                        }
                        else if (cartasJugadores[i+1] == 10) {
                            System.out.println("No se puede cambiar la carta ya que el otro jugador tiene un rey");
                            algo = 1;
                        }
                        else {
                            cambioCarta = cartasJugadores[i];
                            cartasJugadores[i] = cartasJugadores[i+1];
                            cartasJugadores[i+1] = cambioCarta;
                            System.out.println("Tu nueva carta es " + cartasJugadores[i]);
                            algo = 1;
                        }
                    }
                    else if (cambiarCarta == 2) {
                        System.out.println("Has decidido no cambiar tu carta");
                        algo = 1;
                    }
                    else {
                        System.out.println("Opción no disponible, vuelva a intentarlo");
                    }
                }
                turnoJugador++;
                turnoJugador = (turnoJugador%(numeroJugadores+1));
                if (turnoJugador == 0) {
                    turnoJugador++;
                }
            }
            //juego para el último jugador
            algo = 0;
            while (algo == 0) {
                System.out.println("Jugador " + turnoJugador + ", tu carta es un " + cartasJugadores[turnoJugador-1] + ", elige 1 para cambiar tu carta por una de la baraja o 2 para quedarte con la carta que tienes");
                algo = sc.nextInt();
                if (algo == 1) {
                    cartasJugadores[turnoJugador-1] = barajaCartas[contadorCarta];
                    System.out.println("Tu nueva carta es " + cartasJugadores[turnoJugador-1]);
                }
                else if (algo == 2) {
                    System.out.println("Has decidido quedarte con la carta que tenías");
                }
                else {
                    algo = 0;
                    System.out.println("Opción no disponible");
                }
            }
            //comprobar ganador
            int ganador = 0;
            for (int i = 0; i < numeroJugadores-1; i++) {
                if (jugadorMuerto[i]) {
                    ganadorRonda[i] = false;
                    ganadorJuego[i] = false;
                }
                else if (cartasJugadores[ganador] > cartasJugadores [i+1]) {
                    ganador = i+1;
                }
                else {
                    ganador = i+1;
                }
            }
            for (int i = 0; i < numeroJugadores; i++) {
                if (i != ganador) {
                    contadorVecesPerdidas[i] += 1;
                }
            }
            System.out.println("El ganador de la ronda es el jugador " + ganador);
            //reset y barajeo
            generarbaraja.generarBaraja(40);
            contadorCarta = 0;
            contadorRonda++;
            turnoJugador = contadorRonda+1;
        } while (contadorRonda < numeroJugadores);
        int ganador = 0;
        int cantidadGanada = 0;
        for (int i = 0; i < contadorVecesPerdidas.length; i++) {
            if (contadorVecesPerdidas[ganador] < contadorVecesPerdidas[i+1]) {
                ganador = i+1;
            }
            else {
                ganador = i+1;
            }
        }
        for (int i = 0; i < numeroJugadores; i++) {
            if (i != ganador) {
                cantidadGanada += apuestas[i+1];
            }
        }
        for (int i = 0; i < numeroJugadores; i++) {
            if (i != ganador) {
                System.out.println("El jugador " + (i+1) + " ha perdido " + apuestas[i+1] + " euros");
            }
            else {
                System.out.println("El jugador " + (i+1) + " ha ganado " + cantidadGanada + " euros");
            }
        }
    }
}