package com.patrick.delivery.core.usecase.produto;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.ListarProdutosGateway;

import java.util.List;

public class ListarProdutosUseCase {

    private final ListarProdutosGateway listarProdutosGateway;

    public ListarProdutosUseCase(ListarProdutosGateway listarProdutosGateway) {
        this.listarProdutosGateway = listarProdutosGateway;
    }

    public List<Produto> listarProdutos() {
        return listarProdutosGateway.listarProdutos();
    }
}
