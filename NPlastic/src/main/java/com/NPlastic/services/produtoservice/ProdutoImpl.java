package com.NPlastic.services.produtoservice;

import com.NPlastic.entity.Produtos;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class ProdutoImpl implements ProdutoServices{

    private final ProdutoRepository produtoRepository;

    public ProdutoImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produtos criarProduto(Produtos produtos) {

        return produtoRepository.save(produtos);
    }

    @Override
    public Produtos atualizarProduto(Produtos produtos) {
        return null;
    }

    @Override
    public Produtos buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Produtos> listarProdutos() {
        return List.of();
    }

    @Override
    public String deletarProduto(int id) {
        return "";
    }
}
