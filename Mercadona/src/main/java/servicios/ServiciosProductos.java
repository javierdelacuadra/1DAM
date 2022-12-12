package servicios;

import modelo.Producto;

import java.util.List;

public interface ServiciosProductos {
    boolean addProducto(Producto p);

    boolean editarNombre(String nombreViejo, String nombreNuevo);

    boolean editarPrecio(String nombre, double precio);

    boolean editarStock(String nombre, int stock);

    List<String> verClientesOrdenadosPorGasto();

    String getProducto(String nombre);

    List<Producto> mostrarProductos();

    boolean hayProductos();
}
