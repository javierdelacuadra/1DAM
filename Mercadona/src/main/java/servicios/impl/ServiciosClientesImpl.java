package servicios.impl;

import data.DaoCliente;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.ClienteNormal;
import modelo.Ingrediente;
import modelo.LineaCompra;
import servicios.ServiciosClientes;
import ui.common.ConstantesAdmin;

import java.util.List;

public class ServiciosClientesImpl implements ServiciosClientes {

    private final DaoCliente dc;

    @Inject
    public ServiciosClientesImpl(DaoCliente dc) {
        this.dc = dc;
    }

    @Override
    public boolean eliminarCliente(ClienteNormal c) {
        return dc.eliminarCliente(c);
    }

    @Override
    public boolean modificarNombre(ClienteNormal c) {
        return dc.modificarNombre(c);
    }

    @Override
    public boolean modificarDNI(ClienteNormal c, ClienteNormal cviejo) {
        return dc.modificarDNI(c, cviejo);
    }

    @Override
    public List<Cliente> verClientes() {
        return dc.verClientes();
    }

    @Override
    public boolean registrarCliente(Cliente c) {
        if (!dc.existeCliente(c) && !c.getNombre().equalsIgnoreCase(ConstantesAdmin.ADMIN)) {
            return dc.registrarCliente(c);
        }
        return false;
    }

    @Override
    public List<List<LineaCompra>> verComprasAntiguas(String dni) {
        return dc.verComprasAntiguas(dni);
    }

    @Override
    public boolean inicioSesion(Cliente c) {
        return dc.existeCliente(c);
    }

    @Override
    public double gastoTotalCliente(String dni) {
        return dc.gastoTotalCliente(dni);
    }

    @Override
    public boolean addAlergeno(String dni, Ingrediente i) {
        return dc.addAlergeno(dni, i);
    }

    @Override
    public List<Cliente> verClientesOrdenados() {
        return dc.verClientesOrdenadosPorGasto();
    }
}