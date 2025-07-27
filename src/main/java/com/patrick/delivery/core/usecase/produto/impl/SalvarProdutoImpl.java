package com.patrick.delivery.core.usecase.produto.impl;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.SalvarProdutoGateway;
import com.patrick.delivery.infrastructure.entity.ProdutoEntity;
import com.patrick.delivery.infrastructure.mapper.ProdutoMapper;
import com.patrick.delivery.infrastructure.persistence.ProdutoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SalvarProdutoImpl implements SalvarProdutoGateway {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = ProdutoMapper.toEntity(produto);
        return ProdutoMapper.toProduto(produtoRepositoryJpa.save(entity));
    }
}
