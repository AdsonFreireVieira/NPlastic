package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.dto.dtoEndereco.EnderecoRequest;
import com.NPlastic.dto.dtoEndereco.EnderecoResponse;
import com.NPlastic.mapper.EnderecoMapper;
import com.NPlastic.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceEnderecoImpl implements  IEndereco {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public EnderecoResponse CriarEndereco(EnderecoRequest request) {

        Endereco endereco = EnderecoMapper.INSTANCE.toEndereco(request);

        return EnderecoMapper.INSTANCE.toResponse( repository.save(endereco));
    }

    @Override
    public EnderecoResponse atualizarEndereco(EnderecoRequest request) {
        Endereco endereco = EnderecoMapper.INSTANCE.toEndereco(request);

        return EnderecoMapper.INSTANCE.toResponse( repository.save(endereco));
    }

    @Override
    public List<EnderecoResponse> listarEndereco() {
        return EnderecoMapper.INSTANCE.toListResponse((List<Endereco>) repository.findAll());
    }

    @Override
    public EnderecoResponse BuscarPorId(int id) {
        return EnderecoMapper.INSTANCE.toResponse(repository.findById(id).orElse(null));
    }

    @Override
    public void deletarEndereco(int id) {
        repository.deleteById(id);
    }
}
