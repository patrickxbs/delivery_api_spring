package com.patrick.delivery.core.usecase.produto;

import com.patrick.delivery.core.domain.Categoria;
import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.core.domain.exception.CampoJaExisteException;
import com.patrick.delivery.core.usecase.categoria.BuscarCategoriaUseCase;
import com.patrick.delivery.gateway.produto.SalvarProdutoGateway;

import java.util.Optional;

public class SalvarProdutoUseCase {

    private final SalvarProdutoGateway salvarProdutoGateway;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final BuscarCategoriaUseCase buscarCategoriaUseCase;

    public SalvarProdutoUseCase(SalvarProdutoGateway salvarProdutoGateway, BuscarProdutoUseCase buscarProdutoUseCase, BuscarCategoriaUseCase buscarCategoriaUseCase) {
        this.salvarProdutoGateway = salvarProdutoGateway;
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.buscarCategoriaUseCase = buscarCategoriaUseCase;
    }

    public Produto salvar(Produto produto) {

        Optional<Produto> nomeJaExiste = buscarProdutoUseCase.buscarPorNome(produto.getNome());
        if (nomeJaExiste.isPresent())
            throw new CampoJaExisteException(String.format("Produto com o nome '%s' já existe", produto.getNome()));

        Long categoriaId = produto.getCategoria().getId();
        Categoria categoria = buscarCategoriaUseCase.buscarPorId(categoriaId);
        produto.setCategoria(categoria);

        return salvarProdutoGateway.salvar(produto);
    }
}
