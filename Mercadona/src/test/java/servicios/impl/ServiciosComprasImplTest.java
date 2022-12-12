package servicios.impl;

import data.DaoCompras;
import modelo.LineaCompra;
import modelo.Producto;
import modelo.ProductoNormal;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiciosComprasImplTest {

    @InjectMocks
    ServiciosComprasImpl serviciosCompras;

    @Mock
    DaoCompras daoCompras;

    @Test
    @DisplayName("Añadir producto al carrito")
    void addProducto() {
        //given
        Producto p = new ProductoNormal("nombre", 5, 10);
        when(daoCompras.addProducto(p, "dni")).thenReturn(true);
        when(daoCompras.existeProducto(p)).thenReturn(true);

        //when
        boolean resultado = serviciosCompras.addProducto(p, "dni");

        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Añadir producto al carrito no funciona")
    void addProductoNoFunciona() {
        //given
        Producto p = new ProductoNormal("nombre", 5, 10);

        //when
        boolean resultado = serviciosCompras.addProducto(p, "dni");

        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Añadir producto al carrito pero el producto no tiene stock")
    void addProductoSinStock() {
        //given
        ProductoNormal p = new ProductoNormal("nombre", 3, 0);

        //when
        boolean resultado = serviciosCompras.addProducto(p, "dni");

        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver los productos")
    void verProductos() {
        //given
        when(daoCompras.verProductos()).thenReturn(new ArrayList<>());

        //when
        List<Producto> resultado = serviciosCompras.verProductos();

        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Ver el carrito")
    void verCarrito() {
        //given
        when(daoCompras.verCarrito(any())).thenReturn(new ArrayList<>());

        //when
        List<LineaCompra> resultado = serviciosCompras.verCarrito("dni");

        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Pagar compra")
    void pagar() {
        //given
        when(daoCompras.pagar(any(), any())).thenReturn(true);

        //when
        boolean resultado = serviciosCompras.pagar("nombreMonedero", "dni");

        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Pagar compra falla")
    void pagarFallo() {
        //given
        when(daoCompras.pagar(any(), any())).thenReturn(false);

        //when
        boolean resultado = serviciosCompras.pagar("nombreMonedero", "dni");

        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Comprobar existencia del producto")
    void existeProducto() {
        //given
        when(daoCompras.existeProducto(any())).thenReturn(true);

        //when
        boolean resultado = serviciosCompras.existeProducto(any(ProductoNormal.class));

        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Comprobar que no existe el producto")
    void noExisteProducto() {
        //given
        Producto p = new ProductoNormal("nombre", 5, 10);
        when(daoCompras.existeProducto(p)).thenReturn(false);

        //when
        boolean resultado = serviciosCompras.existeProducto(p);

        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }
}