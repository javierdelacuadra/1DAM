package servicios;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ServiciosCalculadoraTest {

    @Test
    void testSuma() {
        int numero1 = 0;
        int numero2 = 0;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.suma(numero1,numero2);

        assertEquals(0,resultado);

    }
    @Test
    void testSumaNegativos() {
        int numero1 = -3;
        int numero2 = 1;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.suma(numero1,numero2);

        assertEquals(-1,resultado);
    }
    @Test
    void testResta() {
        int numero1 = 7;
        int numero2 = 4;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.resta(numero1,numero2);

        assertEquals(3,resultado);
    }
    @Test
    void testRestaNegativos() {
        int numero1 = 2;
        int numero2 = 5;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.resta(numero1,numero2);

        assertEquals(-1,resultado);
    }
    @Test
    void testMultiplicacion() {
        int numero1 = 6;
        int numero2 = 3;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.multiplicacion(numero1,numero2);

        assertEquals(18,resultado);

    }
    @Test
    void testMultiplicacionNegativos() {
        int numero1 = 5;
        int numero2 = -8;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        int resultado = sc.multiplicacion(numero1,numero2);

        assertEquals(-1,resultado);

    }
    @Test
    void testDivision() {
        int numero1 = 12;
        int numero2 = 3;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        double resultado = sc.division(numero1,numero2);

        assertEquals(4,resultado);

    }
    @Test
    void testDivisionNegativos() {
        int numero1 = 6;
        int numero2 = -2;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        double resultado = sc.division(numero1,numero2);

        assertEquals(-1,resultado);

    }
    @Test
    void testDivisionEntre0() {
        int numero1 = 5;
        int numero2 = 0;

        ServiciosCalculadora sc = new ServiciosCalculadora();
        double resultado = sc.division(numero1,numero2);

        assertEquals(-1,resultado);

    }
}