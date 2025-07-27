package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.usecase.endereco.DesativarEnderecoUseCase;
import com.patrick.delivery.core.usecase.endereco.ListarEnderecoPorUsuarioUseCase;
import com.patrick.delivery.gateway.usuario.DesativarUsuarioGateway;

import java.util.List;

public class DesativarUsuarioUseCase {

    private final DesativarUsuarioGateway desativarUsuarioGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final ListarEnderecoPorUsuarioUseCase listarEnderecoPorUsuarioUseCase;
    private final DesativarEnderecoUseCase desativarEnderecoUseCase;

    public DesativarUsuarioUseCase(DesativarUsuarioGateway desativarUsuarioGateway, BuscarUsuarioUseCase buscarUsuarioUseCase, ListarEnderecoPorUsuarioUseCase listarEnderecoPorUsuarioUseCase, DesativarEnderecoUseCase desativarEnderecoUseCase) {
        this.desativarUsuarioGateway = desativarUsuarioGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.listarEnderecoPorUsuarioUseCase = listarEnderecoPorUsuarioUseCase;
        this.desativarEnderecoUseCase = desativarEnderecoUseCase;
    }

    public void deletar(Long id) {
        Usuario usuario = buscarUsuarioUseCase.buscarPorId(id);

        List<Endereco> enderecos = listarEnderecoPorUsuarioUseCase.listarEnderecoPorUsuario(id);
        if (!enderecos.isEmpty())
            enderecos.forEach(endereco -> desativarEnderecoUseCase.desativar(endereco.getId(), id));

        usuario.setAtivo(Boolean.FALSE);

        desativarUsuarioGateway.desativar(usuario);
    }
}
