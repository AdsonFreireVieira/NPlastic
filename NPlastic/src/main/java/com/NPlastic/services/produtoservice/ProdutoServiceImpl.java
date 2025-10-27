package com.NPlastic.services.produtoservice;

import com.NPlastic.dto.produtodto.ProdutosRequest;
import com.NPlastic.dto.produtodto.ProdutosResponse;
import com.NPlastic.entity.Produtos;
import com.NPlastic.mappers.ProdutoMappers;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class ProdutoServiceImpl implements ProdutosServices {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMappers produtoMappers;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMappers produtoMappers) {
        this.produtoRepository = produtoRepository;
        this.produtoMappers = produtoMappers;
    }

    @Override
    public ProdutosResponse criarProduto(ProdutosRequest produtosRequest) {

         Produtos produtos = produtoMappers.toEntity(produtosRequest);
        return produtoMappers.toDto(produtoRepository.save(produtos));
    }

    @Override
    public ProdutosResponse atualizarProduto(int id ,ProdutosRequest produtosRequest) {


        Produtos produtos = produtoRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localizado"));
        produtos.setClassificacao(produtosRequest.getClassificacao());
        produtos.setCor(produtosRequest.getCor());
        produtos.setLitros(produtosRequest.getLitros());
        produtos.setNome(produtosRequest.getNome());
        produtos.setUnidades(produtosRequest.getUnidades());
        produtos.setMedida(produtosRequest.getMedida());

         return produtoMappers.toDto(produtoRepository.save(produtos));
    }
    @Override
    public ProdutosResponse buscarPorId(int id) {

        Produtos produtos = produtoRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localizado"));
        return produtoMappers.toDto(produtos);
    }

    @Override
    public List<ProdutosResponse> listarProdutos() {

        return produtoMappers.listConverttoDto((List<Produtos>)produtoRepository.findAll());
    }

    @Override
    public String deletarProduto(int id) {

        Produtos produtos = produtoRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localizado"));
          if(produtos != null)
              produtoRepository.deleteById(id);
        return "Removido";
    }
}
