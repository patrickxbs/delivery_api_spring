package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.DesativarUsuarioGateway;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.persistence.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DesativarUsuarioImpl implements DesativarUsuarioGateway {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public void desativar(Usuario usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.toEntityComEndereco(usuario);
        usuarioRepositoryJpa.save(usuarioEntity);
    }
}
