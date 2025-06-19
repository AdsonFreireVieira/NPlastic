package com.NPlastic.services.EnderecoService;

import com.NPlastic.dto.enderecoDto.enderecoRequest;
import com.NPlastic.dto.enderecoDto.enderecoResponse;

import java.util.List;

public interface EnderecoService {

    public enderecoResponse novo(enderecoRequest request);

    public enderecoResponse alterar(enderecoRequest request);

    public enderecoResponse buscarPorId(int id);

    public String deletar(int id);

    public List<enderecoResponse> listarEndereco();
}