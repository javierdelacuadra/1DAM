package servicios.impl;

import data.DaoMonedero;
import modelo.Monedero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiciosMonederoImplTest {

    @InjectMocks
    ServiciosMonederoImpl serviciosMonedero;

    @Mock
    DaoMonedero daoMonedero;

    @Test
    @DisplayName("Añadir monedero")
    void addMonedero() {
        //given
        Monedero m = new Monedero("monedero", 100);
        when(daoMonedero.addMonedero("dni", m)).thenReturn(true);
        //when
        boolean resultado = serviciosMonedero.addMonedero("dni", m);
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Añadir monedero con saldo negativo")
    void addMonederoSaldoNegativo() {
        //given
        Monedero m = new Monedero("monedero", -5);
        //when
        boolean resultado = serviciosMonedero.addMonedero("dni", m);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Añadir saldo a un monedero")
    void addSaldo() {
        //given
        Monedero m = new Monedero("monedero", 100);
        when(daoMonedero.addSaldo("dni", m)).thenReturn(true);
        //when
        boolean resultado = serviciosMonedero.addSaldo("dni", m);
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Añadir saldo negativo a un monedero")
    void addSaldoNegativo() {
        //given
        Monedero m = new Monedero("monedero", -5);
        //when
        boolean resultado = serviciosMonedero.addSaldo("dni", m);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver monederos")
    void verMonederos() {
        //given
        when(daoMonedero.verMonederos(anyString())).thenReturn(new ArrayList<>());

        //when
        List<Monedero> resultado = serviciosMonedero.verMonederos("dni");

        //then
        assertAll(
                () -> assertThat(resultado).isNotNull(),
                () -> assertThat(resultado).isEmpty()
        );
    }
}