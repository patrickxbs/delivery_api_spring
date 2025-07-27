package com.patrick.delivery.infrastructure.rest.service;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.usecase.endereco.DesativarEnderecoUseCase;
import com.patrick.delivery.core.usecase.endereco.ListarEnderecoPorUsuarioUseCase;
import com.patrick.delivery.core.usecase.endereco.SalvarEnderecoUseCase;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoRequest;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final SalvarEnderecoUseCase salvarEnderecoUseCase;
    private final ListarEnderecoPorUsuarioUseCase listarEnderecoPorUsuarioUseCase;
    private final DesativarEnderecoUseCase desativarEnderecoUseCase;

    public EnderecoResponse salvar(EnderecoRequest request, Long idUsuario) {
        Endereco enderecoDomain = EnderecoRequest.toEndereco(request);
        Endereco salvar = salvarEnderecoUseCase.salvar(enderecoDomain, idUsuario);
        return EnderecoResponse.toResponse(salvar);
    }

    public List<EnderecoResponse> listarEnderecosPorUsuario(Long idUsuario) {
        List<Endereco> enderecos = listarEnderecoPorUsuarioUseCase.listarEnderecoPorUsuario(idUsuario);
        return enderecos.stream()
                .map(EnderecoResponse::toResponse)
                .toList();
    }

    public void deletar(Long id, Long usuarioId) {
        desativarEnderecoUseCase.desativar(id, usuarioId);
    }
}
