package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Dto.EnderecoDto.EnderecoRequest;
import com.NPlastic.Dto.EnderecoDto.EnderecoResponse;
import com.NPlastic.Entity.Endereco;
<<<<<<< HEAD
import com.NPlastic.dto.dtoEndereco.EnderecoResponse;
import com.NPlastic.mapper.EnderecoMapper;
=======
import com.NPlastic.Mappers.EnderecoMapper;
import com.NPlastic.Mappers.ProdutoMapper;
>>>>>>> fefb70f1e83e1e72ac672e5557ca9e1a6d65f5dc
import com.NPlastic.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceEnderecoImpl implements  IEndereco {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public EnderecoResponse CriarEndereco(EnderecoRequest enderecoRequest) {

        Endereco endereco = EnderecoMapper.INSTANCE.toEntity(enderecoRequest);

        return EnderecoMapper.INSTANCE.toDto(repository.save(endereco));
    }

    @Override
    public EnderecoResponse atualizarEndereco(EnderecoRequest enderecoRequest) {

        Endereco endereco = EnderecoMapper.INSTANCE.toEntity(enderecoRequest);

        return EnderecoMapper.INSTANCE.toDto(repository.save(endereco));
    }

    @Override
    public List<EnderecoResponse> listarEndereco() {
        return  EnderecoMapper.INSTANCE.convertList((List < Endereco >)repository.findAll());
    }

    @Override
    public EnderecoResponse BuscarPorId(int id) {
        return EnderecoMapper.INSTANCE.toDto( repository.findById(id).orElse(null));
    }

    @Override
    public void deletarEndereco(int id) {
        repository.deleteById(id);
    }
}
