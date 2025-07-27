package com.patrick.delivery.core.usecase.endereco.imlp;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.gateway.endereco.BuscarEnderecoGateway;
import com.patrick.delivery.infrastructure.mapper.EnderecoMapper;
import com.patrick.delivery.infrastructure.persistence.EnderecoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BuscarEnderecoImpl implements BuscarEnderecoGateway {

    private final EnderecoRepositoryJpa enderecoRepositoryJpa;

    @Override
    public Optional<Endereco> buscarPorId(Long id) {
        return enderecoRepositoryJpa.findById(id).map(EnderecoMapper::toEndereco);
    }


}
