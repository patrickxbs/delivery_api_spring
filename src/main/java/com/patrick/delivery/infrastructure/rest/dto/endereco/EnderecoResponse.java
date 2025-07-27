package com.patrick.delivery.infrastructure.rest.dto.endereco;

import com.patrick.delivery.core.domain.Endereco;

public record EnderecoResponse(Long id, String cep, String cidade, String bairro, String numero, String logradouro, String complemento, Boolean ativo) {

    public static EnderecoResponse toResponse(Endereco endereco) {
        return new EnderecoResponse(
                endereco.getId(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getNumero(),
                endereco.getLogradouro(),
                endereco.getComplemento(),
                endereco.getAtivo());
    }
}
