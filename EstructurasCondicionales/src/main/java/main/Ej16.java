package main;

import java.util.Scanner;

public class Ej16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique la longitud de su llamada (en minutos)");
        double tiempoLlamada = sc.nextDouble();
        if (tiempoLlamada < 0.01) {
            System.out.println("No se ha podido realizar la llamada");
        }
        else {
            System.out.println("Indique si la llamada se realizó en domingo: (Escriba 1 para sí y 2 para no)");
            int yoCuandoEsDomingo = sc.nextInt();

            if (yoCuandoEsDomingo > 2 || yoCuandoEsDomingo < 1) {
                System.out.println("No se ha podido realizar la llamada");
            }
            else {
                System.out.println("Indique la hora de realización de la llamada: (Escriba 1 para mañana y 2 para tarde)");
                int morningAfternoon = sc.nextInt();
                if (tiempoLlamada < 5 && yoCuandoEsDomingo == 1) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.18*tiempoLlamada)) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.13*tiempoLlamada)) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada < 5) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.15*tiempoLlamada)) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.1*tiempoLlamada)) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada < 8 && yoCuandoEsDomingo == 1) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.18*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.13*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada < 8) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.15*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.1*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada < 10 && yoCuandoEsDomingo == 1) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.18*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.13*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada < 10) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.15*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.1*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada >= 10 && yoCuandoEsDomingo == 1) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.18*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.13*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else if (tiempoLlamada >= 10) {
                    switch (morningAfternoon) {
                        case 1:
                            System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.15*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                            break;
                        case 2:
                            System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.1*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                            break;
                        default: System.out.println("No se ha podido realizar la llamada");
                    }
                }
                else {
                    System.out.println("Si encuentras este error eres increíble");
                }
            }
        }
    }
}