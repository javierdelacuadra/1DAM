package main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cifrado = 1;
        while (cifrado <= 4 && cifrado >= 1) {
            System.out.println("Elige el método de cifrado o descifrado que quieres usar o pulsa 0 para salir");
            System.out.println("1. Cesar (cifrado) 2. Cesar (descifrado) 3. Vigenere (cifrado) 4. Vigenere (descifrado)");
            cifrado = sc.nextInt();
            sc.nextLine();

            switch (cifrado) {
                case 1:
                    Cifrado cifradocesar = new Cifrado();
                    cifradocesar.CifradoCesar(sc);
                    System.out.println("\n");
                    break;
                case 2:
                    Descifrado descifradocesar = new Descifrado();
                    descifradocesar.DescifradoCesar(sc);
                    System.out.println("\n");
                    break;
                case 3:
                    CifradoVigenere cifradoVigenere = new CifradoVigenere();
                    cifradoVigenere.CifradoVigenere(sc);
                    System.out.println("\n");
                    break;
                case 4:
                    DescifradoVigenere descifradoVigenere = new DescifradoVigenere();
                    descifradoVigenere.DescifradoVigenere(sc);
                    System.out.println("\n");
                    break;
                case 0:
                    System.out.println("El programa se ha cerrado con éxito");
                    break;
                default:
                    System.out.println("El tipo de cifrado indicado no existe");
            }
        }
    }
}
