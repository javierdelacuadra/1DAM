package data;

import modelo.Tablero;

import java.util.Arrays;
import java.util.Objects;

public class DaoTablero {

    private final int tamX = 6;
    private final int tamY = 7;
    private Tablero tablero;
    private int[] columnas;

    public DaoTablero() {
        tablero = new Tablero(tamX, tamY);
        columnas = new int[tamY];
        Arrays.fill(columnas, 6);
    }

    public String mostrarTablero() {
        StringBuilder tableroString = new StringBuilder();
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                tableroString.append("[").append(tablero.getCelda(i, j)).append("]");
            }
            tableroString.append("\n");
        }
        return tableroString.toString();
    }

    public boolean comprobarFicha(int columna, String ficha) {
        boolean fichaColocada = false;

        if (columna < 7 && columnas[columna] > 0) {
            tablero.setCelda(columnas[columna] - 1, columna, ficha);
            columnas[columna]--;
            fichaColocada = true;
        }

        return fichaColocada;
    }

    public boolean comprobarGanador(int columna) {
        boolean ganador = false;
        int posicionY = columnas[columna];

        int contador = 1;
        boolean cambioDireccion = false;
        //comprobación horizontal
        if (columna < 6 && !Objects.equals(tablero.getCelda((columna + 1), posicionY), " ") && tablero.getCelda(columna, posicionY).equals(tablero.getCelda((columna + 1), posicionY))) {
            contador++;
        } else cambioDireccion = true;
        if (columna < 5 && !Objects.equals(tablero.getCelda((columna + 2), posicionY), " ") && !cambioDireccion && tablero.getCelda((columna + 1), posicionY).equals(tablero.getCelda((columna + 2), posicionY))) {
            contador++;
        } else cambioDireccion = true;
        if (columna < 4 && !Objects.equals(tablero.getCelda((columna + 3), posicionY), " ") && !cambioDireccion && tablero.getCelda((columna + 2), posicionY).equals(tablero.getCelda((columna + 3), posicionY))) {
            contador++;
        }
        if (columna > 0 && !Objects.equals(tablero.getCelda((columna - 1), posicionY), " ") && tablero.getCelda(columna, posicionY).equals(tablero.getCelda(columna - 1, posicionY))) {
            contador++;
        } else cambioDireccion = true;
        if (columna > 1 && !Objects.equals(tablero.getCelda((columna - 2), posicionY), " ") && !cambioDireccion && tablero.getCelda(columna - 1, posicionY).equals(tablero.getCelda(columna - 2, posicionY))) {
            contador++;
        } else cambioDireccion = true;
        if (columna > 2 && !Objects.equals(tablero.getCelda((columna - 3), posicionY), " ") && !cambioDireccion && tablero.getCelda(columna - 2, posicionY).equals(tablero.getCelda(columna - 3, posicionY))) {
            contador++;
        }
        if (contador >= 4) {
            ganador = true;
        } else {
            contador = 1;
            cambioDireccion = false;
            //comprobación vertical
            if (posicionY < 5 && !Objects.equals(tablero.getCelda((columna), posicionY + 1), " ") && tablero.getCelda(columna, posicionY).equals(tablero.getCelda(columna, posicionY + 1))) {
                contador++;
            } else cambioDireccion = true;
            if (posicionY < 4 && !Objects.equals(tablero.getCelda((columna), posicionY + 2), " ") && !cambioDireccion && tablero.getCelda(columna, posicionY + 1).equals(tablero.getCelda(columna, posicionY + 2))) {
                contador++;
            } else cambioDireccion = true;
            if (posicionY < 3 && !Objects.equals(tablero.getCelda((columna), posicionY + 3), " ") && !cambioDireccion && tablero.getCelda(columna, posicionY + 2).equals(tablero.getCelda(columna, posicionY + 3))) {
                contador++;
            }
            if (contador >= 4) {
                ganador = true;
            } else {
                contador = 1;
                cambioDireccion = false;
                //comprobación diagonal
                if (columna < 6 && posicionY < 5 && !Objects.equals(tablero.getCelda((columna + 1), posicionY + 1), " ") && tablero.getCelda(columna, posicionY).equals(tablero.getCelda(columna + 1, posicionY + 1))) {
                    contador++;
                } else cambioDireccion = true;
                if (columna < 5 && posicionY < 4 && !Objects.equals(tablero.getCelda((columna + 2), posicionY + 2), " ") && !cambioDireccion && tablero.getCelda(columna + 1, posicionY + 1).equals(tablero.getCelda(columna + 2, posicionY + 2))) {
                    contador++;
                } else cambioDireccion = true;
                if (columna < 4 && posicionY < 3 && !Objects.equals(tablero.getCelda((columna + 3), posicionY + 3), " ")  && !cambioDireccion && tablero.getCelda(columna + 2, posicionY + 2).equals(tablero.getCelda(columna + 3, posicionY + 3))) {
                    contador++;
                }
                if (columna > 0 && posicionY > 0 && !Objects.equals(tablero.getCelda((columna - 1), posicionY - 1), " ") && tablero.getCelda(columna, posicionY).equals(tablero.getCelda(columna - 1, posicionY - 1))) {
                    contador++;
                } else cambioDireccion = true;
                if (columna > 1 && posicionY > 1 && !Objects.equals(tablero.getCelda((columna - 2), posicionY - 2), " ") && !cambioDireccion && tablero.getCelda(columna - 1, posicionY - 1).equals(tablero.getCelda(columna - 2, posicionY - 2))) {
                    contador++;
                } else cambioDireccion = true;
                if (columna > 2 && posicionY > 2 && !Objects.equals(tablero.getCelda((columna - 3), posicionY - 3), " ") && !cambioDireccion && tablero.getCelda(columna - 2, posicionY - 2).equals(tablero.getCelda(columna - 3, 0))) {
                    contador++;
                }
                if (contador >= 4) {
                    ganador = true;
                }
            }
        }
        return ganador;
    }
}