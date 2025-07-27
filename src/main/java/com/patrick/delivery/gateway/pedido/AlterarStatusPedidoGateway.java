package com.patrick.delivery.gateway.pedido;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.enuns.StatusPedido;

public interface AlterarStatusPedidoGateway {

    void alterarStaus(Pedido pedido);

}
