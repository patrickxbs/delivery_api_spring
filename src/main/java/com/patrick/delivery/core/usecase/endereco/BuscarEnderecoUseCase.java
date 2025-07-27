package com.patrick.delivery.core.usecase.endereco;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.exception.EntidadeNaoEncontradaException;
import com.patrick.delivery.gateway.endereco.BuscarEnderecoGateway;

public class BuscarEnderecoUseCase {

    private final BuscarEnderecoGateway buscarEnderecoGateway;

    public BuscarEnderecoUseCase(BuscarEnderecoGateway buscarEnderecoGateway) {
        this.buscarEnderecoGateway = buscarEnderecoGateway;
    }

    public Endereco buscarPorId(Long id) {
        return buscarEnderecoGateway.buscarPorId(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Endereço com o id '%s' não encontrado", id)));
    }
}
