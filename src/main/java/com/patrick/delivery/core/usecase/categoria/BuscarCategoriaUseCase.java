package com.patrick.delivery.core.usecase.categoria;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.domain.exception.EntidadeNaoEncontradaException;
import com.patrick.delivery.gateway.categoria.BuscarCategoriaGateway;

import java.util.Optional;

public class BuscarCategoriaUseCase {

    private final BuscarCategoriaGateway buscarCategoriaGateway;

    public BuscarCategoriaUseCase(BuscarCategoriaGateway buscarCategoriaGateway) {
        this.buscarCategoriaGateway = buscarCategoriaGateway;
    }

    public Categoria buscarPorId(Long id) {
        return buscarCategoriaGateway.buscarPorId(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Categoria com o id '%s' não encontrado", id)));
    }

    public Optional<Categoria> buscarPorNome(String nome) {
        return buscarCategoriaGateway.buscarPorNome(nome);
    }

}
