package main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija un ejercicio del 1 al 20");
        int numeroDeEjercicio = sc.nextInt();
        switch (numeroDeEjercicio) {
            case 1:
                System.out.println("Escriba un número");
                int numero1 = sc.nextInt();
                System.out.println("Escriba otro número");
                int numero2 = sc.nextInt();

                if (numero1>numero2) {
                    System.out.println("El primer número es mayor que el segundo");
                }
                else {
                    System.out.println("El segundo número es mayor que el primero");
                }
                break;
            case 2:
                System.out.println("Escriba un número");
                double numero = sc.nextInt();

                if (numero == 0){
                    System.out.println("El número escrito es 0");
                }
                else if (numero > 0) {
                    System.out.println("El número escrito es positivo");
                }
                else if (numero < 0) {
                    System.out.println("El número escrito es negativo");
                }
                break;
            case 3:
                System.out.println("Escriba un número");
                double numeroEjercicio3 = sc.nextInt();

                if (numeroEjercicio3%2 == 0) {
                    System.out.println("El número escrito es par");
                }
                else {
                    System.out.println("El número escrito es impar");
                }
                break;
            case 4:
                System.out.println("Escriba un número");
                double numero1Ej4 = sc.nextDouble();
                System.out.println("Escriba otro número");
                double numero2Ej4 = sc.nextDouble();

                if (numero2Ej4 == 0){
                    System.out.println("No se puede realizar la división");
                }
                else {
                    System.out.println("El resultado de su división es " + (numero1Ej4/numero2Ej4));
                }
                break;
            case 5:
                System.out.println("Escriba su nombre de usuario");
                String nombre = sc.next();
                System.out.println("Escriba su contraseña");
                String password = sc.next();

                if (nombre.equals("pepe") && password.equals("asdasd")){
                    System.out.println("Has entrado al sistema");
                }
                else {
                    System.out.println("El nombre de usuario o la contraseña son incorrectos");
                }
                break;
            case 6:
                System.out.println("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                break;
            case 7:
                System.out.println("Para hacer una potencia se necesita la base y el exponente");
                System.out.println("Escriba la base");
                double base = sc.nextInt();
                System.out.println("Escriba el exponente");
                double exponente = sc.nextInt();

                if (exponente == 0) {
                    System.out.println("El resultado es 1");
                }
                else if (exponente > 0) {
                    System.out.println("El resultado es " + (Math.pow(base,exponente)));
                }
                else if (exponente < 0) {
                    System.out.println("El resultado es " + (1/(Math.pow(base,Math.abs(exponente)))));
                }
                break;
            case 8:
                for (int i = 0; i <= 1000; i++){
                    System.out.println(i);
                }
                break;
            case 9:
                System.out.println("Escribe un número");
                int numero1Ej9 = sc.nextInt();
                System.out.println("Escribe otro número");
                int numero2Ej9 = sc.nextInt();
                System.out.println("Escribe otro número");
                int numero3Ej9 = sc.nextInt();

                if (numero1Ej9 > numero2Ej9 && numero2Ej9 > numero3Ej9) {
                    System.out.println(numero1Ej9 + ", " + numero2Ej9 + ", " + numero3Ej9);
                }
                else if (numero1Ej9 > numero3Ej9 && numero3Ej9 > numero2Ej9) {
                    System.out.println(numero1Ej9 + ", " + numero3Ej9 + ", " + numero2Ej9);
                }
                else if (numero2Ej9 > numero1Ej9 && numero1Ej9 > numero3Ej9) {
                    System.out.println(numero2Ej9 + ", " + numero1Ej9 + ", " + numero3Ej9);
                }
                else if (numero2Ej9 > numero3Ej9 && numero3Ej9 > numero1Ej9) {
                    System.out.println(numero2Ej9 + ", " + numero3Ej9 + ", " + numero1Ej9);
                }
                else if (numero3Ej9 > numero1Ej9 && numero1Ej9 > numero2Ej9) {
                    System.out.println(numero3Ej9 + ", " + numero1Ej9 + ", " + numero2Ej9);
                }
                else if (numero3Ej9 > numero2Ej9 && numero2Ej9 > numero1Ej9) {
                    System.out.println(numero3Ej9 + ", " + numero2Ej9 + ", " + numero1Ej9);
                }
                break;
            case 10:
                System.out.println("Los Agentes de la autoridad y el personal de obras, ¿están obligados " +
                        "a utilizar dispositivos retrorreflectantes que permitan distinguirlos " +
                        "a una distancia mínima de 150 metros?");
                System.out.println("A: Sí, siempre. B: Sí, pero sólo de noche. C: No.");
                String pregunta1 = sc.next();
                if (pregunta1.equalsIgnoreCase("A") || pregunta1.equalsIgnoreCase("B") || pregunta1.equalsIgnoreCase("C")) {
                    System.out.println("pero si pone A, B o C");
                }
                else {
                    System.out.println("Enhorabuena has perdido 30 segundos de tu vida pensando la respuesta");
                    System.out.println("Ha llegado al final de la encuesta y tu respuesta fue la " + pregunta1);
                }
                break;
            case 11:
                System.out.println("Introduzca la longitud del primer cateto de un triángulo");
                int lado1 =sc.nextInt();
                System.out.println("Introduzca la longitud del segundo cateto de un triángulo");
                int lado2 =sc.nextInt();
                System.out.println("Introduzca la longitud de la hipotenusa de un triángulo");
                int lado3 =sc.nextInt();

                if (Math.pow(lado3,2) == (Math.pow(lado2,2)+Math.pow(lado1,2))) {
                    System.out.println("El triángulo es rectángulo");
                }
                else if (lado1 == lado2 && lado2 == lado3) {
                    System.out.println("El triángulo es equilátero");
                }
                else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                    System.out.println("El triángulo es isósceles");
                }
                else {
                    System.out.println("El triángulo es escaleno");
                }
                break;
            case 12:
                System.out.println("Escriba un año");
                int year = sc.nextInt();
                if (year < 0) {
                    System.out.println("El programa no soporta años antes de Cristo. " +
                            "Por favor contacte con el vendedor de su producto.");
                }
                else if (year%4 == 0 && year%400 == 0) {
                    System.out.println("El año es bisiesto");
                }
                else if (year%4 == 0 && year%100 == 0) {
                    System.out.println("El año no es bisiesto");
                }
                else if (year%4 == 0) {
                    System.out.println("El año es bisiesto");
                }
                else {
                    System.out.println("El año no es bisiesto");
                }
                break;
            case 13:
                System.out.println("Introduzca un día");
                int day = sc.nextInt();
                System.out.println("Introduzca un mes (en número)");
                int month = sc.nextInt();
                System.out.println("Introduzca un año");
                int yearEj13 = sc.nextInt();

                if (day > 31 || month > 12) {
                    System.out.println("La fecha no existe");
                }
                else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                    System.out.println("La fecha no existe");
                }
                else if (month == 2 && day == 29 && (yearEj13%4 == 0 && yearEj13%400 == 0)) {
                    System.out.println("La fecha es correcta");
                }
                else if (month == 2 && day == 29 && (yearEj13%4 == 0 && yearEj13%100 == 0)) {
                    System.out.println("La fecha no existe");
                }
                else if (month == 2 && day == 29 && (yearEj13%4 == 0)) {
                    System.out.println("La fecha es correcta");
                }
                else if (month == 2 && day > 28) {
                    System.out.println("La fecha no existe");
                }
                else {
                    System.out.println("La fecha es correcta");
                }
                break;
            case 14:
                System.out.println("Indique el tipo de uva que vende (A o B)");
                String tipoDeUva = sc.next();

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
                break;
            case 15:
                System.out.println("Inserte el número de alumnos");
                int alumnos = sc.nextInt();

                if (alumnos >= 100) {
                    System.out.println("El precio del viaje es de " + (alumnos*65) + " euros");
                }
                else if (alumnos >= 50) {
                    System.out.println("El precio del viaje es de " + (alumnos*70) + " euros");
                }
                else if (alumnos >=30) {
                    System.out.println("El precio del viaje es de " + (alumnos*90) + " euros");
                }
                else {
                    System.out.println("El precio del viaje es de 4000 euros");
                }
                break;
            case 16:
                System.out.println("Indique la longitud de su llamada (en minutos)");
                double tiempoLlamada = sc.nextDouble();
                if (tiempoLlamada < 0.01) {
                    System.out.println("No se ha podido realizar la llamada");
                }
                else {
                    System.out.println("Indique si la llamada se realizó en domingo: (Escriba 1 para sí y 2 para no)");
                    int yoCuandoEsDomingo = sc.nextInt();

                    if (yoCuandoEsDomingo > 2 || yoCuandoEsDomingo < 1) {
                        System.out.println("No se ha podido realizar la llamada");
                    }
                    else {
                        System.out.println("Indique la hora de realización de la llamada: (Escriba 1 para mañana y 2 para tarde)");
                        int morningAfternoon = sc.nextInt();
                        if (tiempoLlamada < 5 && yoCuandoEsDomingo == 1) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.18*tiempoLlamada)) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.13*tiempoLlamada)) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada < 5) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.15*tiempoLlamada)) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + ((tiempoLlamada)+(0.1*tiempoLlamada)) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada < 8 && yoCuandoEsDomingo == 1) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.18*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.13*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada < 8) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.15*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (5+(0.8*(tiempoLlamada-5))+(0.1*(5+(0.8*(tiempoLlamada-5))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada < 10 && yoCuandoEsDomingo == 1) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.18*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.13*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada < 10) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.15*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (7.4+(0.7*(tiempoLlamada-8))+(0.1*(7.4+(0.7*(tiempoLlamada-8))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada >= 10 && yoCuandoEsDomingo == 1) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.18*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.13*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else if (tiempoLlamada >= 10) {
                            switch (morningAfternoon) {
                                case 1:
                                    System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.15*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                                    break;
                                case 2:
                                    System.out.println("El coste final de su llamada es " + (8.8+(0.5*(tiempoLlamada-10))+(0.1*(8.8+(0.5*(tiempoLlamada-10))))) + " euros");
                                    break;
                                default: System.out.println("No se ha podido realizar la llamada");
                            }
                        }
                        else {
                            System.out.println("Si encuentras este error eres increíble");
                        }
                    }
                }
                break;
            case 17:
                System.out.println("Introduzca número del dado (1-6): ");
                int numeroEj17 = sc.nextInt();

                switch (numeroEj17) {
                    case 1:
                        System.out.println("En la cara opuesta está el seis");
                        break;
                    case 2:
                        System.out.println("En la cara opuesta está el cinco");
                        break;
                    case 3:
                        System.out.println("En la cara opuesta está el cuatro");
                        break;
                    case 4:
                        System.out.println("En la cara opuesta está el tres");
                        break;
                    case 5:
                        System.out.println("En la cara opuesta está el dos");
                        break;
                    case 6:
                        System.out.println("En la cara opuesta está el uno");
                        break;
                    default:
                        System.out.println("error: número incorrecto");
                }
                break;
            case 18:
                System.out.println("Escribe un día de la semana (del 1 al 7)");
                int dia = sc.nextInt();

                if (dia == 1) {
                    System.out.println("Lunes");
                }
                else if (dia == 2) {
                    System.out.println("Martes");
                }
                else if (dia == 3) {
                    System.out.println("Miércoles");
                }
                else if (dia == 4) {
                    System.out.println("Jueves");
                }
                else if (dia == 5) {
                    System.out.println("Viernes");
                }
                else if (dia == 6) {
                    System.out.println("Sábado");
                }
                else if (dia == 7) {
                    System.out.println("Domingo");
                }
                else {
                    System.out.println("El número seleccionado no corresponde con ningún día de la semana");
                }
                break;
            case 19:
                System.out.println("Escribe un mes en número (del 1 al 12)");
                int mes = sc.nextInt();

                if (mes == 1 || mes == 3 ||mes == 5 ||mes == 7 ||mes == 8 ||mes == 10 ||mes == 12) {
                    System.out.println("El mes tiene 31 días");
                }
                else if (mes == 4 ||mes == 6 ||mes == 9 ||mes == 11) {
                    System.out.println("El mes tiene 30 días");
                }
                else if (mes == 2) {
                    System.out.println("El mes tiene 28 días");
                }
                else {
                    System.out.println("El número introducido no corresponde con ningún mes");
                }
                break;
            case 20:
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
                break;
            case 21:
                System.out.println("mi cara cuando solo hay 20 ejercicios");
                System.out.println("._.");
                break;
            default:
                System.out.println("(¬_¬)");
        }
    }
}