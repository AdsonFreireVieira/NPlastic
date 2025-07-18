package com.NPlastic.services.produtoService;

import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;

import java.util.List;
import java.util.Optional;

public interface produtoService {

    produtoResponse cadastrarNovo(produtoRequest produtoRequest);

    produtoResponse alterarPedido(produtoRequest produtoRequest , Integer id);

    List<produtoResponse> listarProduto();

   Optional<produtoResponse> buscarPorId(int id);

    String deletar(int id);



}
