package com.patrick.delivery.gateway.pedido;

import com.patrick.delivery.core.domain.Pedido;

import java.util.Optional;

public interface BuscarPedidoGateway {

    Optional<Pedido> buscarPorId(Long id);
}
