package data;

import modelo.Tablero;

import java.util.Objects;
import java.util.Random;

public class DaoTablero {
    private final Tablero tablero;
    private final int[] fichas;
    Random r = new Random();

    public DaoTablero(int dimensiones) {
        tablero = new Tablero(2, dimensiones);
        fichas = new int[dimensiones * 2];
        generarFichas(fichas);
    }

    public void generarFichas(int[] fichas) {
        int contador = 1;
        int numero = 1;

        for (int i = 0; i < fichas.length - 1; i++) {
            int random = r.nextInt(fichas.length);
            if (fichas[random] == 0) {
                fichas[random] = numero;
                contador++;
            } else {
                i--;
            }
            if (contador > 2) {
                contador = 1;
                numero++;
            }
        }
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == 0) {
                fichas[i] = ((fichas.length) / 2);
            }
        }
    }

    public String mostrarTablero(int dimensiones) {
        StringBuilder tableroString = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dimensiones; j++) {
                tableroString.append("[").append(tablero.getCelda(i, j)).append("]");
            }
            tableroString.append("\n");
        }
        return tableroString.toString();
    }

    public boolean comprobarCartaLibre(int x, int y) {
        if (x > 2 || y > (fichas.length / 2) || x < 1 || y < 1) {
            return false;
        } else {
            return Objects.equals(tablero.getCelda(x - 1, y - 1), "*");
        }
    }

    public boolean comprobarPareja(int x1, int y1, int x2, int y2) {
        boolean hayPareja = false;
        int pos1;
        if (x1 == 1) {
            pos1 = (x1 * y1) - 1;
        } else {
            pos1 = y1 + ((fichas.length / 2) - 1);
        }
        int pos2;
        if (x2 == 1) {
            pos2 = (x2 * y2) - 1;
        } else {
            pos2 = y2 + ((fichas.length / 2) - 1);
        }
        if (fichas[pos1] == fichas[pos2]) {
            hayPareja = true;
        } else {
            tablero.setCelda(x1 - 1, y1 - 1, "*");
            tablero.setCelda(x2 - 1, y2 - 1, "*");
        }
        return hayPareja;
    }

    public void levantarFicha(int x, int y) {
        int pos;
        if (x == 1) {
            pos = (x * y) - 1;
        } else {
            pos = y + ((fichas.length / 2) - 1);
        }
        tablero.setCelda(x - 1, y - 1, String.valueOf(fichas[pos]));
    }

    public boolean juegoFinalizado() {
        boolean juegoTerminado = false;
        int contador = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (fichas.length / 2); j++) {
                if (!Objects.equals(tablero.getCelda(i, j), "*")) {
                    contador++;
                }
            }
        }
        if (contador == fichas.length) {
            juegoTerminado = true;
        }
        return juegoTerminado;
    }
}