package com.NPlastic.services.EnderecoService;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.EnderecoMappers;
import com.NPlastic.repository.EnderecoRepository;

import java.util.List;

public class EnderecoServiceImpl  implements  EnderecoService{

    private final EnderecoRepository repository;

    private final EnderecoMappers enderecoMappers;

    public EnderecoServiceImpl(EnderecoRepository repository, EnderecoMappers enderecoMappers) {
        this.repository = repository;
        this.enderecoMappers = enderecoMappers;
    }

    @Override
    public enderecoResponse novo(enderecoRequest request) {

        Endereco endereco = enderecoMappers.toEntity(request);

        return  enderecoMappers.toDto(repository.save(endereco));
    }

    @Override
    public enderecoResponse alterar(enderecoRequest request) {

        Endereco endereco = enderecoMappers.toEntity(request);


        return enderecoMappers.toDto(repository.save(endereco));
    }

    @Override
    public enderecoResponse buscarPorId(int id) {
        return enderecoMappers.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public String deletar(int id) {
        return "REmovido";
    }

    @Override
    public List<enderecoResponse> listarEndereco() {
        return enderecoMappers.toList ( (List<Endereco> )repository.findAll());
    }
}
