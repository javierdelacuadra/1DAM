package servicios;

public class Opcion2Ejercicio1 {
    public void opcion2Ej1() {

        int[] posicionesCartas = new int[10];
        GenerarBaraja generarbaraja = new GenerarBaraja();
        int[] barajaCartas = generarbaraja.generarBaraja(40);
        int numero = 1;
        int contador = 1;

        for (int i = 0; i < barajaCartas.length; i++) {
            if (barajaCartas[i] == numero) {
                contador++;
            }
            if (barajaCartas[i] == numero && contador == 5) {
                posicionesCartas[numero - 1] = i + 1;
                numero++;
                contador = 1;
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
