package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.endereco.BuscarEnderecoUseCase;
import com.patrick.delivery.core.usecase.endereco.DesativarEnderecoUseCase;
import com.patrick.delivery.core.usecase.endereco.ListarEnderecoPorUsuarioUseCase;
import com.patrick.delivery.core.usecase.endereco.SalvarEnderecoUseCase;
import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.gateway.endereco.BuscarEnderecoGateway;
import com.patrick.delivery.gateway.endereco.DesativarEnderecoGateway;
import com.patrick.delivery.gateway.endereco.ListarEnderecoPorUsuarioGateway;
import com.patrick.delivery.gateway.endereco.SalvarEnderecoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoConfig {

    @Bean
    public SalvarEnderecoUseCase salvarEnderecoUseCase(SalvarEnderecoGateway salvarEnderecoGateway,
                                                       BuscarUsuarioUseCase buscarUsuarioUseCase) {
        return new SalvarEnderecoUseCase(salvarEnderecoGateway, buscarUsuarioUseCase);
    }

    @Bean
    public BuscarEnderecoUseCase buscarEnderecoUseCase(BuscarEnderecoGateway buscarEnderecoGateway) {
        return new BuscarEnderecoUseCase(buscarEnderecoGateway);
    }

    @Bean
    public ListarEnderecoPorUsuarioUseCase listarEnderecoPorUsuarioUseCase(ListarEnderecoPorUsuarioGateway gateway) {
        return new ListarEnderecoPorUsuarioUseCase(gateway);
    }

    @Bean
    public DesativarEnderecoUseCase desativarEnderecoUseCase(DesativarEnderecoGateway desativarEnderecoGateway, BuscarEnderecoUseCase buscarEnderecoUseCase) {
        return new DesativarEnderecoUseCase(desativarEnderecoGateway, buscarEnderecoUseCase);
    }
}
