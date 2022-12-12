package servicios;

public class Opcion1Ejercicio2 {
    public void opcion1Ej2() {

        int[] posicionesCartas = new int[10];
        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaCartas = generarbaraja.generarBaraja(40);
        int numero = 1;

        for (int i = 0; i < barajaCartas.length; i++) {
            if (barajaCartas[i] == numero) {
                posicionesCartas[numero - 1] = i + 1;
                numero++;
                i = -1;
            }
        }
        for (int i = 0; i < barajaCartas.length; i++) {
            System.out.print(barajaCartas[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < posicionesCartas.length; i++) {
            System.out.print(posicionesCartas[i] + " ");
        }
    }
}