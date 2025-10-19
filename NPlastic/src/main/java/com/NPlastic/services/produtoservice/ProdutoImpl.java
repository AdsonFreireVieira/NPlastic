package com.NPlastic.services.produtoservice;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;
import com.NPlastic.entity.Produtos;
import com.NPlastic.mappers.ProdutoMappers;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class ProdutoImpl implements ProdutosServices {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMappers produtoMappers;

    public ProdutoImpl(ProdutoRepository produtoRepository,ProdutoMappers produtoMappers) {
        this.produtoRepository = produtoRepository;
        this.produtoMappers = produtoMappers;
    }

    @Override
    public ProdutosResponse criarProduto(ProdutosRequest produtosRequest) {

         Produtos produtos = produtoMappers.toEntity(produtosRequest);
        return produtoMappers.toDto(produtos);
    }

    @Override
    public ProdutosResponse atualizarProduto(int id ,ProdutosRequest produtosRequest) {
        return null;
    }

    @Override
    public ProdutosResponse buscarPorId(int id) {
        return null;
    }

    @Override
    public List<ProdutosResponse> listarProdutos() {

        return produtoMappers.listConverttoDto((List<Produtos>)produtoRepository.findAll());
    }

    @Override
    public String deletarProduto(int id) {
        return "";
    }
}
