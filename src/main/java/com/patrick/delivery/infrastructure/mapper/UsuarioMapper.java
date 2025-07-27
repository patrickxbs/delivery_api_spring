package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public static Usuario toDomainSemEndereco(UsuarioEntity entity) {
        Usuario usuario = new Usuario();

        usuario.setId(entity.getId());
        usuario.setNome(entity.getNome());
        usuario.setTelefone(entity.getTelefone());
        usuario.setEmail(entity.getEmail());
        usuario.setSenha(entity.getSenha());
        usuario.setRole(entity.getRole());
        usuario.setAtivo(entity.getAtivo());

        return usuario;
    }

    public static Usuario toDomainComEndereco(UsuarioEntity entity) {
        Usuario usuario = new Usuario();

        usuario.setId(entity.getId());
        usuario.setNome(entity.getNome());
        usuario.setTelefone(entity.getTelefone());
        usuario.setEmail(entity.getEmail());
        usuario.setSenha(entity.getSenha());
        usuario.setRole(entity.getRole());
        usuario.setAtivo(entity.getAtivo());


        if (entity.getEnderecos() != null) {
            List<Endereco> enderecos =  entity.getEnderecos().stream()
                    .map(endereco ->
                            new Endereco(endereco.getId(), endereco.getCep(), endereco.getCidade(),
                                    endereco.getBairro(), endereco.getNumero(), endereco.getLogradouro(),
                                    endereco.getComplemento(), endereco.isAtivo(), usuario))
                    .toList();
            usuario.setEnderecos(enderecos);
        }

        return usuario;
    }

    public static UsuarioEntity toEntitySemEndereco(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setTelefone(usuario.getTelefone());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setRole(usuario.getRole());
        usuarioEntity.setAtivo(usuario.getAtivo());

        return usuarioEntity;
    }

    public static UsuarioEntity toEntityComEndereco(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setTelefone(usuario.getTelefone());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setRole(usuario.getRole());
        usuarioEntity.setAtivo(usuario.getAtivo());

        if (usuario.getEnderecos() != null) {
            List<EnderecoEntity> enderecos = usuario.getEnderecos().stream()
                    .map(endereco
                            -> new EnderecoEntity(endereco.getId(), endereco.getCep(), endereco.getCidade(),
                            endereco.getBairro(), endereco.getNumero(), endereco.getLogradouro(),
                            endereco.getComplemento(), endereco.getAtivo(), usuarioEntity))
                    .toList();
            usuarioEntity.setEnderecos(enderecos);
        }
        return usuarioEntity;
    }
}
