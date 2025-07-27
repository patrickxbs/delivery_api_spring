package com.patrick.delivery.infrastructure.rest.dto.categoria;

import com.patrick.delivery.core.domain.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(@NotBlank String nome) {

    public static Categoria toCategoria(CategoriaRequest request) {
        return new Categoria(null, request.nome());
    }
}
