package com.NPlastic.services.producaocortesolda;

import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaRequest;
import com.NPlastic.dto.producaocortesolda.ProducaoCorteeSoldaResponse;
import com.NPlastic.entity.ProducaoCorteSolda;
import com.NPlastic.mappers.ProducaoCorteSoldaMappers;
import com.NPlastic.repository.ProducaoCorteSoldaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducaoCorteSoldaImpl implements ProducaoCorteSoldaI {

     private final ProducaoCorteSoldaMappers producaoCorteSoldaMappers;
     private final ProducaoCorteSoldaRepository producaoCorteSoldaRepository;

    public ProducaoCorteSoldaImpl(ProducaoCorteSoldaMappers producaoCorteSoldaMappers, ProducaoCorteSoldaRepository producaoCorteSoldaRepository) {
        this.producaoCorteSoldaMappers = producaoCorteSoldaMappers;
        this.producaoCorteSoldaRepository = producaoCorteSoldaRepository;
    }

    @Override
    public ProducaoCorteeSoldaResponse criarProducaoCorteSolda(ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest) {

        ProducaoCorteSolda producaoCorteSolda = producaoCorteSoldaMappers.toEntity(producaoCorteeSoldaRequest);

        return producaoCorteSoldaMappers.toDto(producaoCorteSoldaRepository.save(producaoCorteSolda));
    }

    @Override
    public Optional<ProducaoCorteeSoldaResponse> atualizarProducaoCorteSolda(int id, ProducaoCorteeSoldaRequest producaoCorteeSoldaRequest) {

        ProducaoCorteSolda producaoCorteSoldaBanco = producaoCorteSoldaRepository.findById(id).orElseThrow(()->new RuntimeException("Nao foi Possivel Atualizar"));

        ProducaoCorteSolda producaoCorteSoldaAtualizar = producaoCorteSoldaMappers.toEntity(producaoCorteeSoldaRequest);

        producaoCorteSoldaBanco.setQuantidade(producaoCorteSoldaAtualizar.getQuantidade());

        return  Optional.ofNullable( producaoCorteSoldaMappers.toDto(producaoCorteSoldaRepository.save(producaoCorteSoldaBanco)));
    }

    @Override
    public ProducaoCorteeSoldaResponse buscarProdutoCorteSolda(int id) {
        return null;
    }

    @Override
    public List<ProducaoCorteeSoldaResponse> listarProdutoCorteSolda() {
        return producaoCorteSoldaMappers.listResponse((List<ProducaoCorteSolda>) producaoCorteSoldaRepository.findAll());
    }

    @Override
    public String deletarProducaoCorteSolda(int id) {
        return "";
    }
}
