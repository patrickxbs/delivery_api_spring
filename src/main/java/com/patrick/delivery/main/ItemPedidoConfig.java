package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.itempedido.PrepararItemPedidoUseCase;
import com.patrick.delivery.core.usecase.produto.AlterarProdutoUseCase;
import com.patrick.delivery.core.usecase.produto.BuscarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemPedidoConfig {

    @Bean
    public PrepararItemPedidoUseCase prepararItemPedidoUseCase(BuscarProdutoUseCase buscarProdutoUseCase, AlterarProdutoUseCase alterarProdutoUseCase) {
        return new PrepararItemPedidoUseCase(buscarProdutoUseCase, alterarProdutoUseCase);
    }
}
