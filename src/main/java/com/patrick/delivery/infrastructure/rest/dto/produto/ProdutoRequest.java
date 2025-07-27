package com.patrick.delivery.infrastructure.rest.dto.produto;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.domain.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequest(@NotBlank String nome, @NotNull Integer quantidade, @NotNull BigDecimal preco, @NotBlank String descricao,
                             @NotNull Long categoriaId) {

    public static Produto toProduto(ProdutoRequest request) {
        Categoria categoria = new Categoria(request.categoriaId(), null);
        return new Produto(null, request.nome(), request.quantidade(), request.preco(), request.descricao(), categoria);
    }
}
