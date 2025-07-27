package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.AtualizarUsuarioGateway;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.persistence.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AtualizarUsuarioImpl implements AtualizarUsuarioGateway {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public void alterarDados(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntitySemEndereco(usuario);
        usuarioRepositoryJpa.save(entity);
    }

    @Override
    public void alterarSenha(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntitySemEndereco(usuario);
        usuarioRepositoryJpa.save(entity);
    }

}
