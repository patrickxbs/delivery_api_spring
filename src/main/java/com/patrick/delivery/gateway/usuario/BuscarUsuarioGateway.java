package com.patrick.delivery.gateway.usuario;

import com.patrick.delivery.core.domain.Usuario;

import java.util.Optional;

public interface BuscarUsuarioGateway {

    Optional<Usuario> buscarPorEmail(String email);

    Optional<Usuario> buscarPorId(Long id);

    boolean telefoneExiste(String telefone);
}
