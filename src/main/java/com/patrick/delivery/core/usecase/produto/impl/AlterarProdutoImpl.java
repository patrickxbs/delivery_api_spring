package com.patrick.delivery.core.usecase.produto.impl;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.AlterarProdutoGateway;
import com.patrick.delivery.infrastructure.entity.ProdutoEntity;
import com.patrick.delivery.infrastructure.mapper.ProdutoMapper;
import com.patrick.delivery.infrastructure.persistence.ProdutoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AlterarProdutoImpl implements AlterarProdutoGateway {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    @Override
    public void alterar(Produto produto) {
        ProdutoEntity entity = ProdutoMapper.toEntity(produto);
        produtoRepositoryJpa.save(entity);
    }
}
