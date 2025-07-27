package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import com.patrick.delivery.infrastructure.entity.ItemPedidoEntity;
import com.patrick.delivery.infrastructure.entity.PedidoEntity;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;

import java.util.List;

public class PedidoMapper {

    public static Pedido toPedido(PedidoEntity entity) {
        Pedido pedido = new Pedido();
        pedido.setId(entity.getId());
        pedido.setDataPedido(entity.getDataPedido());
        pedido.setDataEntregue(entity.getDataEntregue());
        pedido.setStatusPedido(entity.getStatusPedido());
        pedido.setDescricao(entity.getDescricao());
        pedido.setPrecoTotal(entity.getPrecoTotal());

        Usuario usuario = UsuarioMapper.toDomainComEndereco(entity.getUsuarioEntity());
        pedido.setUsuario(usuario);

        Endereco endereco = EnderecoMapper.toEndereco(entity.getEnderecoEntity());
        pedido.setEndereco(endereco);

        List<ItemPedido> itens = entity.getItensEntity().stream()
                .map(item -> new ItemPedido(item.getId(), item.getQuantidade(), item.getPrecoUnitario(),
                        ProdutoMapper.toProduto(item.getProdutoEntity()), pedido))
                .toList();
        pedido.setItens(itens);

        return pedido;
    }

    public static PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());
        entity.setDataPedido(pedido.getDataPedido());
        entity.setDataEntregue(pedido.getDataEntregue());
        entity.setStatusPedido(pedido.getStatusPedido());
        entity.setDescricao(pedido.getDescricao());
        entity.setPrecoTotal(pedido.getPrecoTotal());

        UsuarioEntity usuarioEntity = UsuarioMapper.toEntityComEndereco(pedido.getUsuario());
        entity.setUsuarioEntity(usuarioEntity);

        EnderecoEntity enderecoEntity = EnderecoMapper.toEntity(pedido.getEndereco());
        entity.setEnderecoEntity(enderecoEntity);

        List<ItemPedidoEntity> itensEntity = pedido.getItens().stream()
                .map(item -> new ItemPedidoEntity(item.getId(), item.getQuantidade(), item.getPrecoUnitario(),
                        ProdutoMapper.toEntity(item.getProduto()), entity))
                .toList();
        entity.setItensEntity(itensEntity);

        return entity;
    }
}
