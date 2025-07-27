package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.infrastructure.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaEntity entity) {
        Categoria categoria = new Categoria();
        categoria.setId(entity.getId());
        categoria.setNome(entity.getNome());
        return categoria;
    }

    public static CategoriaEntity toEntity(Categoria categoria) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setId(categoria.getId());
        entity.setNome(categoria.getNome());
        return entity;
    }

}
