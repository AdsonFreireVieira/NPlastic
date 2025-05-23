package com.NPlastic.service.serviceProduto;

import com.NPlastic.Dto.ProdutosDto.ProdutoRequest;
import com.NPlastic.Dto.ProdutosDto.ProdutoResponse;
import com.NPlastic.Entity.Produto;
<<<<<<< HEAD
import com.NPlastic.dto.dtoProduto.ProdutoResponse;
import com.NPlastic.mapper.ProdutoMapper;
=======
import com.NPlastic.Mappers.ProdutoMapper;
>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceProdutoImpl implements IProduto{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest) {

        Produto produto =ProdutoMapper.INSTANCE.toEntity(produtoRequest);

        return ProdutoMapper.INSTANCE.toDto( repository.save(produto));
    }

    @Override
    public ProdutoResponse AtualizaProduto(ProdutoRequest  produtoRequesto) {

        Produto produto = ProdutoMapper.INSTANCE.toEntity(produtoRequesto);
        return ProdutoMapper.INSTANCE.toDto(repository.save(produto));

    }

    @Override
    public List<ProdutoResponse> listarProdutos() {

        return ProdutoMapper.INSTANCE.convertListDto((List<Produto>)repository.findAll());
    }

    @Override
    public ProdutoResponse buscarPorId(int id) {

        return ProdutoMapper.INSTANCE.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public String deletarProduto(int id) {

        return "Removido";
    }
}
