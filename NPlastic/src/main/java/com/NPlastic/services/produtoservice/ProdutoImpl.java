package com.NPlastic.services.produtoservice;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;
import com.NPlastic.entity.Produtos;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class ProdutoImpl implements ProdutosServices {

    private final ProdutoRepository produtoRepository;

    public ProdutoImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutosResponse criarProduto(ProdutosRequest produtosRequest) {

        return null;
    }

    @Override
    public ProdutosResponse atualizarProduto(ProdutosRequest produtosRequest) {
        return null;
    }

    @Override
    public ProdutosResponse buscarPorId(int id) {
        return null;
    }

    @Override
    public List<ProdutosResponse> listarProdutos() {
        return List.of();
    }

    @Override
    public String deletarProduto(int id) {
        return "";
    }
}
