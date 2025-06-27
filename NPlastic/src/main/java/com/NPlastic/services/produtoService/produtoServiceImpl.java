package com.NPlastic.services.produtoService;

import com.NPlastic.Entity.Produto;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import com.NPlastic.mappers.produtoMapper;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class produtoServiceImpl implements  produtoService{

    private final ProdutoRepository produtoRepository;
  private final produtoMapper produtoMappers;
    public produtoServiceImpl(ProdutoRepository produtoRepository, produtoMapper produtoMappers) {
        this.produtoRepository = produtoRepository;
        this.produtoMappers = produtoMappers;
    }


    @Override
    public produtoResponse cadastrarNovo(produtoRequest produtoRequest) {

        Produto produto =  produtoMappers.toEntity(produtoRequest);
        return produtoMappers.toDto(produto);
    }

    @Override
    public produtoResponse alterarPedido(produtoRequest produtoRequest, Integer id) {

          Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Nao Localizado"));

        Produto produtoAtualizado = produtoMappers.atualizarProduto(produtoRequest,produto);
        return produtoMappers.toDto(produtoAtualizado);
    }

    @Override
    public List<produtoResponse> listarProduto() {
        return produtoMappers.toList((List<Produto>) produtoRepository.findAll());
    }

    @Override
    public Optional<produtoResponse> buscarPorId(int id) {
        return produtoRepository.findById(id).map(produtoMappers::toDto);
    }

    @Override
    public String deletar(int id) {
        return "removido";
    }
}
