package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.Entity.Endereco;
import com.NPlastic.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceEnderecoImpl implements  IEndereco {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public Endereco CriarEndereco(Endereco endereco) {


        return repository.save(endereco);
    }

    @Override
    public Endereco atualizarEndereco(Endereco endereco) {

        return  repository.save(endereco);
    }

    @Override
    public List<Endereco> listarEndereco() {
        return (List<Endereco>) repository.findAll();
    }

    @Override
    public Endereco BuscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deletarEndereco(int id) {
        repository.deleteById(id);
    }
}
