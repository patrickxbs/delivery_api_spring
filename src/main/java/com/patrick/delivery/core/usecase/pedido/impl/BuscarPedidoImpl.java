package com.patrick.delivery.core.usecase.pedido.impl;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.gateway.pedido.BuscarPedidoGateway;
import com.patrick.delivery.infrastructure.mapper.PedidoMapper;
import com.patrick.delivery.infrastructure.persistence.PedidoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BuscarPedidoImpl implements BuscarPedidoGateway {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepositoryJpa.findById(id).map(PedidoMapper::toPedido);
    }
}
