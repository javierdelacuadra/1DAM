package data.impl;

import data.DaoCliente;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.ClienteVIP;
import modelo.Ingrediente;
import modelo.LineaCompra;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoClienteImpl extends DaoBase implements DaoCliente {

    private final Database db;

    @Inject
    public DaoClienteImpl(Database db) {
        this.db = db;
    }

    @Override
    public boolean registrarCliente(Cliente c) {
        Map<String, Cliente> clientes = db.loadClientes();
        if (clientes == null) {
            clientes = new LinkedHashMap<>();
        }

        clientes.put(c.getDni(), c);
        return db.saveClientes(clientes);
    }

    @Override
    public boolean eliminarCliente(Cliente c) {
        Map<String, Cliente> clientes = db.loadClientes();

        if (existeCliente(c)) {
            clientes.remove(c.getDni(), c);
        }
        return db.saveClientes(clientes);
    }

    @Override
    public boolean modificarNombre(Cliente c) {
        Map<String, Cliente> clientes = db.loadClientes();
        if (clientes != null) {
            if (clientes.remove(c.getDni(), c)) {
                clientes.put(c.getDni(), c);
                return db.saveClientes(clientes);
            }
        }
        return false;
    }

    @Override
    public boolean modificarDNI(Cliente c, Cliente cviejo) {
        Map<String, Cliente> clientes = db.loadClientes();
        if (clientes != null) {
            if (clientes.remove(cviejo.getDni(), cviejo)) {
                clientes.put(c.getDni(), c);
                return db.saveClientes(clientes);
            }
        }
        return false;
    }

    @Override
    public boolean addAlergeno(String dni, Ingrediente i) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dni).getIngredientes().add(i);
        return db.saveClientes(clientes);
    }

    @Override
    public List<Cliente> verClientes() {
        Map<String, Cliente> clientes = db.loadClientes();
        return devolverListaClonada(clientes.values());
    }

    @Override
    public List<List<LineaCompra>> verComprasAntiguas(String dni) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dni).getComprasAntiguas().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Cliente> verClientesOrdenadosPorGasto() {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.values().stream()
                .sorted(Comparator.comparingDouble(cliente -> gastoTotalCliente(cliente.getDni())))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public double gastoTotalCliente(String dni) {
        double gastoTotal;
        Map<String, Cliente> clientes = db.loadClientes();
        gastoTotal = clientes.get(dni).getComprasAntiguas().stream()
                .flatMapToDouble(lineaCompras -> lineaCompras.stream()
                        .mapToDouble(value -> value.getProducto().getPrecio())).sum();
        if (clientes.get(dni) instanceof ClienteVIP) {
            double descuento = ((ClienteVIP) clientes.get(dni)).getDescuento();
            gastoTotal = (gastoTotal / 100) * (100 - descuento);
        }
        return gastoTotal;
    }

    @Override
    public boolean existeCliente(Cliente c) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.containsKey(c.getDni());
    }
}