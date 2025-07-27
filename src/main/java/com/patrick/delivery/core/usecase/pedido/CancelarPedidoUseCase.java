package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.core.domain.exception.CancelamentoNaoPermitidoException;
import com.patrick.delivery.core.usecase.produto.AlterarProdutoUseCase;
import com.patrick.delivery.enuns.StatusPedido;
import com.patrick.delivery.gateway.pedido.AlterarStatusPedidoGateway;

public class CancelarPedidoUseCase {

    private final AlterarStatusPedidoGateway alterarStatusPedidoGateway;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final AlterarProdutoUseCase alterarProdutoUseCase;

    public CancelarPedidoUseCase(AlterarStatusPedidoGateway alterarStatusPedidoGateway, BuscarPedidoUseCase buscarPedidoUseCase,
                                 AlterarProdutoUseCase alterarProdutoUseCase) {
        this.alterarStatusPedidoGateway = alterarStatusPedidoGateway;
        this.buscarPedidoUseCase = buscarPedidoUseCase;
        this.alterarProdutoUseCase = alterarProdutoUseCase;
    }

    public void cancelar(Long id, Long usuarioId) {
        Pedido pedido = buscarPedidoUseCase.buscarPorId(id);

        if (!pedido.getUsuario().getId().equals(usuarioId))
            throw new CancelamentoNaoPermitidoException("Pedido não pertence ao usuario");

        if (!pedido.getStatusPedido().equals(StatusPedido.PENDENTE))
            throw new CancelamentoNaoPermitidoException("Pedido nao pode ser cancelado, pois ja está na etapa de " + pedido.getStatusPedido());

        pedido.setStatusPedido(StatusPedido.CANCELADO);

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = item.getProduto();
            produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
            alterarProdutoUseCase.alterar(produto.getId(), produto.getQuantidade(), null, null);
        }

        alterarStatusPedidoGateway.alterarStaus(pedido);
    }
}
