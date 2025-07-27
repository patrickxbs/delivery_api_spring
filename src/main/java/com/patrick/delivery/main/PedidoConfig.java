package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.endereco.BuscarEnderecoUseCase;
import com.patrick.delivery.core.usecase.itempedido.PrepararItemPedidoUseCase;
import com.patrick.delivery.core.usecase.pedido.*;
import com.patrick.delivery.core.usecase.produto.AlterarProdutoUseCase;
import com.patrick.delivery.core.usecase.produto.BuscarProdutoUseCase;
import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.gateway.pedido.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

    @Bean
    public SalvarPedidoUseCase salvarPedidoUseCase(SalvarPedidoGateway salvarPedidoGateway,
                                                   BuscarUsuarioUseCase buscarUsuarioUseCase,
                                                   BuscarEnderecoUseCase buscarEnderecoUseCase,
                                                   PrepararItemPedidoUseCase prepararItemPedidoUseCase) {
        return new SalvarPedidoUseCase(salvarPedidoGateway, buscarUsuarioUseCase, buscarEnderecoUseCase, prepararItemPedidoUseCase);
    }

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoGateway buscarPedidoGateway) {
        return new BuscarPedidoUseCase(buscarPedidoGateway);
    }

    @Bean
    public ListarPedidosPorClienteUseCase listarPedidosPorClienteUseCase(ListarPedidosPorClienteGateway listarPedidosPorClienteGateway,
                                                                         BuscarUsuarioUseCase buscarUsuarioUseCase) {
        return new ListarPedidosPorClienteUseCase(listarPedidosPorClienteGateway, buscarUsuarioUseCase);
    }

    @Bean
    public ListarPedidosUseCase listarPedidosUseCase(ListarPedidosGateway listarPedidosGateway) {
        return new ListarPedidosUseCase(listarPedidosGateway);
    }

    @Bean
    public AlterarStatusPedidoUseCase alterarStatusPedidoUseCase(AlterarStatusPedidoGateway alterarStatusPedidoGateway,
                                                                 BuscarPedidoUseCase buscarPedidoUseCase) {
        return new AlterarStatusPedidoUseCase(alterarStatusPedidoGateway, buscarPedidoUseCase);
    }

    @Bean
    public CancelarPedidoUseCase cancelarPedidoUseCase(AlterarStatusPedidoGateway alterarStatusPedidoGateway,
                                                       BuscarPedidoUseCase buscarPedidoUseCase,
                                                       AlterarProdutoUseCase alterarProdutoUseCase) {
        return new CancelarPedidoUseCase(alterarStatusPedidoGateway, buscarPedidoUseCase, alterarProdutoUseCase);
    }
}
