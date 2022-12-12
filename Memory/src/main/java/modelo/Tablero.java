package modelo;

public class Tablero {
    private final String[][] celdas;

    public Tablero(int tamX, int tamY) {
        celdas = new String[tamX][tamY];
    }

    public String getCelda(int x, int y) {
        if (celdas[x][y] == null)
            return "*";
        return celdas[x][y];

    }

    public void setCelda(int x, int y, String valor) {
        celdas[x][y] = valor;
    }
}