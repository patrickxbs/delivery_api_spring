package com.patrick.delivery.infrastructure.rest.dto.endereco;

import com.patrick.delivery.core.domain.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoRequest(@NotBlank String cep, @NotBlank String cidade, @NotBlank String bairro, @NotBlank String numero,
                              @NotBlank String logradouro, @NotBlank String complemento) {

    public static Endereco toEndereco(EnderecoRequest request) {
        return new Endereco(
                null,
                request.cep(),
                request.cidade(),
                request.bairro(),
                request.numero(),
                request.logradouro(),
                request.complemento(),
                null,
                null);
    }
}
