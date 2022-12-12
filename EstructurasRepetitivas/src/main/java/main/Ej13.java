package main;

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba cuántos euros se deben pagar por cada hora de trabajo");
        int eurosHora = sc.nextInt();
        int dias = 6;
        int contador = 0;
        int resultado = 0;

        while (dias > 0) {
            contador++;
            dias--;
            System.out.println("Cuantas horas trabajó el día " + contador);
            int horas = sc.nextInt();
            resultado += (horas*eurosHora);
        }
        if (eurosHora <= 0 ) {
            System.out.println("No se ha podido iniciar el programa");
        }
        else {
            System.out.println("El trabajador recibió " + resultado + " euros esa semana");
        }
        }
    }
