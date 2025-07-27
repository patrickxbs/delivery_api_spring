package com.patrick.delivery.infrastructure.rest.dto.pedido;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.infrastructure.rest.dto.itempedido.ItemPedidoRequest;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record PedidoRequest(String descricao, @NotNull List<ItemPedidoRequest> itens, @NotNull Long usuarioId, @NotNull Long enderecoId) {

    public static Pedido toPedido(PedidoRequest request) {
        List<ItemPedido> itens = new ArrayList<>();
        for (ItemPedidoRequest i: request.itens()) {
            ItemPedido item = ItemPedidoRequest.toItemPedido(i);
            itens.add(item);
        }

        Usuario usuario = new Usuario();
        usuario.setId(request.usuarioId);

        Endereco endereco = new Endereco();
        endereco.setId(request.enderecoId());

        Pedido pedido = new Pedido();
        pedido.setDescricao(request.descricao());
        pedido.setItens(itens);
        pedido.setUsuario(usuario);
        pedido.setEndereco(endereco);

        return pedido;
    }
}
