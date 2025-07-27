package com.patrick.delivery.core.usecase.itempedido;

import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.core.domain.exception.QuantidadeInsuficienteException;
import com.patrick.delivery.core.usecase.produto.AlterarProdutoUseCase;
import com.patrick.delivery.core.usecase.produto.BuscarProdutoUseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrepararItemPedidoUseCase {

    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final AlterarProdutoUseCase alterarProdutoUseCase;

    public PrepararItemPedidoUseCase(BuscarProdutoUseCase buscarProdutoUseCase, AlterarProdutoUseCase alterarProdutoUseCase) {
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.alterarProdutoUseCase = alterarProdutoUseCase;
    }

    public ItemPedido prepararItem(ItemPedido item) {
        Produto produto = buscarProdutoUseCase.buscarPorId(item.getProduto().getId());

        log.info("produto: {}", produto);

        item.setProduto(produto);
        item.setPrecoUnitario(produto.getPreco());

        int quantidadeAtual = produto.getQuantidade() - item.getQuantidade();
        if (quantidadeAtual < 0)
            throw new QuantidadeInsuficienteException("Produto com quantidade insuficiente");

        produto.setQuantidade(quantidadeAtual);
        alterarProdutoUseCase.alterar(produto.getId(), quantidadeAtual, null, null);
        log.info("Item: {}", item);
        return item;
    }
}
