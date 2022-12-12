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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoComprasImplTest {

    @InjectMocks
    DaoComprasImpl daoCompras;

    @Mock
    Database db;

    @Test
    @DisplayName("Añadir producto al carrito")
    void addProducto() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        Cliente c = new ClienteNormal("100", "Juan");
        clientes.put("100", c);
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pizza", 4.99, 10);
        productos.add(p);
        int numero = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase("Pizza")) {
                numero = i;
            }
        }
        double precio = productos.get(numero).getPrecio();
        Producto p1 = new ProductoNormal(productos.get(numero).getNombre(), (precio * p.getStock()), p.getStock());
        LineaCompra lc = new LineaCompra(p1, p.getStock());
        lc.setCantidad(p.getStock());
        clientes.get("100").getCarrito().add(lc);
        productos.get(numero).setStock(productos.get(numero).getStock() - p.getStock());
        when(db.loadClientes()).thenReturn(clientes);
        when(db.loadProductos()).thenReturn(productos);

        //when
        daoCompras.addProducto(p, "100");

        //then
        assertAll(
                () -> assertThat(clientes.get("100").getCarrito().size()).isEqualTo(1),
                () -> assertThat(productos.get(0).getNombre()).isEqualTo("Pizza")
        );
    }

    @Test
    @DisplayName("Ver productos")
    void verProductos() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pizza", 4.99, 10);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);

        //when
        List<Producto> productosdao = daoCompras.verProductos();

        //then
        assertAll(
                () -> assertThat(productosdao.size()).isEqualTo(1),
                () -> assertThat(productosdao.get(0).getNombre()).isEqualTo("Pizza"),
                () -> assertThat(productosdao.get(0).getPrecio()).isEqualTo(4.99),
                () -> assertThat(productosdao.get(0).getStock()).isEqualTo(10)
        );
    }

    @Test
    @DisplayName("Ver carrito")
    void verCarrito() {
        //given
        Map<String, Cliente> clientes = new HashMap<>();
        Cliente c = new ClienteNormal("100", "Juan");
        clientes.put("100", c);
        Producto p = new ProductoNormal("Pizza", 4.99, 10);
        clientes.get("100").getCarrito().add(new LineaCompra(p, p.getStock()));
        when(db.loadClientes()).thenReturn(clientes);

        //when
        List<LineaCompra> carrito = daoCompras.verCarrito("100");

        //then
        assertAll(
                () -> assertThat(carrito.size()).isEqualTo(1),
                () -> assertThat(carrito.get(0).getProducto().getNombre()).isEqualTo("Pizza"),
                () -> assertThat(carrito.get(0).getProducto().getPrecio()).isEqualTo(4.99),
                () -> assertThat(carrito.get(0).getProducto().getStock()).isEqualTo(10)
        );
    }

    @Test
    @DisplayName("Comprobar existencia del producto")
    void existeProducto() {
        //given
        List<Producto> productos = new ArrayList<>();
        Producto p = new ProductoNormal("Pizza", 4.99, 10);
        productos.add(p);
        when(db.loadProductos()).thenReturn(productos);

        //when
        boolean existe = daoCompras.existeProducto(p);

        //then
        assertAll(
                () -> assertThat(existe).isTrue()
        );
    }

    @Test
    @DisplayName("Comprobar existencia del producto")
    void precio() {
        //given
       Map<String, Cliente> clientes = new HashMap<>();
         Cliente c = new ClienteNormal("100", "Juan");
        clientes.put("100", c);
        Producto p = new ProductoNormal("Pizza", 4.99, 2);
        Producto p1 = new ProductoNormal("Pan", 2.99, 1);
        clientes.get("100").getCarrito().add(new LineaCompra(p, p.getStock()));
        clientes.get("100").getCarrito().add(new LineaCompra(p1, p1.getStock()));
        when(db.loadClientes()).thenReturn(clientes);

        //when
        double precio = daoCompras.precio("100");

        //then
        assertAll(
                () -> assertThat(precio).isEqualTo(12.97)
        );
    }
}