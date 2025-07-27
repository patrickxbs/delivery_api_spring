package com.patrick.delivery.gateway.categoria;

import com.patrick.delivery.core.domain.Categoria;

import java.util.Optional;

public interface BuscarCategoriaGateway {

    Optional<Categoria> buscarPorId(Long id);

    Optional<Categoria> buscarPorNome(String nome);
}
