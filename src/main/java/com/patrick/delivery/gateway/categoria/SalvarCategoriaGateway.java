package com.patrick.delivery.gateway.categoria;

import com.patrick.delivery.core.domain.Categoria;

public interface SalvarCategoriaGateway {

    Categoria salvar(Categoria categoriaDomain);
}
