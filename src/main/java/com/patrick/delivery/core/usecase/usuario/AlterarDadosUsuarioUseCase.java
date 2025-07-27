package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.domain.exception.UsuarioInativoException;
import com.patrick.delivery.gateway.usuario.AtualizarUsuarioGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlterarDadosUsuarioUseCase {

    private final AtualizarUsuarioGateway atualizarUsuarioGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public AlterarDadosUsuarioUseCase(AtualizarUsuarioGateway atualizarUsuarioGateway, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.atualizarUsuarioGateway = atualizarUsuarioGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public void atualizar(Long id, String nome, String telefone, String email) {

        Usuario usuario = buscarUsuarioUseCase.buscarPorId(id);

        if (!usuario.getAtivo())
            throw new UsuarioInativoException("Nao e possivel alterar dados com o usuario inativo");

        if (nome != null && !nome.isBlank()) usuario.setNome(nome);

        if (telefone != null && !telefone.isBlank()) usuario.setTelefone(telefone);

        if (email != null && !email.isBlank()) {
            Optional<Usuario> emailJaCadastrado = buscarUsuarioUseCase.buscarPorEmail(email);
            if (emailJaCadastrado.isPresent())
                throw new RuntimeException("Email ja existente");
            usuario.setEmail(email);
        }

        atualizarUsuarioGateway.alterarDados(usuario);
    }
}
