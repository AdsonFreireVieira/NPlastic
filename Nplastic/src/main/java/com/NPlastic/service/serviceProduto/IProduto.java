package com.NPlastic.service.serviceProduto;

import com.NPlastic.dto.dtoProduto.ProdutoResponse;

import java.util.List;

public interface IProduto {

    public ProdutoResponse criarProduto(ProdutoResponse produtoResponse);

    public ProdutoResponse AtualizaProduto(ProdutoResponse produtoResponse );

    public List<ProdutoResponse> listarProdutos();

    public ProdutoResponse  buscarPorId(int id);

    public String deletarProduto(int id);
}
