package com.patrick.delivery.core.usecase.endereco.imlp;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.gateway.endereco.SalvarEnderecoGateway;
import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import com.patrick.delivery.infrastructure.mapper.EnderecoMapper;
import com.patrick.delivery.infrastructure.persistence.EnderecoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SalvarEnderecoImpl implements SalvarEnderecoGateway {

    private final EnderecoRepositoryJpa enderecoRepositoryJpa;

    @Override
    public Endereco salvar(Endereco endereco) {

        EnderecoEntity enderecoEntity = EnderecoMapper.toEntity(endereco);
        EnderecoEntity enderecoSalvo = enderecoRepositoryJpa.save(enderecoEntity);
        return EnderecoMapper.toEndereco(enderecoSalvo);
    }
}
