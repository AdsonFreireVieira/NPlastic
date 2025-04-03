package com.NPlastic.service.ServiceEndereco;

import com.NPlastic.dto.dtoEndereco.EnderecoResponse;

import java.util.List;

public interface IEndereco {

    public EnderecoResponse CriarEndereco(EnderecoResponse request);

    public EnderecoResponse atualizarEndereco(EnderecoResponse request);

    public List<EnderecoResponse> listarEndereco();

    public EnderecoResponse BuscarPorId(int id);

    public void deletarEndereco(int id);
}
