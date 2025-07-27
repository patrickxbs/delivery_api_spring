package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.categoria.BuscarCategoriaUseCase;
import com.patrick.delivery.core.usecase.categoria.ListarCategoriasUseCase;
import com.patrick.delivery.core.usecase.categoria.SalvarCategoriaUseCase;
import com.patrick.delivery.gateway.categoria.BuscarCategoriaGateway;
import com.patrick.delivery.gateway.categoria.ListarCategoriasGateway;
import com.patrick.delivery.gateway.categoria.SalvarCategoriaGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaConfig {

    @Bean
    public SalvarCategoriaUseCase salvarCategoriaUseCase(SalvarCategoriaGateway salvarCategoriaGateway,
                                                         BuscarCategoriaUseCase buscarCategoriaUseCase) {
        return new SalvarCategoriaUseCase(salvarCategoriaGateway, buscarCategoriaUseCase);
    }

    @Bean
    public ListarCategoriasUseCase listarCategoriasUseCase(ListarCategoriasGateway listarCategoriasGateway) {
        return new ListarCategoriasUseCase(listarCategoriasGateway);
    }

    @Bean
    public BuscarCategoriaUseCase buscarCategoriaUseCase(BuscarCategoriaGateway buscarCategoriaGateway) {
        return new BuscarCategoriaUseCase(buscarCategoriaGateway);
    }
}
