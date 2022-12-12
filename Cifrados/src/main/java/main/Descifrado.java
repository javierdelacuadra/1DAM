package main;

import java.util.Scanner;

public class Descifrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Descifrado descifradocesar = new Descifrado();
        descifradocesar.DescifradoCesar(sc);
    }

    public void DescifradoCesar(Scanner sc) {

        System.out.println("Escribe el texto que quieras descifrar");
        String texto = sc.nextLine();
        System.out.println("Escriba un número para descifrar el texto");
        int numeroDescifrado = sc.nextInt();
        int letraNumero = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.codePointAt(i) > 64 && texto.codePointAt(i) < 91) {
                letraNumero = (texto.codePointAt(i) - 13) % 26;

                if (letraNumero - numeroDescifrado < 10) {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado) % 26) + 65);
                    System.out.print(cifrado);
                } else if (letraNumero - numeroDescifrado == 13) {
                    System.out.print("Ñ");
                } else if (letraNumero - numeroDescifrado > 10 && letraNumero < 16) {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado + 1) % 26) + 65);
                    System.out.print(cifrado);
                } else {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado) % 26) + 65);
                    System.out.print(cifrado);
                }
            } else if (texto.codePointAt(i) > 96 && texto.codePointAt(i) < 123) {
                letraNumero = (texto.codePointAt(i) + 7) % 26;
                if (letraNumero - numeroDescifrado < 10) {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado) % 26) + 97);
                    System.out.print(cifrado);
                } else if (letraNumero - numeroDescifrado == 13) {
                    System.out.print("ñ");
                } else if (letraNumero - numeroDescifrado > 10 && letraNumero < 16) {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado + 1) % 26) + 97);
                    System.out.print(cifrado);
                } else {
                    String cifrado = Character.toString(((letraNumero + 26 - numeroDescifrado) % 26) + 97);
                    System.out.print(cifrado);
                }
            } else if (texto.codePointAt(i) == 241) {
                String cifrado = Character.toString(((13 - numeroDescifrado + 1) % 26) + 97);
                System.out.print(cifrado);
            } else if (texto.codePointAt(i) == 209) {
                String cifrado = Character.toString(((13 - numeroDescifrado + 1) % 26) + 65);
                System.out.print(cifrado);
            } else {
                System.out.print(texto.charAt(i));
            }
        }
    }
}