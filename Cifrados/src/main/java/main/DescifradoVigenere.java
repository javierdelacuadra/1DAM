package main;

import java.util.Scanner;

public class DescifradoVigenere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DescifradoVigenere descifradoVigenere = new DescifradoVigenere();
        descifradoVigenere.DescifradoVigenere(sc);
    }
    public void DescifradoVigenere (Scanner sc) {

        System.out.println("Escribe el texto que quieras descifrar");
        String texto = sc.nextLine();
        System.out.println("Escriba una clave para descifrar el texto");
        String clave = sc.nextLine();
        int longitud = clave.length();
        int letraNumero = 0;
        int numeroClave = 0;
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.codePointAt(i) > 64 && texto.codePointAt(i) < 91) {
                letraNumero = (texto.codePointAt(i)-13)%26;
                numeroClave = clave.toUpperCase().codePointAt(contador%clave.length());
                numeroClave = ((numeroClave-13)%26);
                String descifrado = Character.toString(((letraNumero+26-numeroClave)%26)+65);
                System.out.print(descifrado);
                contador++;
            }
            else if (texto.codePointAt(i) > 96 && texto.codePointAt(i) < 123) {
                letraNumero = (texto.codePointAt(i)+7)%26;
                numeroClave = clave.toLowerCase().codePointAt(contador%clave.length());
                numeroClave = ((numeroClave+7)%26);
                String descifrado = Character.toString(((letraNumero+26-numeroClave)%26)+97);
                System.out.print(descifrado);
                contador++;
            }
            else {
                System.out.print(texto.charAt(i));
            }
        }
    }
}
