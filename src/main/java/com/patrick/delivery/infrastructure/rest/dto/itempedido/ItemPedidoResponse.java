package com.patrick.delivery.infrastructure.rest.dto.itempedido;

import com.patrick.delivery.core.domain.ItemPedido;

import java.math.BigDecimal;

public record ItemPedidoResponse(Long id, Integer quantidade, BigDecimal precoUnitario, Long produtoId) {

    public static ItemPedidoResponse toResponse(ItemPedido itemPedido) {
        return new ItemPedidoResponse(itemPedido.getId(), itemPedido.getQuantidade(), itemPedido.getPrecoUnitario(), itemPedido.getProduto().getId());
    }
}
