package com.patrick.delivery.infrastructure.rest.service;

import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.usecase.pedido.*;
import com.patrick.delivery.enuns.StatusPedido;
import com.patrick.delivery.infrastructure.rest.dto.pedido.AlterarStatusPedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final SalvarPedidoUseCase salvarPedidoUseCase;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final ListarPedidosPorClienteUseCase listarPedidosPorClienteGateway;
    private final ListarPedidosUseCase listarPedidosUseCase;
    private final AlterarStatusPedidoUseCase alterarStatusPedidoUseCase;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;

    public PedidoResponse salvar(PedidoRequest request) {
        Pedido pedido = PedidoRequest.toPedido(request);
        return PedidoResponse.toResponse(salvarPedidoUseCase.salvar(pedido));
    }

    public PedidoResponse buscarPorId(Long id) {
        Pedido pedido = buscarPedidoUseCase.buscarPorId(id);
        return PedidoResponse.toResponse(pedido);
    }

    public List<PedidoResponse> listarPedidosPorClienteById(Long clienteId) {
        return listarPedidosPorClienteGateway.listarPorUsuarioId(clienteId)
                .stream()
                .map(PedidoResponse::toResponse)
                .toList();
    }

    public List<PedidoResponse> listarPedidos() {
        return listarPedidosUseCase.listarPedidos()
                .stream()
                .map(PedidoResponse::toResponse)
                .toList();
    }

    public void alterarStatus(Long id, AlterarStatusPedidoRequest status) {
        alterarStatusPedidoUseCase.alterarStatus(id, status.statusPedido());
    }

    public void cancelar(Long id, Long usuarioId) {
        cancelarPedidoUseCase.cancelar(id, usuarioId);
    }
}
