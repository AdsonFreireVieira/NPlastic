package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Entity.Endereco;
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
    public EnderecoResponse CriarEndereco(EnderecoResponse response) {

        Endereco endereco = EnderecoMapper.INSTANCE.toEntity(response);

        return EnderecoMapper.INSTANCE.toDTO( repository.save(endereco));
    }

    @Override
    public EnderecoResponse atualizarEndereco(EnderecoResponse enderecoResponse) {
        Endereco endereco = EnderecoMapper.INSTANCE.toEntity(enderecoResponse);

        return EnderecoMapper.INSTANCE.toDTO( repository.save(endereco));
    }

    @Override
    public List<EnderecoResponse> listarEndereco() {
        return EnderecoMapper.INSTANCE.toListResponse((List<Endereco>) repository.findAll());
    }

    @Override
    public EnderecoResponse BuscarPorId(int id) {
        return EnderecoMapper.INSTANCE.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public void deletarEndereco(int id) {
        repository.deleteById(id);
    }
}
