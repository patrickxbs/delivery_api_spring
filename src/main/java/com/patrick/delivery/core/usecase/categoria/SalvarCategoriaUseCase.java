package com.patrick.delivery.core.usecase.categoria;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.domain.exception.CampoJaExisteException;
import com.patrick.delivery.gateway.categoria.SalvarCategoriaGateway;

import java.util.Optional;

public class SalvarCategoriaUseCase {

    private final SalvarCategoriaGateway salvarCategoriaGateway;
    private final BuscarCategoriaUseCase buscarCategoriaUseCase;

    public SalvarCategoriaUseCase(SalvarCategoriaGateway salvarCategoriaGateway, BuscarCategoriaUseCase buscarCategoriaUseCase) {
        this.salvarCategoriaGateway = salvarCategoriaGateway;
        this.buscarCategoriaUseCase = buscarCategoriaUseCase;
    }

    public Categoria salvar(Categoria categoria) {

        Optional<Categoria> categoriaJaExiste = buscarCategoriaUseCase.buscarPorNome(categoria.getNome());
        if (categoriaJaExiste.isPresent())
            throw new CampoJaExisteException(String.format("Categoria com o nome '%s' já existe", categoria.getNome()));

        return salvarCategoriaGateway.salvar(categoria);
    }
}
