package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.BuscarUsuarioGateway;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.persistence.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BuscarUsuarioImpl implements BuscarUsuarioGateway {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepositoryJpa.findByEmail(email).map(UsuarioMapper::toDomainSemEndereco);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepositoryJpa.findById(id).map(UsuarioMapper::toDomainSemEndereco);
    }

    @Override
    public boolean telefoneExiste(String telefone) {
        return usuarioRepositoryJpa.existsByTelefone(telefone);
    }
}
