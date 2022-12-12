package modelo;

public class Carta {
    private int valorCarta;
    private Palos palo;

    public Carta(int valorCarta, Palos palo) {
        this.valorCarta = valorCarta;
        this.palo = palo;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public Palos getPalo() {
        return palo;
    }
}
