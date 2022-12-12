package main;

import pedidos.dao.modelo.Producto;
import pedidos.servicios.ServiciosPedido;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsProductos {
    ServiciosPedido sp = new ServiciosPedido();
    List<Producto> productos = sp.todosProductos();

    // con reduce y con sorted
    public void productoMasCaro() {
        System.out.println(productos.stream().max(Comparator.comparingInt(Producto::getPrecio)));
        System.out.println(productos.stream()
                .reduce((producto, producto2) -> producto.getPrecio() > producto2.getPrecio() ? producto : producto2));
    }

    //con reduce y con sorted
    public void productoMasBarato() {
        System.out.println(productos.stream().min(Comparator.comparingInt(Producto::getPrecio)));
        System.out.println(productos.stream()
                .reduce((producto, producto2) -> producto.getPrecio() < producto2.getPrecio() ? producto : producto2));
    }

    public void mediaPrecioTodosLosProductos() {
        System.out.println(productos.stream().flatMapToInt(producto -> IntStream.of(producto.getPrecio())).average());

        OptionalDouble hola = OptionalDouble.of(productos.stream().flatMapToInt(producto -> IntStream.of(producto.getPrecio())).average().orElse(0));
    }

    // un grupo de producto por cada franja de 10, de 0 a 10, 11 a 20, etc...
    public void productosAgrupadosPorRangoPrecio10en10() {
        productos.stream().collect(Collectors.groupingBy(Producto::getPrecio));
        //mejorable
    }

    // de los productos que tenga precio de 11 a 20, indicar cuales tienen stock mayor que 5
    public void productosConPrecio11a20YStockMayor5() {
        System.out.println(productos.stream()
                .filter(producto -> producto.getPrecio() > 10 && producto.getPrecio() <= 20 && producto.getStock() > 5)
                .collect(Collectors.toUnmodifiableList()));
    }
}
