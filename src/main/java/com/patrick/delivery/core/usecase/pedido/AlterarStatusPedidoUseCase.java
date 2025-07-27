package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.enuns.StatusPedido;
import com.patrick.delivery.gateway.pedido.AlterarStatusPedidoGateway;

import java.time.LocalDateTime;

public class AlterarStatusPedidoUseCase {

    private final AlterarStatusPedidoGateway alterarStausPedidoGateway;
    private final BuscarPedidoUseCase buscarPedidoUseCase;

    public AlterarStatusPedidoUseCase(AlterarStatusPedidoGateway alterarStausPedidoGateway, BuscarPedidoUseCase buscarPedidoUseCase) {
        this.alterarStausPedidoGateway = alterarStausPedidoGateway;
        this.buscarPedidoUseCase = buscarPedidoUseCase;
    }

    public void alterarStatus(Long id, StatusPedido statusPedido) {
        Pedido pedido = buscarPedidoUseCase.buscarPorId(id);
        pedido.setStatusPedido(statusPedido);

        if (StatusPedido.ENTREGUE.equals(statusPedido))
            pedido.setDataEntregue(LocalDateTime.now());

        alterarStausPedidoGateway.alterarStaus(pedido);
    }
}
