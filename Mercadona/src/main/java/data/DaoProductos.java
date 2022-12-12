package data;

import modelo.Producto;

import java.util.List;

public interface DaoProductos {
    boolean addProducto(Producto p);

    boolean nombreNoRepetido(String nombre);

    List<Producto> verProductos();

    boolean editarNombre(String nombreViejo, String nombreNuevo);

    boolean editarPrecio(String nombre, double precio);

    boolean editarCantidad(String nombre, int cantidad);

    List<String> listaProductosOrdenadosPorCantidadComprada();

    int getNumero(String nombre);

    String getProducto(String nombre);
}
