package com.patrick.delivery.infrastructure.rest.dto.usuario;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public record UsuarioRequest(@NotBlank String nome, @NotBlank String telefone, @NotBlank String email,
                             @NotBlank String senha, EnderecoRequest endereco) {

    public static Usuario toUsuario(UsuarioRequest request) {

        List<Endereco> enderecos = new ArrayList<>();
        if (request.endereco() != null) {
            enderecos.add(EnderecoRequest.toEndereco(request.endereco()));
        }
        return new Usuario(
                null,
                request.nome(),
                request.telefone(),
                request.email(),
                request.senha(),
                null,
                enderecos,
                null);
    }
}
