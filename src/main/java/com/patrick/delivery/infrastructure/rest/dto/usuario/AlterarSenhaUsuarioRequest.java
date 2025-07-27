package com.patrick.delivery.infrastructure.rest.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaUsuarioRequest(@NotBlank String senhaAtual, @NotBlank String senhaNova, @NotBlank String confirmarSenha) {

}
