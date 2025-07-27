package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.ListarUsuariosGateway;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.persistence.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarUsuariosImpl implements ListarUsuariosGateway {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositoryJpa.findAll()
                .stream()
                .map(UsuarioMapper::toDomainSemEndereco)
                .toList();
    }
}
