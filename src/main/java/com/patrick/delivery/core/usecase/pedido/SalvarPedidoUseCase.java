package com.patrick.delivery.core.usecase.pedido;

import com.patrick.delivery.core.domain.Endereco;
import com.patrick.delivery.core.domain.ItemPedido;
import com.patrick.delivery.core.domain.Pedido;
import com.patrick.delivery.core.domain.Usuario;
import com.patrick.delivery.core.domain.exception.EnderecoInvalidoException;
import com.patrick.delivery.core.domain.exception.UsuarioInativoException;
import com.patrick.delivery.core.usecase.endereco.BuscarEnderecoUseCase;
import com.patrick.delivery.core.usecase.itempedido.PrepararItemPedidoUseCase;
import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.enuns.StatusPedido;
import com.patrick.delivery.gateway.pedido.SalvarPedidoGateway;

import java.time.LocalDateTime;

public class SalvarPedidoUseCase {

    private final SalvarPedidoGateway salvarPedidoGateway;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarEnderecoUseCase buscarEnderecoUseCase;
    private final PrepararItemPedidoUseCase prepararItemPedidoUseCase;


    public SalvarPedidoUseCase(SalvarPedidoGateway salvarPedidoGateway, BuscarUsuarioUseCase buscarUsuarioUseCase,
                               BuscarEnderecoUseCase buscarEnderecoUseCase, PrepararItemPedidoUseCase prepararItemPedidoUseCase) {
        this.salvarPedidoGateway = salvarPedidoGateway;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarEnderecoUseCase = buscarEnderecoUseCase;
        this.prepararItemPedidoUseCase = prepararItemPedidoUseCase;
    }

    public Pedido salvar(Pedido pedido) {
        Usuario usuario = buscarUsuarioUseCase.buscarPorId(pedido.getUsuario().getId());

        Endereco endereco = buscarEnderecoUseCase.buscarPorId(pedido.getEndereco().getId());

        if (!usuario.getAtivo())
            throw new UsuarioInativoException("Nao e possivel fazer pedido com o usuario inativo");

        if (!endereco.getUsuario().getId().equals(usuario.getId()) || !endereco.getAtivo())
            throw new EnderecoInvalidoException("Endereco nao pertence ao usuario ou nao esta ativo");

        for (ItemPedido item : pedido.getItens())
            prepararItemPedidoUseCase.prepararItem(item);

        Pedido criarPedido = new Pedido();
        criarPedido.setDataPedido(LocalDateTime.now());
        criarPedido.setStatusPedido(StatusPedido.PENDENTE);
        criarPedido.setUsuario(usuario);
        criarPedido.setEndereco(endereco);
        criarPedido.setItens(pedido.getItens());
        criarPedido.setDescricao(pedido.getDescricao());

        criarPedido.calcularPrecoTotal();

        return salvarPedidoGateway.salvar(criarPedido);
    }
}
