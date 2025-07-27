package com.patrick.delivery.core.usecase.produto;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.AlterarProdutoGateway;

import java.math.BigDecimal;

public class AlterarProdutoUseCase {

    private final AlterarProdutoGateway alterarProdutoGateway;
    private final BuscarProdutoUseCase buscarProdutoUseCase;

    public AlterarProdutoUseCase(AlterarProdutoGateway alterarProdutoGateway, BuscarProdutoUseCase buscarProdutoUseCase) {
        this.alterarProdutoGateway = alterarProdutoGateway;
        this.buscarProdutoUseCase = buscarProdutoUseCase;
    }

    public void alterar(Long id, Integer quantidade, BigDecimal preco, String descricao) {

        Produto produto = buscarProdutoUseCase.buscarPorId(id);

        if (quantidade != null )
            produto.setQuantidade(quantidade);

        if (preco != null) {
            produto.setPreco(preco);
        }

        if (descricao != null && !descricao.isBlank()) {
            produto.setDescricao(descricao);
        }

        alterarProdutoGateway.alterar(produto);
    }
}
