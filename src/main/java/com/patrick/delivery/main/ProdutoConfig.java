package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.categoria.BuscarCategoriaUseCase;
import com.patrick.delivery.core.usecase.produto.*;
import com.patrick.delivery.gateway.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    public SalvarProdutoUseCase salvarProdutoUseCase(SalvarProdutoGateway salvarProdutoGateway,
                                                     BuscarProdutoUseCase buscarProdutoUseCase,
                                                     BuscarCategoriaUseCase buscarCategoriaUseCase) {
        return new SalvarProdutoUseCase(salvarProdutoGateway, buscarProdutoUseCase, buscarCategoriaUseCase);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCase(ListarProdutosGateway listarProdutosGateway) {
        return new ListarProdutosUseCase(listarProdutosGateway);
    }

    @Bean
    public BuscarProdutoUseCase buscarProdutoUseCase(BuscarProdutoGateway buscarProdutoGateway) {
        return new BuscarProdutoUseCase(buscarProdutoGateway);
    }

    @Bean
    public AlterarProdutoUseCase alterarProdutoUseCase(AlterarProdutoGateway alterarProdutoGateway, BuscarProdutoUseCase buscarProdutoUseCase) {
        return new AlterarProdutoUseCase(alterarProdutoGateway, buscarProdutoUseCase);
    }
}
