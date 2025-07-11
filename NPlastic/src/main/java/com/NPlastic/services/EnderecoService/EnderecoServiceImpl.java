package com.NPlastic.services.EnderecoService;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.mappers.EnderecoMappers;
import com.NPlastic.repository.EnderecoRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<enderecoResponse> atualizar(int id ,enderecoRequest request) {

    Endereco endereco =repository.findById(id).orElseThrow(()-> new RuntimeException("Nao Encontrado"));

    enderecoMappers.atualizarEntity(request,endereco);

    repository.save(endereco);


      return Optional.ofNullable(enderecoMappers.toDto(endereco));

    }

    @Override
    public Optional<enderecoResponse> buscarPorId(int id) {
        return repository.findById(id).map(enderecoMappers::toDto);


    }

    @Override
    public  void deletar(int id) {

        buscarPorId(id).orElseThrow(()->  new RuntimeException("Nao localizado"));


    }

    @Override
    public List<enderecoResponse> listarEndereco() {

        return enderecoMappers.toList((List<Endereco>) repository.findAll());
    }

}