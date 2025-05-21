package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.dto.dtoEndereco.EnderecoResponse;

import java.util.List;

public interface IEndereco {

    public EnderecoResponse CriarEndereco(EnderecoRequest request);

    public EnderecoResponse atualizarEndereco(EnderecoRequest request);

    public List<EnderecoResponse> listarEndereco();

    public EnderecoResponse BuscarPorId(int id);

    public void deletarEndereco(int id);
}
