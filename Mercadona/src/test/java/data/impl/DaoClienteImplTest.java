package data.impl;

import modelo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoClienteImplTest {

    @InjectMocks
    DaoClienteImpl daoCliente;

    @Mock
    Database database;

    @Test
    @DisplayName("Registro de cliente cuando ya hay algún cliente")
    void registrarClienteConClientes() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente c = new ClienteNormal("101", "Pedro");
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.registrarCliente(c);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.size()).isEqualTo(2),
                () -> assertThat(clientes.get("101")).isEqualTo(c)
        );
    }

    @Test
    @DisplayName("Registro de cliente cuando no hay clientes")
    void registrarClienteSinClientes() {
        //given
        Map<String, Cliente> clientes = null;
        when(database.loadClientes()).thenReturn(clientes);
        if (clientes == null) {
            clientes = new HashMap<>();
        }
        Cliente c = new ClienteNormal("101", "Pedro");
        Map<String, Cliente> finalClientes = clientes;
        doAnswer(invocation -> {
            finalClientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.registrarCliente(c);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(finalClientes.size()).isEqualTo(1),
                () -> assertThat(finalClientes.get("101")).isEqualTo(c)
        );
    }

    @Test
    @DisplayName("Eliminación de cliente")
    void eliminarCliente() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente c = new ClienteNormal("100", "Juan");
        boolean existeCliente = daoCliente.existeCliente(c);
        assertThat(existeCliente).isTrue();
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.eliminarCliente(c);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.size()).isEqualTo(0),
                () -> assertThat(clientes.get("100")).isNull()
        );
    }

    @Test
    @DisplayName("Eliminación de cliente que no existe")
    void eliminarClienteNoExiste() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente c = new ClienteNormal("101", "Pedro");
        boolean existeCliente = daoCliente.existeCliente(c);
        assertThat(existeCliente).isFalse();
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return false;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.eliminarCliente(c);

        //then
        assertAll(
                () -> assertThat(resultado).isFalse(),
                () -> assertThat(clientes.size()).isEqualTo(1),
                () -> assertThat(clientes.get("100")).isEqualTo(new ClienteNormal("100", "Juan"))
        );
    }

    @Test
    @DisplayName("Modificar nombre de cliente")
    void modificarNombre() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente cnuevo = new ClienteNormal("100", "Pedro");
        clientes.remove(cnuevo.getDni());
        clientes.put(cnuevo.getDni(), cnuevo);
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.modificarNombre(cnuevo);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.size()).isEqualTo(1),
                () -> assertThat(clientes.get("100")).isEqualTo(new ClienteNormal("100", "Pedro"))
        );
    }

    @Test
    @DisplayName("Modificar nombre de cliente que no existe")
    void modificarNombreNoExiste() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente cnuevo = new ClienteNormal("101", "Pedro");

        //when
        boolean resultado = daoCliente.modificarNombre(cnuevo);

        //then
        assertAll(
                () -> assertThat(resultado).isFalse(),
                () -> assertThat(clientes.size()).isEqualTo(1),
                () -> assertThat(clientes.get("100")).isEqualTo(new ClienteNormal("100", "Juan"))
        );
    }

    @Test
    @DisplayName("Modificar DNI de cliente")
    void modificarDNI() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente cviejo = new ClienteNormal("100", "Juan");
        Cliente cnuevo = new ClienteNormal("101", "Juan");
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.modificarDNI(cnuevo, cviejo);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.size()).isEqualTo(1),
                () -> assertThat(clientes.get("101")).isEqualTo(new ClienteNormal("101", "Juan")),
                () -> assertThat(clientes.get("100")).isNull()
        );
    }

    @Test
    @DisplayName("Modificar DNI de cliente que no existe")
    void modificarDNINoExiste() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente cviejo = new ClienteNormal("101", "Juan");
        Cliente cnuevo = new ClienteNormal("102", "Pedro");

        //when
        boolean resultado = daoCliente.modificarDNI(cnuevo, cviejo);

        //then
        assertAll(
                () -> assertThat(resultado).isFalse(),
                () -> assertThat(clientes.size()).isEqualTo(1),
                () -> assertThat(clientes.get("100")).isEqualTo(new ClienteNormal("100", "Juan")),
                () -> assertThat(clientes.get("101")).isNull(),
                () -> assertThat(clientes.get("102")).isNull()
        );
    }

    @Test
    @DisplayName("Añadir alérgeno a cliente")
    void addAlergeno() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        when(database.loadClientes()).thenReturn(clientes);
        Cliente c = new ClienteNormal("100", "Juan");
        Ingrediente i = new Ingrediente("Leche");
        doAnswer(invocation -> {
            clientes.putAll(invocation.getArgument(0));
            return true;
        }).when(database).saveClientes(anyMap());

        //when
        boolean resultado = daoCliente.addAlergeno(c.getDni(), i);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.get("100").getIngredientes()).contains(i)
        );
    }

    @Test
    @DisplayName("Ver lista de clientes")
    void verClientes() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        clientes.put("101", new ClienteNormal("101", "Pedro"));
        when(database.loadClientes()).thenReturn(clientes);

        //when
        List<Cliente> resultado = daoCliente.verClientes();

        //then
        assertAll(
                () -> assertThat(resultado).hasSize(2),
                () -> assertThat(resultado.get(0)).isEqualTo(new ClienteNormal("100", "Juan")),
                () -> assertThat(resultado.get(1)).isEqualTo(new ClienteNormal("101", "Pedro")),
                () -> assertThat(resultado).containsAll(clientes.values()));
    }

    @Test
    @DisplayName("Ver lista de compras antiguas de un cliente")
    void verComprasAntiguas() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        List<LineaCompra> compraAntigua = new ArrayList<>();
        compraAntigua.add(new LineaCompra(new ProductoNormal("Leche", 5), 1));
        clientes.get("100").getComprasAntiguas().add(compraAntigua);
        when(database.loadClientes()).thenReturn(clientes);

        //when
        List<List<LineaCompra>> resultado = daoCliente.verComprasAntiguas("100");

        //then
        assertAll(
                () -> assertThat(resultado).hasSize(1),
                () -> assertThat(resultado.get(0)).containsAll(compraAntigua)
        );
    }

    @Test
    @DisplayName("Ver lista de clientes ordenados por gasto")
    void verClientesOrdenadosPorGasto() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        clientes.put("101", new ClienteNormal("101", "Pedro"));
        List<LineaCompra> compraAntiguaJuan = new ArrayList<>();
        compraAntiguaJuan.add(new LineaCompra(new ProductoNormal("Napolitana", 3.99), 1));
        compraAntiguaJuan.add(new LineaCompra(new ProductoNormal("Leche", 2.99), 1));
        clientes.get("100").getComprasAntiguas().add(compraAntiguaJuan);
        List<LineaCompra> compraAntiguaPedro = new ArrayList<>();
        compraAntiguaPedro.add(new LineaCompra(new ProductoNormal("Leche", 2.99), 1));
        clientes.get("101").getComprasAntiguas().add(compraAntiguaPedro);
        when(database.loadClientes()).thenReturn(clientes);

        //when
        List<Cliente> resultado = daoCliente.verClientesOrdenadosPorGasto();

        //then
        assertAll(
                () -> assertThat(resultado).hasSize(2),
                () -> assertThat(resultado.get(0)).isEqualTo(new ClienteNormal("100", "Juan")),
                () -> assertThat(resultado.get(1)).isEqualTo(new ClienteNormal("101", "Pedro"))
        );
    }

    @Test
    @DisplayName("Ver lista de clientes ordenados por gasto con un cliente VIP")
    void verClientesOrdenadosPorGastoConClienteVIP() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put("100", new ClienteNormal("100", "Juan"));
        clientes.put("101", new ClienteVIP("101", "Pedro", 20));
        List<LineaCompra> compraAntiguaJuan = new ArrayList<>();
        compraAntiguaJuan.add(new LineaCompra(new ProductoNormal("Leche", 2.79), 1));
        clientes.get("100").getComprasAntiguas().add(compraAntiguaJuan);
        List<LineaCompra> compraAntiguaPedro = new ArrayList<>();
        compraAntiguaPedro.add(new LineaCompra(new ProductoNormal("Pan", 2.99), 1));
        clientes.get("101").getComprasAntiguas().add(compraAntiguaPedro);
        when(database.loadClientes()).thenReturn(clientes);

        //when
        List<Cliente> resultado = daoCliente.verClientesOrdenadosPorGasto();

        //then
        assertAll(
                () -> assertThat(resultado).hasSize(2),
                () -> assertThat(resultado.get(0)).isEqualTo(new ClienteNormal("100", "Juan")),
                () -> assertThat(resultado.get(1)).isEqualTo(new ClienteVIP("101", "Pedro", 20))
        );
    }

    @Test
    @DisplayName("Comprobar que el cliente existe")
    void existeCliente() {
    }
}