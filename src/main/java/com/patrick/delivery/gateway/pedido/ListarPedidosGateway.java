package com.patrick.delivery.gateway.pedido;

import com.patrick.delivery.core.domain.Pedido;

import java.util.List;

public interface ListarPedidosGateway {

    List<Pedido> listarPedidos();
}
