package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.exception.SenhaInvalidaException;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.domain.exception.UsuarioInativoException;
import com.patrick.delivery.gateway.usuario.AtualizarUsuarioGateway;
import com.patrick.delivery.gateway.usuario.CriptografarSenhaGateway;

public class AlterarSenhaUsuarioUseCase {

    private final CriptografarSenhaGateway criptografarSenhaGateway;
    private final AtualizarUsuarioGateway atualizarUsuarioGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public AlterarSenhaUsuarioUseCase(AtualizarUsuarioGateway atualizarUsuarioGateway,
                                      BuscarUsuarioUseCase buscarUsuarioUseCase,
                                      CriptografarSenhaGateway criptografarSenhaGateway) {
        this.atualizarUsuarioGateway = atualizarUsuarioGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criptografarSenhaGateway = criptografarSenhaGateway;
    }

    public void alterarSenha(Long id, String senhaAtual, String senhaNova, String confirmarSenha) {
        Usuario usuario = buscarUsuarioUseCase.buscarPorId(id);

        if (!usuario.getAtivo())
            throw new UsuarioInativoException("Nao e possivel alterar a senha com o usuario inativo");

        if (!criptografarSenhaGateway.verificar(senhaAtual, usuario.getSenha()))
            throw new SenhaInvalidaException("Senha atual incorreta");

        if (!senhaNova.equals(confirmarSenha))
            throw new SenhaInvalidaException("A senha nova não coincidem com a confirmacao de senha");

        usuario.setSenha(criptografarSenhaGateway.criptografar(senhaNova));
        atualizarUsuarioGateway.alterarSenha(usuario);
    }
}
