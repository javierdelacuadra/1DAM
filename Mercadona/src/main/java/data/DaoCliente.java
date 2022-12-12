package data;

import modelo.Cliente;
import modelo.Ingrediente;
import modelo.LineaCompra;

import java.util.List;

public interface DaoCliente {
    boolean registrarCliente(Cliente c);

    boolean eliminarCliente(Cliente c);

    boolean modificarNombre(Cliente c);

    boolean modificarDNI(Cliente c, Cliente cviejo);

    boolean addAlergeno(String dni, Ingrediente i);

    List<Cliente> verClientes();

    List<List<LineaCompra>> verComprasAntiguas(String dni);

    List<Cliente> verClientesOrdenadosPorGasto();

    double gastoTotalCliente(String dni);

    boolean existeCliente(Cliente c);
}
