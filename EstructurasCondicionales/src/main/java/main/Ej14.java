package main;

import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el tipo de uva que vende (A o B)");
        String tipoDeUva = sc.nextLine();
        if (tipoDeUva.equalsIgnoreCase("A") || tipoDeUva.equalsIgnoreCase("B")) {
            System.out.println("Indique el tamaño de la uva (1 o 2)");
            int tamanoDeUva = sc.nextInt();
            if (tamanoDeUva > 2 || tamanoDeUva < 1) {
                System.out.println("Está prohibida la venta de uva en Uzbekistán");
            }
            else {
                System.out.println("Indique la cantidad de uva que vende (en kilos)");
                double cantidadDeUva = sc.nextDouble();
                if (cantidadDeUva < 0) {
                    System.out.println("Está prohibida la venta de uva en Uzbekistán");
                }
                else if (tipoDeUva.equalsIgnoreCase("A") && tamanoDeUva == 1) {
                    System.out.println("El beneficio es de " + 0.2*cantidadDeUva + " euros");
                }
                else if (tipoDeUva.equalsIgnoreCase("A") && tamanoDeUva == 2) {
                    System.out.println("El beneficio es de " + 0.3*cantidadDeUva + " euros");
                }
                else if (tipoDeUva.equalsIgnoreCase("B") && tamanoDeUva == 1) {
                    System.out.println("El beneficio es de " + -0.3*cantidadDeUva + " euros");
                }
                else if (tipoDeUva.equalsIgnoreCase("B") && tamanoDeUva == 2) {
                    System.out.println("El beneficio es de " + -0.5*cantidadDeUva + " euros");
                }
                else {
                    System.out.println("error 404 uva not found");
                }
            }
        }
        else {
            System.out.println("Está prohibida la venta de uva en Uzbekistán");
        }
    }
}