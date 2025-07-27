package com.patrick.delivery.core.usecase.endereco.imlp;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.gateway.endereco.ListarEnderecoPorUsuarioGateway;
import com.patrick.delivery.infrastructure.mapper.EnderecoMapper;
import com.patrick.delivery.infrastructure.persistence.EnderecoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ListarEnderecoPorUsuarioImpl implements ListarEnderecoPorUsuarioGateway {

    private final EnderecoRepositoryJpa enderecoRepositoryJpa;

    @Override
    public List<Endereco> listarEnderecoPorUsuario(Long usuarioId) {
        return enderecoRepositoryJpa.findAllByUsuarioEntityId(usuarioId)
                .stream()
                .map(EnderecoMapper::toEndereco)
                .toList();
    }
}
