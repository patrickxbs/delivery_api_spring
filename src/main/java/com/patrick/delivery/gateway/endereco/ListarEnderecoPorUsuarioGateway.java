package com.patrick.delivery.gateway.endereco;

import com.patrick.delivery.core.domain.Endereco;

import java.util.List;

public interface ListarEnderecoPorUsuarioGateway {

    List<Endereco> listarEnderecoPorUsuario(Long usuarioId);
}
