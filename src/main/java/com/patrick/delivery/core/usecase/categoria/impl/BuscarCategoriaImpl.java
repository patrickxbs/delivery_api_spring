package com.patrick.delivery.core.usecase.categoria.impl;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.gateway.categoria.BuscarCategoriaGateway;
import com.patrick.delivery.infrastructure.mapper.CategoriaMapper;
import com.patrick.delivery.infrastructure.persistence.CategoriaRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BuscarCategoriaImpl implements BuscarCategoriaGateway {

    private final CategoriaRepositoryJpa categoriaRepositoryJpa;

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepositoryJpa.findById(id).map(CategoriaMapper::toCategoria);
    }

    @Override
    public Optional<Categoria> buscarPorNome(String nome) {
        return categoriaRepositoryJpa.findByNome(nome).map(CategoriaMapper::toCategoria);
    }
}
