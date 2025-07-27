package com.patrick.delivery.infrastructure.mapper;

import com.patrick.delivery.core.domain.*;
import com.patrick.delivery.infrastructure.entity.*;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ItemPedidoMapper {

    public static ItemPedido toItemPedido(ItemPedidoEntity entity) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(entity.getId());
        itemPedido.setQuantidade(entity.getQuantidade());
        itemPedido.setPrecoUnitario(entity.getPrecoUnitario());

        Produto produto = ProdutoMapper.toProduto(entity.getProdutoEntity());
        itemPedido.setProduto(produto);

        Usuario usuario = UsuarioMapper.toDomainComEndereco(entity.getPedidoEntity().getUsuarioEntity());
        Endereco endereco = EnderecoMapper.toEndereco(entity.getPedidoEntity().getEnderecoEntity());

        Pedido pedido = new Pedido(entity.getPedidoEntity().getId(), entity.getPedidoEntity().getDataPedido(), entity.getPedidoEntity().getDataEntregue(),
                entity.getPedidoEntity().getStatusPedido(), entity.getPedidoEntity().getDescricao(), entity.getPedidoEntity().getPrecoTotal(),
                Collections.singletonList(itemPedido), usuario, endereco);
        itemPedido.setPedido(pedido);

        return itemPedido;
    }

    public static ItemPedidoEntity toEntity(ItemPedido itemPedido) {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
        itemPedidoEntity.setId(itemPedido.getId());
        itemPedidoEntity.setQuantidade(itemPedido.getQuantidade());
        itemPedidoEntity.setPrecoUnitario(itemPedido.getPrecoUnitario());

        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(itemPedido.getProduto());
        itemPedidoEntity.setProdutoEntity(produtoEntity);

        UsuarioEntity usuario = UsuarioMapper.toEntityComEndereco(itemPedido.getPedido().getUsuario());
        EnderecoEntity endereco = EnderecoMapper.toEntity(itemPedido.getPedido().getEndereco());

        PedidoEntity pedidoEntity = new PedidoEntity(itemPedido.getPedido().getId(), itemPedido.getPedido().getDataPedido(),
                itemPedido.getPedido().getDataEntregue(), itemPedido.getPedido().getStatusPedido(), itemPedido.getPedido().getDescricao(),
                itemPedido.getPedido().getPrecoTotal(), Collections.singletonList(itemPedidoEntity), usuario, endereco);
        itemPedidoEntity.setPedidoEntity(pedidoEntity);

        return itemPedidoEntity;
    }
}
