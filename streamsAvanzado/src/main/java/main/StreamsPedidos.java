package main;

import pedidos.dao.modelo.*;
import pedidos.servicios.ServiciosPedido;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPedidos {
    ServiciosPedido sp = new ServiciosPedido();
    List<PedidoCompuesto> pedidos = sp.getTodosPedidos();

    // un map con nombre de producto y cantidad de veces pedido
    public void productosAgrupadosPorCantidadDeVecesPedidos() {

        Producto p = null;

        Map<Integer, List<Producto>> productos = sp.todosProductos().stream()
                .collect(Collectors.groupingBy(producto ->
                        pedidos.stream()
                                .flatMap(pc -> pc.getPedidosSimples().stream())
                                .flatMap(ps -> ps.getLineasPedido().stream())
                                .filter(ps -> ps.getProducto().equals(producto))
                                .mapToInt(LineaPedido::getCantidad)
                                .sum()
                ));


        pedidos.stream()
                .flatMap(pc -> pc.getPedidosSimples().stream())
                .flatMap(ps -> ps.getLineasPedido().stream())
                .filter(ps -> ps.getProducto().equals(p))
                .mapToInt(ps -> ps.getCantidad())
                .sum();


    }

    public void clienteQueMasDineroSehaGastado() {
//
//        pedidos.stream()
//                .filter(pedidoCompuesto -> pedidoCompuesto.getCliente() == X)
//                .mapToDouble(value -> value.getTotalFactura()).sum()
        Cliente c = sp.getTodosClientes().stream().sorted((c1, c2) -> (int) (pedidos.stream()
                .filter(pedidoCompuesto -> pedidoCompuesto.getCliente().equals(c1))
                .mapToDouble(PedidoCompuesto::getTotalFactura).sum() -
                pedidos.stream()
                        .filter(pedidoCompuesto -> pedidoCompuesto.getCliente().equals(c2))
                        .mapToDouble(PedidoCompuesto::getTotalFactura).sum())).findFirst().get();

    }

    // La cantidad media de producto por pedido simple, sumando todas las lineas de pedido de cada simple
    public void lacantidadMediaPedidaDeCadaProductoEnCadaPedidoCompuesto() {
        System.out.println(pedidos.stream()
                .map(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream()
                        .map(pedidoSimple -> pedidoSimple.getLineasPedido().stream()
                                .mapToInt(LineaPedido::getCantidad)
                                .average())));
    }

    public void pedidoSimpleConMasLineasdePedido() {
        System.out.println(pedidos.stream()
                .map(PedidoCompuesto::getPedidosSimples)
                .max(Comparator.comparingInt(List::size)));
    }

    public void todoelDineroFacturadoEnTotalentodosLosPedidos() {
        System.out.println(pedidos.stream().mapToDouble(PedidoCompuesto::getTotalFactura).sum());
    }
}