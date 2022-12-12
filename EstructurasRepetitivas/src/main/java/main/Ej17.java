package main;

import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba cuántos euros se deben pagar por cada hora de trabajo");
        int eurosHora = sc.nextInt();
        System.out.println("Escriba cuántos trabajadores tiene su empresa");
        int contadorTrabajadores = sc.nextInt();
        int cosa = contadorTrabajadores;
        int mediaSueldo = 0;

        while (cosa > 0) {
            cosa--;
            System.out.println("¿Cuántos días ha trabajado el empleado?");
            int dias = sc.nextInt();
            System.out.println("¿Cuántas horas trabajó cada día?");
            int horas = sc.nextInt();
            int algo = (eurosHora*horas)*dias;
            mediaSueldo += algo;
        }
        if (contadorTrabajadores <= 0 || eurosHora <= 0) {
            System.out.println("No se ha podido calcular el resultado");
        }
        else {
            System.out.println("La media de sus sueldos es de " + (mediaSueldo/contadorTrabajadores) + " euros y la empresa pagó "
                    + (mediaSueldo) + " euros");
        }
    }
}
