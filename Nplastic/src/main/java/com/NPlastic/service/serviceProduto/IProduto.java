package com.NPlastic.service.serviceProduto;

import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
import java.util.List;

public interface IProduto {

    public  ProdutoResponse criarProduto(ProdutoRequest produtoRequest);

    public ProdutoResponse AtualizaProduto(ProdutoRequest produtoRequest );

    public List<ProdutoResponse> listarProdutos();

    public ProdutoResponse buscarPorId(int id);

    public String deletarProduto(int id);
}
