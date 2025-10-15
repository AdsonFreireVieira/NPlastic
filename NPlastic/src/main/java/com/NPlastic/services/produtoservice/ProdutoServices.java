package com.NPlastic.services.produtoservice;

import com.NPlastic.entity.Produtos;

import java.util.List;

public interface ProdutoServices {

     Produtos criarProduto(Produtos produtos);

     Produtos atualizarProduto(Produtos produtos);

     Produtos buscarPorId(int id);

     List<Produtos> listarProdutos();

     String deletarProduto(int id);
}
