package com.patrick.delivery.core.usecase.categoria.impl;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.gateway.categoria.ListarCategoriasGateway;
import com.patrick.delivery.infrastructure.mapper.CategoriaMapper;
import com.patrick.delivery.infrastructure.persistence.CategoriaRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarCategoriasImpl implements ListarCategoriasGateway {

    private final CategoriaRepositoryJpa categoriaRepositoryJpa;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepositoryJpa.findAll()
                .stream()
                .map(CategoriaMapper::toCategoria)
                .toList();
    }
}
