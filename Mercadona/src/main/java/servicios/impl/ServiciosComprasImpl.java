package servicios.impl;

import data.DaoCompras;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import modelo.LineaCompra;
import modelo.Producto;
import servicios.ServiciosCompras;

import java.util.List;

public class ServiciosComprasImpl implements ServiciosCompras {

    private final DaoCompras dc;

    @Inject
    public ServiciosComprasImpl(DaoCompras dc) {
        this.dc = dc;
    }

    @Override
    public boolean addProducto(Producto p, String dni) {
        return p.getStock() > 0 && dc.existeProducto(p) && (dc.addProducto(p, dni));
    }

    @Override
    public List<Producto> verProductos() {
        return dc.verProductos();
    }

    @Override
    public List<LineaCompra> verCarrito(String dni) {
        return dc.verCarrito(dni);
    }

    @Override
    public boolean pagar(String nombreMonedero, String dni) {
        return dc.pagar(nombreMonedero, dni);
    }

    @Override
    public boolean existeProducto(Producto p) {
        return dc.existeProducto(p);
    }
}