package com.patrick.delivery.infrastructure.rest.dto.pedido;

import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.enuns.StatusPedido;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoResponse;
import com.patrick.delivery.infrastructure.rest.dto.itempedido.ItemPedidoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record PedidoResponse(Long id, LocalDateTime dataPedido, LocalDateTime dataEntregue, StatusPedido statusPedido, String descricao,
                             BigDecimal precoTotal, List<ItemPedidoResponse> itens, EnderecoResponse endereco) {

    public static PedidoResponse toResponse(Pedido pedido) {
        List<ItemPedidoResponse> itens = new ArrayList<>();
        for (ItemPedido item : pedido.getItens()) {
            itens.add(ItemPedidoResponse.toResponse(item));
        }

        EnderecoResponse endereco = EnderecoResponse.toResponse(pedido.getEndereco());

        return new PedidoResponse(pedido.getId(), pedido.getDataPedido(), pedido.getDataEntregue(),
                pedido.getStatusPedido(), pedido.getDescricao(), pedido.getPrecoTotal(), itens, endereco);
    }
}
