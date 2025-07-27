package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.exception.EntidadeNaoEncontradaException;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.BuscarUsuarioGateway;

import java.util.Optional;

public class BuscarUsuarioUseCase {

    private final BuscarUsuarioGateway buscarUsuarioGateway;

    public BuscarUsuarioUseCase(BuscarUsuarioGateway buscarUsuarioGateway) {
        this.buscarUsuarioGateway = buscarUsuarioGateway;
    }

    public Usuario buscarPorId(Long id) {
        return buscarUsuarioGateway.buscarPorId(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Usuario com o id '%s' não encontrado", id)));
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return buscarUsuarioGateway.buscarPorEmail(email);
    }

    public boolean telefoneExiste(String telefone) {
        return buscarUsuarioGateway.telefoneExiste(telefone);
    }

}
