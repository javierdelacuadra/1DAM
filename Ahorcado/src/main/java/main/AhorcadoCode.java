package main;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Scanner;

public class AhorcadoCode {

    public void ahorcado(Scanner sc) {

        //generación palabra
        Faker f = new Faker(new Locale("es-ES"));

        String palabraGenerada = f.pokemon().name().toUpperCase();

        for (int i = 0; i < palabraGenerada.length(); i++) {
            if (palabraGenerada.charAt(i) == ' ') {
                System.out.print(" ");
            } else {
                System.out.print("_");
            }
        }
        System.out.println("\n");

        String palabra;
        char caracter;
        char guionBajo = '_';
        boolean letraAcertada = false;
        boolean letraRepetida = false;
        int vidas = 5;
        int contador = 0;
        StringBuilder palabraAMostrar = new StringBuilder();
        StringBuilder tempString = new StringBuilder();
        String guardado = "";
        StringBuilder letrasRepetidas = new StringBuilder();

        do {
            System.out.println("Introduzca una letra");
            palabra = sc.nextLine();
            //comprobación si es palabra o carácter
            if (palabra.equalsIgnoreCase(palabraGenerada)) {
                vidas = -1;
                break;
            } else if (palabra.length() > 1) {
                vidas = 0;
                break;
            } else {
                caracter = palabra.toUpperCase().charAt(0);
            }
            //comprobación letra no repetida
            for (int l = 0; l < letrasRepetidas.length(); l++) {
                if (caracter == letrasRepetidas.charAt(l)) {
                    letraRepetida = true;
                }
            }
            if (letraRepetida) {
                System.out.println("Esta letra ya ha sido introducida");
            }
            //comprobación caracteres
            for (int i = 0; i < palabraGenerada.length(); i++) {
                if (palabraGenerada.charAt(i) == caracter) {
                    palabraAMostrar.append(palabraGenerada.toUpperCase().charAt(i));
                    letraAcertada = true;
                } else if (palabraGenerada.charAt(i) == ' ') {
                    palabraAMostrar.append(" ");
                } else {
                    palabraAMostrar.append("_");
                }
            }
            //check si acierta la letra o no
            if (letraAcertada) {
                //primera vez que pasa guarda cadena
                if (contador == 0) {
                    guardado = palabraAMostrar.toString();
                    System.out.println(guardado);
                    contador++;
                } else {
                    //el resto de veces que pasa guarda cadena pero mejor
                    for (int j = 0; j < palabraGenerada.length(); j++) {
                        if (palabraAMostrar.charAt(j) == palabraGenerada.charAt(j)) {
                            tempString.append(palabraAMostrar.charAt(j));
                        } else if (palabraAMostrar.charAt(j) == guionBajo) {
                            tempString.append(guardado.charAt(j));
                        } else if (palabraAMostrar.charAt(j) != guionBajo && guardado.charAt(j) == guionBajo) {
                            tempString.append(palabraAMostrar.charAt(j));
                        }
                    }
                    guardado = tempString.toString();
                    tempString = new StringBuilder();
                    //acierto
                    if (guardado.equals(palabraGenerada)) {
                        vidas = -1;
                        break;
                    } else {
                        System.out.println(guardado);
                    }
                }
            } else {
                vidas--;
                System.out.println("Te quedan " + vidas + " vidas");
                if (vidas == 4) {
                    Dibujos ahorcado2 = new Dibujos();
                    ahorcado2.ahorcado2();
                } else if (vidas == 3) {
                    Dibujos ahorcado3 = new Dibujos();
                    ahorcado3.ahorcado3();
                } else if (vidas == 2) {
                    Dibujos ahorcado4 = new Dibujos();
                    ahorcado4.ahorcado4();
                } else if (vidas == 1) {
                    Dibujos ahorcado5 = new Dibujos();
                    ahorcado5.ahorcado5();
                }
                if (contador == 0) {
                    System.out.println(palabraAMostrar);
                } else {
                    System.out.println(guardado);
                }
            }
            //reset de stringbuilders y booleans
            palabraAMostrar = new StringBuilder();
            letraAcertada = false;
            letraRepetida = false;
            letrasRepetidas.append(caracter);
        } while (vidas > 0);
        if (vidas == 0) {
            System.out.println("Has perdido todas tus oportunidades");
            System.out.println("La palabra a adivinar era " + palabraGenerada);
            Dibujos ahorcado6 = new Dibujos();
            ahorcado6.ahorcado6();
        } else {
            System.out.println("Has acertado la palabra " + palabraGenerada);
        }
    }
}