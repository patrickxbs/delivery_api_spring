package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.gateway.pedido.ListarPedidosPorClienteGateway;

import java.util.List;

public class ListarPedidosPorClienteUseCase {

    private final ListarPedidosPorClienteGateway listarPedidosPorClienteGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public ListarPedidosPorClienteUseCase(ListarPedidosPorClienteGateway listarPedidosPorClienteGateway, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.listarPedidosPorClienteGateway = listarPedidosPorClienteGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public List<Pedido> listarPorUsuarioId(Long usuarioId) {
        buscarUsuarioUseCase.buscarPorId(usuarioId);
        return listarPedidosPorClienteGateway.listarPedidosPorCliente(usuarioId);
    }
}
