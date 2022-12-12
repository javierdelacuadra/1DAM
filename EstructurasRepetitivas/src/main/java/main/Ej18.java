package main;

public class Ej18 {
    public static void main(String[] args) {

        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        do {
            if (minutos > 58 && segundos == 59) {
                minutos = 0;
                segundos = 0;
                horas++;
                System.out.println(horas + ":" + minutos + ":" + segundos);
            }
            else {
                if (segundos > 58) {
                    segundos = 0;
                    minutos++;
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                }
                else {
                    segundos++;
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                }
            }
        } while (horas < 24);
        System.out.println("fin");
    }
}