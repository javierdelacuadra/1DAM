package ui;

import modelo.ClienteNormal;
import modelo.Ingrediente;
import modelo.Monedero;
import modelo.ProductoNormal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.impl.ServiciosClientesImpl;
import servicios.impl.ServiciosComprasImpl;
import servicios.impl.ServiciosMonederoImpl;
import ui.common.ConstantesClientes;
import ui.common.ConstantesGestionClientes;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UIClienteTest {

    //class under test
    UICliente uiCliente;

    @Mock
    ServiciosClientesImpl serviciosClientes;

    @Mock
    ServiciosComprasImpl serviciosCompras;

    @Mock
    ServiciosMonederoImpl serviciosMonedero;

    Scanner sc;

    @SystemStub
    private SystemOut systemOut;

    @Captor
    ArgumentCaptor<ClienteNormal> captorClienteNormal;

    @Captor
    ArgumentCaptor<String> captorString;

    @Captor
    ArgumentCaptor<ProductoNormal> captorProductoNormal;

    @Captor
    ArgumentCaptor<Monedero> captorMonedero;

    @Captor
    ArgumentCaptor<Ingrediente> captorIngrediente;

    @Test
    @DisplayName("Menú Cliente entra en modificar nombre")
    void menuClienteOpcion1Bien() {
        //given
        sc = new Scanner(new LinesAltStream("1", "Juan", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.modificarNombre(any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosClientes).modificarNombre(captorClienteNormal.capture());
        assertAll(
                () -> assertThat(captorClienteNormal.getValue().getNombre()).isEqualTo("Juan"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesGestionClientes.NOMBRE_CAMBIADO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en modificar nombre y pone mal el nombre")
    void menuClienteOpcion1Mal() {
        //given
        sc = new Scanner(new LinesAltStream("1", "Juan", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.modificarNombre(any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosClientes).modificarNombre(captorClienteNormal.capture());
        assertAll(
                () -> assertThat(captorClienteNormal.getValue().getNombre()).isEqualTo("Juan"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesGestionClientes.NO_SE_HAN_PODIDO_MODIFICAR_LOS_DATOS)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en modificar DNI")
    void menuClienteOpcion2Bien() {
        //given
        sc = new Scanner(new LinesAltStream("2", "123", "124", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.modificarDNI(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("123");

        //then
        verify(serviciosClientes).modificarDNI(captorClienteNormal.capture(), captorClienteNormal.capture());
        assertAll(
                () -> assertThat(captorClienteNormal.getValue().getDni()).isEqualTo("123"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesGestionClientes.DNI_CAMBIADO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en modificar DNI y pone mal el DNI")
    void menuClienteOpcion2Mal() {
        //given
        sc = new Scanner(new LinesAltStream("2", "123", "123", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.modificarDNI(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("123");

        //then
        verify(serviciosClientes).modificarDNI(captorClienteNormal.capture(), captorClienteNormal.capture());
        assertAll(
                () -> assertThat(captorClienteNormal.getValue().getDni()).isEqualTo("123"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesGestionClientes.NO_SE_HAN_PODIDO_MODIFICAR_LOS_DATOS)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú compras y añade producto al carrito")
    void menuClienteOpcion4menuComprasOpcion1Bien() {
        //given
        sc = new Scanner(new LinesAltStream("4", "1", "Manzana", "5", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosCompras.addProducto(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosCompras).addProducto(captorProductoNormal.capture(), captorString.capture());
        assertAll(
                () -> assertThat(captorProductoNormal.getValue().getNombre()).isEqualTo("Manzana"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.PRODUCTO_AÑADIDO_A_LA_CESTA)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú compras y añade producto al carrito mal")
    void menuClienteOpcion4menuComprasOpcion1Mal() {
        //given
        sc = new Scanner(new LinesAltStream("4", "1", "Manzana", "5", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosCompras.addProducto(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosCompras).addProducto(captorProductoNormal.capture(), captorString.capture());
        assertAll(
                () -> assertThat(captorProductoNormal.getValue().getNombre()).isEqualTo("Manzana"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.PRODUCTO_NO_AÑADIDO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú compras y paga la compra")
    void menuClienteOpcion4menuComprasOpcion4Bien() {
        //given
        sc = new Scanner(new LinesAltStream("4", "4", "Monedero", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosCompras.pagar(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosCompras).pagar(captorString.capture(), captorString.capture());
        assertAll(
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.PAGO_REALIZADO_CORRECTAMENTE)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú compras y no paga la compra")
    void menuClienteOpcion4menuComprasOpcion4Mal() {
        //given
        sc = new Scanner(new LinesAltStream("4", "4", "Monedero", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosCompras.pagar(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosCompras).pagar(captorString.capture(), captorString.capture());
        assertAll(
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.NO_SE_PUDO_REALIZAR_EL_PAGO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú monederos y añade monedero")
    void menuClienteOpcion3menuMonederosOpcion1Bien() {
        //given
        sc = new Scanner(new LinesAltStream("3", "1", "Monedero", "100", "4", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosMonedero.addMonedero(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosMonedero).addMonedero(captorString.capture(), captorMonedero.capture());
        assertAll(
                () -> assertThat(captorMonedero.getValue().getNombre()).isEqualTo("Monedero"),
                () -> assertThat(captorMonedero.getValue().getDinero()).isEqualTo(100),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.MONEDERO_CREADO_CORRECTAMENTE)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú monedero y añade monedero mal")
    void menuClienteOpcion3menuMonederosOpcion1Mal() {
        //given
        sc = new Scanner(new LinesAltStream("3", "1", "Monedero", "100", "4", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosMonedero.addMonedero(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosMonedero).addMonedero(captorString.capture(), captorMonedero.capture());
        assertAll(
                () -> assertThat(captorMonedero.getValue().getNombre()).isEqualTo("Monedero"),
                () -> assertThat(captorMonedero.getValue().getDinero()).isEqualTo(100),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.NO_SE_HA_PODIDO_CREAR_EL_MONEDERO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú monederos y añade saldo")
    void menuClienteOpcion3menuMonederosOpcion2Bien() {
        //given
        sc = new Scanner(new LinesAltStream("3", "2", "Monedero", "100", "4", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosMonedero.addSaldo(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosMonedero).addSaldo(captorString.capture(), captorMonedero.capture());
        assertAll(
                () -> assertThat(captorMonedero.getValue().getNombre()).isEqualTo("Monedero"),
                () -> assertThat(captorMonedero.getValue().getDinero()).isEqualTo(100),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.SALDO_AÑADIDO_CORRECTAMENTE)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú monederos y añade saldo mal")
    void menuClienteOpcion3menuMonederosOpcion2Mal() {
        //given
        sc = new Scanner(new LinesAltStream("3", "2", "Monedero", "100", "4", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosMonedero.addSaldo(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosMonedero).addSaldo(captorString.capture(), captorMonedero.capture());
        assertAll(
                () -> assertThat(captorMonedero.getValue().getNombre()).isEqualTo("Monedero"),
                () -> assertThat(captorMonedero.getValue().getDinero()).isEqualTo(100),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.NO_SE_HA_PODIDO_AÑADIR_SALDO)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú otros y añade alérgeno ")
    void menuClienteOpcion5menuOtrosOpcion3Bien() {
        //given
        sc = new Scanner(new LinesAltStream("5", "3", "Patata", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.addAlergeno(any(), any())).thenReturn(true);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosClientes).addAlergeno(captorString.capture(), captorIngrediente.capture());
        assertAll(
                () -> assertThat(captorIngrediente.getValue().getNombre()).isEqualTo("Patata"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.ALERGENO_AÑADIDO_CORRECTAMENTE)
        );
    }

    @Test
    @DisplayName("Menú Cliente entra en menú otros y añade alérgeno mal")
    void menuClienteOpcion5menuOtrosOpcion3Mal() {
        //given
        sc = new Scanner(new LinesAltStream("5", "3", "Patata", "5", "6"));
        uiCliente = new UICliente(serviciosClientes, serviciosCompras, serviciosMonedero, sc);
        when(serviciosClientes.addAlergeno(any(), any())).thenReturn(false);

        //when
        uiCliente.menuCliente("12345678A");

        //then
        verify(serviciosClientes).addAlergeno(captorString.capture(), captorIngrediente.capture());
        assertAll(
                () -> assertThat(captorIngrediente.getValue().getNombre()).isEqualTo("Patata"),
                () -> assertThat(systemOut.getOutput().getLines()).contains(ConstantesClientes.NO_SE_HA_PODIDO_AÑADIR_EL_ALÉRGENO)
        );
    }

}