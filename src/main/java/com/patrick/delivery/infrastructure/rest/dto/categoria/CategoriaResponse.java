package com.patrick.delivery.infrastructure.rest.dto.categoria;

import com.patrick.delivery.core.domain.Categoria;

public record CategoriaResponse(Long id, String nome) {

    public static CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }
}
