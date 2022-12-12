package main;

import java.util.Random;
import java.util.Scanner;

public class CartelChiquitistan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int[] cadenaACifrar = {-10, -6, -5, -3, -2, -1, 4, 6, 7, 9};
        int[] cadenaADescifrar = {-2, 3, -5, 6, -6, 7, 8, -8, -9, 10};
        int[] cadenaTest = new int[10];
        int variableGuardado;
        int random;
        int comprobarArray;
        int elegirCifrado;
        int posicionNueva = 0;
        boolean arrayCorrecto = true;

        //Apartado 1 (array generado aleatoriamente para comprobar si está ordenado o no)
        for (int i = 0; i < cadenaTest.length; i++) {
            cadenaTest[i] = r.nextInt(10) + 1;
            random = r.nextInt(2) + 1;
            if (random == 2) {
                cadenaTest[i] = cadenaTest[i] - (cadenaTest[i] * 2);
            }
        }
        System.out.println("Escriba 1 para comprobar si el array es correcto o escriba 2 para continuar");
        comprobarArray = sc.nextInt();
        if (comprobarArray == 1) {
            for (int i = 0; i < cadenaTest.length; i++) {
                if (cadenaTest[i] > cadenaTest[i + 1]) {
                    arrayCorrecto = false;
                    break;
                }
            }
            if (arrayCorrecto) {
                System.out.println("La cadena es correcta");
            } else {
                System.out.println("La cadena no es correcta");
            }
        }
        //Apartado 2 y 3
        boolean esMayor = true;
        int cantidadNegativos = 0;
        int contadorCifrado = 0;
        int posicionActual = 0;
        int guardadoPosicion = 0;
        System.out.println("Elija si quiere cifrar o descifrar la cadena (1 para cifrar, 2 para descifrar)");
        elegirCifrado = sc.nextInt();
        if (elegirCifrado == 1) {
            for (int i = 0; i < cadenaACifrar.length; i++) {
                if (cadenaACifrar[i] < 0) {
                    cantidadNegativos++;
                }
            }
            boolean numeroRepetido = false;
            do {
                int numeroPositivo = (cadenaACifrar[posicionActual]) + ((Math.abs(cadenaACifrar[posicionActual])) * 2);
                //encuentra posición en la que poner el número
                for (int i = 0; i < cadenaACifrar.length - 1; i++) {
                    if (numeroPositivo > (cadenaACifrar[i]) && esMayor) {
                        posicionNueva++;
                    } else if (numeroPositivo >= Math.abs(cadenaACifrar[i]) && !numeroRepetido) {
                        posicionNueva++;
                        numeroRepetido = true;
                    } else {
                        esMayor = false;
                    }
                }
                variableGuardado = cadenaACifrar[posicionActual];
                if (contadorCifrado >= 1) {
                    posicionNueva--;
                }
                if (contadorCifrado == cantidadNegativos - 2) {
                    posicionNueva--;
                }
                // guardo -6
                while (guardadoPosicion < posicionNueva) {
                    cadenaACifrar[guardadoPosicion] = cadenaACifrar[guardadoPosicion + 1];
                    guardadoPosicion++;
                }

                cadenaACifrar[posicionNueva] = variableGuardado;
                posicionNueva = 0;
                guardadoPosicion = 0;
                esMayor = true;
                numeroRepetido = false;
                contadorCifrado++;
            } while (contadorCifrado < cantidadNegativos - 1);
            for (int i = 0; i < cadenaACifrar.length; i++) {
                System.out.print(cadenaACifrar[i] + " ");
            }
        } else if (elegirCifrado == 2) {
            boolean esPositivo = true;
            for (int i = 0; i < cadenaADescifrar.length; i++) {
                if (cadenaADescifrar[i] < 0) {
                    cantidadNegativos++;
                }
            }
            posicionNueva = 9;
            do {
                for (int i = cadenaADescifrar.length - 1; i > 0; i--) {
                    if (cadenaADescifrar[i] > 0 && esPositivo) {
                        posicionNueva--;
                    } else {
                        esPositivo = false;
                    }
                }
                variableGuardado = cadenaADescifrar[posicionNueva];

                while ((posicionActual + contadorCifrado) < (posicionNueva)) {
                    cadenaADescifrar[posicionNueva] = cadenaADescifrar[posicionNueva - 1];
                    posicionNueva--;
                }
                cadenaADescifrar[posicionActual + contadorCifrado] = variableGuardado;
                esPositivo = true;
                posicionNueva = 9;
                contadorCifrado++;
            } while (contadorCifrado < cantidadNegativos - 1);
            for (int i = 0; i < cadenaADescifrar.length; i++) {
                System.out.print(cadenaADescifrar[i] + " ");
            }
        } else {
            System.out.println("No se pudo realizar el cifrado/descifrado");
        }
    }
}