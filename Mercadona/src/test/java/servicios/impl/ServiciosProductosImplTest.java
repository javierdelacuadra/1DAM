package servicios.impl;

import data.impl.DaoProductosImpl;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiciosProductosImplTest {

    @InjectMocks
    ServiciosProductosImpl serviciosProductos;

    @Mock
    DaoProductosImpl daoProductos;

    @Test
    @DisplayName("Añadir producto correctamente")
    void addProducto() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        when(daoProductos.addProducto(any(ProductoNormal.class))).thenReturn(true);
        //when
        boolean resultado = serviciosProductos.addProducto(p);
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Añadir producto sin stock")
    void addProductoSinStock() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 0);
        //when
        boolean resultado = serviciosProductos.addProducto(p);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Añadir producto con precio negativo")
    void addProductoPrecioNegativo() {
        //given
        Producto p = new ProductoNormal("Pan", -3, 20);
        //when
        boolean resultado = serviciosProductos.addProducto(p);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Editar nombre de un producto")
    void editarNombre() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        when(daoProductos.editarNombre(p.getNombre(), "Mayonesa")).thenReturn(true);
        //when
        boolean resultado = serviciosProductos.editarNombre(p.getNombre(), "Mayonesa");
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Editar precio de un producto")
    void editarPrecio() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        when(daoProductos.editarPrecio(p.getNombre(), 2.99)).thenReturn(true);
        //when
        boolean resultado = serviciosProductos.editarPrecio(p.getNombre(), 2.99);
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Editar precio de un producto con precio negativo")
    void editarPrecioNegativo() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        //when
        boolean resultado = serviciosProductos.editarPrecio(p.getNombre(), -2.99);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Editar stock de un producto")
    void editarStock() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        when(daoProductos.editarCantidad(p.getNombre(), 30)).thenReturn(true);
        //when
        boolean resultado = serviciosProductos.editarStock(p.getNombre(), 30);
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Editar stock de un producto con cantidad negativa")
    void editarStockNegativo() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        //when
        boolean resultado = serviciosProductos.editarStock(p.getNombre(), -30);
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Ver lista de productos ordenados por cantidad comprada")
    void verListaProductosOrdenadosPorCantidadComprada() {
        //given
        when(daoProductos.listaProductosOrdenadosPorCantidadComprada()).thenReturn(new ArrayList<>());
        //when
        List<String> resultado = serviciosProductos.verClientesOrdenadosPorGasto();
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Conseguir el nombre de un producto específico")
    void getProducto() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 20);
        when(daoProductos.getProducto(p.getNombre())).thenReturn(anyString());
        //when
        String resultado = serviciosProductos.getProducto(p.getNombre());
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Ver lista de productos")
    void mostrarProductos() {
        //given
        when(daoProductos.verProductos()).thenReturn(new ArrayList<>());
        //when
        List<Producto> resultado = serviciosProductos.mostrarProductos();
        //then
        assertAll(
                () -> assertThat(resultado).isNotNull()
        );
    }

    @Test
    @DisplayName("Comprobar que hay productos en la lista de productos")
    void hayProductos() {
        //given
        when(daoProductos.verProductos()).thenReturn(List.of(new ProductoNormal("Pan", 1.99, 20)));
        //when
        boolean resultado = serviciosProductos.hayProductos();
        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }

    @Test
    @DisplayName("Comprobar que no hay productos en la lista de productos")
    void noHayProductos() {
        //given
        when(daoProductos.verProductos()).thenReturn(new ArrayList<>());
        //when
        boolean resultado = serviciosProductos.hayProductos();
        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }
}