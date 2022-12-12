package data;

import modelo.Juego;

import java.util.Objects;

public class DaoJuego {

    private Juego[] juegos;
    private final int juegosMaximos = 10;

    public DaoJuego() {
        juegos = new Juego[juegosMaximos];

    }

    public String texto(int numero) {
        String muchotexto = " ";
        switch (numero) {
            case 1:
                muchotexto = "1. Añadir juego 2. Cambiar puntuación de juego 3. Borrar juego 4. Obtener puntuación de un juego 5. Ver todos los juegos (0 para salir)";
                break;
            case 2:
                break;
        }
        return muchotexto;
    }

    public boolean addJuego(String nombreJuego) {
        boolean juegoadd = false;
        for (int i = 0; i < juegos.length; i++) {
            if (juegos[i] == null || Objects.equals(juegos[i].getNombre(), "Juego borrado")) {
                juegos[i] = new Juego(nombreJuego, 0);
                i = 10;
                juegoadd = true;
            }
        }
        return juegoadd;
    }

    public boolean cambiarPuntuacion(int numero, int nota) {
        boolean puntuacionCambiada = false;
        if (juegos[numero - 1] != null) {
            if (nota <= 10 && nota >= 0 && !Objects.equals(juegos[numero - 1].getNombre(), "Juego borrado")) {
                juegos[numero - 1].setNota(nota);
                puntuacionCambiada = true;
            }
        }
        return puntuacionCambiada;
    }

    public boolean borrarJuego(int juegoABorrar) {
        boolean juegoBorrado = false;
        if (juegos[juegoABorrar - 1] != null && !Objects.equals(juegos[juegoABorrar - 1].getNombre(), "Juego borrado")) {
            juegos[juegoABorrar - 1].setNombre("Juego borrado");
            juegos[juegoABorrar - 1].setNota(0);
            juegoBorrado = true;
        }
        return juegoBorrado;
    }


    public int obtenerPuntuacionJuego(int numero) {
        int puntuacion = 0;
        if (juegos[numero - 1] == null) {
            puntuacion = -1;
        } else if (Objects.equals(juegos[numero - 1].getNombre(), "Juego borrado")) {
            puntuacion = -1;
        } else {
            puntuacion = juegos[numero - 1].getNota();
        }
        return puntuacion;
    }

    public String verJuegos() {
        StringBuilder juegosString = new StringBuilder();
        int contador = 1;
        for (int i = 0; i < juegos.length; i++) {
            if (juegos[i] != null) {
                juegosString.append(contador).append(". ").append(juegos[i].getNombre()).append("\n");
                contador++;
            }
        }
        if (contador == 1) {
            juegosString.append("No hay juegos en la base de datos");
        }
        return juegosString.toString();
    }
}