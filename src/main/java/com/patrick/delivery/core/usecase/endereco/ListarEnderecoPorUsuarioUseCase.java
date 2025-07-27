package com.patrick.delivery.core.usecase.endereco;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.gateway.endereco.ListarEnderecoPorUsuarioGateway;

import java.util.List;

public class ListarEnderecoPorUsuarioUseCase {

    private final ListarEnderecoPorUsuarioGateway listarEnderecoPorUsuarioGateway;

    public ListarEnderecoPorUsuarioUseCase(ListarEnderecoPorUsuarioGateway listarEnderecoPorUsuarioGateway) {
        this.listarEnderecoPorUsuarioGateway = listarEnderecoPorUsuarioGateway;
    }

    public List<Endereco> listarEnderecoPorUsuario(Long idUsuario) {
        return listarEnderecoPorUsuarioGateway.listarEnderecoPorUsuario(idUsuario);
    }
}
