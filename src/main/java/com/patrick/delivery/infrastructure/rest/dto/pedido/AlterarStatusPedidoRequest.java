package com.patrick.delivery.infrastructure.rest.dto.pedido;

import com.patrick.delivery.enuns.StatusPedido;

public record AlterarStatusPedidoRequest(StatusPedido statusPedido) {
}
