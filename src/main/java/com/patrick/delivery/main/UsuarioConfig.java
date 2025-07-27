package com.patrick.delivery.main;

import com.patrick.delivery.core.usecase.endereco.DesativarEnderecoUseCase;
import com.patrick.delivery.core.usecase.endereco.ListarEnderecoPorUsuarioUseCase;
import com.patrick.delivery.core.usecase.usuario.*;
import com.patrick.delivery.gateway.usuario.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CadastrarClienteUseCase cadastrarClienteUseCase(CadastrarClienteGateway cadastrarClienteGateway,
                                                    BuscarUsuarioUseCase buscarUsuarioUseCase,
                                                    CriptografarSenhaGateway criptografarSenhaGateway) {
        return new CadastrarClienteUseCase(cadastrarClienteGateway, buscarUsuarioUseCase, criptografarSenhaGateway);
    }

    @Bean
    ListarUsuariosUseCase listarUsuariosUseCase(ListarUsuariosGateway listarUsuariosGateway) {
        return new ListarUsuariosUseCase(listarUsuariosGateway);
    }

    @Bean
    BuscarUsuarioUseCase buscarUsuarioUseCase(BuscarUsuarioGateway buscarUsuarioGateway) {
        return new BuscarUsuarioUseCase(buscarUsuarioGateway);
    }

    @Bean
    AlterarSenhaUsuarioUseCase alterarSenhaUsuarioUseCase(AtualizarUsuarioGateway alterarSenhaUsuarioGateway,
                                                          BuscarUsuarioUseCase buscarUsuarioUseCase,
                                                          CriptografarSenhaGateway criptografarSenhaGateway) {
        return new AlterarSenhaUsuarioUseCase(alterarSenhaUsuarioGateway, buscarUsuarioUseCase, criptografarSenhaGateway);
    }

    @Bean
    DesativarUsuarioUseCase desativarUsuarioUseCase(DesativarUsuarioGateway desativarUsuarioGateway,
                                                  BuscarUsuarioUseCase buscarUsuarioUseCase,
                                                  ListarEnderecoPorUsuarioUseCase listarEnderecoPorUsuarioUseCase,
                                                  DesativarEnderecoUseCase desativarEnderecoUseCase) {
        return new DesativarUsuarioUseCase(desativarUsuarioGateway, buscarUsuarioUseCase,
                listarEnderecoPorUsuarioUseCase, desativarEnderecoUseCase);
    }
}
