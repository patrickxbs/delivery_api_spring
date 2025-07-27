package com.patrick.delivery.core.usecase.produto;

import com.patrick.delivery.core.domain.exception.EntidadeNaoEncontradaException;
import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.gateway.produto.BuscarProdutoGateway;

import java.util.Optional;

public class BuscarProdutoUseCase {

    private final BuscarProdutoGateway buscarProdutoGateway;

    public BuscarProdutoUseCase(BuscarProdutoGateway buscarProdutoGateway) {
        this.buscarProdutoGateway = buscarProdutoGateway;
    }

    public Produto buscarPorId(Long id) {
        return buscarProdutoGateway.buscarPorId(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Produto com o id '%s' não encontrado", id)));
    }

    public Optional<Produto> buscarPorNome(String nome) {
        return buscarProdutoGateway.buscarPorNome(nome);
    }
}
