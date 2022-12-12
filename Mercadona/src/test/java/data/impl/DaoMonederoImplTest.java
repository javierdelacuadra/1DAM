package data.impl;

import modelo.Cliente;
import modelo.ClienteNormal;
import modelo.Monedero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoMonederoImplTest {

    @InjectMocks
    private DaoMonederoImpl daoMonedero;

    @Mock
    Database db;

    @Test
    @DisplayName("Añadir saldo a monedero")
    void addSaldo() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        clientes.get("100").getMonederos().add(new Monedero("Monedero 1", 100));
        when(db.loadClientes()).thenReturn(clientes);
        //when
        daoMonedero.addSaldo("100", new Monedero("Monedero 1", 100));
        //then
        assertAll(
                () -> assertThat(clientes.get("100").getMonederos().stream().findFirst().get().getDinero()).isEqualTo(200),
                () -> assertThat(clientes.get("100").getMonederos().stream().findFirst().get().getNombre()).isEqualTo("Monedero 1")
        );
    }

    @Test
    @DisplayName("Añadir monedero")
    void addMonedero() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(db.loadClientes()).thenReturn(clientes);
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(db).saveClientes(anyMap());

        //when
        boolean resultado = daoMonedero.addMonedero("100", new Monedero("Monedero 1", 100));

        //then
        assertAll(
                () -> assertThat(clientes.get("100").getMonederos().stream().findFirst().get().getDinero()).isEqualTo(100),
                () -> assertThat(clientes.get("100").getMonederos().stream().findFirst().get().getNombre()).isEqualTo("Monedero 1"),
                () -> assertThat(clientes.get("100").getMonederos().size()).isEqualTo(1),
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Ver monederos")
    void verMonederos() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        clientes.get("100").getMonederos().add(new Monedero("Monedero 1", 100));
        clientes.get("100").getMonederos().add(new Monedero("Monedero 2", 200));
        when(db.loadClientes()).thenReturn(clientes);

        //when
        List<Monedero> monederos = daoMonedero.verMonederos("100");

        //then
        assertAll(
                () -> assertThat(monederos.size()).isEqualTo(2)
        );
    }
}