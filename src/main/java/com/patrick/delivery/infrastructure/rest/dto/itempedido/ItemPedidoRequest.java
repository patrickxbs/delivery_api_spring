package com.patrick.delivery.infrastructure.rest.dto.itempedido;

import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Produto;

public record ItemPedidoRequest(Long produtoId, Integer quantidade) {

    public static ItemPedido toItemPedido(ItemPedidoRequest request) {
        Produto produto = new Produto();
        produto.setId(request.produtoId());

        return new ItemPedido(null, request.quantidade(), null, produto, null);
    }
}
