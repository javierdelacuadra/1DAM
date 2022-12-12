package main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroEjercicio = 11;

        while (numeroEjercicio <= 20 && numeroEjercicio >= 11) {
            System.out.println("Elija un número de ejercicio del 11 al 20, pulse 0 para salir");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 11:
                    Ej11(sc);
                    break;
                case 12:
                    Ej12(sc);
                    break;
                case 13:
                    Ej13(sc);
                    break;
                case 14:
                    Ej14(sc);
                    break;
                case 15:
                    Ej15(sc);
                    break;
                case 16:
                    Ej16(sc);
                    break;
                case 17:
                    Ej17(sc);
                    break;
                case 18:
                    Ej18();
                    break;
                case 19:
                    Ej19(sc);
                    break;
                case 20:
                    Ej20(sc);
                    break;
                default:
                    break;
            }
        }
        if (numeroEjercicio != 0) {
            System.out.println("El programa no se pudo iniciar");
        }
        else {
            System.out.println("El programa se cerró con éxito");
        }
    }
    public static void Ej11(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba un número para comprobar si es primo o no");
        int numero = sc.nextInt();
        boolean esPrimo = true;
        int valor = 2;

        while (valor < numero) {
            if ((numero % valor) == 0) {

                esPrimo = false;
                break;
            }
            else if ((numero/valor) < 2) {
                break;
            }
            valor++;
        }
        if (esPrimo) {
            System.out.println("primo");
        }
        else {
            System.out.println("no primo");
        }
    }
    public static void Ej12(Scanner sc) {
        sc = new Scanner(System.in);

        int contador = 0;
        int dinero = 0;
        int resultado = 0;

        while (contador < 12) {
            contador++;
            System.out.println("¿Cuántos euros depositó el mes " + contador + "?");
            dinero = sc.nextInt();
            resultado += dinero;
        }
        System.out.println("En 12 meses ahorró " + resultado + " euros");
    }
    public static void Ej13(Scanner sc) {
        sc = new Scanner(System.in);

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
    public static void Ej14(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Indique el kilómetro en el que se encuentra el primer coche");
        double kilometro1 = sc.nextDouble();
        System.out.println("Indique el kilómetro en el que se encuentra el segundo coche");
        double kilometro2 = sc.nextDouble();

        double distanciaMedia = Math.abs(kilometro1-kilometro2);
        double resultado = 0;
        if (kilometro1 < 0 || kilometro2 < 0) {
            System.out.println("Las distancias no pueden ser negativas");
        }
        else if(kilometro1 > kilometro2) {
            resultado = kilometro2 + (distanciaMedia/2);
            System.out.println("Se encuentran en el kilómetro " + resultado);
        }
        else if (kilometro2 > kilometro1) {
            resultado = kilometro1 + (distanciaMedia/2);
            System.out.println("Se encuentran en el kilómetro " + resultado);
        }
        else {
            System.out.println("._.");
        }
    }
    public static void Ej15(Scanner sc) {
        sc = new Scanner(System.in);

        int contador = 0;
        System.out.println("¿En cuántos meses tiene que pagar su producto?");
        int meses = sc.nextInt();
        System.out.println("¿Cuánto tuvo que pagar el primer mes?");
        int precioInicial = sc.nextInt();
        int precioFinal = precioInicial;

        while (contador != meses) {
            contador++;
            precioFinal = precioFinal+precioFinal;
        }
        System.out.println("En total debe pagar " + (precioFinal-precioInicial) + " euros, lo que es una media de " +
                ((precioFinal-precioInicial)/meses) + " euros al mes durante " + meses + " meses");
    }
    public static void Ej16(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba cuántos euros se deben pagar por cada hora de trabajo");
        int eurosHora = sc.nextInt();
        System.out.println("Escriba cuántos trabajadores tiene su empresa");
        int contadorTrabajadores = sc.nextInt();
        int placeholder = contadorTrabajadores;
        int tempsueldo = 0;
        int sueldoTotal = 0;
        int contadorEmpleados = 0;

        while (placeholder > 0) {
            contadorEmpleados++;
            placeholder--;
            System.out.println("¿Cuántas horas ha trabajado el empleado " + contadorEmpleados + " esta semana?");
            int horas = sc.nextInt();
            tempsueldo = (eurosHora * horas);
            sueldoTotal += tempsueldo;
            System.out.println("El empleado " + contadorEmpleados + " gana " + tempsueldo + " euros a la semana");
        }
        if (contadorTrabajadores <= 0 || eurosHora <= 0) {
            System.out.println("No se ha podido calcular el resultado");
        } else {
            System.out.println("La empresa pagó " + (sueldoTotal) + " euros en total");
        }
    }
    public static void Ej17(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba cuántos euros se deben pagar por cada hora de trabajo");
        int eurosHora = sc.nextInt();
        System.out.println("Escriba cuántos trabajadores tiene su empresa");
        int contadorTrabajadores = sc.nextInt();
        int placeholder = contadorTrabajadores;
        int mediaSueldo = 0;

        while (placeholder > 0) {
            placeholder--;
            System.out.println("¿Cuántos días ha trabajado el empleado?");
            int dias = sc.nextInt();
            System.out.println("¿Cuántas horas trabajó cada día?");
            int horas = sc.nextInt();
            int algo = (eurosHora*horas)*dias;
            mediaSueldo += algo;
        }
        if (contadorTrabajadores <= 0 || eurosHora <= 0) {
            System.out.println("No se ha podido calcular el resultado");
        }
        else {
            System.out.println("La media de sus sueldos es de " + (mediaSueldo/contadorTrabajadores) + " euros y la empresa pagó "
                    + (mediaSueldo) + " euros");
        }
    }
    public static void Ej18() {

        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        do {
            if (minutos > 58 && segundos == 59) {
                minutos = 0;
                segundos = 0;
                horas++;
                System.out.println(horas + ":" + minutos + ":" + segundos);
            }
            else {
                if (segundos > 58) {
                    segundos = 0;
                    minutos++;
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                }
                else {
                    segundos++;
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                }
            }
        } while (horas < 24);
        System.out.println("fin");
    }
    public static void Ej19(Scanner sc) {
        sc = new Scanner(System.in);

        int numero = 0;

        do {
            System.out.println("Escriba un número del 1-5 para elegir una opción, escriba 0 para salir");
            numero = sc.nextInt();
            switch (numero) {
                case 1:
                    System.out.println("Ejercicio 1");
                    break;
                case 2:
                    System.out.println("Ejercicio 2");
                    break;
                case 3:
                    System.out.println("Ejercicio 3");
                    break;
                case 4:
                    System.out.println("Ejercicio 4");
                    break;
                case 5:
                    System.out.println("Ejercicio 5");
                    break;
                case 0:
                    System.out.println("El programa se ha cerrado con éxito");
                    break;
                default:
                    System.out.println("Número incorrecto, introduzca un número del 1 al 5 para volver a empezar, " +
                            "cualquier otro para finalizar");
                    numero = sc.nextInt();
                    break;
            }
        } while (numero > 0 && numero < 6);
    }
    public static void Ej20(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba cuántos números primos quiere mostrar");
        int contador = sc.nextInt();

        switch (contador) {
            case 1:
                System.out.println("2");
                break;
            case 2:
                System.out.println("2,3");
                break;
            case 3:
                System.out.println("2,3,5");
                break;
            case 4:
                System.out.println("2,3,5,7");
                break;
            case 5:
                System.out.println("2,3,5,7,11");
                break;
            case 6:
                System.out.println("2,3,5,7,11,13");
                break;
            case 7:
                System.out.println("2,3,5,7,11,13,17");
                break;
            default:
                System.out.println("Límite de números primos alcanzado");
        }
    }
}