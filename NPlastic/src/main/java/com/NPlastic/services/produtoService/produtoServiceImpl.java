package com.NPlastic.services.produtoService;

import com.NPlastic.Entity.Produto;
import com.NPlastic.Mappers.ProdutoMapper;
import com.NPlastic.dto.produtoDto.produtoRequest;
import com.NPlastic.dto.produtoDto.produtoResponse;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class produtoServiceImpl implements  produtoService{

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMappers;

    public produtoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMappers) {
        this.produtoRepository = produtoRepository;
        this.produtoMappers = produtoMappers;
    }


    @Override
    public produtoResponse cadastrarNovo(produtoRequest produtoRequest) {

        Produto produto =  produtoMappers.toEntity(produtoRequest);
        produtoRepository.save(produto);
        return produtoMappers.toDto(produto);
    }

    @Override
    public Optional<produtoResponse> alterarProduto(produtoRequest produtoRequest, int id) {

          Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Nao Localizado"));

        // produtoMappers.atualizarProduto(produtoRequest,produto);
         produtoRepository.save(produto);
        return Optional.of(produtoMappers.toDto(produto));
    }

    @Override
    public List<produtoResponse> listarProduto() {
        return produtoMappers.toListResponse((List<Produto>) produtoRepository.findAll());
    }

    @Override
    public Optional<produtoResponse> buscarPorId(int id) {
        return produtoRepository.findById(id).map(produtoMappers::toDto);
    }

    @Override
    public String deletar(int id) {
        produtoRepository.deleteById(id);
        return "removido";
    }
}
