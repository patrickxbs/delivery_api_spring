package com.patrick.delivery.core.usecase.pedido.impl;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.gateway.pedido.ListarPedidosGateway;
import com.patrick.delivery.infrastructure.mapper.PedidoMapper;
import com.patrick.delivery.infrastructure.persistence.PedidoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarPedidosImpl implements ListarPedidosGateway {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepositoryJpa.findAll().stream().map(PedidoMapper::toPedido).toList();
    }
}
