package ui;

import servicios.ServiciosCalculadora;
import ui.common.Constantes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiciosCalculadora scalc = new ServiciosCalculadora();
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.CALCULADORA);
        int opcion;
        int numero1;
        int numero2;
        do {
            System.out.println(Constantes.ESCRIBE_UN_NÚMERO);
            numero1 = sc.nextInt();
            System.out.println(Constantes.ESCRIBE_OTRO_NÚMERO);
            numero2 = sc.nextInt();
            System.out.println(Constantes.MENU_CALCULADORA);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (scalc.suma(numero1, numero2) != -1) {
                        System.out.println(Constantes.EL_RESULTADO_ES + scalc.suma(numero1, numero2));
                    } else System.out.println(Constantes.OPERACIÓN_INVÁLIDA);
                    break;
                case 2:
                    if (scalc.resta(numero1, numero2) != -1) {
                        System.out.println(Constantes.EL_RESULTADO_ES + scalc.resta(numero1, numero2));
                    } else System.out.println(Constantes.OPERACIÓN_INVÁLIDA);
                    break;
                case 3:
                    if (scalc.multiplicacion(numero1, numero2) != -1) {
                        System.out.println(Constantes.EL_RESULTADO_ES + scalc.multiplicacion(numero1, numero2));
                    } else System.out.println(Constantes.OPERACIÓN_INVÁLIDA);
                    break;
                case 4:
                    if (scalc.division(numero1, numero2) != -1) {
                        System.out.println(Constantes.EL_RESULTADO_ES + scalc.division(numero1, numero2));
                    } else System.out.println(Constantes.OPERACIÓN_INVÁLIDA);
                    break;
                default:
                    System.out.println(Constantes.LA_OPERACIÓN_NO_EXISTE);
            }
        } while (opcion != 0);
        System.out.println("Saliste del programa");
    }
}