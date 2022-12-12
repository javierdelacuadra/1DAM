package servicios.impl;

import data.impl.DaoClienteImpl;
import modelo.Cliente;
import modelo.ClienteNormal;
import modelo.Ingrediente;
import modelo.LineaCompra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiciosClientesImplTest {

    @InjectMocks
    ServiciosClientesImpl serviciosClientes;

    @Mock
    DaoClienteImpl daoCliente;

    @Test
    @DisplayName("Eliminar cliente")
    void eliminarCliente() {
        //given
        when(daoCliente.eliminarCliente(any(ClienteNormal.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.eliminarCliente(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Eliminar cliente que no existe")
    void eliminarClienteNoExiste() {
        //given
        when(daoCliente.eliminarCliente(any(ClienteNormal.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.eliminarCliente(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Modificar nombre")
    void modificarNombre() {
        //given
        when(daoCliente.modificarNombre(any(ClienteNormal.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.modificarNombre(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Modificar nombre con el mismo nombre")
    void modificarNombreMismoNombre() {
        //given
        when(daoCliente.modificarNombre(any(ClienteNormal.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.modificarNombre(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Modificar DNI")
    void modificarDNI() {
        //given
        when(daoCliente.modificarDNI(any(ClienteNormal.class), any(ClienteNormal.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.modificarDNI(new ClienteNormal("dni", "nombre"), new ClienteNormal("dni2", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Modificar DNI que ya existe")
    void modificarDNIYaExiste() {
        //given
        when(daoCliente.modificarDNI(any(ClienteNormal.class), any(ClienteNormal.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.modificarDNI(new ClienteNormal("dni", "nombre"), new ClienteNormal("dni2", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver clientes")
    void verClientes() {
        //given
        when(daoCliente.verClientes()).thenReturn(new ArrayList<>());
        //when
        List<Cliente> resultado = serviciosClientes.verClientes();
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Registrar cliente")
    void registrarCliente() {
        //given
        when(daoCliente.existeCliente(any(Cliente.class))).thenReturn(false);
        when(daoCliente.registrarCliente(any(Cliente.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.registrarCliente(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Registrar cliente con nombre que ya existe")
    void registrarClienteNombreExistente() {
        //given
        when(daoCliente.existeCliente(any(Cliente.class))).thenReturn(false);
        when(daoCliente.registrarCliente(any(Cliente.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.registrarCliente(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Registrar cliente con nombre admin")
    void registrarClienteNombreAdmin() {
        //given
        when(daoCliente.existeCliente(any(Cliente.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.registrarCliente(new ClienteNormal("dni", "admin"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver compras antiguas")
    void verComprasAntiguas() {
        //given
        when(daoCliente.verComprasAntiguas(anyString())).thenReturn(new ArrayList<>());
        //when
        List<List<LineaCompra>> resultado = serviciosClientes.verComprasAntiguas("dni");
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Iniciar sesión")
    void inicioSesion() {
        //given
        when(daoCliente.existeCliente(any(ClienteNormal.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.inicioSesion(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Iniciar sesión con cliente que no existe")
    void inicioSesionClienteNoExiste() {
        //given
        when(daoCliente.existeCliente(any(ClienteNormal.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.inicioSesion(new ClienteNormal("dni", "nombre"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Gasto total del cliente")
    void gastoTotalCliente() {
        //given
        when(daoCliente.gastoTotalCliente(anyString())).thenReturn(0.0);
        //when
        double resultado = serviciosClientes.gastoTotalCliente("dni");
        //then
        assertAll(
                () -> assertThat(resultado).isEqualTo(0.0)
        );
    }

    @Test
    @DisplayName("Añadir alérgeno a cliente")
    void addAlergeno() {
        //given
        when(daoCliente.addAlergeno(anyString(), any(Ingrediente.class))).thenReturn(true);
        //when
        boolean resultado = serviciosClientes.addAlergeno("dni", new Ingrediente("leche"));
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Añadir alérgeno ya existente a cliente")
    void addAlergenoExistente() {
        //given
        when(daoCliente.addAlergeno(anyString(), any(Ingrediente.class))).thenReturn(false);
        //when
        boolean resultado = serviciosClientes.addAlergeno("dni", new Ingrediente("leche"));
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver clientes ordenados por gasto")
    void verClientesOrdenados() {
        //given
        when(daoCliente.verClientesOrdenadosPorGasto()).thenReturn(new ArrayList<>());
        //when
        List<Cliente> resultado = serviciosClientes.verClientesOrdenados();
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }
}