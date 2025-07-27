package com.patrick.delivery.core.usecase.produto.impl;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.BuscarProdutoGateway;
import com.patrick.delivery.infrastructure.mapper.ProdutoMapper;
import com.patrick.delivery.infrastructure.persistence.ProdutoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BuscarProdutoImpl implements BuscarProdutoGateway {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepositoryJpa.findById(id).map(ProdutoMapper::toProduto);
    }

    @Override
    public Optional<Produto> buscarPorNome(String nome) {
        return produtoRepositoryJpa.findByNome(nome).map(ProdutoMapper::toProduto);
    }
}
