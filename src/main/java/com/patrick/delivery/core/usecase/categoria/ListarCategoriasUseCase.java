package com.patrick.delivery.core.usecase.categoria;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.gateway.categoria.ListarCategoriasGateway;

import java.util.List;

public class ListarCategoriasUseCase {

    private final ListarCategoriasGateway listarCategoriasGateway;

    public ListarCategoriasUseCase(ListarCategoriasGateway listarCategoriasGateway) {
        this.listarCategoriasGateway = listarCategoriasGateway;
    }

    public List<Categoria> listarCategorias() {
        return listarCategoriasGateway.listarCategorias();
    }
}
