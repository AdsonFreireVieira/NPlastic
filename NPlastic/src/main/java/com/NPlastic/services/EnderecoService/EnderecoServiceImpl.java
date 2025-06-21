package com.NPlastic.services.EnderecoService;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.EnderecoMappers;
import com.NPlastic.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnderecoServiceImpl  implements  EnderecoService {

    private final EnderecoRepository repository;

    private final EnderecoMappers enderecoMappers;

    public EnderecoServiceImpl(EnderecoRepository repository, EnderecoMappers enderecoMappers) {
        this.repository = repository;
        this.enderecoMappers = enderecoMappers;
    }

    @Override
    public enderecoResponse novo(enderecoRequest request) {

        Endereco endereco = enderecoMappers.toEntity(request);

        return enderecoMappers.toDto(repository.save(endereco));
    }

    @Override
    public enderecoResponse alterar(enderecoRequest request) {

        Endereco endereco = enderecoMappers.toEntity(request);


        return enderecoMappers.toDto(repository.save(endereco));
    }

    @Override
    public Optional<enderecoResponse> buscarPorId(int id) {
        return repository.findById(id).map(enderecoMappers::toDto);


    }

    @Override
    public String deletar(int id) {
        return "removido";
    }

    @Override
    public List<enderecoResponse> listarEndereco() {

        return enderecoMappers.toList((List<Endereco>) repository.findAll());
    }
}