package com.patrick.delivery.infrastructure.rest.dto.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String email, @NotBlank String senha) {
}
