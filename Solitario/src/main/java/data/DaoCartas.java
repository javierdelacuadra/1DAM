package data;

import modelo.Carta;
import modelo.Palos;

import java.util.Arrays;
import java.util.Random;

import static modelo.Palos.OROS;

public class DaoCartas {

    private final Carta[] barajaCartas;
    public Carta[] barajaTemporal;
    private Carta[] descartes;
    private Carta[] cartasEnJuego;
    private int[] pila;
    private int contadorCarta;


    private final int cartasTotalesBaraja = 40;

    public DaoCartas() {
        barajaCartas = new Carta[cartasTotalesBaraja];
        barajaTemporal = new Carta[cartasTotalesBaraja];
        pila = new int[4];
        descartes = new Carta[cartasTotalesBaraja];
        cartasEnJuego = new Carta[3];
        contadorCarta = 0;
        generarBaraja();
        barajar();
    }

    public void generarBaraja() {
        int numero = 1;
        for (int i = 0; i < barajaCartas.length; i++) {
            barajaCartas[i] = new Carta(numero, OROS);
            i++;
            barajaCartas[i] = new Carta(numero, Palos.ESPADAS);
            i++;
            barajaCartas[i] = new Carta(numero, Palos.COPAS);
            i++;
            barajaCartas[i] = new Carta(numero, Palos.BASTOS);
            numero++;
        }
    }

    public void barajar() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int random1 = r.nextInt(40);
            int random2 = r.nextInt(40);
            Carta cambio = barajaCartas[random1];
            barajaCartas[random1] = barajaCartas[random2];
            barajaCartas[random2] = cambio;
        }
    }

    public void sacarDosCartas() {
        if (contadorCarta < 38) {
            cartasEnJuego[0] = barajaCartas[contadorCarta];
            cartasEnJuego[1] = barajaCartas[contadorCarta + 1];
            contadorCarta += 2;
        }
    }

    public boolean comprobarCarta1() {
        int palo = 0;
        if (cartasEnJuego[0] != null) {
            palo = (cartasEnJuego[0].getPalo().ordinal());
        }
        boolean sePuedeEcharCarta1 = false;
        if (cartasEnJuego[0].getValorCarta() == pila[palo] + 1) {
            sePuedeEcharCarta1 = true;
            barajaCartas[contadorCarta - 2] = null;
            pila[palo]++;
        }

        return sePuedeEcharCarta1;
    }

    public boolean comprobarCarta2() {
        int palo;
        boolean sePuedeEcharCarta2 = false;
        if (cartasEnJuego[1] != null) {
            palo = (cartasEnJuego[1].getPalo().ordinal());
            if (cartasEnJuego[1].getValorCarta() == pila[palo] + 1) {
                sePuedeEcharCarta2 = true;
                barajaCartas[contadorCarta - 1] = null;
                pila[palo]++;
            }
        }

        return sePuedeEcharCarta2;
    }

    public void mandarCarta1ADescartes() {
        for (int i = descartes.length - 1; i > 0; i--) {
            if (descartes[i] == null) {
                descartes[i] = cartasEnJuego[0];
                i = -1;
            }
        }
    }

    public void mandarCarta2ADescartes() {
        for (int i = descartes.length - 1; i > 0; i--) {
            if (descartes[i] == null) {
                descartes[i] = cartasEnJuego[1];
                i = -1;
            }
        }
    }

    public boolean comprobarDescartes() {
        boolean cartaDescartesColocada = false;
        int palo = 0;

        for (int i = 0; i < descartes.length; i++) {
            if (descartes[0] != null) {
                palo = (descartes[i].getPalo().ordinal());
            }
            if (descartes[i] != null && descartes[i].getValorCarta() == pila[palo] + 1) {
                cartaDescartesColocada = true;
                pila[palo]++;
                descartes[i] = null;
                i = 40;
            } else if (descartes[i] != null) {
                i = 40;
            }
        }

        return cartaDescartesColocada;
    }

    public void darVueltaABaraja() {
        int contadorBaraja = 0;
        barajaTemporal = new Carta[cartasTotalesBaraja];
        for (int i = 0; i < barajaCartas.length; i++) {
            if (barajaCartas[i] != null) {
                barajaTemporal[contadorBaraja] = barajaCartas[i];
                contadorBaraja++;
            }
        }
        for (int i = 0; i < barajaTemporal.length; i++) {
            barajaCartas[i] = barajaTemporal[i];
        }
        contadorCarta = 0;
    }

    public boolean comprobarJuegoTerminado() {
        boolean juegoTerminado = true;
        for (int i = 0; i < pila.length; i++) {
            if (pila[i] != 10) {
                juegoTerminado = false;
            }
        }
        if (cartasMaximas() == 0) {
            juegoTerminado = true;
        }
        return juegoTerminado;
    }

    public int cartasMaximas() {
        int cartasMaximas = 0;

        for (int i = 0; i < pila.length; i++) {
            cartasMaximas += pila[i];
        }
        cartasMaximas = 40 - cartasMaximas;

        return cartasMaximas;
    }

    public boolean comprobarAcabadoRonda() {
        boolean rondaTerminada = false;
        int contador = 0;
        for (int i = 0; i < barajaCartas.length; i++) {
            if (barajaCartas[i] != null) {
                contador++;
            }
        }
        if (contadorCarta > contador - 2) {
            rondaTerminada = true;
        }

        return rondaTerminada;
    }

    public String mostrarPila() {
        return "Pila: " + Arrays.toString(pila);
    }

    public String texto(int numero) {
        String muchotexto;

        switch (numero) {
            case 1:
                muchotexto = "La carta ha sido echada con éxito";
                break;
            case 2:
                muchotexto = "comprobando descartes...";
                break;
            case 3:
                muchotexto = "No se ha podido echar la carta";
                break;
            case 4:
                muchotexto = "La carta de descartes no se podía echar o no había cartas en la pila de descartes";
                break;
            case 5:
                muchotexto = "Sacando 2 cartas...";
                break;
            case 6:
                muchotexto = "Pila: " + Arrays.toString(pila);
                break;
            case 7:
                muchotexto = "Dando vuelta a la baraja...";
                break;
            case 8:
                muchotexto = "Carta 1: \n" + cartasEnJuego[0].getValorCarta() + " de " + cartasEnJuego[0].getPalo();
                break;
            case 9:
                muchotexto = "Carta 2: \n" + cartasEnJuego[1].getValorCarta() + " de " + cartasEnJuego[1].getPalo();
                break;
            default:
                muchotexto = "error 404 solitario not found";
                break;
        }
        return muchotexto;
    }
}