package com.patrick.delivery.core.usecase.endereco;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.gateway.endereco.SalvarEnderecoGateway;

public class SalvarEnderecoUseCase {

    private final SalvarEnderecoGateway salvarEnderecoGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public SalvarEnderecoUseCase(SalvarEnderecoGateway salvarEnderecoGateway, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.salvarEnderecoGateway = salvarEnderecoGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public Endereco salvar(Endereco endereco, Long idUsuario) {
        Usuario usuario = buscarUsuarioUseCase.buscarPorId(idUsuario);
        endereco.setUsuario(usuario);
        endereco.setAtivo(Boolean.TRUE);
        return salvarEnderecoGateway.salvar(endereco);
    }
}
