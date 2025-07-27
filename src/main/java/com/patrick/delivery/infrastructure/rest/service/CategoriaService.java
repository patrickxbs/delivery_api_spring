package com.patrick.delivery.infrastructure.rest.service;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.usecase.categoria.BuscarCategoriaUseCase;
import com.patrick.delivery.core.usecase.categoria.ListarCategoriasUseCase;
import com.patrick.delivery.core.usecase.categoria.SalvarCategoriaUseCase;
import com.patrick.delivery.infrastructure.rest.dto.categoria.CategoriaRequest;
import com.patrick.delivery.infrastructure.rest.dto.categoria.CategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final SalvarCategoriaUseCase salvarCategoriaUseCase;
    private final ListarCategoriasUseCase listarCategoriasUseCase;
    private final BuscarCategoriaUseCase buscarCategoriaUseCase;

    public CategoriaResponse salvar(CategoriaRequest request) {
        Categoria categoria = CategoriaRequest.toCategoria(request);
        return CategoriaResponse.toResponse(salvarCategoriaUseCase.salvar(categoria));
    }

    public List<CategoriaResponse> listar() {
        return listarCategoriasUseCase.listarCategorias().stream()
                .map(CategoriaResponse::toResponse)
                .toList();
    }

    public CategoriaResponse buscarPorId(Long id) {
        return CategoriaResponse.toResponse(buscarCategoriaUseCase.buscarPorId(id));
    }
}
