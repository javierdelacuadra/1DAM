package servicios;

import modelo.LineaCompra;
import modelo.Producto;

import java.util.List;

public interface ServiciosCompras {
    boolean addProducto(Producto p, String dni);

    List<Producto> verProductos();

    List<LineaCompra> verCarrito(String dni);

    boolean pagar(String nombreMonedero, String dni);

    boolean existeProducto(Producto p);
}
