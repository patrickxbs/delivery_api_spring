package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.CadastrarClienteGateway;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.persistence.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CadastrarClienteImpl implements CadastrarClienteGateway {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Usuario cadastrarCliente(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntityComEndereco(usuario);
        return UsuarioMapper.toDomainComEndereco(usuarioRepositoryJpa.save(entity));
    }
}
