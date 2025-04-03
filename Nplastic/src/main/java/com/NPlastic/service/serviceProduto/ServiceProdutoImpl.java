package com.NPlastic.service.serviceProduto;

import com.NPlastic.Entity.Produto;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceProdutoImpl implements IProduto{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto criarProduto(Produto produto) {

        return repository.save(produto);
    }

    @Override
    public Produto AtualizaProduto(Produto  produto) {

        return repository.save(produto);

    }

    @Override
    public List<Produto> listarProdutos() {
        return (List<Produto>)repository.findAll();
    }

    @Override
    public Produto buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public String deletarProduto(int id) {

        return "Removido";
    }
}
