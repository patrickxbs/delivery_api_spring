package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class EnderecoMapper {

    public static Endereco toEndereco(EnderecoEntity entity) {
        Endereco endereco = new Endereco();

        endereco.setId(entity.getId());
        endereco.setCep(entity.getCep());
        endereco.setCidade(entity.getCidade());
        endereco.setBairro(entity.getBairro());
        endereco.setNumero(entity.getNumero());
        endereco.setLogradouro(entity.getLogradouro());
        endereco.setComplemento(entity.getComplemento());
        endereco.setAtivo(entity.isAtivo());

        Usuario usuario = new Usuario(entity.getUsuarioEntity().getId(), entity.getUsuarioEntity().getNome(),
                entity.getUsuarioEntity().getTelefone(), entity.getUsuarioEntity().getEmail(), entity.getUsuarioEntity().getSenha(),
                entity.getUsuarioEntity().getRole(), Collections.singletonList(endereco), entity.getUsuarioEntity().getAtivo());

        endereco.setUsuario(usuario);

        return endereco;
    }

    public static EnderecoEntity toEntity(Endereco endereco) {
        EnderecoEntity enderecoEntity = new EnderecoEntity();

        enderecoEntity.setId(endereco.getId());
        enderecoEntity.setCep(endereco.getCep());
        enderecoEntity.setCidade(endereco.getCidade());
        enderecoEntity.setBairro(endereco.getBairro());
        enderecoEntity.setNumero(endereco.getNumero());
        enderecoEntity.setLogradouro(endereco.getLogradouro());
        enderecoEntity.setComplemento(endereco.getComplemento());
        enderecoEntity.setAtivo(endereco.getAtivo());

        UsuarioEntity usuarioEntity = new UsuarioEntity(endereco.getUsuario().getId(), endereco.getUsuario().getNome(),
                endereco.getUsuario().getTelefone(), endereco.getUsuario().getEmail(), endereco.getUsuario().getSenha(),
                endereco.getUsuario().getRole(), Collections.singletonList(enderecoEntity), endereco.getUsuario().getAtivo());

        enderecoEntity.setUsuarioEntity(usuarioEntity);

        return enderecoEntity;
    }
}
