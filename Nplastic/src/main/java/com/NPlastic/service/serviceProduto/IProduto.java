package com.NPlastic.service.serviceProduto;

import com.NPlastic.Entity.Produto;

import java.util.List;

public interface IProduto {

    public Produto criarProduto(Produto produto);

    public Produto AtualizaProduto(Produto produto );

    public List<Produto> listarProdutos();

    public Produto buscarPorId(int id);

    public String deletarProduto(int id);
}
