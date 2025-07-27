package com.patrick.delivery.core.usecase.endereco;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.exception.EnderecoInvalidoException;
import com.patrick.delivery.gateway.endereco.DesativarEnderecoGateway;

public class DesativarEnderecoUseCase {

    private final DesativarEnderecoGateway desativarEnderecoGateway;
    private final BuscarEnderecoUseCase buscarEnderecoUseCase;

    public DesativarEnderecoUseCase(DesativarEnderecoGateway desativarEnderecoGateway, BuscarEnderecoUseCase buscarEnderecoUseCase) {
        this.desativarEnderecoGateway = desativarEnderecoGateway;
        this.buscarEnderecoUseCase = buscarEnderecoUseCase;
    }

    public void desativar(Long id, Long usuarioId) {
        Endereco endereco = buscarEnderecoUseCase.buscarPorId(id);

        if (!endereco.getUsuario().getId().equals(usuarioId))
            throw new EnderecoInvalidoException("Endereco nao pertence ao usuario");

        endereco.setAtivo(Boolean.FALSE);

        desativarEnderecoGateway.desativar(endereco);
    }
}
