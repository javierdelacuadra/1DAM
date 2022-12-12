package ui;

import data.DaoTablero;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dificultad;
        int dimensiones = 0;
        int x1;
        int x2;
        int y1;
        int y2;
        int contador = 0;
        int puntosJ1 = 0;
        int puntosJ2 = 0;

        System.out.println("Elija la dificultad del juego");
        System.out.println("1: Fácil 2: Medio 3: Díficil");
        dificultad = sc.nextInt();
        sc.nextLine();
        while (dificultad < 1 || dificultad > 3) {
            System.out.println("El número debe estar entre 1 y 3, inténtalo de nuevo");
            dificultad = sc.nextInt();
            sc.nextLine();
        }
        switch (dificultad) {
            case 1:
                dimensiones = 4;
                break;
            case 2:
                dimensiones = 6;
                break;
            case 3:
                dimensiones = 8;
                break;
            default:
                System.out.println("Un saludito pal Sonarlint");
        }
        //creación del tablero y generación de las fichas
        DaoTablero d = new DaoTablero(dimensiones);

        do {
            System.out.println("Turno del jugador " + ((contador % 2) + 1));
            System.out.println(d.mostrarTablero(dimensiones));
            //levantar ficha 1
            do {
                System.out.println("Elige la fila: (1-2)");
                x1 = sc.nextInt();
                System.out.println("Elige la columna: (1-" + dimensiones + ")");
                y1 = sc.nextInt();
                if (!d.comprobarCartaLibre(x1, y1)) {
                    System.out.println("Esa ficha ya está levantada, inténtelo de nuevo");
                }
            } while (!d.comprobarCartaLibre(x1, y1));
            d.levantarFicha(x1, y1);
            System.out.println(d.mostrarTablero(dimensiones));
            //levantar ficha 2
            do {
                System.out.println("Segunda ficha:");
                System.out.println("Elige la fila: (1-2)");
                x2 = sc.nextInt();
                System.out.println("Elige la columna: (1-" + dimensiones + ")");
                y2 = sc.nextInt();
                if (!d.comprobarCartaLibre(x2, y2)) {
                    System.out.println("Esa ficha ya está levantada o no existe, inténtelo de nuevo");
                }
            } while (!d.comprobarCartaLibre(x2, y2));
            d.levantarFicha(x2, y2);
            System.out.println(d.mostrarTablero(dimensiones));
            //comprobación de si hay pareja o no
            if (d.comprobarPareja(x1, y1, x2, y2)) {
                System.out.println("Pareja acertada");
                if (contador % 2 == 0) {
                    puntosJ1 += 2;
                } else {
                    puntosJ2 += 2;
                }
            } else {
                System.out.println("No se ha acertado la pareja");
                contador++;
            }
        } while (!d.juegoFinalizado());
        System.out.println(d.mostrarTablero(dimensiones));
        if (puntosJ1 > puntosJ2) {
            System.out.print("El ganador es el jugador 1 con " + puntosJ1);
        } else if (puntosJ1 == puntosJ2) {
            System.out.print("Los dos jugadores han empatado a " + puntosJ1);
        } else {
            System.out.print("El ganador es el jugador 2 con " + puntosJ2);
        }
        System.out.print(" puntos");
    }
}