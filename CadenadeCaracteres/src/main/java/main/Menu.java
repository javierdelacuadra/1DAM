package main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroEjercicio = 1;

        while (numeroEjercicio <= 10 && numeroEjercicio >= 1) {
            System.out.println("Elija un número de ejercicio del 1 al 10, pulse 0 para salir");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 1:
                    Ej1(sc);
                    break;
                case 2:
                    Ej2(sc);
                    break;
                case 3:
                    Ej3(sc);
                    break;
                case 4:
                    Ej4(sc);
                    break;
                case 5:
                    Ej5(sc);
                    break;
                case 6:
                    Ej6(sc);
                    break;
                case 7:
                    Ej7(sc);
                    break;
                case 8:
                    Ej8(sc);
                    break;
                case 9:
                    Ej9(sc);
                    break;
                case 10:
                    Ej10(sc);
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

    public static void Ej1(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba una palabra");
        String palabra = sc.nextLine();

        int contador = palabra.length();

        for (int i = 0; i < contador ; i++) {
            System.out.print(palabra.charAt(i)+" ");
        }
    }

    public static void Ej2(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Introduzca una palabra o frase");
        String frase = sc.nextLine();
        System.out.println("Introduzca una serie de carácteres");
        String cadena = sc.nextLine();

        if ((frase.substring(0, (cadena.length())).equals(cadena))) {
            System.out.println("La frase comienza por la cadena introducida");
        }
        else {
            System.out.println("La frase no comienza por la cadena introducida");
        }
    }

    public static void Ej3(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        System.out.println("Escribe una letra");
        String letra = sc.nextLine();
        int contador = 0;
        int longitud = palabra.length();
        int a = 0;
        char caracter = letra.toUpperCase().charAt(0);

        while (a < longitud) {

            if (palabra.toUpperCase().charAt(a) == caracter) {
                contador++;
            }
            a++;
        }
        System.out.println("La palabra " + palabra + " tiene el carácter " + letra + " " + contador + " veces");
    }

    public static void Ej4(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una frase");
        String frase = sc.nextLine();
        int contador = 0;
        int longitud = frase.length();
        int a = 0;
        int espacio = frase.indexOf(" ");
        char caracter = frase.charAt(espacio);

        while (a < longitud) {
            if (frase.charAt(a) == caracter) {
                contador++;
            }
            a++;
        }
        System.out.println("La frase tiene " + (contador+1) + " palabras");
    }

    public static void Ej5(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escriba su nombre completo");
        String nombre = sc.nextLine();

        int longitud = nombre.length();
        int a = 0;
        int espacio = nombre.indexOf(" ");
        char caracter = nombre.charAt(espacio);
        System.out.print(nombre.toUpperCase().charAt(0) + " ");
        while (a < longitud) {
            if (nombre.charAt(a) == caracter) {
                System.out.print(nombre.toUpperCase().charAt(a + 1) + " ");
            }
            a++;
        }
    }

    public static void Ej6(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        int longitud = palabra.length();

        for (int i = 0; i < longitud; i++) {
            System.out.print(palabra.charAt(longitud-i-1));
        }
    }

    public static void Ej7(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o frase");
        String palabra = sc.nextLine();
        System.out.println("Escribe un carácter");
        String caracter1 = sc.nextLine();


        while (caracter1.length() != 1) {
            System.out.println("El carácter introducido no es correcto, introduzca otro");
            caracter1 = sc.nextLine();
        }

        System.out.println("Escribe otro carácter");
        String caracter2 = sc.nextLine();

        while (caracter2.length() != 1) {
            System.out.println("El carácter introducido no es correcto, introduzca otro");
            caracter2 = sc.nextLine();
        }

        String resultado = palabra.replace(caracter1, caracter2);
        System.out.println(resultado);

    }

    public static void Ej8(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o frase");
        String palabra = sc.nextLine();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.codePointAt(i) > 64 && palabra.codePointAt(i) < 91) {
                System.out.print(palabra.toLowerCase().charAt(i));
            }
            else if (palabra.codePointAt(i) > 96 && palabra.codePointAt(i) < 123) {
                System.out.print(palabra.toUpperCase().charAt(i));
            }
            else if (palabra.codePointAt(i) == 32) {
                System.out.print(" ");
            }
        }
    }

    public static void Ej9(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Introduzca una palabra o frase");
        String frase = sc.nextLine();
        System.out.println("Introduzca una serie de carácteres");
        String cadena = sc.nextLine();
        boolean coincide = true;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.substring(i, (i+cadena.length())).equals(cadena)) {
                coincide = true;
                break;
            }
            else {
                coincide = false;
            }
        }
        if (coincide) {
            System.out.println("La frase sí contiene la serie de carácteres introducidos");
        }
        else {
            System.out.println("La frase no contiene la serie de carácteres introducidos");
        }
    }

    public static void Ej10(Scanner sc) {
        sc = new Scanner(System.in);

        System.out.println("Escribe una palabra");
        String palabra = sc.nextLine();
        boolean esPalindromo = true;
        int longitud = palabra.length();

        int i;
        if (longitud % 2 == 0) {
            for (i = 0; i <= ((longitud / 2) - 1); i++) {
                if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                    esPalindromo = false;
                    break;
                }
            }
        } else {
            for (i = 0; i < ((longitud / 2)); i++) {
                if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                    esPalindromo = false;
                    break;
                }
            }
        }
        if (esPalindromo) {
            System.out.println("La palabra introducida es un palíndromo");
        }
        else {
            System.out.println("La palabra introducida no es un palíndromo");
        }
    }
}