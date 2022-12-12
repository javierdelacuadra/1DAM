package modelo;

public class Tablero {
    private final String[] celdas;
    public final int cantidad_celdas = 9;


    public Tablero() {
        celdas = new String[cantidad_celdas];
    }

    public String getCelda(int numeroCelda) {
        if (celdas[numeroCelda] == null)
            return " ";
        if (numeroCelda > cantidad_celdas)
            return "-";
        return celdas[numeroCelda];
    }

    public void setCelda(int numeroCelda, String valor) {
        celdas[numeroCelda] = valor;
    }
}