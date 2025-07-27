package com.patrick.delivery.core.usecase.pedido.impl;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.gateway.pedido.ListarPedidosPorClienteGateway;
import com.patrick.delivery.infrastructure.mapper.PedidoMapper;
import com.patrick.delivery.infrastructure.persistence.PedidoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarPedidosPorClienteImpl implements ListarPedidosPorClienteGateway {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;


    @Override
    public List<Pedido> listarPedidosPorCliente(Long clienteId) {
        return pedidoRepositoryJpa.findAllByUsuarioEntityId(clienteId).stream()
                .map(PedidoMapper::toPedido).toList();
    }
}
