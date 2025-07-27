package com.patrick.delivery.infrastructure.rest.service;

import com.patrick.delivery.core.domain.Produto;
import com.patrick.delivery.core.usecase.produto.*;
import com.patrick.delivery.infrastructure.rest.dto.produto.AlterarProdutoRequest;
import com.patrick.delivery.infrastructure.rest.dto.produto.ProdutoRequest;
import com.patrick.delivery.infrastructure.rest.dto.produto.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final SalvarProdutoUseCase salvarProdutoUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final AlterarProdutoUseCase alterarProdutoUseCase;

    public ProdutoResponse salvar(ProdutoRequest request) {
        Produto produto = ProdutoRequest.toProduto(request);
        return ProdutoResponse.toResponse(salvarProdutoUseCase.salvar(produto));
    }

    public List<ProdutoResponse> listarProdutos() {
        return listarProdutosUseCase.listarProdutos().stream().map(ProdutoResponse::toResponse).toList();
    }

    public ProdutoResponse buscarPorId(Long id) {
        return ProdutoResponse.toResponse(buscarProdutoUseCase.buscarPorId(id));
    }

    public void alterar(Long id, AlterarProdutoRequest request) {
        alterarProdutoUseCase.alterar(id, request.quantidade(), request.preco(), request.descricao());
    }
}
