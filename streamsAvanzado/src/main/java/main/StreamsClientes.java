package main;

import pedidos.dao.modelo.Cliente;
import pedidos.dao.modelo.Cuenta;
import pedidos.servicios.ServiciosPedido;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsClientes {

    ServiciosPedido sp = new ServiciosPedido();

    List<Cliente> clientes = sp.getTodosClientes();

    // Cliente con mas cuentas
    public void clienteConMasCuentas() {
        System.out.println(clientes.stream()
                .map(cliente -> cliente.getCuentas().stream()
                        .max(Comparator.comparingInt(value -> cliente.getCuentas().size()))));
    }

    // Cliente + Numero de cuentas de cada cliente.
    public void clienteYNumeroCuentas() {
        System.out.println(clientes
                .stream()
                .collect(Collectors.toMap(Cliente::getNombre, cliente -> cliente.getCuentas().size())));
    }

    // Clientes agrupados por el numero de cuentas
    public void clientesAgrupadosPorNumeroCuentas() {
        System.out.println(clientes.stream()
                .collect(Collectors.groupingBy(cliente -> cliente.getCuentas().size())));
    }

    // Clientes que tienen mas cuentas o iguales a la media.
    public void clientesConMasCuentasQuelaMedia() {
        double media = clientes.stream().mapToInt(value -> value.getCuentas().size()).average().orElse(0);

        System.out.println(clientes.stream()
                .filter(cliente -> cliente.getCuentas().size() >= media)
                .collect(Collectors.toUnmodifiableList()));
    }

    // media de dinero de todas las cuentas
    public void mediaDineroTodasCuentas() {
        System.out.println(clientes.stream()
                .map(cliente -> cliente.getCuentas().stream()
                        .mapToInt(Cuenta::getSaldo).average()));
    }


    // Clientes ordenados por el saldo total.
    public void clientesOrdenadosPorSaldoTotal() {
        System.out.println(clientes.stream()
                .flatMap(cliente -> cliente.getCuentas().stream())
                .sorted(Comparator.comparingInt(Cuenta::getSaldo).reversed())
                .collect(Collectors.toUnmodifiableList()));
    }

    // Cliente con la suma del saldo de todas sus cuentas.
    public void clientesYSumaSaldoTodasCuentas() {
        System.out.println(clientes.stream()
                .flatMap(cliente -> cliente.getCuentas().stream())
                .flatMapToInt(cuenta -> IntStream.of(cuenta.getSaldo())).sum());
    }


    // el cuarto cliente con más dinero
    public void cuartoClienteConMasDinero() {
        System.out.println(clientes.stream()
                .flatMap(cliente -> cliente.getCuentas().stream())
                .sorted(Comparator.comparingInt(Cuenta::getSaldo).reversed()).skip(3).findFirst());
    }


    // numero de clientes agrupados por dominio del correo ya@gmail.com
    public void numeroClientesPorDominioCorreo() {

    }
}