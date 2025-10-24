package com.NPlastic.services.producaoextrusao;

import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoRequest;
import com.NPlastic.dto.producaoextrusao.ProducaoExtrusaoResponse;
import com.NPlastic.entity.ProducaoExtrusao;
import com.NPlastic.mappers.ProducaoExtrusaoMappers;
import com.NPlastic.mappers.ProdutoMappers;
import com.NPlastic.repository.ProducaoExtrusaoRepository;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
@Service
public class ProducaoExtrusaoImpl implements ProducaoExtrusaoI{

    private final ProducaoExtrusaoRepository producaoExtrusaoRepository;
    private final ProducaoExtrusaoMappers  producaoExtrusaoMappers;

    public ProducaoExtrusaoImpl(ProducaoExtrusaoRepository producaoExtrusaoRepository, ProducaoExtrusaoMappers producaoExtrusaoMappers) {
        this.producaoExtrusaoRepository = producaoExtrusaoRepository;
        this.producaoExtrusaoMappers = producaoExtrusaoMappers;
    }


    @Override
    public ProducaoExtrusaoResponse criarProdutoExtrusao(ProducaoExtrusaoRequest producaoExtrusaoRequest) {

         ProducaoExtrusao producaoExtrusao = producaoExtrusaoMappers.toEntity(producaoExtrusaoRequest);

          return producaoExtrusaoMappers.toDto(producaoExtrusaoRepository.save(producaoExtrusao));
    }

    @Override
    public ProducaoExtrusaoResponse atualizarProdutoExtrusao(int id,ProducaoExtrusaoRequest producaoExtrusaoRequest) {

        ProducaoExtrusao producaoExtrusao = producaoExtrusaoRepository.findById(id).orElseThrow(()-> new RuntimeException("Nao Localizado"));

        producaoExtrusao.setKilograma(producaoExtrusaoRequest.getKilograma());

        return producaoExtrusaoMappers.toDto(producaoExtrusaoRepository.save(producaoExtrusao));
    }

    @Override
    public ProducaoExtrusaoResponse buscarPorId(int id) {

        ProducaoExtrusao producaoExtrusao = producaoExtrusaoRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localizado"));
        return producaoExtrusaoMappers.toDto(producaoExtrusao);
    }

    @Override
    public List<ProducaoExtrusaoResponse> listarProducaoExtrusao() {
        return producaoExtrusaoMappers.listConverttoDto((List<ProducaoExtrusao>)producaoExtrusaoRepository.findAll());
    }

    @Override
    public String deletarProducaoExtrusao(int id) {
        ProducaoExtrusao producaoExtrusao = producaoExtrusaoRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localicado"));
          if(producaoExtrusao != null)
              producaoExtrusaoRepository.deleteById(id);
        return "Removido";
    }
}
