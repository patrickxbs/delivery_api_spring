package com.patrick.delivery.infrastructure.rest.dto.produto;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.infrastructure.rest.dto.categoria.CategoriaResponse;

import java.math.BigDecimal;

public record ProdutoResponse(Long id, String nome, Integer quantidade, BigDecimal preco, String descricao, CategoriaResponse categoriaResponse) {

    public static ProdutoResponse toResponse(Produto produto) {

        CategoriaResponse categoriaResponse = CategoriaResponse.toResponse(produto.getCategoria());

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPreco(),
                produto.getDescricao(),
                categoriaResponse);
    }
}
