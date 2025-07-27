package com.patrick.delivery.gateway.endereco;

import com.patrick.delivery.core.domain.Endereco;

import java.util.Optional;

public interface BuscarEnderecoGateway {

    Optional<Endereco> buscarPorId(Long id);

}
