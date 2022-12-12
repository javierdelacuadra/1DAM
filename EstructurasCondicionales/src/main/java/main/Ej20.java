package main;

import java.util.Scanner;

public class Ej20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el peso de su paquete en gramos");
        int peso = sc.nextInt();
        System.out.println("Elija una zona para enviar su paquete (en número)\n1. América del Norte " +
                "2. América Central 3. América del Sur 4. Europa 5. Asia");
        int zona = sc.nextInt();

        if (peso > 5000 || peso < 1) {
            System.out.println("No se puede enviar el paquete");
        }
        else if (zona == 1) {
            System.out.println("El precio del envío es de " + 24*peso + " euros");
        }
        else if (zona == 2) {
            System.out.println("El precio del envío es de " + 20*peso + " euros");
        }
        else if (zona == 3) {
            System.out.println("El precio del envío es de " + 21*peso + " euros");
        }
        else if (zona == 4) {
            System.out.println("El precio del envío es de " + 10*peso + " euros");
        }
        else if (zona == 5) {
            System.out.println("El precio del envío es de " + 18*peso + " euros");
        }
        else {
            System.out.println("La zona a la que intenta enviar el paquete no existe");
        }
    }
}
