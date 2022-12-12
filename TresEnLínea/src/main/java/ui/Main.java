package ui;

import data.DaoTablero;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DaoTablero d = new DaoTablero();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int posicionFicha;
        String ficha;

        System.out.println("Normas del juego: \n" + "2 jugadores juegan por turnos, echando fichas X o O. " +
                "El objetivo es tener 3 fichas seguidas de manera horizontal, vertical o diagonal. \n" +
                "Las casillas están ordenadas de izquierda a derecha siendo los números del 1 al 9.");
        System.out.println(d.mostrarTablero());
        do {
            if (contador % 2 == 0) {
                ficha = "X";
            } else {
                ficha = "0";
            }
            System.out.println("Elige una casilla para colocar tu ficha");
            posicionFicha = sc.nextInt();
            while (!d.comprobarFicha(posicionFicha - 1, ficha)) {
                System.out.println("Esa celda ya está ocupada, elige otra");
                posicionFicha = sc.nextInt();
            }
            System.out.println(d.mostrarTablero());

            if (contador >= 4) {
                if (d.comprobarGanador()) {
                    contador = 9;
                }
            }
            contador++;
        } while (contador <= 8);
        if (contador == 9) {
            System.out.println("empate");
        } else {
            if (ficha.equals("X")) {
                System.out.println("el ganador es la ficha X");
            } else {
                System.out.println("el ganador es la ficha 0");
            }
        }
    }
}