package com.NPlastic.service.serviceProduto;

import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.dtoProduto.ProdutoResponse;
import com.NPlastic.mapper.ProdutoMapper;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceProdutoImpl implements IProduto{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoResponse criarProduto(ProdutoResponse produtoResponse) {

        Produto produtos = ProdutoMapper.INSTANCE.toEntity(produtoResponse);
        return ProdutoMapper.INSTANCE.toDTO(repository.save(produtos));
    }

    @Override
    public ProdutoResponse AtualizaProduto(ProdutoResponse produtoResponse) {

        Produto produto = ProdutoMapper.INSTANCE.toEntity(produtoResponse);
        return ProdutoMapper.INSTANCE.toDTO(repository.save(produto));

    }

    @Override
    public List<ProdutoResponse> listarProdutos() {
        return ProdutoMapper.INSTANCE.toListResponse((List<Produto>)repository.findAll());
    }

    @Override
    public ProdutoResponse buscarPorId(int id) {
        return ProdutoMapper.INSTANCE.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public String deletarProduto(int id) {

        return "Removido";
    }
}
