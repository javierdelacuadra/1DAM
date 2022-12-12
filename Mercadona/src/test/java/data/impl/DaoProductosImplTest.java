package data.impl;

import modelo.Producto;
import modelo.ProductoNormal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class DaoProductosImplTest {

    @InjectMocks
    DaoProductosImpl daoProductos;

    @Mock
    Database db;

    @Test
    @DisplayName("Ver productos")
    void verProductos() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);

        //when
        List<Producto> resultado = daoProductos.verProductos();

        //then
        assertAll(
                () -> assertThat(resultado).isNotNull(),
                () -> assertThat(resultado.size()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Editar nombre")
    void editarNombre() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);
        doAnswer(invocation -> {
            productos.addAll(invocation.getArgument(0));
            return true;
        }).when(db).saveProductos(productos);

        //when
        boolean resultado = daoProductos.editarNombre("Pan", "Pizza");

        //then
        assertAll(
                () -> assertThat(productos.get(0).getNombre()).isEqualTo("Pizza"),
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Editar precio")
    void editarPrecio() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);
        doAnswer(invocation -> {
            productos.addAll(invocation.getArgument(0));
            return true;
        }).when(db).saveProductos(productos);

        //when
        boolean resultado = daoProductos.editarPrecio("Pan", 2.99);

        //then
        assertAll(
                () -> assertThat(productos.get(0).getPrecio()).isEqualTo(2.99),
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Modificar el stock de un producto")
    void editarCantidad() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);
        doAnswer(invocation -> {
            productos.addAll(invocation.getArgument(0));
            return true;
        }).when(db).saveProductos(productos);

        //when
        boolean resultado = daoProductos.editarCantidad("Pan", 2);

        //then
        assertAll(
                () -> assertThat(productos.get(0).getStock()).isEqualTo(3),
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Encontrar la posición del producto en la lista")
    void getNumero() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        Producto p1 = new ProductoNormal("Pizza", 2.99, 2);
        productos.add(p);
        productos.add(p1);
        when(db.loadProductos()).thenReturn(productos);

        //when
        int resultado = daoProductos.getNumero("Pizza");

        //then
        assertAll(
                () -> assertThat(resultado).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Conseguir los datos de un producto")
    void getProducto() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        Producto p1 = new ProductoNormal("Pizza", 2.99, 2);
        productos.add(p);
        productos.add(p1);
        when(db.loadProductos()).thenReturn(productos);

        //when
        String resultado = daoProductos.getProducto("Pizza");

        //then
        assertAll(
                () -> assertThat(resultado).isEqualTo(p1.toString())
        );
    }

    @Test
    @DisplayName("Comprobar que no encuentra un producto que no existe")
    void getProductoNoEncontrados() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        Producto p1 = new ProductoNormal("Pizza", 2.99, 2);
        productos.add(p);
        productos.add(p1);
        when(db.loadProductos()).thenReturn(productos);

        //when
        String resultado = daoProductos.getProducto("Pollo");

        //then
        assertAll(
                () -> assertThat(resultado).isEqualTo("No se ha encontrado el producto")
        );
    }

    @Test
    @DisplayName("Comprobar que no hay un producto con el mismo nombre")
    void nombreNoRepetido() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        Producto p1 = new ProductoNormal("Pizza", 2.99, 2);
        productos.add(p);
        productos.add(p1);
        when(db.loadProductos()).thenReturn(productos);

        //when
        boolean resultado = daoProductos.nombreNoRepetido("Napolitana");

        //then
        assertAll(
                () -> assertThat(resultado).isTrue()
        );
    }

    @Test
    @DisplayName("Comprobar que hay un producto con ese nombre")
    void nombreRepetido() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pan", 1.99, 1);
        Producto p1 = new ProductoNormal("Pizza", 2.99, 2);
        productos.add(p);
        productos.add(p1);
        when(db.loadProductos()).thenReturn(productos);

        //when
        boolean resultado = daoProductos.nombreNoRepetido("Pan");

        //then
        assertAll(
                () -> assertThat(resultado).isFalse()
        );
    }
}