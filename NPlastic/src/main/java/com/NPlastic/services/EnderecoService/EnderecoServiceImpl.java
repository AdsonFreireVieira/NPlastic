package com.NPlastic.services.EnderecoService;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.Mappers.EnderecoMapper;
import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;
import com.NPlastic.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl  implements  EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper enderecoMappers;


    public EnderecoServiceImpl(EnderecoRepository repository, EnderecoMapper enderecoMappers) {
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

   // enderecoMappers.atualizarEntity(request, endereco);

   Endereco enderecoAtualizado = repository.save(endereco);


      return Optional.ofNullable(enderecoMappers.toDto(enderecoAtualizado));

    }

    @Override
    public Optional<enderecoResponse> buscarPorId(int id) {
        return repository.findById(id).map(enderecoMappers::toDto);


    }

    @Override
    public   void deletar(int id) {

        buscarPorId(id).orElseThrow(()->  new RuntimeException("Nao localizado"));
         repository.deleteById(id);

    }

    @Override
    public List<enderecoResponse> listarEndereco() {

        return enderecoMappers.convertList((List<Endereco>) repository.findAll());
    }

}