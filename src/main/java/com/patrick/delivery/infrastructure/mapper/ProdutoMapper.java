package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.infrastructure.entity.CategoriaEntity;
import com.patrick.delivery.infrastructure.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProdutoMapper {

    public static Produto toProduto(ProdutoEntity entity) {
        Produto produto = new Produto();
        produto.setId(entity.getId());
        produto.setNome(entity.getNome());
        produto.setQuantidade(entity.getQuantidade());
        produto.setPreco(entity.getPreco());
        produto.setDescricao(entity.getDescricao());

        Categoria categoria = new Categoria();
        categoria.setId(entity.getCategoriaEntity().getId());
        categoria.setNome(entity.getCategoriaEntity().getNome());

        produto.setCategoria(categoria);

        return produto;
    }

    public static ProdutoEntity toEntity(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(produto.getId());
        entity.setNome(produto.getNome());
        entity.setQuantidade(produto.getQuantidade());
        entity.setPreco(produto.getPreco());
        entity.setDescricao(produto.getDescricao());

        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(produto.getCategoria().getId());
        categoriaEntity.setNome(produto.getCategoria().getNome());

        entity.setCategoriaEntity(categoriaEntity);

        return entity;
    }
}
