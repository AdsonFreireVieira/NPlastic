package com.NPlastic.services.EnderecoService;

import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    public enderecoResponse novo(enderecoRequest request);

    public Optional<enderecoResponse> atualizar(int id ,enderecoRequest request);

    public Optional<enderecoResponse> buscarPorId(int id);

    public String deletar(int id);

    public List<enderecoResponse> listarEndereco();
}