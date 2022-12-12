package servicios;

import modelo.Cliente;
import modelo.ClienteNormal;
import modelo.Ingrediente;
import modelo.LineaCompra;

import java.util.List;

public interface ServiciosClientes {
    boolean eliminarCliente(ClienteNormal c);

    boolean modificarNombre(ClienteNormal c);

    boolean modificarDNI(ClienteNormal c, ClienteNormal cviejo);

    List<Cliente> verClientes();

    boolean registrarCliente(Cliente c);

    List<List<LineaCompra>> verComprasAntiguas(String dni);

    boolean inicioSesion(Cliente c);

    double gastoTotalCliente(String dni);

    boolean addAlergeno(String dni, Ingrediente i);

    List<Cliente> verClientesOrdenados();
}
