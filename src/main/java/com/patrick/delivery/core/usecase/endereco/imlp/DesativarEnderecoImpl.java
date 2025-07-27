package com.patrick.delivery.core.usecase.endereco.imlp;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.gateway.endereco.DesativarEnderecoGateway;
import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import com.patrick.delivery.infrastructure.mapper.EnderecoMapper;
import com.patrick.delivery.infrastructure.persistence.EnderecoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DesativarEnderecoImpl implements DesativarEnderecoGateway {

    private final EnderecoRepositoryJpa enderecoRepositoryJpa;

    @Override
    public void desativar(Endereco endereco) {
        EnderecoEntity entity = EnderecoMapper.toEntity(endereco);
        enderecoRepositoryJpa.save(entity);
    }
}
