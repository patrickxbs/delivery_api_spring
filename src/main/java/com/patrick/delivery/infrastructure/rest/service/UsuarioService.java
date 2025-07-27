package com.patrick.delivery.infrastructure.rest.service;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.usecase.usuario.*;
import com.patrick.delivery.infrastructure.rest.dto.usuario.AlterarDadosUsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.AlterarSenhaUsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.UsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final AlterarSenhaUsuarioUseCase alterarSenhaUsuarioUseCase;
    private final AlterarDadosUsuarioUseCase atualizarUsuarioUseCase;
    private final DesativarUsuarioUseCase deletarUsuarioUseCase;


    public UsuarioResponse cadastrar(UsuarioRequest request) {
        Usuario usuarioSalvo = cadastrarClienteUseCase.cadastrar(
                UsuarioRequest.toUsuario(request));
        return UsuarioResponse.toResponse(usuarioSalvo);
    }

    public List<UsuarioResponse> listarUsuarios() {
        return listarUsuariosUseCase.listarUsuarios()
                .stream()
                .map(UsuarioResponse::toResponse)
                .toList();
    }

    public UsuarioResponse buscarUsuario(Long id) {
        Usuario usuario = buscarUsuarioUseCase.buscarPorId(id);
        return UsuarioResponse.toResponse(usuario);
    }

    public void alterarSenha(Long id, AlterarSenhaUsuarioRequest resquest) {
        alterarSenhaUsuarioUseCase.alterarSenha(
                id, resquest.senhaAtual(), resquest.senhaNova(), resquest.confirmarSenha());
    }

    public void alterarDados(Long id, AlterarDadosUsuarioRequest request) {
        atualizarUsuarioUseCase.atualizar(
                id, request.nome(), request.telefone(), request.email());
    }

    public void deletar(Long id) {
        deletarUsuarioUseCase.deletar(id);
    }

}
