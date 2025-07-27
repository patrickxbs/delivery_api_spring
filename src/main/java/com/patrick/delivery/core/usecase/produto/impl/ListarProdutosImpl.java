package com.patrick.delivery.core.usecase.produto.impl;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.ListarProdutosGateway;
import com.patrick.delivery.infrastructure.mapper.ProdutoMapper;
import com.patrick.delivery.infrastructure.persistence.ProdutoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarProdutosImpl implements ListarProdutosGateway {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepositoryJpa.findAll()
                .stream()
                .map(ProdutoMapper::toProduto)
                .toList();
    }
}
