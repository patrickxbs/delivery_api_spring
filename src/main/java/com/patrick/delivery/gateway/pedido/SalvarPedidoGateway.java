package com.patrick.delivery.gateway.pedido;

import com.patrick.delivery.core.domain.Pedido;

public interface SalvarPedidoGateway {

    Pedido salvar(Pedido pedido);
}
