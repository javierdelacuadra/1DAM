package ui;

import data.DaoCartas;

public class Main {
    public static void main(String[] args) {

        DaoCartas dc = new DaoCartas();

        boolean carta1Colocada = false;
        boolean carta2Colocada = false;
        boolean cartaDescartesColocada;
        boolean juegoTerminado = false;
        boolean ganador = true;
        int cartasRonda1 = 0;
        int cartasRonda2 = 0;
        int cambio = 0;

        System.out.println(dc.mostrarPila());
        do {
            do {
                // sacar 2 cartas
                dc.sacarDosCartas();
                System.out.println(dc.texto(5));
                System.out.println(dc.texto(6));

                // comprobar carta 1
                System.out.println(dc.texto(8));
                if (dc.comprobarCarta1()) {
                    carta1Colocada = true;
                    System.out.println(dc.texto(1));
                    System.out.println(dc.texto(6));
                } else {
                    System.out.println(dc.texto(3));
                }
                // comprobar carta 2
                if (!dc.comprobarJuegoTerminado()) {
                    System.out.println(dc.texto(9));
                    if (dc.comprobarCarta2()) {
                        carta2Colocada = true;
                        System.out.println(dc.texto(1));
                        System.out.println(dc.texto(6));
                    } else {
                        System.out.println(dc.texto(3));
                    }
                }

                //descartes
                if (!carta1Colocada) {
                    dc.mandarCarta1ADescartes();
                }
                if (!carta2Colocada) {
                    dc.mandarCarta2ADescartes();
                }
                //comprobar si se puede echar la primera carta de descartes
                if (carta1Colocada && carta2Colocada) {
                    System.out.println(dc.texto(2));
                    cartaDescartesColocada = true;
                    while (cartaDescartesColocada) {
                        if (!dc.comprobarDescartes()) {
                            cartaDescartesColocada = false;
                            System.out.println(dc.texto(4));
                        } else {
                            System.out.println(dc.texto(6));
                            System.out.println(dc.texto(1));
                        }
                    }
                }
                carta1Colocada = false;
                carta2Colocada = false;
            } while (!dc.comprobarAcabadoRonda());
            //comprobar si el jugador ha perdido
            if (cambio % 2 == 0) {
                cartasRonda1 = dc.cartasMaximas();
                cambio++;
                if (cartasRonda1 == cartasRonda2) {
                    juegoTerminado = true;
                    ganador = false;
                }
            } else if (cambio % 2 == 1) {
                cartasRonda2 = dc.cartasMaximas();
                if (cartasRonda1 == cartasRonda2) {
                    juegoTerminado = true;
                    ganador = false;
                } else {
                    cambio++;
                }
            }
            //comprobar si el jugador ha ganado
            if (dc.comprobarJuegoTerminado()) {
                juegoTerminado = true;
            } else {
                dc.darVueltaABaraja();
                System.out.println(dc.texto(7));
            }
        } while (!juegoTerminado);
        if (ganador) {
            System.out.println("Enhorabuena! Has conseguido ganar la partida del solitario");
        } else {
            System.out.println("No se ha echado ninguna carta desde que se dió la vuelta a la baraja así que has perdido");
        }
    }
}