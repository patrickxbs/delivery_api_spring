package com.patrick.delivery.gateway.produto;

import com.patrick.delivery.core.domain.Produto;

import java.util.Optional;

public interface BuscarProdutoGateway {

    Optional<Produto> buscarPorId(Long id);

    Optional<Produto> buscarPorNome(String nome);
}
