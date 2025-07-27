package com.patrick.delivery.infrastructure.rest.dto.usuario;

import com.patrick.delivery.core.domain.Usuario;

public record UsuarioResponse(Long id, String nome, String telefone, String email, Boolean ativo) {

    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getTelefone(), usuario.getEmail(), usuario.getAtivo());
    }
}
