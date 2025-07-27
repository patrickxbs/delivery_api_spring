package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.gateway.pedido.ListarPedidosGateway;

import java.util.List;

public class ListarPedidosUseCase {

    private final ListarPedidosGateway listarPedidosGateway;

    public ListarPedidosUseCase(ListarPedidosGateway listarPedidosGateway) {
        this.listarPedidosGateway = listarPedidosGateway;
    }

    public List<Pedido> listarPedidos() {
        return listarPedidosGateway.listarPedidos();
    }
}
