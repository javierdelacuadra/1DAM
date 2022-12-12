package main;

import java.util.Scanner;

public class CifradoVigenere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CifradoVigenere cifradoVigenere = new CifradoVigenere();
        cifradoVigenere.CifradoVigenere(sc);
    }

    public void CifradoVigenere(Scanner sc) {

        System.out.println("Escribe el texto que quieras cifrar");
        String texto = sc.nextLine();
        System.out.println("Escriba una clave para cifrar el texto");
        String clave = sc.nextLine();
        int longitud = clave.length();
        int letraNumero = 0;
        int numeroClave = 0;
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.codePointAt(i) > 64 && texto.codePointAt(i) < 91) {
                letraNumero = (texto.codePointAt(i) - 13) % 26;
                numeroClave = clave.toUpperCase().codePointAt(contador % clave.length());
                numeroClave = ((numeroClave - 13) % 26);
                String cifrado = Character.toString(((letraNumero + numeroClave) % 26) + 65);
                System.out.print(cifrado);
                contador++;
            } else if (texto.codePointAt(i) > 96 && texto.codePointAt(i) < 123) {
                letraNumero = (texto.codePointAt(i) + 7) % 26;
                numeroClave = clave.toLowerCase().codePointAt(contador % clave.length());
                numeroClave = ((numeroClave + 7) % 26);
                String cifrado = Character.toString(((letraNumero + numeroClave) % 26) + 97);
                System.out.print(cifrado);
                contador++;
            } else {
                System.out.print(texto.charAt(i));
            }
        }
    }
}
