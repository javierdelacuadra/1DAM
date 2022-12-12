package ui;

import data.DaoJuego;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoJuego d = new DaoJuego();
        int opcion;
        int numeroJuego;
        int nota;
        int puntuacion = 0;
        String nombreJuego;
        boolean terminar = false;

        do {
            System.out.println("Elige una opción:");
            System.out.println(d.texto(1));
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del juego");
                    nombreJuego = sc.nextLine();
                    if (d.addJuego(nombreJuego)) {
                        System.out.println("Juego añadido con éxito");
                    }
                    else {
                        System.out.println("El juego ya ha sido introducido o se ha alcanzado el número máximo de juegos (10)");
                    }
                    break;
                case 2:
                    System.out.println("Elige un juego para añadir/cambiar la puntuación");
                    System.out.println(d.verJuegos());
                    numeroJuego = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce la nota (entre 0 y 10) que le quieres asignar al juego");
                    nota = sc.nextInt();
                    if (d.cambiarPuntuacion(numeroJuego, nota)) {
                        System.out.println("La nota ha sido asignada con éxito");
                    }
                    else {
                        System.out.println("No se ha podido asignar la nota al juego elegido");
                    }
                    break;
                case 3:
                    if (d.verJuegos().equals("No hay juegos en la base de datos")) {
                        System.out.println("Añade algún juego antes de borrar alguno");
                    }
                    else {
                        System.out.println("Elige un juego para borrarlo (en número)");
                        numeroJuego = sc.nextInt();
                        if (d.borrarJuego(numeroJuego)) {
                            System.out.println("Juego eliminado con éxito");
                        }
                        else {
                            System.out.println("No se pudo borrar el juego");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Elige un juego para ver su puntuación");
                    System.out.println(d.verJuegos());
                    numeroJuego = sc.nextInt();
                    puntuacion = d.obtenerPuntuacionJuego(numeroJuego);
                    if (puntuacion <= 10 && puntuacion >= 0) {
                        System.out.println("La puntuación es " + puntuacion);
                    }
                    else {
                        System.out.println("No hay una puntuación asignada a ese juego");
                    }
                    break;
                case 5:
                    System.out.println(d.verJuegos());
                    break;
                case 0:
                    terminar = true;
                    System.out.println("Programa cerrado con éxito");
                    break;
                default:
                    System.out.println("error 404");
                    break;
            }
        } while (!terminar);
    }
}
