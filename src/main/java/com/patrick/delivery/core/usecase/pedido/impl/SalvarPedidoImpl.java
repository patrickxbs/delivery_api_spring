package com.patrick.delivery.core.usecase.pedido.impl;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.gateway.pedido.SalvarPedidoGateway;
import com.patrick.delivery.infrastructure.entity.PedidoEntity;
import com.patrick.delivery.infrastructure.mapper.PedidoMapper;
import com.patrick.delivery.infrastructure.persistence.PedidoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SalvarPedidoImpl implements SalvarPedidoGateway {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        return PedidoMapper.toPedido(pedidoRepositoryJpa.save(entity));
    }
}
