package com.patrick.delivery.infrastructure.rest.dto.produto;

import java.math.BigDecimal;

public record AlterarProdutoRequest(Integer quantidade, BigDecimal preco, String descricao) {
}
