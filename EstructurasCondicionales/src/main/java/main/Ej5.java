package main;

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba su nombre de usuario");
        String nombre = sc.nextLine();
        System.out.println("Escriba su contraseña");
        String password = sc.nextLine();

        if (nombre.equals("pepe") && password.equals("asdasd")){
            System.out.println("Has entrado al sistema");
        }
        else {
            System.out.println("El nombre de usuario o la contraseña son incorrectos");
        }
    }
}
