package data;

import modelo.Tablero;

public class DaoTablero {

    private Tablero tablero;

    public DaoTablero() {
        tablero = new Tablero();
    }

    public boolean comprobarGanador() {
        boolean ganador;

        ganador = (!tablero.getCelda(0).equals(" ") && tablero.getCelda(0).equals(tablero.getCelda(1))
                && tablero.getCelda(1).equals(tablero.getCelda(2)));

        if (!tablero.getCelda(3).equals(" ") && tablero.getCelda(3).equals(tablero.getCelda(4))
                && tablero.getCelda(4).equals(tablero.getCelda(5))) {
            ganador = true;
        }
        if (!tablero.getCelda(6).equals(" ") && tablero.getCelda(6).equals(tablero.getCelda(7))
                && tablero.getCelda(7).equals(tablero.getCelda(8))) {
            ganador = true;
        }
        if (!tablero.getCelda(0).equals(" ") && tablero.getCelda(0).equals(tablero.getCelda(3))
                && tablero.getCelda(3).equals(tablero.getCelda(6))) {
            ganador = true;
        }
        if (!tablero.getCelda(1).equals(" ") && tablero.getCelda(1).equals(tablero.getCelda(4))
                && tablero.getCelda(4).equals(tablero.getCelda(7))) {
            ganador = true;
        }
        if (!tablero.getCelda(2).equals(" ") && tablero.getCelda(2).equals(tablero.getCelda(5))
                && tablero.getCelda(5).equals(tablero.getCelda(8))) {
            ganador = true;
        }
        if (!tablero.getCelda(0).equals(" ") && tablero.getCelda(0).equals(tablero.getCelda(4))
                && tablero.getCelda(4).equals(tablero.getCelda(8))) {
            ganador = true;
        }
        if (!tablero.getCelda(2).equals(" ") && tablero.getCelda(2).equals(tablero.getCelda(4))
                && tablero.getCelda(4).equals(tablero.getCelda(6))) {
            ganador = true;
        }
        return ganador;
    }

    public String mostrarTablero() {
        StringBuilder tableroString = new StringBuilder();
        for (int i = 0; i < tablero.cantidad_celdas; i++) {
            tableroString.append("[").append(tablero.getCelda(i)).append("]");
            if ((i + 1) % 3 == 0) {
                tableroString.append("\n");
            }
        }
        return tableroString.toString();
    }

    public boolean comprobarFicha(int posicionFicha, String ficha) {
        boolean fichaColocada = false;
        if (posicionFicha <= 8 && tablero.getCelda(posicionFicha).equals(" ")) {
            tablero.setCelda(posicionFicha, ficha);
            fichaColocada = true;
        }
        return fichaColocada;
    }
}