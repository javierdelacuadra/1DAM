package servicios;

public class ServiciosCalculadora {
    public int suma(int numero1, int numero2) {
        if (numero1 >= 0 && numero2 >= 0) {
            return numero1 + numero2;
        } else return -1;
    }

    public int resta(int numero1, int numero2) {
        if (numero1 >= 0 && numero2 >= 0 && (numero1 - numero2) >= 0) {
            return numero1 - numero2;
        } else return -1;
    }

    public int multiplicacion(int numero1, int numero2) {
        if (numero1 >= 0 && numero2 >= 0) {
            return numero1 * numero2;
        } else return -1;
    }

    public double division(double numero1, double numero2) {
        if (numero1 >= 0 && numero2 > 0) {
            return numero1 / numero2;
        } else return -1;
    }

}