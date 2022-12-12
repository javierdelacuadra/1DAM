package main;

import java.util.Scanner;

public class Ej16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba cuántos euros se deben pagar por cada hora de trabajo");
        int eurosHora = sc.nextInt();
        System.out.println("Escriba cuántos trabajadores tiene su empresa");
        int contadorTrabajadores = sc.nextInt();
        int cosa = contadorTrabajadores;
        int tempsueldo = 0;
        int sueldoTotal = 0;
        int contadorEmpleados = 0;

        while (cosa > 0) {
            contadorEmpleados++;
            cosa--;
            System.out.println("¿Cuántas horas ha trabajado el empleado " + contadorEmpleados + " esta semana?");
            int horas = sc.nextInt();
            tempsueldo = (eurosHora * horas);
            sueldoTotal += tempsueldo;
            System.out.println("El empleado " + contadorEmpleados + " gana " + tempsueldo + " euros a la semana");
        }
        if (contadorTrabajadores <= 0 || eurosHora <= 0) {
            System.out.println("No se ha podido calcular el resultado");
        } else {
            System.out.println("La empresa pagó " + (sueldoTotal) + " euros en total");
        }

    }
}
