package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.exception.CampoJaExisteException;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.enuns.Role;
import com.patrick.delivery.gateway.usuario.CadastrarClienteGateway;
import com.patrick.delivery.gateway.usuario.CriptografarSenhaGateway;

import java.util.Collections;
import java.util.Optional;

public class CadastrarClienteUseCase {

    private final CadastrarClienteGateway cadastrarClienteGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriptografarSenhaGateway criptografarSenhaGateway;

    public CadastrarClienteUseCase(CadastrarClienteGateway cadastrarClienteGateway,
                                   BuscarUsuarioUseCase buscarUsuarioUseCase,
                                   CriptografarSenhaGateway criptografarSenhaGateway) {
        this.cadastrarClienteGateway = cadastrarClienteGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criptografarSenhaGateway = criptografarSenhaGateway;
    }

    public Usuario cadastrar(Usuario usuario) {

        validarEmailETelefone(usuario);

        String senhaCripto = criptografarSenhaGateway.criptografar(usuario.getSenha());

        Usuario cadastrarCliente = new Usuario();
        cadastrarCliente.setNome(usuario.getNome());
        cadastrarCliente.setTelefone(usuario.getTelefone());
        cadastrarCliente.setEmail(usuario.getEmail());
        cadastrarCliente.setSenha(senhaCripto);
        cadastrarCliente.setRole(Role.CLIENTE);
        cadastrarCliente.setAtivo(Boolean.TRUE);

        if(!usuario.getEnderecos().isEmpty()) {
            Endereco endereco = usuario.getEnderecos().get(0);
            endereco.setAtivo(Boolean.TRUE);
            endereco.setUsuario(cadastrarCliente);
            cadastrarCliente.setEnderecos(Collections.singletonList(endereco));
        }

        return cadastrarClienteGateway.cadastrarCliente(cadastrarCliente);
    }

    private void validarEmailETelefone(Usuario usuario) {
        Optional<Usuario> emailJaExiste = buscarUsuarioUseCase.buscarPorEmail(usuario.getEmail());
        if (emailJaExiste.isPresent())
            throw new CampoJaExisteException("Email ja cadastrado por outro usuario");

        if (buscarUsuarioUseCase.telefoneExiste(usuario.getTelefone()))
            throw new CampoJaExisteException("Telefone ja cadastrado por outro usuario");
    }
}
