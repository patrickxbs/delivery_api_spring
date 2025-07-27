package com.patrick.delivery.core.usecase.categoria.impl;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.gateway.categoria.SalvarCategoriaGateway;
import com.patrick.delivery.infrastructure.entity.CategoriaEntity;
import com.patrick.delivery.infrastructure.mapper.CategoriaMapper;
import com.patrick.delivery.infrastructure.persistence.CategoriaRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SalvarCategoriaImpl implements SalvarCategoriaGateway {

    private final CategoriaRepositoryJpa categoriaRepositoryJpa;

    @Override
    public Categoria salvar(Categoria categoria) {
        CategoriaEntity entity = CategoriaMapper.toEntity(categoria);
        return CategoriaMapper.toCategoria(categoriaRepositoryJpa.save(entity));
    }
}
