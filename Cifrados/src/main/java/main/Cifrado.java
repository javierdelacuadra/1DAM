package main;

import java.util.Scanner;

public class Cifrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cifrado cifradocesar = new Cifrado();
        cifradocesar.CifradoCesar(sc);
    }

    public void CifradoCesar(Scanner sc) {

        System.out.println("Escribe el texto que quieras cifrar");
        String texto = sc.nextLine();
        System.out.println("Escriba un número para cifrar el texto");
        int numeroCifrado = sc.nextInt();
        int letraNumero = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.codePointAt(i) > 64 && texto.codePointAt(i) < 91) {
                letraNumero = (texto.codePointAt(i) - 11) % 27;
                if (letraNumero + numeroCifrado < 14) {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado) % 26) + 65);
                    System.out.print(cifrado);
                } else if (letraNumero + numeroCifrado == 14) {
                    System.out.print("ñ");
                } else if (letraNumero + numeroCifrado > 14 && letraNumero < 14) {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado - 1) % 26) + 65);
                    System.out.print(cifrado);
                } else {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado) % 26) + 65);
                    System.out.print(cifrado);
                }
            } else if (texto.codePointAt(i) > 96 && texto.codePointAt(i) < 123) {
                letraNumero = (texto.codePointAt(i) + 7) % 26;

                if (letraNumero + numeroCifrado < 14) {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado) % 26) + 97);
                    System.out.print(cifrado);
                } else if (letraNumero + numeroCifrado == 14) {
                    System.out.print("Ñ");
                } else if (letraNumero + numeroCifrado > 14 && letraNumero < 14) {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado - 1) % 26) + 97);
                    System.out.print(cifrado);
                } else {
                    String cifrado = Character.toString(((letraNumero + numeroCifrado) % 26) + 97);
                    System.out.print(cifrado);
                }
            } else if (texto.codePointAt(i) == 241) {
                String cifrado = Character.toString(((13 + numeroCifrado) % 26) + 97);
                System.out.print(cifrado);
            } else if (texto.codePointAt(i) == 209) {
                String cifrado = Character.toString(((13 + numeroCifrado) % 26) + 65);
                System.out.print(cifrado);
            } else {
                System.out.print(texto.charAt(i));
            }
        }
    }
}