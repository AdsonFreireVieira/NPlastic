package com.NPlastic.services.produtoservice;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;

import java.util.List;

public interface ProdutosServices {

     ProdutosResponse criarProduto(ProdutosRequest produtosRequest);

     ProdutosResponse atualizarProduto(int id,ProdutosRequest produtosRequests);

     ProdutosResponse buscarPorId(int id);

     List<ProdutosResponse> listarProdutos();

     String deletarProduto(int id);
}
