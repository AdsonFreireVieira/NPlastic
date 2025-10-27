package com.NPlastic.services.producaoestoque;

import com.NPlastic.dto.estoquedto.EstoqueRequest;
import com.NPlastic.dto.estoquedto.EstoqueResponse;
import com.NPlastic.entity.Estoque;
import com.NPlastic.mappers.EstoqueMappers;
import com.NPlastic.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EstoqueImpl implements EstoqueServiceImpl {

    private final EstoqueMappers mappers;
    private final EstoqueRepository estoqueRepository;

    public EstoqueImpl(EstoqueMappers mappers, EstoqueRepository estoqueRepository) {
        this.mappers = mappers;
        this.estoqueRepository = estoqueRepository;
    }


    @Override
    public EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest) {

        Estoque estoque = mappers.toEntity(estoqueRequest);
        return mappers.toDto(estoqueRepository.save(estoque));
    }

    @Override
    public EstoqueResponse atualizarEstoque(int id,EstoqueRequest estoqueRequest) {

        Estoque estoque= estoqueRepository.findById(id).orElseThrow(()->new RuntimeException("Nao Localizado"));

        estoque.setQuantidade(estoqueRequest.getQuantidade());

        estoqueRepository.save(estoque);



        return mappers.toDto(estoque);
    }

    @Override
    public EstoqueResponse buscarPorId(int id) {

        Estoque estoque = estoqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Encontrado"));

        if (estoque == null) {
            return mappers.toDto(estoque);

        }
        return null;
    }
    @Override
    public List<EstoqueResponse> listarEstoque() {

        return mappers.ListResponse((List<Estoque>)estoqueRepository.findAll());
    }
}
