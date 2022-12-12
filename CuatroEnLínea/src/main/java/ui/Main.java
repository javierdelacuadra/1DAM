package ui;

import data.DaoTablero;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DaoTablero d = new DaoTablero();
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int columna;
        String ficha;

        System.out.println(d.mostrarTablero());
        do {
            if (contador % 2 == 0) {
                ficha = "X";
            } else {
                ficha = "O";
            }
            System.out.println("Elige una columna para colocar tu ficha");
            columna = sc.nextInt();
            while (!d.comprobarFicha(columna - 1, ficha)) {
                System.out.println("Esa columna ya está ocupada, elige otra");
                columna = sc.nextInt();
            }
            System.out.println(d.mostrarTablero());
            if (contador >= 6) {
                if (d.comprobarGanador(columna-1)) {
                    contador = 43;
                }
            }
            contador++;
        } while (contador <= 41);
        if (contador == 42) {
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