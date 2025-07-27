package com.patrick.delivery.gateway.usuario;

import com.patrick.delivery.core.domain.Usuario;

public interface AtualizarUsuarioGateway {

    void alterarDados(Usuario usuario);

    void alterarSenha(Usuario usuario);
}
