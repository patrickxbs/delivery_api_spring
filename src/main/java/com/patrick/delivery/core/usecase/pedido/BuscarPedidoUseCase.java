package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.domain.exception.EntidadeNaoEncontradaException;
import com.patrick.delivery.gateway.pedido.BuscarPedidoGateway;

public class BuscarPedidoUseCase {

    private final BuscarPedidoGateway buscarPedidoGateway;

    public BuscarPedidoUseCase(BuscarPedidoGateway buscarPedidoGateway) {
        this.buscarPedidoGateway = buscarPedidoGateway;
    }

    public Pedido buscarPorId(Long id) {
        return buscarPedidoGateway.buscarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format("Pedido com o id '%s' não encontrado", id)));
    }
}
