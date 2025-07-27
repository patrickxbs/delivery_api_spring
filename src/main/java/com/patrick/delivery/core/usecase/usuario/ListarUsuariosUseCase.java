package com.patrick.delivery.core.usecase.usuario;

import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.gateway.usuario.ListarUsuariosGateway;

import java.util.List;

public class ListarUsuariosUseCase {

    private final ListarUsuariosGateway listarUsuariosGateway;

    public ListarUsuariosUseCase(ListarUsuariosGateway listarUsuariosGateway) {
        this.listarUsuariosGateway = listarUsuariosGateway;
    }

    public List<Usuario> listarUsuarios() {
        return listarUsuariosGateway.listarUsuarios();
    }
}
